plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
//    id("androidx.navigation.safeargs.kotlin")
//    id("kotlin-android-extension")
}

android {
    namespace = "ir.androidcoder.testingandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "ir.androidcoder.testingandroid"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation("com.google.truth:truth:1.1.3")

    // Material Design
    implementation ("com.google.android.material:material:1.12.0")

    // Architectural Components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")

    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    implementation ("androidx.lifecycle:lifecycle-runtime:2.8.6")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")

    // Room
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")

    // Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.6.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Coroutine Lifecycle Scopes
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")

    // Navigation Components
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    //Coil
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("io.coil-kt:coil-svg:2.5.0")

    // Activity KTX for viewModels()
    implementation ("androidx.activity:activity-ktx:1.9.2")

    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.50")
    kapt ("com.google.dagger:hilt-android-compiler:2.50")

    kapt ("androidx.hilt:hilt-compiler:1.2.0")

    // Timber
    implementation ("com.jakewharton.timber:timber:4.7.1")

    // Local Unit Tests
    implementation ("androidx.test:core:1.6.1")
    testImplementation ("junit:junit:4.13")
    testImplementation ("org.hamcrest:hamcrest-all:1.3")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.robolectric:robolectric:4.3.1")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation ("com.google.truth:truth:1.1.3")
//    testImplementation ("org.mockito:mockito-core:5.2.1")

    // Instrumented Unit Tests
//    androidTestImplementation ("com.linkedin.dexmaker:dexmaker-mockito:5.2.1")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("com.google.truth:truth:1.1.3")
//    androidTestImplementation ("org.mockito:mockito-core:5.2.1")
//    testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")

}