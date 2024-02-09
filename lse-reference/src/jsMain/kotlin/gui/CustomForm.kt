/**
 * 自定义表单构建器
 * @see <a href="https://lse.liteldev.com/zh/apis/GuiAPI/FormBuilder/#api_1">📰 自定义表单构建器 API</a>
 */
open external class LLSE_CustomForm {
    /**
     * 设置表单的标题
     * @param title 表单的标题
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun setTitle(title: String): CustomForm


    /**
     * 向表单内增加一行文本
     * @param text 一行文本
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addLabel(text: String): CustomForm

    /**
     * 向表单内增加一行输入框
     * @param title 输入框描述文本
     * @param placeholder 输入框内的提示字符
     * @param default 输入框中默认存在的内容
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addInput(
        title: String,
        placeholder: String = definedExternally,
        default: String = definedExternally
    ): CustomForm

    /**
     * 向表单内增加一行开关选项
     * @param title 开关选项描述文本
     * @param default 开关的默认状态 开 / 关
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addSwitch(title: String, default: Boolean = definedExternally): CustomForm

    /**
     * 向表单内增加一行下拉菜单
     * @param title 下拉菜单描述文本
     * @param items 下拉菜单中的选项文本列表
     * @param default 下拉菜单默认选中的列表项序号. 序号从0开始编号, 默认为0, 即默认选中列表的第一项.
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addDropdown(
        title: String,
        items: Array<String>,
        default: Int
    ): CustomForm

    /**
     * 向表单内增加一行游标滑块
     * @param title 游标滑块描述文本
     * @param min 游标滑块最小值
     * @param max 游标滑块最大值
     * @param step 游标滑块调整的最小分度值, 默认为1
     * @param default 游标滑块默认初始格数, 数值必须在最小和最大格数之间. 默认为0, 即滑块位于滑块行的开头.
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addSlider(
        title: String,
        min: Int,
        max: Int,
        step: Int = definedExternally,
        default: Int = definedExternally
    ): CustomForm

    /**
     * 向表单内增加一行步进滑块
     * @param title 步进滑块描述文本
     * @param items 步进滑块的选项文本列表
     * @param default 步进滑块默认初始选项, 序号从0开始编号. 默认为0, 即滑块位于滑块行的开头.
     * @return 处理完毕的表单对象 (便于连锁进行其他操作)
     */
    fun addStepSlider(
        title: String,
        items: Array<String>,
        default: Int
    ): CustomForm
}
typealias CustomForm = LLSE_CustomForm
