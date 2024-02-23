// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/CommandAPI.cpp

external class LLSE_Command(nullptr: Nothing) {
    val name: String
    val registered: Boolean

    /**
     * 新增一个指令枚举选项
     * @param name 枚举名, 用于设置参数时区分枚举
     * @param values 枚举的有效值
     * @return 新增枚举选项的标识名称
     */
    fun setEnum(name: String, values: Array<String>): String

    /**
     * 设置指令别名 (可多次调用)
     * @param alias 指令别名
     * @return 是否成功设置
     */
    fun setAlias(alias: String): Boolean

    //.instanceFunction("newParameter", &CommandClass::newParameter)

    /**
     * 新增一个必选参数
     * @param name 参数名, 用于执行指令时识别参数
     * @param type 命令参数类型
     * @param enumName 枚举名 (仅 ParamType 为 Enum 时有效, 用于区分枚举选项)
     * @param identifier 参数标识. 特殊情况下用于唯一识别参数, 一般可用 enumName 或 name 代替
     * @param enumOptions 参数选项. 设置为 1 可在指令提示中展开枚举选项, 如 <action : TagChangeAction> 会变成 <add|remove>
     * @return 是否成功设置
     */
    fun mandatory(
        name: String,
        type: ParamType,
        enumName: String,
        identifier: String,
        enumOptions: Int
    ): Boolean
    /** @see mandatory */
    fun mandatory(
        name: String,
        type: ParamType,
        enumName: String,
        identifier: String
    ): Boolean
    /** @see mandatory */
    fun mandatory(
        name: String,
        type: ParamType,
        enumName: String
    ): Boolean
    /** @see mandatory */
    fun mandatory(
        name: String,
        type: ParamType,
        enumName: String,
        enumOptions: Int
    ): Boolean
    /** @see mandatory */
    fun mandatory(
        name: String,
        type: ParamType
    ): Boolean

    /**
     * 新增一个必选参数
     * @param name 参数名, 用于执行指令时识别参数
     * @param type 命令参数类型
     * @param enumName 枚举名 (仅 ParamType 为 Enum 时有效, 用于区分枚举选项)
     * @param identifier 参数标识. 特殊情况下用于唯一识别参数, 一般可用 enumName 或 name 代替
     * @param enumOptions 参数选项. 设置为 1 可在指令提示中展开枚举选项, 如 <action : TagChangeAction> 会变成 <add|remove>
     * @return 是否成功设置
     */
    fun optional(
        name: String,
        type: ParamType,
        enumName: String,
        identifier: String,
        enumOptions: Int
    )
    /** @see optional */
    fun optional(
        name: String,
        type: ParamType,
        enumName: String,
        identifier: String
    )
    /** @see optional */
    fun optional(
        name: String,
        type: ParamType,
        enumName: String
    )
    /** @see optional */
    fun optional(
        name: String,
        type: ParamType,
        enumName: String,
        enumOptions: Int
    )
    /** @see optional */
    fun optional(
        name: String,
        type: ParamType
    )

//    目前没有相关文档 :/
//    fun setSoftEnum()
//    fun addSoftEnumValues()
//    fun removeSoftEnumValues()
//    fun getSoftEnumValues()
//    fun getSoftEnumNames()

    /**
     * 新增一条指令重载
     *
     * 要想让命令正常运行, 必须至少添加一条重载.
     * 所谓重载, 本质上相当于参数的组合, 譬如重载`['a', 'b', 'c']`
     * 相当于命令可以被执行为`/cmd <a> <b> <c>`,
     * 而重载`[]`相当于可以被执行为`/cmd`.
     *
     * 重载的参数标识符可以是参数名, 枚举名, 参数标识符,
     * 但不能使用无法区分具体参数的标识符,
     * 如两个参数都叫 `action` 但枚举选项不同, 此时应该使用枚举名而不是参数名.
     * @param params 参数标识符, 重载所用到的参数列表, 可用 参数标识符,枚举名,参数名.
     * @return 是否成功设置
     */
    fun overload(params: Array<String>): Boolean

    /**
     * 设置指令回调
     * @param callback 注册的这个命令被执行时, 接口自动调用的回调函数.
     * @return 是否成功设置
     */
    fun setCallback(callback: (
                cmd: Command,
                origin: CommandOrigin,
                output: CommandOutput,
                result: dynamic
            ) -> Unit): Boolean

    /**
     * 安装指令
     *
     * 在对命令的所有配置完成之后, 使用此函数将命令注册到 BDS 的命令系统当中
     * @return 是否成功安装
     */
    fun setup(): Boolean
}
typealias Command = LLSE_Command

external enum class PermType {
    /** 任何人都可以执行这条指令 #0 */
    Any,
    /** 只有OP可以执行这条指令 #1 */
    GameMasters,
    /** #2 */
    Admin,
    /** #3 */
    HostPlayer,
    /** 只有控制台可以执行这条指令 #4 */
    Console,
    /** #5 */
    Internal
}

external enum class ParamType {
    /** 布尔值参数 */
    Bool,
    /** 整数参数 */
    Int,
    /** 浮点数参数 */
    Float,
    /** 字符串参数 */
    String,
    /** 实体目标选择器参数 */
    Actor,
    /** 玩家目标选择器参数 */
    Player,
    /** 整数坐标参数 */
    BlockPos,
    /** 浮点数坐标参数 */
    Vec3,
    /** 原始字符串参数(可包含特殊字符，如逗号空格，只能作为最后一个参数使用) */
    RawText,
    /** 消息类型参数(同 /say 指令参数，会自动展开目标选择器等) */
    Message,
    /** JSON字符串参数 */
    JsonValue,
    /** 物品类型参数 */
    Item,
    /** 方块类型参数 */
    Block,
    /** 效果类型参数 */
    Effect,
    /** 枚举参数 */
    Enum,
    /** 可变枚举参数 */
    SoftEnum,
    /** 实体类型参数 */
    ActorType,
    /** 指令名称参数（仅供测试） */
    Command
}

external class CommandOrigin(nullptr: Nothing) {
    /** 指令执行主体类型 */
    val type: Number

    val typeName: String

    /** 指令执行主体的名称 */
    val name: String

    /** 指令执行主体的坐标 */
    val pos: FloatPos

    /** 指令执行主体的方块坐标 */
    val blockPos: IntPos

    /** 执行指令的实体（可空） */
    val entity: Entity?

    /** 执行指令的玩家（可空） */
    val player: Player?

    fun getNbt(): NbtCompound

    override fun toString(): String
}

external class CommandOutput(nullptr: Nothing) {
    val empty: Boolean
    //.instanceProperty("type", &CommandOutputClass::getType)
    val successCount: Number

    /**
     * 输出一条成功信息
     * @param msg 要输出的信息
     * @param param 要替换的参数
     * @returns 是否成功输出
     */
    fun success(msg: String?, param: Array<Any>? = definedExternally): Boolean

    /**
     * 输出一条错误信息
     * @param msg 要输出的信息
     * @param param 要替换的参数
     * @returns 是否成功输出
     */
    fun error(msg: String, param: Array<Any>? = definedExternally): Boolean

    /**
     * 输出一条普通信息
     * @param msg 要输出的信息
     * @param param 要替换的参数
     * @param arg3 整数 作用未知
     * @returns 是否成功输出
     */
    fun addMessage(msg: String, param: Array<Any>? = definedExternally, arg3: Int? = definedExternally): Boolean

    override fun toString(): String
}