package com.easy.view.animator.activity

import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import kotlinx.android.synthetic.main.activity_easy_finish.*

/**
 * Created by shishoufeng on 2020/10/27.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单的 关闭页面
 *
 */
class EasyFinishActivity : BaseEasyActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_easy_finish
    }

    override fun initView() {
        btnFinish?.setOnClickListener { finish() }
    }


}