package vip.cdms.lse.dsl.form

import Player

class ModalFormBuilder : FormBuilder {
    override var title: String? = null
    var content: String? = null
    var submit: (Player.() -> Unit)? = null

    class Action(val text: String, val callback: Player.() -> Unit)
    var confirm: Action? = null
    fun confirm(text: String, callback: Player.() -> Unit) { confirm = Action(text, callback) }
    var cancel: Action? = null
    fun cancel(text: String, callback: Player.() -> Unit) { cancel = Action(text, callback) }

    override infix fun send(player: Player) {
        player.sendModalForm(
            title = title ?: "",
            content = content ?: "",
            confirmButton = confirm?.text ?: "",
            cancelButton = cancel?.text ?: "",
        ) {_, result ->
            if (result == null || result == false) cancel?.callback?.invoke(player)
            else confirm?.callback?.invoke(player)
            submit?.invoke(player)
        }
    }
}
fun ModalFormBuilder(extension: ModalFormBuilder.() -> Unit): ModalFormBuilder {
    val builder = ModalFormBuilder()
    builder.extension()
    return builder
}
