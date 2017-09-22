import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by extra
val springBootVersion: String by extra

buildscript {
    val kotlinVersion by extra { "1.1.50" }
    val springBootVersion by extra { "2.0.0.M4" }

    repositories {
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    }


}

version = "1.0.0-SNAPSHOT"

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

plugins {
    val kotlinVersion = "1.1.50"
    id("org.gradle.kotlin.kotlin-dsl").version("0.11.2")
    id("org.springframework.boot").version("1.5.7.RELEASE")
    id("io.spring.dependency-management").version("1.0.3.RELEASE")
    id("org.jetbrains.kotlin.plugin.spring").version(kotlinVersion)
    kotlin("jvm").version(kotlinVersion)
}

repositories {
    maven {
        url = uri("https://repo.spring.io/milestone")
    }
    mavenCentral()
}

configurations {
    all { exclude(module = "spring-boot-starter-logging") }
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-actuator:$springBootVersion")
    compile("org.springframework.boot:spring-boot-starter-webflux:$springBootVersion")

    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("io.projectreactor:reactor-test")
}