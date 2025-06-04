plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id("groovy")
    id("io.micronaut.application") version "4.5.3"
    id("io.micronaut.aot") version "4.5.3"
    id("io.micronaut.library") version "4.5.3" apply false
    id("io.micronaut.openapi") version "4.5.3" apply false
}

version = project.properties["z4jVersion"]!!
group = "lol.pbu"

subprojects {
    apply(plugin = "io.micronaut.library")
    apply(plugin = "io.micronaut.openapi")
}

micronaut {
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

application {
    mainClass.set("lol.pbu.Application")
}

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        annotationProcessor("org.projectlombok:lombok")
        annotationProcessor("io.micronaut.validation:micronaut-validation-processor")

        compileOnly("org.projectlombok:lombok")

        implementation("io.micronaut.reactor:micronaut-reactor-http-client")
        implementation("io.micronaut:micronaut-http-client")
        implementation("io.micronaut.serde:micronaut-serde-jackson")
        implementation("org.slf4j:jul-to-slf4j")
        implementation("io.micronaut.validation:micronaut-validation")
        runtimeOnly("ch.qos.logback:logback-classic")
        runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
        runtimeOnly("org.yaml:snakeyaml")
        testImplementation("org.testcontainers:spock")
        testImplementation("org.testcontainers:testcontainers")
        testImplementation("net.datafaker:datafaker:2.4.3")
    }

    java {
        sourceCompatibility = JavaVersion.toVersion("17") // graalvm-ce
    }

    val markdownDoclet: Configuration by configurations.creating

    tasks.named<Javadoc>("javadoc") {
        options.docletpath = markdownDoclet.files.toList()
        options.doclet = "org.jdrupes.mdoclet.MDoclet"
        options.quiet()
        (options as? CoreJavadocOptions)?.addStringOption("Xdoclint:-html") // Safe cast

        options.jFlags = listOf(
            "--add-exports=jdk.compiler/com.sun.tools.doclint=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
            "--add-exports=jdk.javadoc/jdk.javadoc.internal.tool=ALL-UNNAMED",
            "--add-exports=jdk.javadoc/jdk.javadoc.internal.doclets.toolkit=ALL-UNNAMED",
            "--add-opens=jdk.javadoc/jdk.javadoc.internal.doclets.toolkit.resources.releases=ALL-UNNAMED"
        )
    }

    tasks.named("build") {
        dependsOn(tasks.named("javadoc"))
    }
}
