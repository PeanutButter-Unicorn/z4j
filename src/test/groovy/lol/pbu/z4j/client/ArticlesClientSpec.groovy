package lol.pbu.z4j.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ArticlesClientSpec extends Specification {

    @Inject
    @Shared
    ArticlesClient articlesClient

    def "can use ListArticles for other tests"() { // https://github.com/PeanutButter-Unicorn/z4j/issues/31
        when:
        def response = articlesClient.listArticles("en-us", null, null, null, null)

        then:
        response.status() == HttpStatus.OK

        and:
        response.body().articles != null

        then:
        if (response.body().articles.size() > 0) {
            // this tests ability needed in https://github.com/PeanutButter-Unicorn/z4j/issues/30
            response.body().articles.forEach { article -> article.id != null }
        }
    }
}
