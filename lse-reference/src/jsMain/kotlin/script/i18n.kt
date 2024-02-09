/**
 * 国际化API
 *
 * 随着我们的社区越来越大，语言成为了各个国家的用户和玩家之间交流的障碍。为了解决这个问题，我们提供了I18nAPI并鼓励插件创作者使用国际化接口。
 * @see <a href="https://lse.liteldev.com/zh/apis/ScriptAPI/i18n/">🛫 国际化 API</a>
 */
external class i18n {
    companion object {
        /**
         * 加载翻译数据
         * @param path 翻译数据所在的文件/目录
         * @param defaultLocaleName 默认的语言名称，形如zh_CN或en，若传入空字符串，则默认跟随系统语言
         * @param defaultLangData 该参数将用于补全或创建翻译文件
         */
        fun load(path: String, defaultLocaleName: String, defaultLangData: Any): Unit

        /**
         * 获取文本的指定语言翻译
         * @param key 文本或ID
         * @param localeName 目标语言，默认为i18n.load时传入的defaultLocaleName
         * @returns 翻译内容（若经过多次回落仍未找到翻译，则返回key）
         */
        fun get(key: String, localeName: String = definedExternally): String

        /**
         * 使用指定语言翻译文本并格式化
         * @param localeName 目标语言
         * @param key 文本或ID
         * @param info 格式化参数
         * @returns 翻译并格式化后的文本
         */
        fun trl(localeName: String, key: String, vararg info: Any): String

        /**
         * 使用默认语言翻译文本并格式化
         * @param key 文本或ID
         * @param info 格式化参数
         * @returns 翻译并格式化后的文本
         */
        fun tr(key: String, vararg info: Any): String
    }
}
