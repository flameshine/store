group = "com.example"
version = "1.0-SNAPSHOT"

description = "Implementation of the fairly convenient online marketplace."

plugins {
    java
    id("org.springframework.boot") version "2.4.3"
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

repositories {
    mavenCentral()
}

val springBootVersion = "2.4.3"
val mysqlVersion = "8.0.23"
val lombokVersion = "1.18.20"
val testngVersion = "7.4.0"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-security:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-validation:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    implementation("mysql:mysql-connector-java:${mysqlVersion}")

    compileOnly("org.projectlombok:lombok:${lombokVersion}")

    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

    testImplementation("org.testng:testng:${testngVersion}")
}

tasks.test {
    useTestNG()
}