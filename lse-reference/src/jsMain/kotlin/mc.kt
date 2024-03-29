external class mc {
    companion object {
        // region https://lse.liteldev.com/zh/apis/EventAPI/Listen/
        /**
         * 注册监听器
         * @param event 要监听的事件名
         * @param callback 注册的监听函数. 当指定的事件发生时, BDS会调用你给出的监听函数, 并传入相应的参数
         * @return 是否成功监听事件
         * @see <a href="https://lse.liteldev.com/zh/apis/EventAPI/Listen/#_4">📜 监听事件列表</a>
         */
        fun listen(
            event: String,
            callback: Any
        ): Boolean
        // endregion

        // region https://lse.liteldev.com/zh/apis/GameAPI/Basic/
        /**
         * 生成一个整数坐标对象
         * @param x x 坐标
         * @param y y 坐标
         * @param z z 坐标
         * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
         * @return 一个整数坐标对象
         */
        fun newIntPos(x: Int, y: Int, z: Int, dimid: Int): IntPos

        /**
         * 生成一个浮点数坐标对象
         * @param x x 坐标
         * @param y y 坐标
         * @param z z 坐标
         * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
         * @return 一个浮点数坐标对象
         */
        fun newFloatPos(x: Float, y: Float, z: Float, dimid: Int): FloatPos

        /**
         * 获取结构NBT
         * @param pos1 对角坐标1, 填写方式与 fill命令 的 from 参数类似
         * @param pos2 对角坐标2, 填写方式与 fill命令 的 to 参数类似
         * @param ignoreBlocks 忽略方块
         * @param ignoreEntities 忽略实体
         * @return 结构NBT
         */
        fun getStructure(
            pos1: IntPos, pos2: IntPos,
            ignoreBlocks: Boolean = definedExternally, ignoreEntities: Boolean = definedExternally
        ): NbtCompound

        /**
         * 放置结构NBT
         * @param nbt 结构NBT
         * @param pos 放置坐标
         * @param mirror 镜像模式: 0 不镜像, 1 X轴, 2 Z轴, 3 XZ轴
         * @param rotation 旋转角度: 0 不旋转, 1 旋转90°, 2 旋转180°, 3 旋转270°
         * @return 是否放置成功
         */
        fun setStructure(
            nbt: NbtCompound, pos: IntPos,
            mirror: Int = definedExternally, rotation: Int = definedExternally
        ): Boolean
        // endregion

        // region https://lse.liteldev.com/zh/apis/GameAPI/Command/
        /**
         * 执行一条后台命令
         * @param cmd 待执行的命令
         * @return 是否执行成功
         */
        fun runcmd(cmd: String): Boolean

        /**
         * 执行一条后台命令 (强化版)
         * > runcmdEx 与普通 runcmd 实现区别非常大, 在于 Ex 版本拥有隐藏输出的机制, 执行结果不会输出至控制台, 因此如果有需要, 要手动用 log 函数将结果输出
         *
         * 对于返回的某个执行结果对象res, 有如下这些成员:
         *
         * | 成员         | 含义                 | 类型       |
         * | ----------- | ------------------- | --------- |
         * | res.success | 是否执行成功          | `Boolean` |
         * | res.output  | BDS执行命令后的输出结果 | `String`  |
         * @param cmd 待执行的命令
         * @return 命令执行结果
         */
        fun runcmdEx(cmd: String): dynamic

        /**
         * 注册一条顶层命令
         * @param cmd 待注册的命令
         * @param description 命令描述文本
         * @param permission 指令执行所需权限 (默认 `PermType.GameMasters`只有OP可以执行这条指令)
         * @param flag 默认值 0x80
         * @param alias 命令的别名 (可以为命令设置多个别名, 执行的时候相当于触发同一条命令)
         * @return 指令对象
         */
        fun newCommand(
            cmd: String,
            description: String,
            permission: PermType = definedExternally,
            flag: Int = definedExternally,
            alias: String = definedExternally
        ): Command
        // endregion

        // region https://lse.liteldev.com/zh/apis/GameAPI/Particle/
        /**
         * 生成一个粒子生成器对象
         * @param displayRadius 粒子显示半径. 默认值 `4294967295`
         * @param highDetial 需要高细节线条. 默认值 `true`
         * @param doubleSide 需要双面粒子. 默认值 `true`
         */
        fun newParticleSpawner(
            displayRadius: Int = definedExternally,
            highDetial: Boolean = definedExternally,
            doubleSide: Boolean = definedExternally
        ): ParticleSpawner
        // endregion

        // region https://lse.liteldev.com/zh/apis/GameAPI/Player/
        /**
         * 从现有玩家获取
         * @param info 玩家的名字或者Xuid
         * @return 生成的玩家对象
         */
        fun getPlayer(info: String): Player

        /**
         * 获取所有在线玩家
         * @return 玩家对象的数组
         */
        fun getOnlinePlayers(): Array<Player>

        /**
         * 广播一个文本消息给所有玩家
         * @param msg 待发送的文本
         * @param type 发送的文本消息类型, 默认为0: 0 普通消息(Raw), 1聊天消息(Chat), 5 物品栏上方的消息(Tip), 9 JSON格式消息(JSON)
         * @return 是否成功发送
         */
        fun broadcast(msg: String, type: Int = definedExternally): Boolean

        /**
         * 获取玩家对应的NBT对象 (可获取离线玩家的NBT)
         * @param uuid 玩家的UUID
         * @return 玩家的NBT对象
         */
        fun getPlayerNbt(uuid: String): NbtCompound

        /**
         * 写入玩家对应的NBT对象 (可操作离线玩家的NBT)
         * @param uuid 玩家的UUID
         * @param nbt NBT对象
         * @return 是否成功写入
         */
        fun setPlayerNbt(uuid: String, nbt: NbtCompound): Boolean

        /**
         * 覆盖玩家对应的NBT对象的特定NbtTag
         * @param uuid 玩家的UUID
         * @param nbt NBT对象
         * @param tags 需要覆盖的NbtTag
         * @return 是否成功覆盖对应的Tag
         */
        fun setPlayerNbtTags(
            uuid: String,
            nbt: NbtCompound,
            tags: Array<String>
        ): Boolean

        /**
         * 从存档中删除玩家对应的NBT对象的全部内容
         * @param uuid 玩家的UUID
         * @return 是否删除成功
         */
        fun deletePlayerNbt(uuid: String): Boolean

        /**
         * 创建一个模拟玩家
         * @param name 模拟玩家名
         * @param pos 生成生物的位置的坐标对象 (或者使用x, y, z, dimid来确定生成位置)
         * @return 模拟玩家对象 (为 Null 则表示生成失败)
         */
        fun spawnSimulatedPlayer(
            name: String,
            pos: IntPos
        ): Player?
        /**
         * 创建一个模拟玩家
         * @param name 模拟玩家名
         * @param pos 生成生物的位置的坐标对象 (或者使用x, y, z, dimid来确定生成位置)
         * @return 模拟玩家对象 (为 Null 则表示生成失败)
         */
        fun spawnSimulatedPlayer(
            name: String,
            pos: FloatPos
        ): Player?
        /**
         * 创建一个模拟玩家
         * @param name 模拟玩家名
         * @param x x 坐标
         * @param y y 坐标
         * @param z z 坐标
         * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
         * @return 模拟玩家对象 (为 Null 则表示生成失败)
         */
        fun spawnSimulatedPlayer(
            name: String,
            x: Int,
            y: Int,
            z: Int,
            dimid: Int
        ): Player?
        /**
         * 创建一个模拟玩家
         * @param name 模拟玩家名
         * @param x x 坐标
         * @param y y 坐标
         * @param z z 坐标
         * @param dimid 维度ID: 0 代表主世界, 1 代表下界, 2 代表末地
         * @return 模拟玩家对象 (为 Null 则表示生成失败)
         */
        fun spawnSimulatedPlayer(
            name: String,
            x: Float,
            y: Float,
            z: Float,
            dimid: Int
        ): Player?
        // endregion

        // region https://lse.liteldev.com/zh/apis/GameAPI/ScoreBoard/
        /**
         * 创建一个新的计分项
         * @param name 计分项名称
         * @param displayName 计分项显示名称
         * @return 新增创建的计分项对象. 如果返回Null, 则代表创建失败
         */
        fun newScoreObjective(name: String, displayName: String): Objective?

        /**
         * 获取某个已存在的计分项
         * @param name 要获取的计分项名称
         * @return 对应的计分项对象. 如果返回Null, 则代表计分项不存在
         */
        fun getScoreObjective(name: String): Objective?

        /**
         * 获取所有计分项 (此接口的作用类似命令 `/scoreboard objectives list`)
         * @return 计分板系统记录的所有计分项对象
         */
        fun getAllScoreObjectives(): Array<Objective>

        /**
         * 获取某个处于显示状态的计分项
         * @param slot 待查询的显示槽位名称. 可以为 sidebar/belowname/list
         * @return 如果返回Null, 则代表对应槽位未显示计分项
         */
        fun getDisplayObjective(slot: String): Objective?

        /**
         * 获取玩家计分项的分数 (可查询离线玩家计分板)
         * @param uuid 玩家的UUID
         * @param name 计分项名称
         * @return 计分板上的数值
         */
        fun getPlayerScore(uuid: String, name: String): Int

        /**
         * 设置玩家计分项的分数 (可修改离线玩家计分板)
         * @param uuid 玩家的UUID
         * @param name 计分项名称
         * @param value 要设置的数值
         * @return 是否设置成功
         */
        fun setPlayerScore(uuid: String, name: String, value: Int): Boolean

        /**
         * 增加玩家计分项的分数 (可修改离线玩家计分板)
         * @param uuid 玩家的UUID
         * @param name 计分项名称
         * @param value 要增加的数值
         * @return 是否设置成功
         */
        fun addPlayerScore(uuid: String, name: String, value: Int): Boolean

        /**
         * 减少玩家计分项的分数 (可修改离线玩家计分板)
         * @param uuid 玩家的UUID
         * @param name 计分项名称
         * @param value 要减少的数值
         * @return 是否设置成功
         */
        fun reducePlayerScore(uuid: String, name: String, value: Int): Boolean

        /**
         * 移除玩家计分项的分数 (可修改离线玩家计分板)
         * @param uuid 玩家的UUID
         * @param name 计分项名称
         * @return 是否设置成功
         */
        fun deletePlayerScore(uuid: String, name: String): Boolean

        /**
         * 移除一个已存在的计分项
         * @param name 计分项名称
         * @return 是否移除成功
         */
        fun removeScoreObjective(name: String): Boolean

        /**
         * 使计分项停止显示
         * @param slot 显示槽位名称字符串. 可以为 sidebar/belowname/list
         * @return 是否清除成功
         */
        fun clearDisplayObjective(slot: String): Boolean
        // endregion

        // region https://lse.liteldev.com/zh/apis/GameAPI/Server/
        /**
         * 获取BDS服务端版本号
         * @return 服务端版本号字符串, 格式形如`v1.17.10`
         */
        fun getBDSVersion(): String

        /**
         * 获取BDS服务端协议版本
         * @return 服务端协议版本
         */
        fun getServerProtocolVersion(): Number

        /**
         * 设置服务器Motd字符串
         * @param motd 目标Motd字符串
         * @return 是否设置成功
         */
        fun setMotd(motd: String): Boolean

        /**
         * 设置服务器最大玩家数
         * @param num 最大玩家数
         * @return 是否设置成功
         */
        fun setMaxPlayers(num: Number): Boolean

        /**
         * 获取服务器游戏时间
         * @param TimeID 想要查询的时间 (0 代表daytime, 1 代表gametime, 2 代表day)
         * @return 获取到的时间
         */
        fun getTime(TimeID: Int): Number

        /**
         * 设置服务器时间
         * @param tick 想要设置的时间
         * @return 是否设置成功
         */
        fun setTime(tick: Number): Boolean

        /**
         * 获取服务器天气
         * @return 当前天气 (0 代表晴天, 1 代表雨天, 2 代表雷暴)
         */
        fun getWeather(): Int

        /**
         * 设置服务器天气
         * @param WeatherID 想要设置的天气 (0 代表晴天, 1 代表雨天, 2 代表雷暴)
         * @return 是否设置成功
         */
        fun setWeather(WeatherID: Int): Boolean
        // endregion

        // region https://lse.liteldev.com/zh/apis/GuiAPI/FormBuilder/
        /**
         * 创建表单对象
         * @return 新创建的空白表单对象
         */
        fun newSimpleForm(): SimpleForm

        /**
         * 创建表单对象
         * @return 新创建的空白表单对象
         */
        fun newCustomForm(): CustomForm
        // endregion


    }
}