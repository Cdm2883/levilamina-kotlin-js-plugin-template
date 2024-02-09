fun main() {
    log("Hello, Kotlin/JS!")
    mc.listen("onJoin") {
        player: Player ->
        logger.warn("${player.name} joined the server!")
    }
}