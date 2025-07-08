package lol.pbu.z4j.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class ArticlesClientSpec extends Specification {

    @Inject
    @Shared
    ArticlesClient articlesClient

    @Inject
    @Shared
    LocalesClient localesClient

    @Unroll
    def "can use ListArticles for other tests using the '#locale' locale"() { // https://github.com/PeanutButter-Unicorn/z4j/issues/31
        when:"query articles list for the '#locale' locale"
        def response = articlesClient.listArticles(locale, null, null, null, null)

        then:"received expected 200 response"
        response.status() == HttpStatus.OK

        and:"articles object is not null (even if empty)"
        response.body().articles != null

        then:"validate the returned article objects have an ID that other tests will require"
        if (response.body().articles.size() > 0) {
            // this tests ability needed in https://github.com/PeanutButter-Unicorn/z4j/issues/30
            response.body().articles.forEach { article -> article.id != null }
        }

        where:
        locale << localesClient.listLocales().body().getLocales().collect { it.locale.toLowerCase() }
    }
}
