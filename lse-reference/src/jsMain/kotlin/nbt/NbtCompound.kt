/**
 * NBT标签类型
 *
 * 一个NbtCompound代表一个完整的标签, 里面储存了一系列键值对, 类似于对象 / 表这样的数据结构.
 * 通过NbtCompound对象的接口, 才可以进行 NBT 标签所独有的一些操作.
 * @see <a href="https://lse.liteldev.com/zh/apis/NbtAPI/NBTCompound/">📒 NbtCompound - 标签类型</a>
 */
external class NbtCompound
/**
 * 创建新的 NBT 标签对象
 * @param data 传入一个NBT对象构成的对象. 对象中允许包含其他数组 / 对象结构, 但内容必须都为NBT对象
 * @exception JsError 如果创建失败，将抛出异常
 */(data: dynamic = definedExternally) {

    /**
     * 获取NBT对象储存的数据类型
     * @return NBT.Compound
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串, 则传入此参数
     */
    fun toString(space: Number = definedExternally): String
 
    /**
     * 获取所有的键
     * @return Compound 中所有的键
     */
    fun getKeys(): Array<String>

    /**
     * 获取键对应的值的数据类型
     * @param key 要查询的键名
     * @return 对应的值的数据类型
     */
    fun getTypeOf(key: String): NBT

    /**
     * 设置键对应的 NBT 对象
     * @param key 要操作的键名
     * @param tag 要写入的 NBT 对象（它承载着具体的NBT数据）
     * @return 是否写入成功
     */
    fun setTag(key: String, tag: dynamic): Boolean

    /**
     * 读取键对应的 NBT 对象
     * @param key 要操作的键名
     * @return 键对应的NBT对象
     */
    fun getTag(key: String): dynamic

    /**
     * 删除键对应的 NBT 对象
     * @param key 要操作的键名。键名必须已经存在
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun removeTag(key: String): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setEnd(key: String): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return NbtCompound 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setByte(key: String, data: Byte): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setShort(key: String, data: Short): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setInt(key: String, data: Int): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setLong(key: String, data: Long): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setFloat(key: String, data: Float): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setDouble(key: String, data: Double): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setByteArray(key: String, data: ByteBuffer): NbtCompound

    /**
     * 设置键对应的值的具体数据
     * @param key 要操作的键名
     * @param data 要写入的具体数据
     * @return 处理完毕的NBT对象（便于连锁进行其他操作）
     */
    fun setString(key: String, data: String): NbtCompound

    /**
     * 读取键对应的值的具体数据
     * @param key 要操作的键名
     * @return 键对应的值的具体数据
     */
    fun getData(key: String): dynamic

    /**
     * 将 NBT 标签对象 转换为Object
     * @return 对应的对象/表
     */
    fun toObject(): Any

    /**
     * 将 NBT 标签对象 序列化为二进制NBT
     * @return 对应的二进制NBT数据
     */
    fun toBinaryNBT(): ByteBuffer

    /**
     * 将NBT对象转换为SNBT字符串
     * @param space （可选参数）如果要格式化输出的字符串，则传入此参数
     */
    fun toSNBT(space: Int = definedExternally): String

    /**
     * 销毁此 NBT 标签对象
     * @return 是否成功清理
     */
    fun destroy(): Boolean
}