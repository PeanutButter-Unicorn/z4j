import org.apache.tools.ant.filters.ReplaceTokens
import java.util.*

plugins {
    id("io.micronaut.application")
    id("com.gradleup.shadow")
    id("org.graalvm.buildtools.native")
}

group = "lol.pbu"
version = project.properties["zencliVersion"]!!

dependencies {
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation(project(":core"))
    implementation("info.picocli:picocli")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    runtimeOnly("org.yaml:snakeyaml")
}

application {
    mainClass = "lol.pbu.command.ZcmiCommand"
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
            buildArgs.add("--initialize-at-build-time=kotlin.coroutines.intrinsics")
        }
    }
}
