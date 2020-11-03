package com.easy.view.animator.activity

import android.content.Intent
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.easy.view.R
import com.easy.view.base.BaseEasyListActivity

/**
 * Created by shishoufeng on 2020/10/27.
 * email:shoufengshi@lagou.com
 *
 * desc: activity 转场动画测试
 *
 */
class AnimatorTestActivity : BaseEasyListActivity() {


    override fun getContentList(): MutableList<String> {
        return arrayListOf("Slide Top", "Slide Bottom", "Slide Left", "Slide Right")
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val intent = Intent()
        intent.setClass(this@AnimatorTestActivity, EasyFinishActivity::class.java)
        startActivity(intent)

        val animArray = when (position) {
            0 -> arrayOf(
                R.anim.anim_activity_slide_top_enter,
                R.anim.anim_activity_slide_top_exit
            )
            1 -> arrayOf(
                R.anim.anim_activity_slide_bottom_enter,
                R.anim.anim_activity_slide_bottom_exit
            )

            else -> arrayOf(
                R.anim.anim_activity_slide_left_enter,
                R.anim.anim_activity_slide_left_exit
            )
        }
        overridePendingTransition(animArray[0], animArray[1])
    }

}