import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("com.google.gms.google-services")
}

val localProperties = Properties()

localProperties.load(
    rootProject.file("local.properties").inputStream()
)

android {

    namespace = "com.prathvik.arogyanidhi"

    compileSdk = 35

    defaultConfig {

        applicationId = "com.prathvik.arogyanidhi"

        minSdk = 26
        targetSdk = 35

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"

        val geminiApiKey =
            localProperties.getProperty(
                "GEMINI_API_KEY"
            ) ?: ""

        buildConfigField(
            "String",
            "GEMINI_API_KEY",
            "\"$geminiApiKey\""
        )
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_17

        targetCompatibility =
            JavaVersion.VERSION_17
    }

    kotlinOptions {

        jvmTarget = "17"
    }

    buildFeatures {

        compose = true

        buildConfig = true
    }

    packaging {

        resources {

            excludes += "/META-INF/{AL2.0,LGPL2.1,INDEX.LIST}"
        }
    }
}

dependencies {

    implementation(
        platform(
            libs.androidx.compose.bom
        )
    )

    implementation(libs.androidx.compose.ui)

    implementation(
        libs.androidx.compose.material3
    )

    implementation(
        libs.androidx.activity.compose
    )

    implementation(libs.androidx.core.ktx)

    implementation(
        libs.androidx.lifecycle.runtime.ktx
    )

    implementation(
        libs.androidx.navigation.compose
    )

    implementation(libs.androidx.room.runtime)

    implementation(libs.androidx.room.ktx)

    implementation(
        libs.kotlinx.coroutines.android
    )

    implementation(libs.retrofit)

    implementation(libs.retrofit.gson)

    implementation(libs.okhttp.logging)

    implementation(
        platform(
            "com.google.firebase:firebase-bom:33.1.2"
        )
    )
    implementation("androidx.compose.material:material-icons-extended")

    implementation(
        "com.google.firebase:firebase-auth-ktx"
    )

    testImplementation(libs.junit)

    androidTestImplementation(
        libs.androidx.junit
    )

    androidTestImplementation(
        libs.androidx.espresso.core
    )
}