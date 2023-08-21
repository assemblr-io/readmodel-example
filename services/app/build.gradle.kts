

val postgres_version: String by project
val ktor_version: String by project
val kotlinx_version: String by project

plugins{
    application
    standardKotlinJvmModule()
}

dependencies {
    implementation(project(":services:domain"))
    implementation(project(":services:infrastructure"))
    implementation("org.postgresql:postgresql:$postgres_version")
    implementation(project(":services:web"))
    implementation("ch.qos.logback:logback-classic:1.4.8")
}

application {
    mainClass.set("vgw.events.lnd.ApplicationKt")
}
