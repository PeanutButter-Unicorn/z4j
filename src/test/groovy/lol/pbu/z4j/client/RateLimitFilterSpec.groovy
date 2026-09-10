package lol.pbu.z4j.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.simple.SimpleHttpRequest
import lol.pbu.z4j.ratelimit.RateLimitConfiguration
import lol.pbu.z4j.ratelimit.RateLimitSnapshot
import lol.pbu.z4j.ratelimit.RateLimitTracker
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import spock.lang.Specification
import java.time.Duration

class RateLimitFilterSpec extends Specification {

    def "filter delays request when approaching limit and auto wait is enabled"() {
        given:
        def tracker = new RateLimitTracker() {
            @Override
            boolean isApproachingLimit(int threshold) {
                return true
            }
        }
        def config = new RateLimitConfiguration()
        config.setAutoWaitEnabled(true)
        config.setApproachThreshold(50)
        config.setWaitDurationSeconds(5) // use 5 seconds for tests
        
        def filter = new RateLimitFilter(tracker, config)
        
        def request = Mock(MutableHttpRequest)
        request.getPath() >> "/api/v2/users"
        request.getMethodName() >> "GET"
        request.getUri() >> URI.create("https://z.com/api/v2/users")
        
        def chain = Mock(ClientFilterChain)
        
        def response = Mock(HttpResponse)
        
        def headers = Mock(io.micronaut.http.HttpHeaders)
        headers.names() >> ([] as Set)
        response.getHeaders() >> headers

        response.getStatus() >> io.micronaut.http.HttpStatus.OK

        

        chain.proceed(request) >> Flux.just(response)

        when:
        def start = System.currentTimeMillis()
        def result = Mono.from(filter.doFilter(request, chain)).block()
        def duration = System.currentTimeMillis() - start

        then:
        result == response
        duration >= 4900 // Should have waited roughly 5 seconds
        
    }
    
    def "filter does not delay request when auto wait is disabled"() {
        given:
        def tracker = new RateLimitTracker() {
            @Override
            boolean isApproachingLimit(int threshold) {
                return true
            }
        }
        def config = new RateLimitConfiguration()
        config.setAutoWaitEnabled(false)
        config.setApproachThreshold(50)
        config.setWaitDurationSeconds(5)
        
        def filter = new RateLimitFilter(tracker, config)
        
        def request = Mock(MutableHttpRequest)
        request.getPath() >> "/api/v2/users"
        request.getMethodName() >> "GET"
        request.getUri() >> URI.create("https://z.com/api/v2/users")
        
        def chain = Mock(ClientFilterChain)
        def response = Mock(HttpResponse)
        
        def headers = Mock(io.micronaut.http.HttpHeaders)
        headers.names() >> ([] as Set)
        response.getHeaders() >> headers

        response.getStatus() >> io.micronaut.http.HttpStatus.OK

        // Even if approaching limit, should not wait because disabled
        

        chain.proceed(request) >> Flux.just(response)

        when:
        def start = System.currentTimeMillis()
        def result = Mono.from(filter.doFilter(request, chain)).block()
        def duration = System.currentTimeMillis() - start

        then:
        result == response
        duration < 1000 // Should not wait
    }
}
