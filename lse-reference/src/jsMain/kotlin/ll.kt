external class ll {
    companion object {
        // region script/ScriptHelper.kt
        /**
         * 注册插件
         * @param name 插件名字
         * @param introduction 对插件的简短介绍
         * @param version [Number, Number, Number, Version?] 插件的版本信息[2,0,1]
         * @param otherInformation Record<String, String> 其他你愿意提供的的附加信息 (如许可证, 开源地址等)
         */
        fun registerPlugin(
            name: String,
            introduction: String,
            version: Any,
            otherInformation: Any
        ): Unit
        // endregion

        // region script/Li.kt
        /** LiteLoaderBDS 使用的语言. (例如 `zh_Hans`, `en` 和 `ru_RU`) */
        val language: String
        /** 主版本号 (如 **2**.1.0 里的 **2**)*/
        val major: Number
        /** 次版本号 (如 2.**1**.0 里的 **1**)*/
        val minor: Number
        /** 修订版本号 (如 2.1.**0** 里的 **0**) */
        val revision: Number
        /** 版本状态 (`0` 为 `Dev`, `1` 为 `Beta`, `2` 为 `Release`) */
        val status: Number
        /** LiteLoaderBDS Script Engine 版本 */
        val scriptEngineVersion: String
        /** 是否处于 Wine 环境下 */
        val isWine: Boolean
        /** 是否处于 debug 模式 */
        val isDebugMode: Boolean
        /** 当前版本是否为测试版 */
        val isBeta: Boolean
        /** 当前版本是否为开发版 */
        val isDev: Boolean
        /** 当前版本是否为发布版本 */
        val isRelease: Boolean

        /**
         * 获取 LiteLoader 加载器版本
         * @return 加载器版本对象
         */
        fun version(): version

        /**
         * 获取 LiteLoader 加载器版本字符串
         * @return 加载器版本
         */
        fun versionString(): String

        /**
         * 检查 LiteLoader 加载器版本
         * @return 检查结果
         */
        fun requireVersion(
            major: Number,
            minor: Number = definedExternally,
            revision: Number = definedExternally
        ): Boolean

        /**
         * 列出所有已加载的插件
         * @return 列出所有已加载的插件
         */
        fun listPlugins(): Array<String>

        /**
         * 导出函数
         * @param func 要导出的函数
         * @param namespace 函数的命名空间名, 只是方便用于区分不同插件导出的API
         * @param name 函数的导出名称. 其他插件根据导出名称来调用这个函数
         * @return 是否成功导出
         */
        fun exports(
            func: Any,
            namespace: String,
            name: String
        ): Boolean
        /**
         * 导出函数
         * @param func 要导出的函数
         * @param name 函数的导出名称. 其他插件根据导出名称来调用这个函数
         * @return 是否成功导出
         */
        fun exports(func: Any, name: String): Boolean

        /**
         * 导入函数
         * @param namespace 要导入的函数使用的命名空间名称
         * @param name 要导入的函数使用的导出名称
         * @return 导入的函数
         */
        fun imports(namespace: String, name: String): Any

        /**
         * 导入函数
         * @param name 要导入的函数使用的导出名称
         * @return 导入的函数
         */
        fun imports(name: String): Any

        /**
         * 判断远程函数是否已导出
         * @param namespace 函数使用的命名空间名称
         * @param name 函数使用的导出名称
         * @return 函数是否已导出
         */
        fun hasExported(namespace: String, name: String): Boolean

        /**
         * 判断远程函数是否已导出
         * @param name 函数使用的导出名称
         * @return 函数是否已导出
         */
        fun hasExported(name: String): Boolean

        /**
         * 设置插件依赖库
         * @param path 依赖库文件名 (如 `addplugin.js`)
         * @param remotePath 查找并装载依赖库的路径, 说明见文档
         * @return 是否加载依赖库成功
         */
        fun require(path: String, remotePath: String = definedExternally): Boolean

        /**
         * 将字符串作为脚本代码执行
         * @param str 要作为脚本代码执行的字符串
         * @return 执行结果
         */
        fun eval(str: String): Any
        // endregion
    }
}