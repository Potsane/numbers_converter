buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.gradle)
        classpath (libs.kotlin.gradle.plugin)
        classpath (libs.hilt.android.gradle.plugin)
        classpath (libs.google.services)
        classpath (libs.firebase.crashlytics.gradle)
        classpath (libs.androidx.navigation.safe.args.gradle.plugin)
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}