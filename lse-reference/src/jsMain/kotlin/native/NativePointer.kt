// https://github.com/LiteLDev/LegacyScriptEngine/blob/d700ce3a2dd20e84c986f19ab18925ff2d7d7b0a/src/legacy/api/NativePointer.cpp#L12

external class NativePointer {
    /**
     * 指针地址
     * @return 以数字形式表示的指针所指地址
     */
    fun asRawAddress(): Number

    /**
     * 指针地址描述
     * @return 以十六进制形式表示的指针所指地址
     */
    fun asHexAddress(): String

    fun asRef(): NativePointer
    fun deRef(): NativePointer

    fun isNull(): Boolean

    /**
     * 指针偏移
     * @param offset 偏移量
     * @returns 偏移后指针
     */
    fun offset(offset: Number): NativePointer

    val byte: Any
    val int8: Any
    val uint8: Any
    val int16: Any
    val uint16: Any
    val int32: Any
    val uint32: Any
    val long: Any
    val ulong: Any
    val int64: Any
    val uint64: Any
    val float: Any
    val double: Any
    val string: String
    val bool: Boolean

    fun asStdString(): NativeStdString
// TODO
//    fun asEntity(): LLSE_Entity
//    fun asItem(): LLSE_Item
//    fun asPlayer(): LLSE_Player
//    fun asContainer(): LLSE_Container

    companion object {
        /**
         * 内存申请
         * @param size 欲申请的内存的大小
         * @return 指向新内存的指针
         */
        fun malloc(size: Number): NativePointer

        /**
         * 销毁内存
         * @param block 需要销毁的内存块
         */
        fun free(block: NativePointer)

        /**
         * 获得符号地址
         * @param symbol 需要查询的符号
         * @return 查询结果，若查询失败则返回空指针
         */
        fun fromSymbol(symbol: String): NativePointer

        /**
         * 获得地址实例
         * @param address 地址，以16进制字符串或数字表示
         * @return 对应地址的指针实例
         */
        fun fromAddress(address: String): NativePointer
        /** @see fromAddress */
        fun fromAddress(address: Number): NativePointer
    }
}