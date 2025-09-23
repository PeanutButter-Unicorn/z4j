plugins {
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"
    id ("org.sonarqube") version "latest.release"
    id ("jacoco")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "groovy")
}