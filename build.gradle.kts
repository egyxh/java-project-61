plugins {
    java
    application
    checkstyle
    id("com.github.ben-manes.versions") version "0.51.0"
}

application {
    applicationName = "app"
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}

tasks.build {
    dependsOn(tasks.clean)
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}

tasks.withType<Checkstyle> {
    configFile = file("config/checkstyle/checkstyle.xml")
    ignoreFailures = false
}

tasks.installDist {
    destinationDir = file("$buildDir/install/$name")
    doLast {
        println("Дистрибутив создан в: $destinationDir")
    }
}
