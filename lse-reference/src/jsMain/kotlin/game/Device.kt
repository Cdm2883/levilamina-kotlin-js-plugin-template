// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/DeviceAPI.cpp

external class LLSE_Device(nullptr: Nothing) {
    /** 玩家设备的IP地址 */
    val ip: String

    /** 玩家的平均网络延迟时间 (ms) */
    val avgPing: Int

    /** 玩家的平均网络丢包率 (%) */
    val avgPacketLoss: Float

    /** 玩家的网络延迟时间 (ms) */
    val lastPing: Int

    /** 玩家的网络丢包率 (%) */
    val lastPacketLoss: Float

    /**
     * 玩家设备的操作系统类型
     *
     * | dv.os返回字符串  | 玩家设备的操作系统       |
     * | -------------- | -------------------- |
     * | `Android`      | 手机谷歌Android        |
     * | `iOS`          | 手机苹果iOS/平板iPadOS  |
     * | `OSX`          | 电脑苹果macOS          |
     * | `Amazon`       | 平板/电视亚马逊FireOS   |
     * | `GearVR`       | 头显三星GearVR         |
     * | `Hololens`     | 头显微软HoloLens       |
     * | `Windows10`    | 电脑微软Windows        |
     * | `Win32`        | 电脑微软Win32 (教育版?) |
     * | `TVOS`         | 机顶盒苹果tvOS         |
     * | `PlayStation`  | 主机索尼PlayStation    |
     * | `Nintendo`     | 掌机任天堂Switch       |
     * | `Xbox`         | 主机微软Xbox           |
     * | `WindowsPhone` | 手机微软Windows Mobile |
     * | `Unknown`      | 未知系统               |
     */
    val os: String

    //.instanceProperty("inputMode", &DeviceClass::getInputMode)
    //.instanceProperty("playMode", &DeviceClass::getPlayMode)

    /** 玩家连接的地址 */
    val serverAddress: String

    /** 玩家客户端的识别码ID */
    val clientId: String
}
typealias Device = LLSE_Device
