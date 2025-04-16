plugins {
    java
    id("com.github.ben-manes.versions") version "0.51.0"
    application
    id("checkstyle")

}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    build {
        dependsOn(clean)  
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

checkstyle {
    toolVersion = "10.12.4" 
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false 
}
