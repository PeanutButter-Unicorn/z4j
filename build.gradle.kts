plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id("groovy")
    id("io.micronaut.library") version "4.5.3" apply false
    id("io.micronaut.aot") version "4.5.3" apply false
    id("io.micronaut.openapi") version "4.5.3" apply false
}

version = project.properties["z4jVersion"]!!
group = "lol.pbu"

allprojects { repositories { mavenCentral() } }

subprojects {
    apply(plugin = "groovy")
    apply(plugin = "io.micronaut.library")
    apply(plugin = "io.micronaut.aot")
    apply(plugin = "io.micronaut.openapi")

    dependencies {
        annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
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
}
