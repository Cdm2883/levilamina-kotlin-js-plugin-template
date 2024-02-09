external class NativePatch {
    companion object {
        /**
         * PatternSearch搜索
         *
         * 在全局范围内搜索指定Bytes并获得第一个结果地址
         * @param pattern 描述匹配模式的字符串
         * @return 结果地址
         */
        fun search(pattern: String): NativePointer

        /**
         * Patch应用补丁
         *
         * 对指定位置进行Patch操作
         * @param pointer 目标地址
         * @param expect 原始字节
         * @param target 目标字节
         * @return 成功结果
         */
        fun patch(pointer: NativePatch, expect: String, target: String): Boolean

        /**
         * Dump展示内存
         *
         * 以十六进制字符串展示目标地址的指定长度内存
         * @param pointer 目标地址
         * @param size 长度
         * @return 内存内容
         */
        fun patch(pointer: NativePointer, size: Int): String
    }
}