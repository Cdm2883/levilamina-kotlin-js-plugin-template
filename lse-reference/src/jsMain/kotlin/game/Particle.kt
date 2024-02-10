// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/ParticleAPI.cpp

/**
 * 粒子生成器
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Particle/">✨ ParticleSpawner 对象</a>
 */
external class ParticleSpawner
/**
 * 生成一个粒子生成器对象
 * @param displayRadius 粒子显示半径
 * @param highDetial 需要高细节线条
 * @param doubleSide 需要双面粒子
 */(displayRadius: Int, highDetial: Boolean, doubleSide: Boolean) {
    /** 粒子显示半径 */
    var displayRadius: Int
    /** 需要高细节线条 */
    var highDetial: Boolean
    /** 需要双面粒子 */
    var doubleSide: Boolean

    // .instanceFunction("spawnParticle", &ParticleSpawner::spawnParticle)
    // .instanceFunction("drawPoint", &ParticleSpawner::drawPoint)
    // .instanceFunction("drawNumber", &ParticleSpawner::drawNumber)
    // .instanceFunction("drawAxialLine", &ParticleSpawner::drawAxialLine)
    // .instanceFunction("drawOrientedLine", &ParticleSpawner::drawOrientedLine)
    // .instanceFunction("drawCuboid", &ParticleSpawner::drawCuboid)
    // .instanceFunction("drawCircle", &ParticleSpawner::drawCircle)
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
