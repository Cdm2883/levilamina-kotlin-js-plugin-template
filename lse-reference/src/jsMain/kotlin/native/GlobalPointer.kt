// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/GlobalNativePointer.cpp

external class GlobalPointer {
    companion object {
        fun Level(): NativePointer
        fun Minecraft(): NativePointer
        fun ServerNetworkHandler(): NativePointer
        fun MinecraftCommands(): NativePointer
        fun LevelStorage(): NativePointer
        fun DBStorage(): NativePointer
        fun RakNetServerLocator(): NativePointer
        fun RakNetRakPeer(): NativePointer
        fun Scoreboard(): NativePointer
        fun AllowListFile(): NativePointer
        fun PropertiesSettings(): NativePointer
    }
}