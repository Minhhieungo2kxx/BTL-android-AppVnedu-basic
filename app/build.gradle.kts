plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.btl_qlsv"
    compileSdk = 35



    defaultConfig {
        applicationId = "com.example.btl_qlsv"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Add this if not already

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.itextpdf:itext7-core:7.2.5")
    implementation("com.squareup.picasso:picasso:2.8")
//    implementation("com.github.AnyChart:AnyChart-Android:1.1.2")
    implementation("org.apache.poi:poi:5.2.3") // Thư viện Apache POI
    implementation("org.apache.poi:poi-ooxml:5.2.3") // Thư viện hỗ trợ định dạng .xlsx


    configurations.all {
        resolutionStrategy {
            force("androidx.core:core:1.13.0")
            // Nếu thư viện nào đang kéo support cũ, loại bỏ nó
            eachDependency {
                if (requested.group == "com.android.support") {

                }
            }
        }


    }
}