package lol.pbu.z4j.client

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import lol.pbu.z4j.Z4jSpec
import lol.pbu.z4j.model.ArticlesResponse
import lol.pbu.z4j.model.CategoriesResponse
import lol.pbu.z4j.model.ListArticlesSortByParameter
import lol.pbu.z4j.model.ListArticlesSortOrderParameter
import lol.pbu.z4j.model.ListCategoriesSortByParameter
import reactor.core.publisher.Mono
import spock.lang.Shared

@MicronautTest
class CategoryClientSpec extends Z4jSpec {

    @Shared
    CategoryClient adminCategoryClient, agentCategoryClient, userCategoryClient

    @Shared
    List<String> allLocales

    def setupSpec() {
        adminCategoryClient = adminCtx.getBean(CategoryClient.class)
        agentCategoryClient = agentCtx.getBean(CategoryClient.class)
        userCategoryClient = userCtx.getBean(CategoryClient.class)
        allLocales = userCtx.getBean(LocaleClient.class).listLocales().block().locales.collect { it.locale.toLowerCase() }
    }

    def "can use ListArticles for other tests using the '#locale' locale for the #userType user type"(CategoryClient categoryClient, String userType, String locale, ListCategoriesSortByParameter sortBy, ListArticlesSortOrderParameter sortOrder) {
        when: "query articles list for the '#locale' locale"
        categoryClient.listCategories(locale, sortBy, sortOrder).block()

        then:
        noExceptionThrown()

        where:
        [[categoryClient, userType], locale, sortBy, sortOrder, startTime, labelNames] << [
                [[adminCategoryClient, "admin"], [agentCategoryClient, "agent"], [userCategoryClient, "user"]],
                allLocales,
                [ListCategoriesSortByParameter.values(), null].flatten(),
                [ListArticlesSortOrderParameter.values(), null].flatten()
        ].combinations()
    }
}
