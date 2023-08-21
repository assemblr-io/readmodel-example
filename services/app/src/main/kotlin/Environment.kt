object Environment {
    val port = getIntEnvironmentVar("QUERY_PORT")
    val dbConnectionString = getStringEnvironmentVar("EVENTSOURCE_DB_URL")
}

private fun getStringEnvironmentVar(key: String): String {
    val value = System.getenv(key) ?: throw RuntimeException("environment variable $key not set")
    if (value.isBlank()) throw RuntimeException("environment variable $key must not be blank.")
    return value
}

private fun getIntEnvironmentVar(key: String): Int {
    val value = System.getenv(key) ?: throw RuntimeException("environment variable $key not set")
    val intValue = value.toIntOrNull() ?: throw RuntimeException("environment variable $key must be of type int.")
    if (intValue<0) throw RuntimeException("[$key] environment variable must be greater than 0.")
    return intValue
}