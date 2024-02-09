fun main() {
    log("Hello, Kotlin/JS!")
    mc.listen("onJoin") {
        log("join")
    }
}