package vip.cdms.lse.dsl.form

import Player
import mc

/**
 * ```
 * mc.getPlayer("Cdm2883") send
 *         SimpleFormBuilder {
 *             title = "标题"
 *             content = "内容"
 *             simple(text = "A") {  // 轻松构建嵌套表单
 *                 // title不写会继承 (content也是), 这里将会是"标题"
 *                 content = "AAA"
 *                 button(text = "A -> A")
 *                 button(text = "A -> B")
 *                 button(text = "A -> C")
 *             }
 *             button(text = "B") {
 *                 sendToast(title = "Oops!", message = "awa")
 *                 teleport(feetPos.apply { y += 40 })
 *             }
 *             button(text = "C")
 *
 *             submit = {
 *                 // 任意按钮按下
 *             }
 *             cancel = {}
 *         }
 * ```
 */
class SimpleFormBuilder : ArrayList<SimpleFormBuilder.Button>(), FormBuilder {
    var index: Int = 0
    override var title: String? = null
    var content: String? = null
    var submit: (Player.() -> Unit)? = null
    var cancel: (Player.() -> Unit)? = null

    class Button(val text: String, val image: String?, val callback: (Player.() -> Unit)?)
    fun button(text: String, image: String? = undefined, callback: (Player.() -> Unit)? = null) = add(Button(text, image, callback))
    fun simple(text: String, image: String? = undefined, callback: SimpleFormBuilder.(Player) -> Unit) =
        button(text, image) {
            val builder = SimpleFormBuilder()
            builder.title = title
            builder.content = content
            builder.callback(this)
            builder send this
        }
    fun modal(text: String, image: String? = undefined, callback: ModalFormBuilder.(Player) -> Unit) =
        button(text, image) {
            val builder = ModalFormBuilder()
            builder.title = title
            builder.content = content
            builder.callback(this)
            builder send this
        }
    fun custom(text: String, image: String? = undefined, callback: CustomFormBuilder.(Player) -> Unit) =
        button(text, image) {
            val builder = CustomFormBuilder()
            builder.title = title
            builder.callback(this)
            builder send this
        }

    @Suppress("DuplicatedCode")
    operator fun plus(builder: SimpleFormBuilder): SimpleFormBuilder {
        val new = SimpleFormBuilder()
        new.title = builder.title ?: title
        new.submit = {
            submit?.invoke(this)
            builder.submit?.invoke(this)
        }
        new.cancel = {
            cancel?.invoke(this)
            builder.cancel?.invoke(this)
        }
        new.addAll(this)
        new.addAll(builder)
        return new
    }

    override infix fun send(player: Player) {
        val form = mc.newSimpleForm()
        form.setTitle(title ?: throw Error("None of title"))
        forEach { button ->
            if (button.image == undefined) form.addButton(text = button.text)
            else form.addButton(text = button.text, image = button.image)
        }

        player.sendForm(form) {
            _: Player, id: Int? ->
            if (id == null) {
                cancel?.let { it(player) }
                return@sendForm
            }

            getOrNull(index + id)?.callback?.invoke(player)
        }
    }
}
fun SimpleFormBuilder(index: Int = 0, extension: SimpleFormBuilder.() -> Unit): SimpleFormBuilder {
    val builder = SimpleFormBuilder()
    builder.index = index
    builder.extension()
    return builder
}
