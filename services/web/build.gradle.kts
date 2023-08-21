val ktor_version: String by project

plugins{
    standardKotlinJvmModule()
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

repositories{
    mavenCentral()
}

dependencies{
    implementation("io.ktor:ktor-server-jetty-jvm:$ktor_version")
    implementation(project(":services:domain"))
    implementation(project(":services:infrastructure"))
    testImplementation(project(":services:app"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}
