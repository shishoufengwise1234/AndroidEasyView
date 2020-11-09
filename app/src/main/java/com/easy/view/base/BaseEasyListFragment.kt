package com.easy.view.base

import com.chad.library.adapter.base.listener.OnItemClickListener
import com.easy.view.R
import kotlinx.android.synthetic.main.layout_list_content_view.*

/**
 * Created by shishoufeng on 2020/11/6.
 * email:shoufengshi@lagou.com
 *
 * desc: 抽象列表fragment封装层
 *
 */
abstract class BaseEasyListFragment : BaseFragment(), OnItemClickListener {

    override fun getLayoutId(): Int {
        return R.layout.layout_list_content_view
    }

    override fun initView() {
        listContentView?.setData(getContentList())
        listContentView?.setOnItemClickListener(this@BaseEasyListFragment)
    }

    abstract fun getContentList(): MutableList<String>

}