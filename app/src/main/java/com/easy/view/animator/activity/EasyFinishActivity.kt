package com.easy.view.animator.activity

import com.easy.view.base.BaseEasyActivity
import com.easy.view.databinding.ActivityEasyFinishBinding

/**
 * Created by shishoufeng on 2020/10/27.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单的 关闭页面
 *
 */
class EasyFinishActivity : BaseEasyActivity<ActivityEasyFinishBinding>() {


    override val binding: ActivityEasyFinishBinding
        get() = ActivityEasyFinishBinding.inflate(layoutInflater)

    override fun initView() {
        binding.btnFinish.setOnClickListener { finish() }
    }


}