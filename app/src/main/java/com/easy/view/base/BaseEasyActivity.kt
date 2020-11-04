package com.easy.view.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 *
 * desc: 基础view 页面封装
 *
 *
 */
abstract class BaseEasyActivity : AppCompatActivity(),View.OnClickListener {

    protected val LOG_TAG: String = this.javaClass.simpleName

    private  var unBinder : Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        unBinder = ButterKnife.bind(this)

        initView()
    }


    abstract fun getLayoutId(): Int

    abstract fun initView()


    override fun onClick(v: View?) {
        onViewsClick(v?.id)
    }

    open fun onViewsClick(id: Int?){
        
    }

    override fun onDestroy() {
        super.onDestroy()
        unBinder?.unbind()


    }


}