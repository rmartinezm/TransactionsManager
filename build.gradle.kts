import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
}

group = "me.robertomtz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("org.koin:koin-core:2.2.2")
    implementation("com.google.code.gson:gson:2.8.6")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}