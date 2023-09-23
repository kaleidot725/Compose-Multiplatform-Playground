import com.android.build.gradle.internal.tasks.factory.dependsOn
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.licensee)
    alias(libs.plugins.kotlinx.serialization)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activityCompose)
                implementation(libs.compose.uitooling)
                implementation(libs.kotlinx.coroutines.android)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutines.swing)
            }
        }

        val iosMain by getting {
            dependencies {
            }
        }
    }
}

android {
    namespace = "jp.kaleidot725.sample.license"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        applicationId = "jp.kaleidot725.sample.license.androidApp"
        versionCode = 1
        versionName = "1.0.0"
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
        resources.srcDirs("src/commonMain/resources")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jp.kaleidot725.sample.license.desktopApp"
            packageVersion = "1.0.0"
        }
    }
}

enum class LicenseFile(
    val from: File, val to: File
) {
    Android(
        from = File("composeApp/build/reports/licensee/androidRelease/artifacts.json"),
        to = File("composeApp/src/commonMain/resources/licensee/android/artifacts.json")
    ),
    IOSX64(
        from = File("composeApp/build/reports/licensee/iosX64/artifacts.json"),
        to = File("composeApp/src/commonMain/resources/licensee/iosX64/artifacts.json"),
    ),
    IOSArm64(
        from = File("composeApp/build/reports/licensee/iosArm64/artifacts.json"),
        to = File("composeApp/src/commonMain/resources/licensee/iosArm64/artifacts.json"),
    ),
    IOSSimulatorArm64(
        from = File("composeApp/build/reports/licensee/iosSimulatorArm64/artifacts.json"),
        to = File("composeApp/src/commonMain/resources/licensee/iosSimulatorArm64/artifacts.json"),
    ),
    JVM(
        from = File("composeApp/build/reports/licensee/desktop/artifacts.json"),
        to = File("composeApp/src/commonMain/resources/licensee/desktop/artifacts.json"),
    )
}

licensee {
    allow("Apache-2.0")
    allow("MIT")
}

tasks.register("updateLicense") {
    doFirst {
        LicenseFile.values().forEach { item ->
            item.from.copyTo(item.to, true)
        }
    }
}.dependsOn(tasks.check)
