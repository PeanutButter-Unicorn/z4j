import org.apache.tools.ant.filters.ReplaceTokens
import java.util.*

plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id("groovy")
    id("com.gradleup.nmcp.aggregation").version("1.1.0")
    id("io.micronaut.application")
    id("jacoco")
    id("org.sonarqube") version "latest.release"
    id("com.gradleup.shadow") version "8.3.6"
    id("org.graalvm.buildtools.native") version "0.10.6"
}

group = "lol.pbu"
version = project.properties["zencliVersion"]!!

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation(project(":core"))
    implementation("info.picocli:picocli")
    implementation("info.picocli:picocli-jansi-graalvm:1.2.0")
    implementation("org.fusesource.jansi:jansi:2.4.2")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.slf4j:jul-to-slf4j")
    implementation("io.micronaut.validation:micronaut-validation")
    runtimeOnly("ch.qos.logback:logback-core")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.yaml:snakeyaml")
}

application {
    mainClass = "lol.pbu.command.Z4jCommand"
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

tasks.withType<ProcessResources> {
    val props = Properties()
    file("gradle.properties").inputStream().use { props.load(it) }
    filesMatching("**/application.yml") {
        filter(mapOf("tokens" to props), ReplaceTokens::class.java)
    }
}

micronaut {
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("lol.pbu.*")
    }
}

graalvmNative {
    toolchainDetection = true
    binaries {
        named("main") {
            imageName.set("zencli")
            buildArgs.add("--initialize-at-build-time=kotlin.coroutines.intrinsics,")
        }
    }
}
