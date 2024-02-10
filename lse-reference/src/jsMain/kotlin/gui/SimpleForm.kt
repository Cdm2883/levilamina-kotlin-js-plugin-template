/**
 * 普通表单构建器
 * @see <a href="https://lse.liteldev.com/zh/apis/GuiAPI/FormBuilder/">📃 普通表单构建器 API</a>
 */
open external class LLSE_SimpleForm(nullptr: Nothing) {
    /**
     * 设置表单的标题
     * @param title 表单的标题
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun setTitle(title: String): SimpleForm

    /**
     * 设置表单的内容
     * @param content 表单的文本内容
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun setContent(content: String): SimpleForm

    /**
     * 向表单内增加一行按钮
     *
     * 图片路径参数 `image` 使用材质包路径或者URL来标识按钮对应的图标.
     * 对于表单上的每个按钮, 如下设置对应的图标
     *
     * 1. 如果使用材质包路径, 图片路径应该形如 `textures/items/apple`
     * 2. 如果使用URL路径, 那么在这里放入完整的URL即可, 形如 `https://www.baidu.com/img/flexible/logo/pc/result.png`
     * 3. 如果这个按钮你不需要显示图片, 那不传入此参数即可
     * @param text 按钮文本的字符串
     * @param image 按钮图片所在路径
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addButton(text: String, image: String = definedExternally): SimpleForm
}
typealias SimpleForm = LLSE_SimpleForm
