version = project.properties["z4jHelpCenterVersion"]!!
group = "lol.pbu.z4j"

micronaut {
    openapi {
        version = "6.16.0"
        client(file("src/main/resources/helpcenter.yaml")) {
            apiPackageName.set("lol.pbu.z4j.helpcenter.client")
            modelPackageName.set("lol.pbu.z4j.helpcenter.model")
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
