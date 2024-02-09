external enum class Version {
    Release,
    Beta,
    Dev,
}

/**
 * 输出信息到控制台
 * @param data 待输出的变量或者数据
 */
external fun log(vararg data: Any): Unit

/**
 * 输出带颜色文本
 * @param color 此行输出的颜色(代码示例和效果见文档)
 * @param data 待输出的变量或者数据
 */
external fun colorLog(color: String, vararg data: Any): Unit

/**
 * 异步输出
 * @param data 待输出的变量或者数据
 */
external fun fastLog(vararg data: Any): Unit

/**
 * 推迟一段时间执行代码
 * @param func 待执行的函数
 * @param msec 推迟执行的时间（毫秒）
 * @return 此任务ID
 */
external fun setTimeout(
    func: () -> Unit,
    msec: Number
): Int?
/**
 * 推迟一段时间执行代码
 * @param func 待执行的代码段
 * @param msec 推迟执行的时间（毫秒）
 * @return 此任务ID
 */
external fun setTimeout(
    func: String,
    msec: Number
): Int?

/**
 * 设置周期执行代码
 * @param func 待执行的函数
 * @param msec 执行间隔周期（毫秒）
 * @return 此任务ID
 */
external fun setInterval(
    func: () -> Unit,
    msec: Number
): Int?
/**
 * 设置周期执行代码
 * @param func 待执行的代码段
 * @param msec 执行间隔周期（毫秒）
 * @return 此任务ID
 */
external fun setInterval(
    func: String,
    msec: Number
): Int?

/**
 * 取消延时 / 周期执行项
 * @param taskid 由前几个函数返回的任务ID
 * @return 是否取消成功
 */
external fun clearInterval(taskid: Int): Boolean?
