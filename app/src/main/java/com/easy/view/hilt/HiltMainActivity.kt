package com.easy.view.hilt

import com.easy.view.base.BaseEasyActivity
import com.easy.view.bean.HiltText
import com.easy.view.databinding.ActivityHiltMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by shishoufeng on 2020/11/17.
 * email:shoufengshi@lagou.com
 *
 * desc: hilt注入框架demo
 */
@AndroidEntryPoint
class HiltMainActivity: BaseEasyActivity<ActivityHiltMainBinding>() {

    @Inject lateinit var hiltText: HiltText

    override val binding: ActivityHiltMainBinding
        get() = ActivityHiltMainBinding.inflate(layoutInflater)

    override fun initView() {
        binding.tvHiltContent.text = "id = ${hiltText.id} , text = ${hiltText.text}"
    }
}