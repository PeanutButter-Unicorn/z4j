plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id("groovy")
    id("io.micronaut.aot") version "4.5.3"
    id("io.micronaut.library") version "4.5.3"
    id("io.micronaut.openapi") version "4.5.3"
    id("maven-publish")
    id("org.jreleaser") version "1.19.0"
}

version = project.properties["z4jVersion"]!!
group = "lol.pbu"

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
}

java {
    sourceCompatibility = JavaVersion.toVersion("17") // graalvm-ce
    withJavadocJar()
    withSourcesJar()
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("z4j")
                description.set("Zendesk API client for Java")
                url.set("https://github.com/PeanutButter-Unicorn/z4j")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Jonathan-Zollinger")
                        name.set("Jonathan Zollinger")
                        email.set("jonathan.zollinger@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/PeanutButter-Unicorn/z4j.git")
                    developerConnection.set("scm:git:ssh://github.com/PeanutButter-Unicorn/z4j.git")
                    url.set("https://github.com/PeanutButter-Unicorn/z4j")
                }
            }
        }
    }

    repositories {
        maven {
            name = "staging"
            url = layout.buildDirectory.dir("staging-deploy")
        }
    }
}

jreleaser {
    signing {
        isEnabled.set(true)
        isArmored.set(true)
    }
    deploy {
        maven {
            mavenCentral {
                sonatype {
                    isEnabled.set(true)
                    url.set("https://central.sonatype.com/api/v1/publisher")
                    stagingRepository(layout.buildDirectory.dir("staging-deploy"))
                }
            }
        }
    }
}
