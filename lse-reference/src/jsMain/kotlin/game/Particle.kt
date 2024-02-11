// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/ParticleAPI.cpp

/**
 * 粒子生成器
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Particle/">✨ game.ParticleSpawner 对象</a>
 */
external class ParticleSpawner
/**
 * 生成一个粒子生成器对象
 * @param displayRadius 粒子显示半径. 默认值 `4294967295`
 * @param highDetial 需要高细节线条. 默认值 `true`
 * @param doubleSide 需要双面粒子. 默认值 `true`
 */(
       displayRadius: Int = definedExternally,
       highDetial: Boolean = definedExternally,
       doubleSide: Boolean = definedExternally
   ) {
    /** 粒子显示半径 */
    var displayRadius: Int
    /** 需要高细节线条 */
    var highDetial: Boolean
    /** 需要双面粒子 */
    var doubleSide: Boolean

    /**
     * 生成指定名称粒子
     * @param pos 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     */
    fun spawnParticle(pos: IntPos, name: String): Boolean
    /** @see spawnParticle */
    fun spawnParticle(pos: FloatPos, name: String): Boolean

    /**
     * 生成点粒子
     * @param pos 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param pointSize 只有 1, 2, 4, 8, 16 大小可选. 默认为 `4`
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawPoint(
        pos: IntPos,
        pointSize: Int = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawPoint */
    fun drawPoint(
        pos: FloatPos,
        pointSize: Int = definedExternally,
        color: String = definedExternally
    ): Boolean

    /**
     * 生成数字粒子
     * @param pos 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param num 只可填 0~16
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawNumber(
        pos: IntPos,
        num: Int,
        color: String = definedExternally
    ): Boolean
    /** @see drawNumber */
    fun drawNumber(
        pos: FloatPos,
        num: Int,
        color: String = definedExternally
    ): Boolean
    /**
     * 生成数字粒子
     * @param pos 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param num 只可填 0~16 或 A~F
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawNumber(
        pos: IntPos,
        num: String,
        color: String = definedExternally
    ): Boolean
    /** @see drawNumber */
    fun drawNumber(
        pos: FloatPos,
        num: String,
        color: String = definedExternally
    ): Boolean

    /**
     * 生成轴向线段
     * @param pos 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param direction 应当使用 game.Direction 枚举填充
     * @param length 任意实数
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawAxialLine(
        pos: IntPos,
        direction: Int,
        length: Number,
        color: String = definedExternally
    ): Boolean
    /** @see drawAxialLine */
    fun drawAxialLine(
        pos: FloatPos,
        direction: Int,
        length: Number,
        color: String = definedExternally
    ): Boolean

    /**
     * 生成有向线段
     * @param start 线段起点, 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param end 线段终点, 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param lineWidth 只有 1, 2, 4, 8, 16 大小可选. 默认为 4
     * @param minSpacing 任意实数, 此线段点最小间隔. 默认为 1
     * @param maxParticlesNum 整数, 此线段最大粒子数, 达到后会自动增加间隔. 默认为 64
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawOrientedLine(
        start: IntPos,
        end: IntPos,
        lineWidth: Int = definedExternally,
        minSpacing: Number = definedExternally,
        maxParticlesNum: Int = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawOrientedLine */
    fun drawOrientedLine(
        start: IntPos,
        end: FloatPos,
        lineWidth: Int = definedExternally,
        minSpacing: Number = definedExternally,
        maxParticlesNum: Int = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawOrientedLine */
    fun drawOrientedLine(
        start: FloatPos,
        end: IntPos,
        lineWidth: Int = definedExternally,
        minSpacing: Number = definedExternally,
        maxParticlesNum: Int = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawOrientedLine */
    fun drawOrientedLine(
        start: FloatPos,
        end: FloatPos,
        lineWidth: Int = definedExternally,
        minSpacing: Number = definedExternally,
        maxParticlesNum: Int = definedExternally,
        color: String = definedExternally
    ): Boolean

    /**
     * 生成立方体
     * @param pos 可以是浮点坐标或者整数坐标, 整数坐标会取方块角落底部位置. 若只有一个坐标, 会画出 1×1×1 大小的立方体
     * @param pos2 可以是浮点坐标或者整数坐标, 整数坐标会取方块角落顶端位置. 会画出从最小角落 pos 到最大角落 pos2 的立方体
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawCuboid(
        pos: IntPos,
        pos2: IntPos = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawCuboid */
    fun drawCuboid(
        pos: IntPos,
        pos2: FloatPos = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawCuboid */
    fun drawCuboid(
        pos: FloatPos,
        pos2: IntPos = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawCuboid */
    fun drawCuboid(
        pos: FloatPos,
        pos2: FloatPos = definedExternally,
        color: String = definedExternally
    ): Boolean

    /**
     * 生成圆
     * @param pos 圆心. 可以是浮点坐标或者整数坐标, 整数坐标会取方块中心点位置
     * @param facing 应当使用 game.Direction 枚举填充
     * @param radius 任意实数, 半径
     * @param lineWidth 只有 1, 2, 4, 8, 16 大小可选. 默认为 4
     * @param minSpacing 任意实数, 此圆点最小间隔. 默认为 1
     * @param maxParticlesNum 整数, 此圆最大粒子数, 达到后会自动增加间隔. 默认为 64
     * @param color 应当使用 game.ParticleColor 枚举填充. 默认为 `game.ParticleColor.White`
     */
    fun drawCircle(
        pos: IntPos,
        facing: Int,
        radius: Number,
        lineWidth: Int = definedExternally,
        minSpacing: Number = definedExternally,
        maxParticlesNum: Int = definedExternally,
        color: String = definedExternally
    ): Boolean
    /** @see drawCircle */
    fun drawCircle(
        pos: FloatPos,
        facing: Int,
        radius: Number,
        lineWidth: Int = definedExternally,
        minSpacing: Number = definedExternally,
        maxParticlesNum: Int = definedExternally,
        color: String = definedExternally
    ): Boolean
}

/**
 * 粒子颜色枚举
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Particle/#_2">粒子颜色枚举</a>
 */
external class ParticleColor {
    companion object {
        /** "B" */ val Black: String
        /** "I" */ val Indigo: String
        /** "L" */ val Lavender: String
        /** "T" */ val Teal: String
        /** "C" */ val Cocoa: String
        /** "D" */ val Dark: String
        /** "O" */ val Oatmeal: String
        /** "W" */ val White: String
        /** "R" */ val Red: String
        /** "A" */ val Apricot: String
        /** "Y" */ val Yellow: String
        /** "G" */ val Green: String
        /** "V" */ val Vatblue: String
        /** "S" */ val Slate: String
        /** "P" */ val Pink: String
        /** "F" */ val Fawn: String
    }
}

/**
 * 方向枚举
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Particle/#_3">方向枚举</a>
 */
external class Direction {
    companion object {
        /** 0 */ val NEG_Y: Int
        /** 1 */ val POS_Y: Int
        /** 2 */ val NEG_Z: Int
        /** 3 */ val POS_Z: Int
        /** 4 */ val NEG_X: Int
        /** 5 */ val POS_X: Int
    }
}
