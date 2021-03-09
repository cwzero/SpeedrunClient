plugins {
    id("com.github.ben-manes.versions") version "0.38.0"
    id("java-library")
    id("application")
}

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
    jcenter()
    google()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.18")
    compileOnly("org.projectlombok:lombok:1.18.18")

    implementation("org.slf4j:slf4j-api:1.7.30")
    runtimeOnly("org.slf4j:slf4j-simple:1.7.30")

    testImplementation(platform("org.junit:junit-bom:5.8.0-M1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.mockito:mockito-core:3.8.0")
    testImplementation("org.mockito:mockito-junit-jupiter:3.8.0")

    testImplementation("org.assertj:assertj-core:3.19.0")

    // API Stuff
    implementation("org.glassfish.jersey.core:jersey-client:2.33")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:2.33")
    implementation("org.glassfish.jersey.inject:jersey-hk2:2.33")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.2")

    implementation("io.github.openfeign:feign-core:11.0")
    implementation("io.github.openfeign:feign-jackson:11.0")
    implementation("io.github.openfeign:feign-httpclient:11.0")
    implementation("io.github.openfeign:feign-slf4j:11.0")
    implementation("io.github.openfeign:feign-jaxrs2:11.0")
    testImplementation("io.github.openfeign:feign-mock:11.0")

    // CSV
    implementation("org.apache.commons:commons-csv:1.8")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("com.liquidforte.speedrun.client.main.Main")
}