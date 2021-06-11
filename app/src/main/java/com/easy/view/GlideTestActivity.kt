package com.easy.view

import com.bumptech.glide.Glide
import com.easy.view.base.BaseEasyActivity
import com.easy.view.databinding.ActivityGlideTestBinding

/**
 * Created by shishoufeng on 2020/12/24.
 * email:shoufengshi@lagou.com
 *
 * desc:
 *
 *
 */
class GlideTestActivity : BaseEasyActivity<ActivityGlideTestBinding>() {

    override val binding: ActivityGlideTestBinding
        get() = ActivityGlideTestBinding.inflate(layoutInflater)

    override fun initView() {

        Glide.with(this)
            .load("https://www.lgstatic.com/i/image2/M01/03/EC/Cip5yF_khlyAUmcZAAczpVRxfcQ893.gif")
            .into(binding.ivGlideTest)
    }
}