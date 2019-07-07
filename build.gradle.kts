// Reference - https://kotlinlang.org/docs/reference/using-gradle.html
// Update at 20190705

import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "shijian.su"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.3.41"
}

repositories {
    jcenter()
}

dependencies {
    // implementation(kotlin("stdlib")) // Java6
    // implementation(kotlin("stdlib-jdk7")) // Java7
    implementation(kotlin("stdlib-jdk8")) // Java8
    // use Kotlin reflection
    implementation(kotlin("reflect"))
    // use testing facilities
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

// To specify additional compilation options, use the kotlinOptions property of a Kotlin compilation task.
tasks.withType<KotlinCompile> {
    kotlinOptions.suppressWarnings = true
}

sourceSets["main"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("part-1-introducing-kotlin/src/main/kotlin")
    kotlin.srcDir("part-2-embracing-kotlin/src/main/kotlin")
}
