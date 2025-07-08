package lol.pbu.z4j.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class LocalesClientSpec extends Specification {

    @Inject
    @Shared
    LocalesClient localesClient

    def "can list public locales"(){
        when:
        def response = localesClient.listLocales()

        then:
        response.status() == HttpStatus.OK
    }

}
