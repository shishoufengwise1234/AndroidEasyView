package com.easy.view.animator

import android.content.Intent
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.easy.view.EmptyActivity
import com.easy.view.animator.activity.AnimatorTestActivity
import com.easy.view.base.BaseEasyListActivity

/**
 * Created by shishoufeng on 2020/10/26.
 * email:shoufengshi@lagou.com
 *
 * desc: 动画主界面
 *
 */
class AnimationMainActivity : BaseEasyListActivity() {

    override fun getContentList(): MutableList<String> {
        return arrayListOf("Activity 转场动画")
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val intent = Intent()
        val clazz = when (position) {
            0 -> AnimatorTestActivity::class.java

            else -> EmptyActivity::class.java
        }
        startActivity(intent.setClass(this@AnimationMainActivity,clazz))
    }
}