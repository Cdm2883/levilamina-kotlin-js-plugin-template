// 似乎没有看到NbtEnd的定义, 但NBT的枚举有

external class NbtByte(data: Byte = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: Byte): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): Byte
}

external class NbtShort(data: Short = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: Short): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): Short
}

external class NbtInt(data: Int = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: Int): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): Int
}

external class NbtLong(data: Long = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: Long): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): Long
}

external class NbtFloat(data: Float = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: Float): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): Float
}

external class NbtDouble(data: Double = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: Double): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): Double
}

external class NbtString(data: String = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: String): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): String
}

external class NbtByteArray(data: ByteArray = definedExternally) {
    /**
     * 获取NBT对象储存的数据类型
     * @return 此NBT对象储存的数据类型
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串，则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 设置对象的数据
     * @param data 写入对应类型的数据
     */
    fun set(data: ByteArray): Boolean

    /**
     * 读取对象的数据
     * @returns 对象中储存的数据
     */
    fun get(): ByteArray
}
