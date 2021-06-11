package com.easy.view

import android.view.MotionEvent
import com.easy.view.base.BaseEasyActivity
import com.easy.view.databinding.LayoutCommonEmptyBinding

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 *
 *
 * desc:  空页面展示
 */
class EmptyActivity : BaseEasyActivity<LayoutCommonEmptyBinding>() {


    override fun initView() {}

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.actionMasked
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            finish()
        }
        return super.onTouchEvent(event)
    }
}