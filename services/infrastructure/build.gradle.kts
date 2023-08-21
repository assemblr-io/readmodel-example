val postgres_version: String by project

plugins{
    standardKotlinJvmModule()
}

repositories{
    mavenCentral()
}

dependencies {
    implementation(project(":services:domain"))
    implementation("org.postgresql:postgresql:$postgres_version")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}
