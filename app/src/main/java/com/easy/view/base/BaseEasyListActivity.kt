package com.easy.view.base

import com.chad.library.adapter.base.listener.OnItemClickListener
import com.easy.view.R
import kotlinx.android.synthetic.main.layout_list_content_view.*

/**
 * Created by shishoufeng on 2020/10/26.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单列表页面
 *
 */
abstract class BaseEasyListActivity : BaseEasyActivity(), OnItemClickListener {

    override fun getLayoutId(): Int {
        return R.layout.layout_list_content_view
    }

    override fun initView() {
        listContentView?.setData(getContentList())
        listContentView?.setOnItemClickListener(this@BaseEasyListActivity)
    }


    abstract fun getContentList(): MutableList<String>


}