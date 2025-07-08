package lol.pbu.z4j.client


import io.micronaut.http.HttpStatus
import io.micronaut.http.client.exceptions.HttpClientException
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Unroll

@MicronautTest
class LocalesClientSpec extends Z4jSpec {

    @Shared
    LocalesClient managersLocalesClient, agentsLocalesClient, usersLocalesClient, noAuthLocalesClient,
                  badEmailLocalesClient, badUrlLocalesClient

    def setupSpec() {
        managersLocalesClient = managerCtx.getBean(LocalesClient.class)
        agentsLocalesClient = agentCtx.getBean(LocalesClient.class)
        usersLocalesClient = userCtx.getBean(LocalesClient.class)
        noAuthLocalesClient = badTokenCtx.getBean(LocalesClient.class)
        badEmailLocalesClient = badEmailCtx.getBean(LocalesClient.class)
        badUrlLocalesClient = badUrlCtx.getBean(LocalesClient.class)
    }


    @Unroll
    def "can list public locales for #clientName"() {
        when:
        def response = localesClient.listLocales()

        then:
        response.status() == HttpStatus.OK

        where:
        clientName              | localesClient
        "managers client"       | managersLocalesClient
        "agents client"         | agentsLocalesClient
        "users client"          | usersLocalesClient
        "no-auth client"        | noAuthLocalesClient
        "bad email client"      | badEmailLocalesClient
    }

    def "calling locales client with a bad URL throws an exception"() {
        when:
        badUrlLocalesClient.listLocales()

        then:
        thrown(HttpClientException)
    }
}
