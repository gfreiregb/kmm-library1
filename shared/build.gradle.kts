plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
}

val libName = "kmm_library1"
val libVersion = "1.3.0"
group = "com.project.kmm_library1"

version = libVersion

publishing {
    publications.withType<MavenPublication> {
        artifactId = libName
    }
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/gfreiregb/kmm-library1")
            credentials {
                username = "gfreiregb"
                password = "CREATE_YOUR_PERSONAL_ACCESS_TOKEN"
            }
        }
    }
}

kotlin {
    targetHierarchy.default()

    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()
}

android {
    namespace = "com.project.kmm_library1"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}