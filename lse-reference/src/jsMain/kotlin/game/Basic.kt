/**
 * 整数坐标对象
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Basic/#_2">🎯 坐标对象</a>
 */
external class IntPos
/**
 * 生成一个整数坐标对象
 * @param x x 坐标
 * @param y y 坐标
 * @param z z 坐标
 * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
 */(x: Int, y: Int, z: Int, dimid: Int) {
    /** x 坐标 */
    var x: Int
    /** y 坐标 */
    var y: Int
    /** x 坐标 */
    var z: Int
    /** 维度文字名: 主世界, 下界, 末地 */
    val dim: String
    /** 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地 */
    var dimid: Int
    override fun toString(): String
}

/**
 * 浮点数坐标对象
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Basic/#_2">🎯 坐标对象</a>
 */
external class FloatPos
/**
 * 生成一个浮点数坐标对象
 * @param x x 坐标
 * @param y y 坐标
 * @param z z 坐标
 * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
 */(x: Float, y: Float, z: Float, dimid: Int) {
    /** x 坐标 */
    var x: Float
    /** y 坐标 */
    var y: Float
    /** x 坐标 */
    var z: Float
    /** 维度文字名: 主世界, 下界, 末地 */
    val dim: String
    /** 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地 */
    var dimid: Int
    override fun toString(): String
}

/**
 * 方向角对象
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Basic/#_6">📐 方向角对象</a>
 */
external class DirectionAngle
/**
 * 创建偏航角
 * @param pitch 俯仰角 (-90° ~ 90°)
 * @param yaw 偏航角 (旋转角)
 */(pitch: Float, yaw: Float) {
    /** 俯仰角 (-90° ~ 90°) */
    var pitch: Float
    /** 偏航角 (旋转角) */
    var yaw: Float
    /**
     * 将偏航角转换为基本朝向
     *
     * 返回值为`0`-`3`，代表 北东南西 四个基本朝向\
     * 用于快速确定实体面向的大致方向
     * @return 当前方向角对象所指示的基本朝向
     */
    fun toFacing(): Int
    override fun toString(): String
}
