plugins {
    alias(libs.plugins.kotlin.jvm)
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.javaCompatibility.get().toInt())
    targetCompatibility = JavaVersion.toVersion(libs.versions.javaCompatibility.get().toInt())
}