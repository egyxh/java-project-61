plugins {
    java
    application
    id("checkstyle")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("com.diffplug.spotless") version "6.25.0"
}

spotless {
    java {
        target("src/**/*.java")  // Указываем целевые файлы
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
        googleJavaFormat("1.17.0").aosp()  // Указываем явную версию форматера
        importOrder()  // Сортировка импортов
    }
    format("misc") {
        target("*.gradle.kts", "*.md", ".gitignore")
        trimTrailingWhitespace()
        endWithNewline()
    }
}

checkstyle {
    toolVersion = "10.12.5"
    configFile = file("config/checkstyle/checkstyle.xml")
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
    destinationDir = file("$buildDir/install/app/")
    doLast {
        println("Дистрибутив создан в: $destinationDir")
    }
}
