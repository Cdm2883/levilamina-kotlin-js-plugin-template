/**
 * NBT列表类型
 *
 * 一个NbtList代表一个列表, 里面储存了一列 NBT 对象, 类似于列表 / 数组这样的数据结构.
 * 通过NbtList对象的接口, 才可以进行 NBT 列表所独有的一些操作.
 * @see <a href="https://lse.liteldev.com/zh/apis/NbtAPI/NBTList/">📚 NbtList - 列表类型</a>
 */
external class NbtList
/**
 * 创建新的NBT列表对象
 * @param data 传入一个NBT对象构成的数组. 数组中允许包含其他数组 / 对象结构, 但内容必须都为NBT对象
 */(data: Array<dynamic> = definedExternally) {

    /**
     * 获取NBT对象储存的数据类型
     * @return NBT.List
     */
    fun getType(): NBT

    /**
     * 将NBT对象转换为Json字符串
     * @param space 如果要格式化输出的字符串, 则传入此参数
     */
    fun toString(space: Int = definedExternally): String

    /**
     * 获取列表长度
     * @return 此列表的长度
     */
    fun getSize(): Int

    /**
     * 获取某个下标位置储存的数据类型
     * @param index 要查询的目标下标
     * @return 此下标处储存的NBT的数据类型
     */
    fun getTypeOf(index: Int): NBT

    /**
     * 设置某个下标位置的NBT对象
     * @param index 要操作的目标下标
     * @param tag 要写入的 NBT 对象
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setTag(index: Int, tag: dynamic): NbtList

    /**
     * 读取某个下标位置的NBT对象
     * @param index 要操作的目标下标
     * @return NBT对象
     */
    fun getTag(index: Int): dynamic

    /**
     * 往列表末尾追加一个NBT对象
     * @param tag 要追加的 NBT 对象
     * @return 追加完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun addTag(tag: dynamic): NbtList

    /**
     * 删除某个下标位置的NBT对象
     * @param index 要删除的目标下标
     * @return 处理完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun removeTag(index: Int): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setEnd(index: Int): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setByte(index: Int, data: Byte): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setShort(index: Int, data: Short): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setInt(index: Int, data: Int): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setLong(index: Int, data: Long): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setFloat(index: Int, data: Float): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setDouble(index: Int, data: Double): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setByteBuffer(index: Int, data: ByteBuffer): NbtList

    /**
     * 设置某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @param data 要写入的具体数据
     * @return 写入完毕的NBT列表 (便于连锁进行其他操作)
     */
    fun setString(index: Int, data: String): NbtList

    /**
     * 读取某个下标位置的具体数据
     * @param index 要操作的目标下标
     * @return 键对应的值的具体数据
     */
    fun getData(index: Int): dynamic

    /**
     * 将List类型转换为Array
     * @return 对应的数组/列表
     */
    fun toArray(): Array<dynamic>
}