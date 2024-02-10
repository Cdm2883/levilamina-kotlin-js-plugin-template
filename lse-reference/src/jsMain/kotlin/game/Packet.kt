// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/PacketAPI.cpp

/**
 * 数据包对象
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Packet/#api_1">🔉 数据包对象 API</a>
 */
external class LLSE_Packet(nullptr: Nothing) {
    fun asPointer(): NativePointer

    /**
     * 获取数据包名称
     */
    fun getName(): String

    /**
     * 获取数据包ID
     */
    fun getId(): Int
}
typealias Packet = LLSE_Packet

/**
 * 二进制流对象
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Packet/#api_3">🔌 二进制流对象 API</a>
 */
external class BinaryStream {
    /** getAndReleaseData */
    fun getData(): String

    /**
     * 重置二进制流
     * @return 是否成功
     */
    fun reset(): Boolean

    /**
     * 给二进制流分配空间
     * @param size 分配的字节数
     * @return 是否成功
     */
    @Deprecated(message = "疑似已遗弃, LSE函数内无实际内容")
    fun reserve(size: Int): Boolean

    // 写入二进制流. 难得写文档了, 代码即注释
    fun writeBool(value: Boolean): Boolean
    fun writeByte(value: Byte): Boolean
    fun writeDouble(value: Double): Boolean
    fun writeFloat(value: Float): Boolean
    fun writeSignedBigEndianInt(value: Int): Boolean
    fun writeSignedInt(value: Int): Boolean
    fun writeSignedInt64(value: Int): Boolean
    fun writeSignedShort(value: Short): Boolean
    fun writeString(value: String): Boolean
    fun writeUnsignedChar(value: Char): Boolean
    fun writeUnsignedInt(value: Int): Boolean
    fun writeUnsignedInt64(value: Int): Boolean
    fun writeUnsignedShort(value: Short): Boolean
    fun writeUnsignedVarInt(value: Int): Boolean
    fun writeUnsignedVarInt64(value: Int): Boolean
    fun writeVarInt(value: Int): Boolean
    fun writeVarInt64(value: Int): Boolean
    fun writeVec3(value: FloatPos): Boolean
    fun writeCompoundTag(value: NbtCompound): Boolean

    /**
     * 通过二进制流构建数据包
     * @param pktid 数据包ID
     * @return 数据包对象
     */
    fun createPacket(pktid: Int): Packet
}
