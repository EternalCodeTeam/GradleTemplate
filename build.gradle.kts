plugins {
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.eternalcode.gradletemplate"
version = "1.0.0"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    // lombok
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
}


java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType <com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("GradleTemplate v${project.version}.jar")

    exclude("org/intellij/lang/annotations/**")
    exclude("org/jetbrains/annotations/**")
    exclude("javax/**")
}
