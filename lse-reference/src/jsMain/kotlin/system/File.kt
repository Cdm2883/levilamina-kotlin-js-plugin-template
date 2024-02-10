// https://github.com/LiteLDev/LegacyScriptEngine/blob/c6258c5cfc8dc0f9b2f2b78868f33a7c95e6fc8d/src/legacy/api/FileSystemAPI.cpp

open external class File
/**
 * @param path 想要打开的文件路径
 * @param mode 文件的打开模式
 * @param isBinary 是否以二进制模式打开文件, 默认为`false`
 */(path: String, mode: Number, isBinary: Boolean = definedExternally) {

    /** 当前文件路径 */
    val path: String

    /** 当前文件的绝对路径 */
    val absolutePath: String

    /** 当前文件大小 */
    val size: Number

    /**
     * 从文件读取文本 / 二进制数据
     * @param cnt 要读取的字符数 / 字节数
     * @return String|ByteBuffer|null 读取的字符串内容 / 二进制数据
     */
    fun readSync(cnt: Number): Any?

    /**
     * 从文件读取一行文本
     * @return 读取的字符串内容
     */
    fun readLineSync(): String?

    /**
     * 从文件读取所有内容
     * @return String|ByteBuffer|null 读取的字符串内容 / 二进制数据
     */
    fun readAllSync(): Any?

    /**
     * 写入文本 / 二进制数据到文件
     * @param str 要写入的内容
     * @return 是否成功写入
     */
    fun writeSync(str: String): Boolean
    /** @see writeSync */
    fun writeSync(str: ByteBuffer): Boolean

    /**
     * 写入一行文本到文件
     * @param str 要写入的内容
     * @return 是否成功写入
     */
    fun writeLineSync(str: String): Boolean

    /**
     * 从文件读取文本 (异步)
     * @param cnt 要读取的字符数
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun read(
        cnt: Number,
        callback: (result: String?) -> Unit
    ): Boolean
    /**
     * 从文件读取二进制数据 (异步)
     * @param cnt 要读取的字节数
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun read(
        cnt: Number,
        callback: (result: ByteBuffer?) -> Unit
    ): Boolean

    /**
     * 从文件读取一行文本 (异步)
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun readLine(callback: (result: String) -> Unit): Boolean

    /**
     * 从文件读取所有内容 (异步)
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun readAll(callback: (result: String?) -> Unit): Boolean
    /** @see readAll */
    fun readAll(callback: (result: ByteBuffer?) -> Unit): Boolean

    /**
     * 写入文本到文件 (异步)
     * @param str 要写入的内容
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun write(
        str: String,
        callback: (result: Boolean) -> Unit = definedExternally
    ): Boolean
    /**
     * 写入二进制数据到文件 (异步)
     * @param str 要写入的内容
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun write(
        str: ByteBuffer,
        callback: (result: Boolean) -> Unit = definedExternally
    ): Boolean

    /**
     * 写入一行文本到文件 (异步)
     * @param str 要写入的内容
     * @param callback 获取结果的回调函数
     * @return 是否成功发送请求
     */
    fun writeLine(
        str: String,
        callback: (result: Boolean) -> Unit = definedExternally
    ): Boolean
    /** @see writeLine */
    fun writeLine(
        str: ByteBuffer,
        callback: (result: Boolean) -> Unit = definedExternally
    ): Boolean

    /**
     * 文件指针是否位于文件尾
     * @return 文件指针是否处于文件尾
     */
    fun isEOF(): Boolean

    /**
     * 移动文件指针
     * @param pos 文件指针要移动到的位置
     * @param isRelative 是否是相对当前文件指针位置移动
     * @return 是否移动成功
     */
    fun seekTo(pos: Number, isRelative: Boolean): Boolean

    /**
     * 设定文件大小 (设定的新大小可以大于文件的当前大小. 如果设定的新大小小于文件的当前大小, 原文件将被截断)
     * @param size 要设定的目标大小
     * @return 是否设定成功
     */
    fun setSize(size: Number): Boolean

    /**
     * 关闭文件 (文件关闭后, 严禁再次使用)
     * @return 是否成功关闭
     */
    fun close(): Boolean

    /**
     * 刷新文件缓冲区
     * @return 是否成功刷新
     */
    fun flush(): Boolean

    /**
     * 获取错误码
     * @return 上一次IO操作产生的错误码
     */
    fun errorCode(): Int

    /**
     * 清除错误状态
     * @return 是否成功清除
     */
    fun clear(): Boolean

    companion object {
        /** 文件打开模式枚举 - 只读 */
        val ReadMode: Number

        /** 文件打开模式枚举 - 写入 */
        val WriteMode: Number

        /** 文件打开模式枚举 - 追加 */
        val AppendMode: Number

        /**
         * 读入文件的所有内容
         * @param path 目标文件的路径. 相对路径以BDS根目录为基准
         * @return 文件的所有数据
         */
        fun readFrom(path: String): String?

        /**
         * 向指定文件写入内容
         * @param path 目标文件的路径. 相对路径以BDS根目录为基准
         * @param text 要写入的内容
         * @return 是否写入成功
         */
        fun writeTo(path: String, text: String): Boolean

        /**
         * 向指定文件追加一行
         * @param path 目标文件的路. 相对路径以BDS根目录为基准
         * @param text 要写入的内容
         * @return 是否写入成功
         */
        fun writeLine(path: String, text: String): Boolean

        /**
         * 创建文件夹
         * @param dir 目标文件夹的路径
         * @return 是否成功创建
         */
        fun createDir(dir: String): Boolean

        /**
         * 创建文件夹
         * @param dir 目标文件夹的路径
         * @return 是否成功创建
         */
        fun mkdir(dir: String): Boolean

        /**
         * 删除文件 / 文件夹
         * @param path 目标文件 / 文件夹的路径
         * @return 是否成功删除
         */
        fun delete(path: String): Boolean

        /**
         * 判断文件 / 文件夹是否存在
         * @param path 目标文件 / 文件夹的路径
         * @return 目标是否存在
         */
        fun exists(path: String): Boolean

        /**
         * 复制文件 / 文件夹到指定位置
         * @param from 源文件 / 文件夹的路径
         * @param to 目标文件 / 文件夹的位置
         * @return 是否复制成功
         */
        fun copy(from: String, to: String): Boolean

        /**
         * 移动文件 / 文件夹到指定位置
         * @param from 源文件 / 文件夹的路径
         * @param to 目标文件 / 文件夹的位置
         * @return 是否复制成功
         */
        fun move(from: String, to: String): Boolean

        /**
         * 重命名指定文件 / 文件夹
         * @param from 文件 / 文件夹的旧名字
         * @param to 新名字
         * @return 是否复制成功
         */
        fun rename(from: String, to: String): Boolean

        /**
         * 获取指定文件的大小 (如果传入的路径位置是一个文件夹, 则返回`-1`)
         * @param path 所操作的文件路径
         * @return 文件的大小 (字节)
         */
        fun getFileSize(path: String): Int

        /**
         * 判断指定路径是否是文件夹
         * @param path 所判断的路径
         * @return 目标路径是否是文件夹
         */
        fun checkIsDir(path: String): Boolean

        /**
         * 列出指定文件夹下的所有文件 / 文件夹
         * @param dir 文件夹路径
         * @return 文件夹名数组
         */
        fun getFilesList(dir: String): Array<String>

        // 向下兼容就不写了
    }
}
