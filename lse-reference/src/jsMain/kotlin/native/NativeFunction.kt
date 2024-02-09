external enum class NativeTypes {
    Void,
    Bool,
    Char,
    UnsignedChar,
    Short,
    UnsignedShort,
    Int,
    UnsignedInt,
    Long,
    UnsignedLong,
    LongLong,
    UnsignedLongLong,
    Float,
    Double,
    Pointer,
}

open external class NativeHook {
    /**
     * call功能
     *
     * 通过虚拟对象call，调用对应函数
     * @param params 对应NativeFunction所描述的函数参数
     * @return 对应NativeFunction所描述的返回类型
     */
    fun call(vararg params: Any): Any

    /** 函数指针的指针值 NativePointer|number */
    var address: Any
}

// 都用的
// &ScriptNativeFunction::getCallableFunction
// &ScriptNativeFunction::getAddress
// &ScriptNativeFunction::setAddress
// 算继承吧
external class NativeFunction : NativeHook {
    /**
     * Hook函数钩子
     *
     * 改写指定地址函数的头部，设置回调函数，当原函数调用时则会调用回调函数 如果需要保留原始功能，请记得在回调函数内调用原函数
     * @param func 回调函数，请注意保持参数类型与NativeFunction描述的一致
     */
    fun hook(func: Any): NativeHook

    companion object {
        /**
         * Symbol获得函数
         *
         * 自动解析Symbol并得到一个可调用的函数，如解析失败，抛出异常
         * @param symbol 需要解析的函数
         * @return 原生函数实例
         */
        fun fromSymbol(symbol: String): NativeFunction

        /**
         * Describe获得函数
         *
         * 描述函数类型并得到一个不可调用的函数，如需调用，则还需手动设置Address属性
         * @param ReturnValue 返回值类型
         * @param Params 参数类型，从左到右直接传递
         */
        fun fromDescription(
            ReturnValue: NativeTypes,
            Params: Array<NativeTypes>
        ): NativeFunction

        /**
         * Script获得函数
         *
         * 描述函数类型并得到一个来自脚本的函数，其被包装为可直接在本机代码中调用的函数
         * @param ReturnValue 返回值类型
         * @param Params 参数类型，从左到右直接传递
         * @param Callback 回调函数，当该原生包装函数被调用后，会调用此函数
         */
        fun fromScript(
            ReturnValue: NativeTypes,
            Params: Array<NativeTypes>,
            Callback: Any
        ): NativeFunction
    }
}
