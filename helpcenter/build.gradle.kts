version = project.properties["z4jHelpCenterVersion"]!!
group = "lol.pbu.z4j"

micronaut {
    openapi {
        version = "6.16.0"
        client(file("src/main/resources/helpcenter.yaml")) {
            apiPackageName.set("lol.pbu.z4j.ticket.client")
            modelPackageName.set("lol.pbu.z4j.ticket.model")
            useReactive.set(false)
            useAuth.set(false)
            lombok.set(true)
        }
    }
    processing {
        incremental(true)
        annotations("lol.pbu.*")
    }
}
