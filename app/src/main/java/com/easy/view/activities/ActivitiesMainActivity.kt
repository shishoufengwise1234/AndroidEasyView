package com.easy.view.activities

import android.content.Intent
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.easy.view.EmptyActivity
import com.easy.view.activities.backpressed.BackMainActivity
import com.easy.view.base.BaseEasyListActivity

/**
 * Created by shishoufeng on 2020/11/5.
 * email:shoufengshi@lagou.com
 *
 * desc: 活动相关主界面
 *
 */
class ActivitiesMainActivity : BaseEasyListActivity() {

    override fun getContentList(): MutableList<String> {
        return arrayListOf("JetPack activity OnBackPressedCallback 测试示例")
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        startActivity(
            Intent(
                this@ActivitiesMainActivity,
                when (position) {
                    0 -> BackMainActivity::class.java
                    else -> EmptyActivity::class.java
                }
            )
        )
    }
}