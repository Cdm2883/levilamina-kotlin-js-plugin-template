# levilamina-kotlin-js-plugin-template
使用 Kotlin/JS 开发 LSE 插件!

> [!WARNING]  
> LegacyScriptEngine 接口的完整定义正在编写. 并且 LegacyScriptEngine 正在处于开发阶段, 接口定义可能随时发生改变, 需谨慎使用该项目进行开发!

## 🛠️ 用法
1. 克隆该项目到本地
2. 在模块 [plugin](plugin/src/jsMain/kotlin/Main.kt) 处编写你的插件逻辑
3. 使用 Gradle 构建根项目或 plugin 模块
4. 分发或使用位于 [plugin/build/dist/js/productionExecutable/levilamina-kotlin-js-plugin-template.js](plugin/build/dist/js/productionExecutable/levilamina-kotlin-js-plugin-template.js) 的编译结果文件!
5. 在 [settings.gradle.kts](settings.gradle.kts) 中修改`rootProject.name`为你的项目名称
6. 探索 [plugin/build.gradle.kts](plugin/build.gradle.kts) 自定义编译过程

...

## 🧩 模块
| 名称            | 注释                    |
|---------------|-----------------------|
| lse-reference | LSE接口定义               |
| lse-ktx       | 对于Kotlin使用LSE接口的封装优化库 |
| plugin        | 插件主逻辑                 |

## ✨ 特性
- [ ] LSE接口完整定义
  - [ ] DataAPI
  - [x] EventAPI
  - [ ] GameAPI
  - [x] GuiAPI
  - [ ] NativeAPI
  - [x] NbtAPI
  - [x] ScriptAPI
  - [x] SystemAPI
- [ ] 命令注册的DSL
- [ ] 表单UI的DSL
- [ ] NBT操作的DSL

...

## 🤔 问答
### Q: 是否支持`适用于 LiteLoaderBDSv2 的 LLSE`?
A: `lse-reference`的接口定义是按照[`适用于 Levilamina 的 LSE`](https://github.com/LiteLDev/LegacyScriptEngine)编写的, 其中大部分接口都有向下兼容.\
若遇到无法使用的情况 *(例如NativeAPI的部分接口)*, 可自行定义接口或使用 Kotlin/JS 内置的`fun js(code: String): dynamic`执行**常量**代码.
### Q: 为什么不使用`Kotlin/Native`?
A: ~~不太熟悉cpp (逃~~ 这条道路还是留给其他开发者探索吧!

## 📰 链接
- [Dukat - Converter of TypeScript definition files to Kotlin declarations](https://github.com/Kotlin/dukat)
- [Kotlin/JS dead code elimination](https://kotlinlang.org/docs/javascript-dce.html)
- [Use JavaScript code from Kotlin](https://kotlinlang.org/docs/js-interop.html)
- [Dynamic type](https://kotlinlang.org/docs/dynamic-type.html)
- [Use dependencies from npm](https://kotlinlang.org/docs/using-packages-from-npm.html)

## 🎈 开源
项目由 [Kotlin Multiplatform](https://github.com/JetBrains/kotlin) 强力驱动并采用 [Apache License 2.0](LICENSE) 开源
```
Copyright 2024 Cdm2883

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```