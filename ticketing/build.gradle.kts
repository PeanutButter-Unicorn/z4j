version = project.properties["z4jTicketingVersion"]!!
group = "lol.pbu.z4j"

micronaut {
    openapi {
        client(file("src/main/resources/ticketing.yaml")) {
            apiPackageName.set("lol.pbu.z4j.ticket.client")
            modelPackageName.set("lol.pbu.z4j.ticket.model")
            useReactive.set(false)
            useAuth.set(false)
        }
    }
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("lol.pbu.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}