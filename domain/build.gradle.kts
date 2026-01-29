plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(libs.javax.inject)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
}

