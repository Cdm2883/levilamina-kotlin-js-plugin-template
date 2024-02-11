// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/ScoreboardAPI.cpp

/**
 * 计分板
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/ScoreBoard/">📝 计分板 API</a>
 */
external class LLSE_Objective(nullptr: Nothing) {
    /** 计分项名称 */
    val name: String
    /** 计分项的显示名称 */
    val displayName: String

    /**
     * 显示槽位名称字符串. 可以为sidebar/belowname/list
     * @param slot 显示槽位名称字符串. 可以为sidebar/belowname/list
     * @param sortOrder 排序方式. 可以为 0(升序) 或 1(降序), 默认值为0
     * @return 是否设置成功
     */
    fun setDisplay(slot: String, sortOrder: Int = definedExternally): Boolean

    /**
     * 设置某个目标的分数
     * @param target 计分项跟踪的目标, 可传入玩家对象或者任意字符串
     * @param score 要设置的分数
     * @return 该目标在经过设置操作后的分数. 如果返回Null, 则代表操作失败
     */
    fun setScore(target: Player, score: Int): Int?
    /** @see setScore */
    fun setScore(target: String, score: Int): Int?

    /**
     * 增加某个目标的分数
     * @param target 计分项跟踪的目标, 可传入玩家对象或者任意字符串
     * @param score 要增加的分数
     * @return 该目标在经过增加操作后的分数. 如果返回Null, 则代表操作失败
     */
    fun addScore(target: Player, score: Int): Int?
    /** @see addScore */
    fun addScore(target: String, score: Int): Int?

    /**
     * 减少某个目标的分数
     * @param target 计分项跟踪的目标, 可传入玩家对象或者任意字符串
     * @param score 要减少的分数
     * @return 该目标在经过减少操作后的分数. 如果返回Null, 则代表操作失败
     */
    fun reduceScore(target: Player, score: Int): Int?
    /** @see reduceScore */
    fun reduceScore(target: String, score: Int): Int?

    /**
     * 停止跟踪某个目标
     * @param target 计分项跟踪的目标, 可传入玩家对象或者任意字符串
     * @return 是否停止成功
     */
    fun deleteScore(target: Player): Boolean
    /** @see deleteScore */
    fun deleteScore(target: String): Boolean

    /**
     * 获取跟踪的某个目标的分数
     * @param target 待查询的跟踪目标, 可传入玩家对象或者任意字符串
     * @return 该目标/玩家在此计分项中的分数
     */
    fun getScore(target: Player): Int
    /** @see getScore */
    fun getScore(target: String): Int
}
typealias Objective = LLSE_Objective
