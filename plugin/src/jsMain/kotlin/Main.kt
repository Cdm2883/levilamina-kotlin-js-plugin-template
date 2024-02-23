import vip.cdms.lse.dsl.command.MCCommandHelper
import vip.cdms.lse.dsl.form.ModalFormBuilder
import vip.cdms.lse.dsl.form.SimpleFormBuilder
import vip.cdms.lse.dsl.form.send

fun main() {
    log("Hello, Kotlin/JS!")
    mc.listen("onJoin") {
        player: Player ->
        logger.warn("${player.name} joined the server!")
    }

    mc.listen("onServerStarted") {
        val helper = MCCommandHelper {
            cmd = "tpa"
            description = "玩家互传"
            permission = PermType.Any
        }
        val command = helper.build()
        command.overload(arrayOf())
        command.setCallback { _, origin, _, _ ->
            if (origin.player == null) return@setCallback
            origin.player!! send SimpleFormBuilder {
                val root = this  // 传送锚点 (
                title = "TPA玩家互传"
                content = "选择传送模式"

                fun playerSelector(title: String, callback: Player.(select: Player) -> Unit)
                    = custom(title) {
                        this.title = title
                        val players = mc.getOnlinePlayers()
                        val index by dropdown("选择", players.map { it.name }.toTypedArray())
                        submit = { callback(this, players[index]) }
                        cancel = { root send this }
                        // also cancel = { this@SimpleFormBuilder send this }
                        // also cancel = { this send root }
                    }
                fun Player.questPlayer(content: String, confirm: () -> Unit)
                    = this send ModalFormBuilder {
                        this.title = this@SimpleFormBuilder.title
                        this.content = content
                        this.confirm = ModalFormBuilder.Action("同意") { confirm() }
                    }

                playerSelector("传送自己到别人") { select ->
                    select.questPlayer("$name 请求传送到你这里") { teleport(select.pos) }
                }
                playerSelector("传送别人到自己") { select ->
                    select.questPlayer("$name 请求你传送到TA那里") { select.teleport(pos) }
                }
            } }
        command.setup()
    }

}
