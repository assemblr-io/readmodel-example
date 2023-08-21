
plugins{
    standardKotlinJvmModule()
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

repositories{
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}