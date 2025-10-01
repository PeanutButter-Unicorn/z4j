import org.apache.tools.ant.filters.ReplaceTokens
import java.util.*

plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id("groovy")
    id("com.gradleup.nmcp.aggregation").version("1.1.0")
    id("io.micronaut.application") version "4.5.3"
    id("io.micronaut.openapi") version "4.5.3"
    id("jacoco")
    id("org.sonarqube") version "latest.release"
    id("com.gradleup.shadow") version "8.3.6"
    id("org.graalvm.buildtools.native") version "0.10.6"
}

version = project.properties["z4jVersion"]!!
val dataFakerVersion = project.properties["dataFakerVersion"]!!
group = "lol.pbu"

application {
    mainClass.set("lol.pbu.z4j.cli.Z4jCommand")
}

repositories {
    mavenCentral()
}

sonarqube {
    properties {
        property("sonar.tests", "src/test/groovy")
    }
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
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

java {
    sourceCompatibility = JavaVersion.toVersion("17") // graalvm-ce
}

tasks.withType<ProcessResources> {
    val props = Properties()
    file("gradle.properties").inputStream().use { props.load(it) }
    filesMatching("**/application.yml") {
        filter(mapOf("tokens" to props), ReplaceTokens::class.java)
    }
}


micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("lol.pbu.*")
    }
    openapi {
        version = "6.16.0"
        client(file("src/main/resources/z4j.yaml")) {
            apiPackageName.set("lol.pbu.z4j.client")
            modelPackageName.set("lol.pbu.z4j.model")
            useReactive.set(false)
            useAuth.set(false)
            lombok.set(true)
            clientId.set("zendesk")
            apiNameSuffix.set("Client")
            alwaysUseGenerateHttpResponse.set(true)
        }
    }
}
tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    classDirectories.setFrom(files(classDirectories.files.map {
        fileTree(it) {
            exclude("lol/pbu/Application.class")
        }
    }))
}
tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}
tasks.check {
    dependsOn(tasks.jacocoTestReport)
}
tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events = setOf(org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showStackTraces = true
        showCauses = true
    }
}
graalvmNative {
    toolchainDetection = true
    binaries {
        named("main") {
            imageName.set("z4jCli")
        }
    }
}
