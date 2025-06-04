version = project.properties["z4jTicketingVersion"]!!
group = "lol.pbu.z4j"

micronaut {
    openapi {
        version = "6.16.0"
         client(file("src/main/resources/ticketing.yaml")) {
            apiPackageName.set("lol.pbu.z4j.ticket.client")
            modelPackageName.set("lol.pbu.z4j.ticket.model")
            useReactive.set(false)
            useAuth.set(false)
            lombok.set(true)
            clientId.set("micronaut.http.services.zendesk.url")
            apiNameSuffix.set("Client")
            alwaysUseGenerateHttpResponse.set(true)
        }
    }
    processing {
        incremental(true)
        annotations("lol.pbu.*")
    }
}
