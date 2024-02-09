external interface time {
    /** 年份数值 (4位) */
    val Y: Number
    /** 月份数值 */
    val M: Number
    /** 天数数值 */
    val D: Number
    /** 小时数值 (24小时制) */
    val h: Number
    /** 分钟数值 */
    val m: Number
    /** 秒数值 */
    val s: Number
    /** 毫秒数值 */
    val ms: Number
}

external class system {
    companion object {
        /**
         * 调用shell执行指定系统命令
         * @param cmd 执行的系统命令
         * @param callback shell进程结束之后返回数据使用的回调函数
         * @param timeLimit 命令运行的最长时限, 单位为毫秒. 默认为`-1`, 即不限制运行时间
         * @return 是否成功启动命令
         */
        fun cmd(
            cmd: String,
            callback: (exitcode: Number, output: String) -> Unit,
            timeLimit: Number = definedExternally
        ) : Boolean

        /**
         * 运行指定位置程序
         * @param process 运行的程序路径 (与命令行参数)
         * @param callback 程序进程结束之后返回数据使用的回调函数
         * @param timeLimit 程序进程运行的最长时限, 单位为毫秒. 默认为`-1`, 即不限制运行时间.
         * @return 是否成功启动命令
         */
        fun newProcess(
            process: String,
            callback: (exitcode: Number, output: String) -> Unit,
            timeLimit: Number = definedExternally
        ): Boolean

        /**
         * 获取当前时间字符串
         * @return 当前的时间字符串, 使用当地时区和24小时制
         */
        fun getTimeStr(): String

        /**
         * 获取当前的时间对象
         * @return 当前的时间对象
         */
        fun getTimeObj(): time

        /**
         * 随机生成一个 GUID  字符串
         * @return 一个随机生成的唯一标识符GUID
         */
        fun randomGuid(): String
    }
}