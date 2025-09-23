plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id ("org.sonarqube") version "latest.release"
    id ("jacoco")
    id("com.gradleup.shadow") version "8.3.6" apply false
    id("io.micronaut.application") version "4.5.4" apply false
    id("org.graalvm.buildtools.native") version "0.10.6" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "groovy")
}