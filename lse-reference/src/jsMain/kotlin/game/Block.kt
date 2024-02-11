// https://github.com/LiteLDev/LegacyScriptEngine/blob/main/src/legacy/api/BlockAPI.cpp

external class LLSE_Block(nullptr: Nothing) {
    //.instanceFunction("asPointer", &BlockClass::asPointer)

    //.instanceProperty("name", &BlockClass::getName)
    //.instanceProperty("type", &BlockClass::getType)
    //.instanceProperty("id", &BlockClass::getId)
    //.instanceProperty("pos", &BlockClass::getPos)
    //.instanceProperty("tileData", &BlockClass::getTileData)
    //.instanceProperty("variant", &BlockClass::getVariant)
    //.instanceProperty("translucency", &BlockClass::getTranslucency)
    //.instanceProperty("thickness", &BlockClass::getThickness)

    //.instanceProperty("isAir", &BlockClass::isAir)
    //.instanceProperty("isBounceBlock", &BlockClass::isBounceBlock)
    //.instanceProperty("isButtonBlock", &BlockClass::isButtonBlock)
    //.instanceProperty("isCropBlock", &BlockClass::isCropBlock)
    //.instanceProperty("isDoorBlock", &BlockClass::isDoorBlock)
    //.instanceProperty("isFenceBlock", &BlockClass::isFenceBlock)
    //.instanceProperty("isFenceGateBlock", &BlockClass::isFenceGateBlock)
    //.instanceProperty("isThinFenceBlock", &BlockClass::isThinFenceBlock)
    //.instanceProperty("isHeavyBlock", &BlockClass::isHeavyBlock)
    //.instanceProperty("isStemBlock", &BlockClass::isStemBlock)
    //.instanceProperty("isSlabBlock", &BlockClass::isSlabBlock)
    //.instanceProperty("isUnbreakable", &BlockClass::isUnbreakable)
    //.instanceProperty("isWaterBlockingBlock", &BlockClass::isWaterBlockingBlock)

    //.instanceFunction("setNbt", &BlockClass::setNbt)
    //.instanceFunction("getNbt", &BlockClass::getNbt)
    //.instanceFunction("getBlockState", &BlockClass::getBlockState)
    //.instanceFunction("hasContainer", &BlockClass::hasContainer)
    //.instanceFunction("getContainer", &BlockClass::getContainer)
    //.instanceFunction("hasBlockEntity", &BlockClass::hasBlockEntity)
    //.instanceFunction("getBlockEntity", &BlockClass::getBlockEntity)
    //.instanceFunction("removeBlockEntity", &BlockClass::removeBlockEntity)
    //.instanceFunction("destroy", &BlockClass::destroyBlock)

    // For Compatibility
    //.instanceFunction("setTag", &BlockClass::setNbt)
    //.instanceFunction("getTag", &BlockClass::getNbt)
}
typealias Block = LLSE_Block
