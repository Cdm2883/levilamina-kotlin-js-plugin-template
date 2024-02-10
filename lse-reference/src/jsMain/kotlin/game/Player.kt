// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/PlayerAPI.cpp

/**
 * 玩家对象
 *
 * 在脚本引擎中, 使用"玩家对象"来操作和获取某一个玩家的相关信息.
 * @see <a href="https://lse.liteldev.com/zh/apis/GameAPI/Player/">🏃‍♂️ 玩家对象 API</a>
 */
open external class LLSE_Player(nullptr: Nothing) {
    fun asPointer(): NativePointer

    // region 属性 https://lse.liteldev.com/zh/apis/GameAPI/Player/#-
    /** 玩家名 */ val name: String
    /** 玩家所在坐标 */ val pos: FloatPos
    /** 玩家腿部所在坐标 */ val feetPos: FloatPos
    /** 玩家所在的方块坐标 */ val blockPos: IntPos
    /** 玩家上次死亡的坐标 */ val lastDeathPos: IntPos
    /** 玩家的真实名字 */ val realName: String
    /** 玩家XUID字符串 */ val xuid: String
    /** 玩家Uuid字符串 */ val uuid: String
    /** 玩家的操作权限等级 (0 - 4) */ val permLevel: Int
    /** 玩家的游戏模式 (0 - 2, 6) */ val gameMode: Int
    /** 玩家是否可以睡觉 */ val canSleep: Boolean
    /** 玩家是否可以飞行 */ val canFly: Boolean
    /** 玩家是否可以在地图上看到 */ val canBeSeenOnMap: Boolean
    /** 玩家是否可以冻结 */ val canFreeze: Boolean
    /** 玩家是否能看到日光 */ val canSeeDaylight: Boolean
    /** 玩家是否可以显示姓名标签 */ val canShowNameTag: Boolean
    /** 玩家是否可以开始在床上睡觉 */ val canStartSleepInBed: Boolean
    /** 玩家是否可以拾取物品 */ val canPickupItems: Boolean
    /** 玩家最大生命值 */ val maxHealth: Int
    /** 玩家当前生命值 */ val health: Int
    /** 玩家当前是否悬空 */ val inAir: Boolean
    /** 玩家当前是否在水中 */ val inWater: Boolean
    /** 玩家是否在熔岩中 */ val inLava: Boolean
    /** 玩家是否下雨 */ val inRain: Boolean
    /** 玩家是否在雪中 */ val inSnow: Boolean
    /** 玩家是否在墙上 */ val inWall: Boolean
    /** 玩家是否在水中或雨中 */ val inWaterOrRain: Boolean
    /** 玩家是否在世界 */ val inWorld: Boolean
    /** 玩家是否在云端 */ val inClouds: Boolean
    /** 玩家当前速度 */ val speed: Float
    /** 玩家当前朝向 */ val direction: DirectionAngle
    /** 玩家 (实体的)唯一标识符 */ val uniqueId: String
    /** 玩家设置的语言的标识符 (形如zh_CN) */ val langCode: String
    /** 玩家是否正在加载 */ val isLoading: Boolean
    /** 玩家是否隐身中 */ val isInvisible: Boolean
    /** 玩家在传送门中 */ val isInsidePortal: Boolean
    /** 玩家是否受伤 */ val isHurt: Boolean
    /** 未知 (盲猜微软验证之类的) */ val isTrusting: Boolean
    /** 玩家是否在能造成伤害的方块上 */ val isTouchingDamageBlock: Boolean
    /** 玩家是否饿了 */ val isHungry: Boolean
    /** 玩家是否着火 */ val isOnFire: Boolean
    /** 玩家是否在地上 */ val isOnGround: Boolean
    /** 玩家是否在高温方块上 (岩浆等) */ val isOnHotBlock: Boolean
    /** 玩家在交易 */ val isTrading: Boolean
    /** 玩家是否是冒险模式 */ val isAdventure: Boolean
    /** 玩家在滑行 */ val isGliding: Boolean
    /** 玩家是否是生存模式 */ val isSurvival: Boolean
    /** 玩家是否是观众模式 */ val isSpectator: Boolean
    /** 玩家是否在骑行 */ val isRiding: Boolean
    /** 玩家在跳舞? */ val isDancing: Boolean
    /** 玩家是否是创造模式 */ val isCreative: Boolean
    /** 玩家是否在飞行 */ val isFlying: Boolean
    /** 玩家是否正在睡觉 */ val isSleeping: Boolean
    /** 玩家是否正在移动 */ val isMoving: Boolean
    /** 玩家是否正在潜行 */ val isSneaking: Boolean
    // endregion

    // region 函数 https://lse.liteldev.com/zh/apis/GameAPI/Player/#-_1
    /**
     * 判断玩家是否为OP
     * @return 玩家是否为OP
     */
    fun isOP(): Boolean

    // .instanceFunction("setPermLevel", &PlayerClass::setPermLevel)
    // .instanceFunction("setGameMode", &PlayerClass::setGameMode)

    // -
    /**
     * 以某个玩家身份执行一条命令
     * (是以某个玩家**身份**哦! 本来没权限执行的命令也无法执行)
     * @param cmd 待执行的命令
     * @return 是否执行成功
     */
    fun runcmd(cmd: String): Boolean

    /**
     * 传送玩家至指定位置
     * @param pos 目标位置坐标
     * @param rot 传送后玩家的朝向, 若缺省则与传送前朝向相同
     * @return 是否成功传送
     */
    fun teleport(pos: IntPos, rot: DirectionAngle = definedExternally): Boolean
    /** @see teleport */
    fun teleport(pos: FloatPos, rot: DirectionAngle = definedExternally): Boolean
    /**
     * 传送玩家至指定位置
     * @param x 目标 x 坐标
     * @param y 目标 y 坐标
     * @param z 目标 z 坐标
     * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
     */
    fun teleport(x: Int, y: Int, z: Int, dimid: Int, rot: DirectionAngle = definedExternally): Boolean
    /** @see teleport */
    fun teleport(x: Float, y: Float, z: Float, dimid: Int, rot: DirectionAngle = definedExternally): Boolean

    /**
     * 杀死玩家
     * @return 是否成功执行
     */
    fun kill(): Boolean

    /**
     * 断开玩家连接
     * @param msg 被踢出玩家出显示的断开原因. 如果不传入, 默认为"正在从服务器断开连接"
     * @return 是否成功断开连接
     */
    fun kick(msg: String = definedExternally): Boolean

    /** @see kick */
    fun disconnect(msg: String = definedExternally): Boolean

    /**
     * 发送一个文本消息给玩家
     * @param msg 待发送的文本
     * @param type 发送的文本消息类型, 默认为0: 0 普通消息(Raw), 1 聊天消息(Chat), 4 音乐盒消息(Popup), 5 物品栏上方的消息(Tip), 9 JSON格式消息(JSON)
     * @return 是否成功发送
     */
    fun tell(msg: String, type: Int = definedExternally): Boolean

    /**
     * 以某个玩家身份说话
     * @param text 模拟说话内容
     * @return 是否执行成功
     */
    fun talkAs(text: String): Boolean
    /**
     * 以某个玩家身份向某玩家说话
     * @param target 模拟说话对象
     * @param text 模拟说话内容
     * @return 是否执行成功
     */
    fun talkAs(target: Player, text: String): Boolean
    // 我服了爸爸, 这lse在线文档的这两个talkAS的定义怎么是分开的

    /** @see tell */
    fun sendText(msg: String, type: Int = definedExternally): Boolean

    /**
     * 设置玩家显示标题
     *
     * | type参数 | 消息类型                                |
     * | ------- | ------------------------------------- |
     * | 0       | 清空 (Clear)                           |
     * | 1       | 重设 (Reset)                           |
     * | 2       | 设置主标题 (SetTitle)                   |
     * | 3       | 设置副标题 (SetSubTitle)                |
     * | 4       | 设置Actionbar (SetActionBar)           |
     * | 5       | 设置显示时间 (SetDurations)              |
     * | 6       | Json型主标题 (TitleTextObject)          |
     * | 7       | Json型副标题 (SubtitleTextObject)       |
     * | 8       | Json型Actionbar (ActionbarTextObject)  |
     * @param content 欲设置标题内容
     * @param type 设置的标题类型 默认为2
     * @param fadeInTime 淡入时间. 单位为 Tick, 默认为10
     * @param stayTime 停留时间. 单位为 Tick, 默认为70
     * @param fadeOutTime 淡出时间. 单位为 Tick, 默认为20
     * @return 是否成功发送
     */
    fun setTitle(
        content: String,
        type: Int = definedExternally,
        fadeInTime: Int = definedExternally,
        stayTime: Int = definedExternally,
        fadeOutTime: Int = definedExternally
    ): Boolean

    /**
     * 重命名玩家
     * @param newname 玩家的新名字
     * @return 是否重命名成功
     */
    fun rename(newname: String): Boolean

    /**
     * 使指定玩家着火
     * @param time 着火时长, 单位秒
     * @param isEffect 会不会有火的效果
     * @return 是否成功着火
     */
    fun setFire(time: Int, isEffect: Boolean): Boolean

    /**
     * 熄灭玩家
     * @return 是否已被熄灭
     */
    fun stopFire(): Boolean

    // .instanceFunction("transServer", &PlayerClass::transServer)
    // .instanceFunction("crash", &PlayerClass::crash)

    /**
     * 对玩家造成伤害
     * @param damage 对玩家造成的伤害数值
     * @return 是否造成伤害
     */
    fun hurt(damage: Int): Boolean

    /**
     * 治疗玩家
     * @param health 治疗的心数
     * @return 治疗是否成功
     */
    fun heal(health: Int): Boolean

    /**
     * 设置玩家的生命值
     * @param health 生命值数
     * @return 是否成功
     */
    fun setHealth(health : Int): Boolean

    /**
     * 设置玩家最大生命值
     * @param health 生命值数
     * @return 是否成功
     */
    fun setMaxHealth(health: Int): Boolean
    // 这个函数也是, 而且这lse在线文档的这两个的定义分开得更远

    /**
     * 为玩家设置伤害吸收属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setAbsorption(value: Int): Boolean

    /**
     * 为玩家设置攻击伤害属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setAttackDamage(value: Int): Boolean

    /**
     * 为玩家设置最大攻击伤害属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setMaxAttackDamage(value: Int): Boolean

    /**
     * 为玩家设置跟随范围
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setFollowRange(value: Int): Boolean

    /**
     * 为玩家设置击退抵抗属性
     * @param value 新的值 (0 or 1)
     * @return 为玩家设置属性值是否成功
     */
    fun setKnockbackResistance(value: Int): Boolean

    /**
     * 为玩家设置幸运属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setLuck(value: Int): Boolean

    /**
     * 为玩家设置移动速度属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setMovementSpeed(value: Int): Boolean

    /**
     * 为玩家设置水下移动速度属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setUnderwaterMovementSpeed(value: Int): Boolean

    /**
     * 为玩家设置岩浆上移动速度属性
     * @param value 新的值
     * @return 为玩家设置属性值是否成功
     */
    fun setLavaMovementSpeed(value: Int): Boolean

    /**
     * 设置玩家饥饿值
     * @param hunger 饥饿值数
     * @return 是否成功
     */
    fun setHungry(hunger: Int): Boolean

    // .instanceFunction("refreshChunks", &PlayerClass::refreshChunks)
    // .instanceFunction("giveItem", &PlayerClass::giveItem)
    // .instanceFunction("clearItem", &PlayerClass::clearItem)
    // .instanceFunction("isSprinting", &PlayerClass::isSprinting)
    // .instanceFunction("setSprinting", &PlayerClass::setSprinting)

    /**
     * 在屏幕上方显示消息 (类似于成就完成)
     * @param title 待发送的标题
     * @param message 待发送的文本
     * @return 是否成功发送
     */
    fun sendToast(title: String, message: String): Boolean

    // player->distanceTo
    /**
     * 获取玩家到坐标的距离
     * @param pos 目标位置
     * @return 到坐标的距离 (方块)
     */
    fun distanceTo(pos: Entity): Number
    /** @see distanceTo */
    fun distanceTo(pos: Player): Number
    /** @see distanceTo */
    fun distanceTo(pos: IntPos): Number
    /** @see distanceTo */
    fun distanceTo(pos: FloatPos): Number
    // player->distanceToSqr
    /** @see distanceTo */
    fun distanceToSqr(pos: Entity): Number
    /** @see distanceToSqr */
    fun distanceToSqr(pos: Player): Number
    /** @see distanceToSqr */
    fun distanceToSqr(pos: IntPos): Number
    /** @see distanceToSqr */
    fun distanceToSqr(pos: FloatPos): Number

    // -
    /**
     * 获取玩家当前站立所在的方块
     * @return 当前站立在的方块对象
     */
    fun getBlockStandingOn(): Block

    /**
     * 获取玩家对应的设备信息对象
     * @return 玩家对应的设备信息对象
     */
    fun getDevice(): Device

    /**
     * 获取玩家主手中的物品对象
     *
     * 此处获取的物品对象为引用.
     * 也就是说, 修改此处返回的物品对象, 或使用其API, 就相当于直接操作玩家主手中对应的物品
     * @return 玩家主手中的物品对象
     */
    fun getHand(): Item

    /**
     * 获取玩家副手的物品对象
     *
     * 此处获取的物品对象为引用.
     * 也就是说, 修改此处返回的物品对象, 或使用其API, 就相当于直接操作玩家主手中对应的物品
     * @return 玩家副手中的物品对象
     */
    fun getOffHand(): Item

    /**
     * 获取玩家物品栏的容器对象
     * @return 玩家物品栏对应的容器对象
     */
    fun getInventory(): Container

    /**
     * 获取玩家盔甲栏的容器对象
     * @return 玩家盔甲栏对应的容器对象
     */
    fun getArmor(): Container

    /**
     * 获取玩家末影箱的容器对象
     * @return 玩家末影箱对应的容器对象
     */
    fun getEnderChest(): Container

    // .instanceFunction("getRespawnPosition", &PlayerClass::getRespawnPosition)
    // .instanceFunction("setRespawnPosition", &PlayerClass::setRespawnPosition)
    // .instanceFunction("refreshItems", &PlayerClass::refreshItems)

    // -
    // .instanceFunction("getScore", &PlayerClass::getScore)
    // .instanceFunction("setScore", &PlayerClass::setScore)
    // .instanceFunction("addScore", &PlayerClass::addScore)
    // .instanceFunction("reduceScore", &PlayerClass::reduceScore)
    // .instanceFunction("deleteScore", &PlayerClass::deleteScore)
    // .instanceFunction("setSidebar", &PlayerClass::setSidebar)
    // .instanceFunction("removeSidebar", &PlayerClass::removeSidebar)
    // .instanceFunction("setBossBar", &PlayerClass::setBossBar)
    // .instanceFunction("removeBossBar", &PlayerClass::removeBossBar)
    // .instanceFunction("addLevel", &PlayerClass::addLevel)
    // .instanceFunction("reduceLevel", &PlayerClass::reduceLevel)
    // .instanceFunction("getLevel", &PlayerClass::getLevel)
    // .instanceFunction("setLevel", &PlayerClass::setLevel)

    /**
     * 缩放玩家
     * @param scale 新的玩家体积
     * @return 玩家是否成功地被缩放
     */
    fun setScale(scale: Int): Boolean

    // .instanceFunction("resetLevel", &PlayerClass::resetLevel)
    // .instanceFunction("addExperience", &PlayerClass::addExperience)
    // .instanceFunction("reduceExperience", &PlayerClass::reduceExperience)
    // .instanceFunction("getCurrentExperience", &PlayerClass::getCurrentExperience)
    // .instanceFunction("setCurrentExperience", &PlayerClass::setCurrentExperience)
    // .instanceFunction("getTotalExperience", &PlayerClass::getTotalExperience)
    // .instanceFunction("setTotalExperience", &PlayerClass::setTotalExperience)
    // .instanceFunction("getXpNeededForNextLevel", &PlayerClass::getXpNeededForNextLevel)
    // .instanceFunction("setAbility", &PlayerClass::setAbility)
    // .instanceFunction("getBiomeId", &PlayerClass::getBiomeId)
    // .instanceFunction("getBiomeName", &PlayerClass::getBiomeName)

    // -
    // .instanceFunction("getAllEffects", &PlayerClass::getAllEffects)
    // .instanceFunction("addEffect", &PlayerClass::addEffect)
    // .instanceFunction("removeEffect", &PlayerClass::removeEffect)

    // -
    // .instanceFunction("sendSimpleForm", &PlayerClass::sendSimpleForm)
    // .instanceFunction("sendModalForm", &PlayerClass::sendModalForm)
    // .instanceFunction("sendCustomForm", &PlayerClass::sendCustomForm)
    // .instanceFunction("sendForm", &PlayerClass::sendForm)
    // .instanceFunction("sendPacket", &PlayerClass::sendPacket)

    // -
    // .instanceFunction("setExtraData", &PlayerClass::setExtraData)
    // .instanceFunction("getExtraData", &PlayerClass::getExtraData)
    // .instanceFunction("delExtraData", &PlayerClass::delExtraData)

    // -
    // .instanceFunction("setNbt", &PlayerClass::setNbt)
    // .instanceFunction("getNbt", &PlayerClass::getNbt)
    // .instanceFunction("addTag", &PlayerClass::addTag)
    // .instanceFunction("removeTag", &PlayerClass::removeTag)
    // .instanceFunction("hasTag", &PlayerClass::hasTag)
    // .instanceFunction("getAllTags", &PlayerClass::getAllTags)
    // .instanceFunction("getAbilities", &PlayerClass::getAbilities)
    // .instanceFunction("getAttributes", &PlayerClass::getAttributes)
    // .instanceFunction("getEntityFromViewVector", &PlayerClass::getEntityFromViewVector)
    // .instanceFunction("getBlockFromViewVector", &PlayerClass::getBlockFromViewVector)
    // .instanceFunction("quickEvalMolangScript", &PlayerClass::quickEvalMolangScript)

    // LLMoney
    // .instanceFunction("getMoney", &PlayerClass::getMoney)
    // .instanceFunction("setMoney", &PlayerClass::setMoney)
    // .instanceFunction("addMoney", &PlayerClass::addMoney)
    // .instanceFunction("reduceMoney", &PlayerClass::reduceMoney)
    // .instanceFunction("transMoney", &PlayerClass::transMoney)
    // .instanceFunction("getMoneyHistory", &PlayerClass::getMoneyHistory)
    // endregion

    // region 模拟玩家 https://lse.liteldev.com/zh/apis/GameAPI/Player/#api_2
    // .instanceFunction("isSimulatedPlayer", &PlayerClass::isSimulatedPlayer)
    // .instanceFunction("simulateSneak", &PlayerClass::simulateSneak)
    // .instanceFunction("simulateAttack", &PlayerClass::simulateAttack)
    // .instanceFunction("simulateDestroy", &PlayerClass::simulateDestroy)
    // .instanceFunction("simulateDisconnect", &PlayerClass::simulateDisconnect)
    // .instanceFunction("simulateInteract", &PlayerClass::simulateInteract)
    // .instanceFunction("simulateRespawn", &PlayerClass::simulateRespawn)
    // .instanceFunction("simulateJump", &PlayerClass::simulateJump)
    // .instanceFunction("simulateLocalMove", &PlayerClass::simulateLocalMove)
    // .instanceFunction("simulateWorldMove", &PlayerClass::simulateWorldMove)
    // .instanceFunction("simulateMoveTo", &PlayerClass::simulateMoveTo)
    // .instanceFunction("simulateLookAt", &PlayerClass::simulateLookAt)
    // .instanceFunction("simulateSetBodyRotation", &PlayerClass::simulateSetBodyRotation)
    // .instanceFunction("simulateNavigateTo", &PlayerClass::simulateNavigateTo)
    // .instanceFunction("simulateUseItem", &PlayerClass::simulateUseItem)
    // .instanceFunction("simulateStopDestroyingBlock", &PlayerClass::simulateStopDestroyingBlock)
    // .instanceFunction("simulateStopInteracting", &PlayerClass::simulateStopInteracting)
    // .instanceFunction("simulateStopMoving", &PlayerClass::simulateStopMoving)
    // .instanceFunction("simulateStopUsingItem", &PlayerClass::simulateStopUsingItem)
    // .instanceFunction("simulateStopSneaking", &PlayerClass::simulateStopSneaking)
    // endregion

    // region 向下兼容
    // .instanceProperty("sneaking", &PlayerClass::isSneaking)
    // .instanceProperty("ip", &PlayerClass::getIP)
    // .instanceFunction("setTag", &PlayerClass::setNbt)
    // .instanceFunction("getTag", &PlayerClass::getNbt)
    // .instanceFunction("setOnFire", &PlayerClass::setOnFire)
    // .instanceFunction("removeItem", &PlayerClass::removeItem)
    // .instanceFunction("getAllItems", &PlayerClass::getAllItems)
    // .instanceFunction("removeScore", &PlayerClass::deleteScore)
    // .instanceFunction("distanceToPos", &PlayerClass::distanceTo)
    // endregion
}
typealias Player = LLSE_Player
