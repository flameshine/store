group = "com.example"
version = "1.0-SNAPSHOT"

description = "Implementation of the fairly convenient online marketplace with shopping cart functionality."

plugins {
    java
    id("org.springframework.boot") version "2.5.5"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.5.5"
val lombokVersion = "1.18.20"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-security:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-validation:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    implementation("mysql:mysql-connector-java:8.0.23")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")

    compileOnly("org.projectlombok:lombok:${lombokVersion}")

    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

    testImplementation("org.testng:testng:7.4.0")
}

tasks.test {
    useTestNG()
}