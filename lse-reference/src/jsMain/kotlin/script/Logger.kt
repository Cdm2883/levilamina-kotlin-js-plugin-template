external class logger {
    companion object {
        /**
         * 设置日志是否输出到控制台
         * @param isOpen 设置日志是否输出到控制台
         * @param logLevel (可选参数) 控制台的日志输出等级，默认为`4`
         */
        fun setConsole(isOpen: Boolean, logLevel: Int = definedExternally): Unit

        /**
         * 设置日志是否输出到文件
         * @param filePath 设置日志输出到的文件路径
         * @param logLevel (可选参数) 文件的最小日志输出等级，默认为`4`
         */
        fun setFile(filePath: String, logLevel: Int = definedExternally): Unit

        /**
         * 设置日志是否输出到某个玩家
         * @param player 设置日志输出到的目标玩家对象. 如果传入Null, 则代表关闭到玩家的输出.
         * @param logLevel (可选参数) 玩家的最小日志输出等级, 默认为`4`
         */
        fun setPlayer(player: Player?, logLevel: Int = definedExternally): Unit

        /** 输出普通文本 */
        fun log(vararg data: Any): Unit
        /** 输出调试信息 */
        fun debug(vararg data: Any): Unit
        /** 输出提示信息 */
        fun info(vararg data: Any): Unit
        /** 输出警告信息 */
        fun warn(vararg data: Any): Unit
        /** 输出错误信息 */
        fun error(vararg data: Any): Unit
        /** 输出严重错误信息 */
        fun fatal(vararg data: Any): Unit

        /**
         * 设置自定义日志消息标头
         * @param title 设置的自定义标头
         */
        fun setTitle(title: String): Unit

        /**
         * 统一修改日志输出等级
         * @param level 日志输出等级 0~5
         */
        fun setLogLevel(level: Int): Unit
    }
}