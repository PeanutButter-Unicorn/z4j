package lol.pbu.z4j.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import lol.pbu.z4j.model.LocalesList
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class LocalesClientSpec extends Specification {

    @Inject
    @Shared
    LocalesClient localesClient

    def "ListLocales"() {
        when:
        HttpResponse<LocalesList> response = localesClient.listLocales()

        then:
        response.status() == HttpStatus.OK

        and:
        response.body() != null
    }
}
