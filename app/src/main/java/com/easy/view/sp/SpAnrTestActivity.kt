package com.easy.view.sp

import android.content.Context
import android.view.View
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import com.easy.view.databinding.ActivitySpAnrTestBinding

/**
 * Created by shishufeng on 2021/6/7
 * desc: 测试8.0以下sp anr 问题修复
 */
class SpAnrTestActivity: BaseEasyActivity<ActivitySpAnrTestBinding>() {

    override val binding: ActivitySpAnrTestBinding
        get() = ActivitySpAnrTestBinding.inflate(layoutInflater)

    override fun initView() {
        binding.btnStartWrite.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        if (v?.id == R.id.btn_start_write){
            startSpApply()
        }
    }

    private fun startSpApply() {
        val sp = getSharedPreferences("spAnrTest",Context.MODE_PRIVATE)
        val edit = sp.edit()
        val content = "为某个模块启用视图绑定功能后，系统会为该模块中包含的每个 XML 布局文件生成一个绑定类。每个绑定类均包含对根视图以及具有 ID 的所有视图的引用。系统会通过以下方式生成绑定类的名称：将 XML 文件的名称转换为驼峰式大小写，并在末尾添加“Binding”一词。\n" +
                "\n" +
                "例如，假设某个布局文件的名称为 result_profile.xml：所生成的绑定类的名称就为 ResultProfileBinding。此类具有两个字段：一个是名为 name 的 TextView，另一个是名为 button 的 Button。该布局中的 ImageView 没有 ID，因此绑定类中不存在对它的引用。\n" +
                "\n" +
                "每个绑定类还包含一个 getRoot() 方法，用于为相应布局文件的根视图提供直接引用。在此示例中，ResultProfileBinding 类中的 getRoot() 方法会返回 LinearLayout 根视图。\n" +
                "\n" +
                "以下几个部分介绍了生成的绑定类在 Activity 和 Fragment 中的使用。在 Activity 中使用视图绑定\n" +
                "如需设置绑定类的实例以供 Activity 使用，请在 Activity 的 onCreate() 方法中执行以下步骤：\n" +
                "\n" +
                "调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用。\n" +
                "通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。\n" +
                "将根视图传递到 setContentView()，使其成为屏幕上的活动视图。为某个模块启用视图绑定功能后，系统会为该模块中包含的每个 XML 布局文件生成一个绑定类。每个绑定类均包含对根视图以及具有 ID 的所有视图的引用。系统会通过以下方式生成绑定类的名称：将 XML 文件的名称转换为驼峰式大小写，并在末尾添加“Binding”一词。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"例如，假设某个布局文件的名称为 result_profile.xml：所生成的绑定类的名称就为 ResultProfileBinding。此类具有两个字段：一个是名为 name 的 TextView，另一个是名为 button 的 Button。该布局中的 ImageView 没有 ID，因此绑定类中不存在对它的引用。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"每个绑定类还包含一个 getRoot() 方法，用于为相应布局文件的根视图提供直接引用。在此示例中，ResultProfileBinding 类中的 getRoot() 方法会返回 LinearLayout 根视图。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"以下几个部分介绍了生成的绑定类在 Activity 和 Fragment 中的使用。在 Activity 中使用视图绑定\\n\" +\n" +
                "                \"如需设置绑定类的实例以供 Activity 使用，请在 Activity 的 onCreate() 方法中执行以下步骤：\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用。\\n\" +\n" +
                "                \"通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。\\n\" +\n" +
                "                \"将根视图传递到 setContentView()，使其成为屏幕上的活动视图。"
        repeat(1000){
            edit.putString("it_$it",content)
            edit.apply()
        }
    }


}