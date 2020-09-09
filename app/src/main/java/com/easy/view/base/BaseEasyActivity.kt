package com.easy.view.base

import android.os.Bundle
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
abstract class BaseEasyActivity : AppCompatActivity() {

    private  var unBinder : Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        unBinder = ButterKnife.bind(this)

        initView()
    }


    abstract fun getLayoutId(): Int

    abstract fun initView()


    override fun onDestroy() {
        super.onDestroy()
        unBinder?.unbind()


    }
}