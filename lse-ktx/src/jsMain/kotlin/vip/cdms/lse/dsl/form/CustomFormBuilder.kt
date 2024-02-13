package vip.cdms.lse.dsl.form

import CustomForm
import Player
import kotlin.reflect.KProperty

/**
 * 示例
 * ```
 * mc.getPlayer("Cdm2883") send
 *         CustomFormBuilder {
 *             title = "注册"
 *             label(text = "Tip: 用户名只能是数字英文组合")
 *             val name by input("你的用户名")
 *
 *             submit = {  // 玩家提交表单之后的回调
 *                 player.tell(msg = "name: $name")
 *             }
 *             cancel = {  // 玩家取消表单之后的回调. 绝对不要用之前委托获取的属性!! 例如这里的 name
 *                 // 坏坏玩家关闭了表单, 必须惩罚他
 *                 kill()
 *             }
 *         } + // 可以封装不同组件, 然后加起来!
 *         CustomFormBuilder {
 *             val password by input("你的密码")
 *             val repeat by input("请再输入一遍")
 *             submit = {
 *                 player.tell(msg = "password: $password")
 *             }
 *         }
 * ```
 */
class CustomFormBuilder : ArrayList<CustomFormBuilder.FormComponent<*>>(), FormBuilder {
    var index: Int = 0
    override var title: String? = null
    var submit: (Player.() -> Unit)? = null
    var cancel: (Player.() -> Unit)? = null

    @Suppress("unused")
    class FormComponent<T>(var value: dynamic, val builder: CustomForm.() -> Unit)
    operator fun <T> FormComponent<T>.getValue(t: Any?, property: KProperty<*>): T = (value as? T)!!
    private fun <T> addComponent(value: T? = null, builder: CustomForm.() -> Unit) =FormComponent<T>(value, builder).apply { add(this) }

    fun label(text: String) = addComponent(text) { addLabel(text) }
    fun input(title: String, placeholder: String? = undefined, default: String? = undefined) = addComponent<String> {
        // 真是够了, lse这些函数传undefined过去会当作正常参数
        when {
            placeholder != null && default != null -> addInput(title, placeholder, default)
            placeholder != null -> addInput(title, placeholder)
            default != null -> addInput(title, default = default)
            else -> addInput(title)
        }
    }
    fun switch(title: String, default: Boolean? = undefined) = addComponent<Boolean> {
        if (default == undefined) addSwitch(title)
        else addSwitch(title, default)
    }
    fun dropdown(title: String, items: Array<String>, default: Int? = undefined) = addComponent<Int> {
        if (default == undefined) addDropdown(title, items)
        else addDropdown(title, items, default)
    }
    fun slider(title: String, min: Int, max: Int, step: Int? = undefined, default: Int? = undefined) = addComponent<Int> {
        when {
            step != null && default != null -> addSlider(title, min, max, step, default)
            step != null -> addSlider(title, min, max, step)
            default != null -> addSlider(title, min, max, default = default)
            else -> addSlider(title, min, max)
        }
    }
    fun stepSlider(title: String, items: Array<String>, default: Int? = undefined) = addComponent<Int> {
        if (default == undefined) addStepSlider(title, items)
        else addStepSlider(title, items, default)
    }

    @Suppress("DuplicatedCode")
    operator fun plus(builder: CustomFormBuilder): CustomFormBuilder {
        val new = CustomFormBuilder()
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
//    operator fun plus(form: CustomForm): CustomFormBuilder

    override infix fun send(player: Player) {
        val form = mc.newCustomForm()
        form.setTitle(title ?: throw Error("None of title"))
        forEach { component -> component.builder(form) }

        player.sendForm(form) {
            _: Player, data: Array<dynamic>? ->
            if (data == null) {
                cancel?.let { it(player) }
                return@sendForm
            }

            for (i in index..<size) {
                this[i].value = data[i] ?: this[i].value
            }
            submit?.let { it(player) }
        }
    }
}
fun CustomFormBuilder(index: Int = 0, extension: CustomFormBuilder.() -> Unit): CustomFormBuilder {
    val builder = CustomFormBuilder()
    builder.index = index
    builder.extension()
    return builder
}
