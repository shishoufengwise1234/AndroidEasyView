package com.easy.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 *
 * desc: 基础view 页面封装
 *
 *
 */
abstract class BaseEasyActivity<Bind : ViewBinding> : AppCompatActivity(), View.OnClickListener {

    protected val LOG_TAG: String = this.javaClass.simpleName

    protected open val binding: Bind? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null){
            val layoutId = getLayoutId()
            if (layoutId != 0) {
                setContentView(layoutId)
            }
        }else{
            setContentView(binding?.root)
        }

        initView()
    }

    open fun getLayoutId(): Int = 0

    abstract fun initView()


    override fun onClick(v: View?) {
        onViewsClick(v?.id)
    }

    open fun onViewsClick(id: Int?) {

    }

    override fun onDestroy() {
        super.onDestroy()

    }


}