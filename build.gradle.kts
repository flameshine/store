group = "com.flameshine"
version = "1.0-SNAPSHOT"

description = "Implementation of the online marketplace with the shopping cart functionality."

plugins {
    java
    id("org.springframework.boot") version "2.6.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.6.2"
val lombokVersion = "1.18.22"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-security:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-validation:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation("mysql:mysql-connector-java:8.0.25")

    compileOnly("org.projectlombok:lombok:${lombokVersion}")

    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
}

tasks.test {
    useJUnitPlatform()
}