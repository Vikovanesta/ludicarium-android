import me.hailpanda.ludicarium.AppBuildType

plugins {
    alias(libs.plugins.ludicarium.android.application)
    alias(libs.plugins.ludicarium.android.application.compose)
    alias(libs.plugins.ludicarium.android.hilt)
}

android {
    namespace = "me.hailpanda.ludicarium"

    defaultConfig {
        applicationId = "me.hailpanda.ludicarium"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = AppBuildType.DEBUG.applicationIdSuffix
        }

        val release = getByName("release") {
            isMinifyEnabled = true
            applicationIdSuffix = AppBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
            // Ensure Baseline Profile is fresh for release builds.
//            baselineProfile.automaticGenerationDuringBuild = true
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    flavorDimensions += listOf("contentType")
    productFlavors {
        create("demo") {
            dimension = "contentType"
        }
        create("prod") {
            dimension = "contentType"
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)

    implementation(project(":core:designSystem"))

    debugImplementation(libs.androidx.compose.ui.testManifest)
}

dependencyGuard {
    configuration("prodReleaseRuntimeClasspath")
}