const val kotlinVersion = "1.4.30"

object BuildPlugins {
    object Version {
        const val androidBuildToolsVersion = "7.0.0-alpha06"
        const val versionsVersion = "0.33.0"
        const val detektVersion = "1.14.1"
        const val ktlintVersion = "9.4.0"
        const val canidropjetifierVersion = "0.5"
    }

    const val versions = "com.github.ben-manes.versions"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
    const val canidropjetifier = "com.github.plnice.canidropjetifier"

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Version.androidBuildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

    const val versionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Version.versionsVersion}"
    const val detektPlugin = "$detekt:detekt-gradle-plugin:${Version.detektVersion}"
    const val ktlintPlugin = "org.jlleitschuh.gradle:ktlint-gradle:${Version.ktlintVersion}"
    const val canidropjetifierPlugin = "com.github.plnice:canidropjetifier:${Version.canidropjetifierVersion}"
}

object AndroidSdk {
    const val min = 23
    const val compile = 30
    const val target = compile
}


object Libraries {
    private object Versions {
        const val appCompat = "1.3.0-beta01"
        const val ktxActivity = "1.3.0-alpha02"
        const val ktxFragment = "1.3.0"
        const val material = "1.3.0"
        const val constraintLayout = "2.1.0-alpha1"
        const val navigation = "2.3.3"

        const val junit = "4.13.1"
        const val androidXJunit = "1.1.3-alpha04"
        const val espressoCore = "3.4.0-alpha04"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val ktxActivity = "androidx.activity:activity-ktx:${Versions.ktxActivity}"
    const val ktxFragment = "androidx.fragment:fragment-ktx:${Versions.ktxFragment}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val junit = "junit:junit:${Versions.junit}"
    const val androidXJunit = "androidx.test.ext:junit:${Versions.androidXJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
