external class network {
    companion object {
        /**
         * 发送一个异步HTTP(s) Get请求
         * @param url 请求的目标地址（包括 Get 请求附带的参数）
         * @param callback 当请求返回时执行的回调函数，用于回传HTTP(s)响应结果。
         * @return 是否成功发送请求
         */
        fun httpGet(
            url: String,
            callback: (status: Number, result: String) -> Unit
        ): Boolean

        /**
         * 发送一个异步HTTP(s) Get请求
         * @param url 请求的目标地址（包括 Get 请求附带的参数）
         * @param header 请求头（包括 Get 请求Request header）
         * @param callback 当请求返回时执行的回调函数，用于回传HTTP(s)响应结果。
         * @return 是否成功发送请求
         */
        fun httpGet(
            url: String,
            header: Any,
            callback: (status: Number, result: String) -> Unit
        ): Boolean

        /**
         * 发送一个异步HTTP(s) Post请求
         * @param url 请求的目标地址
         * @param data 发送的数据
         * @param type 发送的 Post 数据类型，形如 `text/plain` `application/x-www-form-urlencoded` 等
         * @param callback 当请求返回时执行的回调函数，用于回传HTTP(s)响应结果。
         * @return 是否成功发送请求
         */
        fun httpPost(
            url: String,
            data: String,
            type: String,
            callback: (status: Number, result: String) -> Unit
        ): Boolean

        /**
         * 发送一个异步HTTP(s) Post请求
         * @param url 请求的目标地址
         * @param header 请求头（包括 Post 请求Request header）
         * @param data 发送的数据
         * @param type 发送的 Post 数据类型，形如 `text/plain` `application/x-www-form-urlencoded` 等
         * @param callback 当请求返回时执行的回调函数，用于回传HTTP(s)响应结果。
         * @return 是否成功发送请求
         */
        fun httpPost(
            url: String,
            header: Any,
            data: String,
            type: String,
            callback: (status: Number, result: String) -> Unit
        ): Boolean
    }
}

typealias WSClientType = Number
external class WSClient {
    /** 处于正常连接中   */
    val Open: WSClientType
    /** 正在断开连接 */
    val Closing: WSClientType
    /** 未连接 */
    val Closed: WSClientType

    /** 当前的连接状态 */
    val status: WSClientType

    /**
     * 创建连接
     * @param target 要连接的目标地址
     * @return 是否成功连接
     */
    fun connect(target: String): Boolean

    /**
     * 异步创建连接
     * @param target 要连接的目标地址
     * @param callback 当连接成功或者失败时执行的回调函数。
     * @return 是否成功开始尝试连接
     */
    fun connectAsync(target: String, callback: (success: Boolean) -> Unit): Boolean

    /**
     * 发送文本
     * @param msg 要发送的文本
     * @return 是否成功发送
     */
    fun send(msg: String): Boolean
    /**
     * 二进制消息
     * @param msg 要发送的二进制数据
     * @return 是否成功发送
     */
    fun send(msg: ByteBuffer): Boolean

    /**
     * 监听WebSocket事件
     * @param event 要监听的事件名
     * @param callback 注册的监听函数
     * @return 是否成功监听事件
     * @see <a href="https://lse.liteldev.com/zh/apis/SystemAPI/Network/#_5">监听事件列表</a>
     */
    fun listen(event: String, callback: Any): Boolean

    /**
     * 关闭连接 (在处于关闭状态时，请勿继续使用此客户端对象！)
     * @return 是否成功关闭连接
     */
    fun close(): Boolean

    /**
     * 强制断开连接
     * @return 是否成功断开连接
     */
    fun shutdown(): Boolean

    /**
     * 获取错误码
     * @return 上一次错误产生的错误码
     */
    fun errorCode(): Int
}

external class HttpRequest {
    /** 请求方法 */
    val method: String

    /** 请求路径 */
    val path: String

    /** 请求查询参数 */
    val query: Any

    /** 请求查询参数(同上) */
    val params: Any

    /** 请求头 */
    val headers: Any

    /** 请求内容 */
    val body: String

    /** 请求源地址 */
    val remoteAddr: String

    /** 请求源端口 */
    val remotePort: Number

    /** 请求版本 */
    val version: String

    /** 请求路径正则匹配结果 */
    val matches: Array<Any>

    /**
     * 获取指定请求头的值
     * @param name 请求头名称
     * @return 请求头的值数组(如果没有该请求头，则返回`[]`空数组)
     */
    fun getHeader(name: String): Array<String>
}

external class HttpResponse {
    /** 响应状态码 */
    var status: Number

    /** 响应头 */
    var header: Any

    /** 响应内容 */
    var body: String

    /** 响应版本 */
    var version: String

    /** 错误原因 */
    var reason: String

    /**
     * 获取指定请求头的值
     * @param name 请求头名称
     * @return 请求头的值数组(如果没有该请求头，则返回`[]`空数组)
     */
    fun getHeader(name: String): Array<String>

    /**
     * 设置指定响应头的值
     * @param name 响应头名称
     * @param value 响应头值
     * @return 处理完毕的响应对象
     */
    fun setHeader(name: String, value: Any): HttpResponse

    /**
     * 写入响应内容
     * @param content 响应内容
     * @return 处理完毕的响应对象
     */
    fun write(vararg content: Any): HttpResponse
}

external class HttpServer {
    /**
     * 监听 Get 请求
     * @param path 请求目录，以`/`开头，可以包含正则表达式。如: `/test/(.+)`
     * @param callback 回调函数，在收到符合path的GET请求回调
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onGet(
        path: String,
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 Put 请求
     * @param path 请求目录，以`/`开头，可以包含正则表达式。如: `/test/(.+)`
     * @param callback 回调函数，在收到符合path的Put请求回调
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onPut(
        path: String,
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 Post 请求
     * @param path 请求目录，以`/`开头，可以包含正则表达式。如: `/test/(.+)`
     * @param callback 回调函数，在收到符合path的Post请求回调
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onPost(
        path: String,
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 Patch 请求
     * @param path 请求目录，以`/`开头，可以包含正则表达式。如: `/test/(.+)`
     * @param callback 回调函数，在收到符合path的Patch请求回调
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onPatch(
        path: String,
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 Delete 请求
     * @param path 请求目录，以`/`开头，可以包含正则表达式。如: `/test/(.+)`
     * @param callback 回调函数，在收到符合path的Delete请求回调
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onDelete(
        path: String,
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 Options 请求
     * @param path 请求目录，以`/`开头，可以包含正则表达式。如: `/test/(.+)`
     * @param callback 回调函数，在收到符合path的Options请求回调
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onOptions(
        path: String,
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 PreRouting 预路由事件
     * @param callback 回调函数，在收到请求时调用。在回调函数中可以修改响应，如果返回`false`，则不会继续路由至对应路径的回调函数(但仍然会触发PostRouting事件)。
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onPreRouting(
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 PostRouting 后路由事件
     * @param callback 回调函数，在对应目录的回调函数(或PreRouting事件)执行完毕后调用，在回调函数中可以修改响应
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onPostRouting(
        callback: (req: HttpRequest, resp: HttpResponse) -> Unit
    ): HttpServer

    /**
     * 监听 Error 错误事件
     * @param callback 回调函数，在错误(状态码 >= 400)时调用
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onError(callback: (req: HttpRequest, resp: HttpResponse) -> Unit): HttpServer

    /**
     * 监听 Exception 异常事件
     * @param callback 回调函数，在handler中有抛出异常时调用，参数3为异常信息
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun onException(
        callback: (req: HttpRequest, resp: HttpResponse,error:String) -> Unit
    ): HttpServer

    /**
     * 监听端口并开启服务器
     * @param addr 监听地址，可以是IP地址或域名
     * @param port 监听端口
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun listen(addr: String, port: Number): HttpServer

    /**
     * 监听端口并开启服务器
     * @param addr 监听地址，可以是IP地址或域名
     * @param port 监听端口
     * @return 处理完毕的服务器对象（便于连锁进行其他操作）
     */
    fun startAt(addr: String, port: Number): HttpServer

    /**
     * 停止服务器
     */
    fun stop(): Unit

    /**
     * 获取服务器是否正在运行
     * @return 服务器正在运行与否
     */
    fun isRunning(): Boolean
}
