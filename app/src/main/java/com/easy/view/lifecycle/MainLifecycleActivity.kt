package com.easy.view.lifecycle

import android.content.Intent
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.easy.view.EmptyActivity
import com.easy.view.base.BaseEasyListActivity
import com.easy.view.lifecycle.simple.LifecycleSimpleActivity

/**
 * Created by shishoufeng on 2020/12/26.
 * email:shoufengshi@lagou.com
 *
 * desc: lifecycle 组件测试类
 *
 *
 */
class MainLifecycleActivity : BaseEasyListActivity() {


    override fun getContentList(): MutableList<String> {
        return arrayListOf("与ViewModel、LiveData搭配简单示例")
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        startActivity(
            Intent(
                this, when (position) {
                    0 -> LifecycleSimpleActivity::class.java
                    else -> {
                        EmptyActivity::class.java
                    }
                }
            )
        )
    }
}