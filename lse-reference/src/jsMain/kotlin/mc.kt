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

        // region https://lse.liteldev.com/zh/apis/GameAPI/Server/
        /**
         * 获取BDS服务端版本号
         * @return 服务端版本号字符串，格式形如`v1.17.10`
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
         * @param TimeID 想要查询的时间 (0 代表daytime，1 代表gametime，2 代表day)
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
         * @return 当前天气 (0 代表晴天，1 代表雨天，2 代表雷暴)
         */
        fun getWeather(): Int

        /**
         * 设置服务器天气
         * @param WeatherID 想要设置的天气 (0 代表晴天，1 代表雨天，2 代表雷暴)
         * @return 是否设置成功
         */
        fun setWeather(WeatherID: Int): Boolean
        // endregion


    }
}