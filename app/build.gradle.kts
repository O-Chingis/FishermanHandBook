plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.kotlinfishermanhandbook"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.kotlinfishermanhandbook"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    // Правильный способ включения ViewBinding
    viewBinding {
        enable = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")
    implementation(libs.material)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testImplementation(libs.junit) // убедитесь, что junit указан в libs.versions.toml
    testImplementation(libs.mockito) // убедитесь, что mockito указан в libs.versions.toml

    androidTestImplementation(libs.androidx.junit) // убедитесь, что androidx.junit указан в libs.versions.toml
    androidTestImplementation(libs.androidx.espresso.core) // убедитесь, что androidx.espresso.core указан в libs.versions.toml
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4) // убедитесь, что androidx.ui.test.junit4 указан в libs.versions.toml

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    testImplementation(libs.junit) // Ensure junit is defined in libs.versions.toml
    testImplementation(libs.mockito) // Ensure mockito is defined in libs.versions.toml

    androidTestImplementation(libs.androidx.junit) // Ensure androidx.junit is defined in libs.versions.toml
    androidTestImplementation(libs.androidx.espresso.core) // Ensure androidx.espresso.core is defined in libs.versions.toml
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4) // Ensure androidx.ui.test.junit4 is defined in libs.versions.toml
    androidTestImplementation(libs.androidx.ui.test.junit4) // UI-тесты для Compose



}