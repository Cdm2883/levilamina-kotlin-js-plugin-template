package vip.cdms.lse.dsl.command

import Command
import PermType
import mc

/**
 * ```
 * MCCommandHelper {
 *         cmd = "kotlinjs"
 *         description = "Kotlin/JS 命令注册DSL测试"
 *         permission = PermType.Any
 *
 * //        aliases = arrayListOf("kotlin", "ktjs", "kt")
 *         alias = "kotlin"
 *         alias = "ktjs"
 *         alias = "kt"
 *
 *         build {
 *             setEnum("ChangeAction", arrayOf("add", "remove"))
 *             setEnum("ListAction", arrayOf("list"))
 *             mandatory("action", ParamType.Enum, "ChangeAction", 1)
 *             mandatory("action", ParamType.Enum, "ListAction", 1)
 *             mandatory("name", ParamType.RawText)
 *             overload(arrayOf("ChangeAction", "name"))
 *             overload(arrayOf("ListAction"))
 *             setCallback { cmd, origin, output, result ->
 *                 when (result.action) {
 *                     "add" -> output.success("add \"${result.name}\"")
 *                     "remove" -> output.success("remove \"${result.name}\"")
 *                     "list" -> output.success("Name List:")
 *                 }
 *             }
 *             setup()
 *         }
 *     }
 * ```
 */
class MCCommandHelper {
    lateinit var cmd: String
    var description: String = "Kotlin/JS"
    var permission = PermType.GameMasters
    var flag: Int = 0x80

    var aliases = ArrayList<String>()
    var alias: String
        get() = aliases.last()
        set(value) { aliases.add(value) }

    fun build(extension: Command.() -> Unit = {}): Command {
        val command = mc.newCommand(cmd, description, permission, flag)
        aliases.forEach { alias -> command.setAlias(alias) }
        command.extension()
        return command
    }
}
fun MCCommandHelper(extension: MCCommandHelper.() -> Unit): MCCommandHelper {
    val helper = MCCommandHelper()
    helper.extension()
    return helper
}
