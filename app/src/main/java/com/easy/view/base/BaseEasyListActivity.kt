package com.easy.view.base

import com.chad.library.adapter.base.listener.OnItemClickListener
import com.easy.view.databinding.LayoutListContentViewBinding

/**
 * Created by shishoufeng on 2020/10/26.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单列表页面
 *
 */
abstract class BaseEasyListActivity : BaseEasyActivity<LayoutListContentViewBinding>(), OnItemClickListener {

    override val binding: LayoutListContentViewBinding
        get() = LayoutListContentViewBinding.inflate(layoutInflater)

    override fun initView() {
        binding.listContentView.setData(getContentList())
        binding.listContentView.setOnItemClickListener(this@BaseEasyListActivity)
    }


    abstract fun getContentList(): MutableList<String>


}