package com.easy.view.hilt

import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import com.easy.view.bean.HiltText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hilt_main.*
import javax.inject.Inject

/**
 * Created by shishoufeng on 2020/11/17.
 * email:shoufengshi@lagou.com
 *
 * desc: hilt注入框架demo
 */
@AndroidEntryPoint
class HiltMainActivity: BaseEasyActivity() {

    @Inject lateinit var hiltText: HiltText

    override fun getLayoutId(): Int {
        return R.layout.activity_hilt_main
    }

    override fun initView() {
        tvHiltContent.text = "id = ${hiltText.id} , text = ${hiltText.text}"
    }
}