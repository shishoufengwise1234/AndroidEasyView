package com.easy.view

import com.bumptech.glide.Glide
import com.easy.view.base.BaseEasyActivity
import kotlinx.android.synthetic.main.activity_glide_test.*

/**
 * Created by shishoufeng on 2020/12/24.
 * email:shoufengshi@lagou.com
 *
 * desc:
 *
 *
 */
class GlideTestActivity:BaseEasyActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_glide_test
    }

    override fun initView() {

        Glide.with(this)
            .load("https://www.lgstatic.com/i/image2/M01/03/EC/Cip5yF_khlyAUmcZAAczpVRxfcQ893.gif")
            .into(iv_glide_test)
    }
}