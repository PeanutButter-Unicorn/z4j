package lol.pbu.z4j.client


import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import lol.pbu.z4j.model.ListArticlesSortByParameter
import lol.pbu.z4j.model.ListArticlesSortOrderParameter
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class ArticlesClientSpec extends Specification {

    @Inject
    @Shared
    ArticlesClient articlesClient

//    def "ArchiveArticle"() {
//
//    }
//
//    def "BulkAttachmentsArticles"() {
//    }
//
//    def "CreateArticle"() {
//    }

    @Unroll
    def "ListArticles via #sortBy and #sortOrder"() {
        when:
        def response = articlesClient.listArticles("en-us", null, null, null, null)

        then:
        response.status() == HttpStatus.OK

        where:
        locale| sortBy| sortOrder| startTime| labelNames | _
        "en-us" | null | null | null | null | _
        "en-us" | ListArticlesSortByParameter.CREATED_AT | ListArticlesSortOrderParameter.ASC | null | null | _
    }

//    def "ShowArticle"() {
//    }
//
//    def "UpdateArticle"() {
//    }
//
//    def "UpdateArticleSourceLocale"() {
//    }
}
