/**
 * 伤害原因枚举, 有问号的待验证
 */
external enum class DamageCause {
    /** 其他 #-0x01 */
    None,

    /** 非正常方式 (如脚本直接设置血量为0)，这种方式的伤害不会被盔甲与buff吸收 #0x00 */
    Override,

    /** 接触伤害 (如仙人掌) #0x01 */
    Contact,

    /** 实体攻击 #0x02 */
    EntityAttack,

    /** 抛射物攻击 #0x03 */
    Projectile,

    /** 窒息 (密封空间) #0x04 */
    Suffocation,

    /** 掉落 #0x05 */
    Fall,

    /** 着火 #0x06 */
    Fire,

    /** 着火 #0x07 */
    FireTick,

    /** 熔岩 #0x08 */
    Lava,

    /** 溺水 #0x09 */
    Drowning,

    /** 方块爆炸 #0x0a */
    BlockExplosion,

    /** 实体爆炸 #0x0b */
    EntityExplosion,

    /** 虚空 #0x0c */
    Void,

    /** 自杀 #0x0d */
    Suicide,

    /** 尖牙对生物造成的伤害、守卫者对生物造成的魔法伤害和药水伤害等 #0x0e */
    Magic,

    /** 凋零效果 #0x0f */
    Wither,

    /** 饥饿 #0x10 */
    Starve,

    /** 下落的铁砧 #0x11 */
    Anvil,

    /** 荆棘 #0x12 */
    Thorns,

    /** 下落的方块 #0x13 */
    FallingBlock,

    /** 活塞 #0x14 */
    Piston,

    /** 动态能量 (滑翔撞墙) #0x15 */
    FlyIntoWall,

    /** 岩浆块 #0x16 */
    Magma,

    /** 烟花 #0x17 */
    Fireworks,

    /** 闪电 #0x18 */
    Lightning,

    /** 充能 (?) #0x19 */
    Charging,

    /** 温度  (雪人?) #0x1a */
    Temperature,

    /** 冰冻 #0x1b */
    Freezing,

    /** 被钟乳石砸到 #0x1c */
    Stalactite,

    /** 掉落到石笋上 #0x1d */
    Stalagmite,

    /** 所有 #0x1f */
    All,
}