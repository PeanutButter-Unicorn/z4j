package lol.pbu.z4j.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ArticleClientSpec extends Specification {

    @Inject
    @Shared
    ArticlesClient articlesClient

    def "can list articles"() {
        when: "list articles"
        def response = articlesClient.listArticles("en-us", null, null, null, null)

        then:
        response.status() == HttpStatus.OK
    }


}
