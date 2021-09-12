plugins {
    kotlin("jvm") version "1.5.30"
}

group = "kr.myoung2"
version = property("version")!!

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks {
    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }
    }
    jar {
        from (shade.map { if (it.isDirectory) it else zipTree(it) })
    }
}