import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins{
    `kotlin-dsl`
}

repositories{
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains.kotlin", "kotlin-gradle-plugin", "1.8.10")
    implementation(kotlin("script-runtime"))
}