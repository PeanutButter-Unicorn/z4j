package lol.pbu.z4j.testUtils

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer

class TestClient<T> {
    static T admin, agent, user, badToken, badEmail, badUrl
    private Class<T> aClass

    private static ApplicationContext adminCtx, agentCtx, userCtx, badTokenCtx, badEmailCtx, badUrlCtx

    TestClient(Class<T> aClass) {
        this.aClass = aClass
        adminCtx = getCtx("Z4J_ADMIN_EMAIL")
        agentCtx = getCtx("Z4J_AGENT_EMAIL")
        userCtx = getCtx("Z4J_END_USER_EMAIL")
        badTokenCtx = getCtx("Z4J_ADMIN_EMAIL", ["micronaut.http.services.zendesk.token": "this-is-an-invalid-token"])
        badEmailCtx = getCtx("Z4J_ADMIN_EMAIL", ["micronaut.http.services.zendesk.email": "this-is-an-invalid-email"])
        badUrlCtx = getCtx("Z4J_ADMIN_EMAIL", ["micronaut.http.services.zendesk.url": "https://fake-url.lol"])
    }

    T getAdmin() {
        if (null == admin) {
            admin = adminCtx.getBean(aClass)
        }
        return admin
    }

    T getAgent() {
        if (null == agent) {
            agent = agentCtx.getBean(aClass)
        }
        return agent
    }

    T getUser() {
        if (null == user) {
            user = userCtx.getBean(aClass)
        }
        return user
    }

    T getBadToken() {
        if (null == badToken) {
            badToken = badTokenCtx.getBean(aClass)
        }
        return badToken
    }

    T getBadEmail() {
        if (null == badEmail) {
            badEmail = badEmailCtx.getBean(aClass)
        }
        return badEmail
    }

    T getBadUrl() {
        if (null == badUrl) {
            badUrl = badUrlCtx.getBean(aClass)
        }
        return badUrl
    }

    static ApplicationContext getCtx(String authUser) {
        return getCtx(authUser, [:])
    }

    static void stopAll() {
        adminCtx.stop()
        agentCtx.stop()
        userCtx.stop()
        badTokenCtx.stop()
        badEmailCtx.stop()
        badUrlCtx.stop()
    }

    /**
     * create an ApplicationContext for z4j testing with the given env vars.
     *
     * @param authUser environment variable whose value holds the user's email address
     * @return ApplicationContext with the specified environment variables
     */
    static ApplicationContext getCtx(String authUser, Map<String, String> properties) {
        ["MICRONAUT_HTTP_SERVICES_ZENDESK_EMAIL",
         "MICRONAUT_HTTP_SERVICES_ZENDESK_TOKEN",
         "MICRONAUT_HTTP_SERVICES_ZENDESK_URL"].each { envVar ->
            if (null != System.getenv(envVar)) {
                throw new IllegalStateException("$envVar is set. Do not define this variable in testing.")
            }
        }
        ["Z4J_URL", authUser].each { envVar ->
            if (null == System.getenv(envVar)) {
                throw new IllegalStateException("$envVar environment variable is not set.")
            }
        }
        properties = ["micronaut.http.services.zendesk.email": System.getenv(authUser),
                      "micronaut.http.services.zendesk.url"  : System.getenv("Z4J_URL"),
                      "micronaut.http.services.zendesk.token": System.getenv("Z4J_TOKEN")
        ] + properties
        ApplicationContext.builder(EmbeddedServer).properties(properties).build().start()
    }
}
