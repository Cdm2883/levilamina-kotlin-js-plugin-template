external enum class NBT {
    End,
    Byte,
    Short,
    Int,
    Long,
    Float,
    Double,
    ByteArray,
    String,
    List,
    Compound;
    companion object {
        /**
         * 从 SNBT 字符串生成 NBT 标签对象
         * @param snbt 你要解析的SNBT字符串
         * @return 生成的NBT对象
         */
        fun parseSNBT(snbt: kotlin.String): NbtCompound?

        /**
         * 从二进制 NBT 数据生成 NBT 标签对象
         * @param nbt 你要解析的二进制 NBT 数据
         * @return 生成的NBT对象
         */
        fun parseBinaryNBT(nbt: ByteBuffer): NbtCompound?

        /** @deprecated */
        fun newTag(arg: NBT): dynamic

        /** @deprecated */
        fun createTag(arg: NBT): dynamic
    }
}
