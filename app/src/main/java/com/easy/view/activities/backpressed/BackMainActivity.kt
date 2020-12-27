package com.easy.view.activities.backpressed

import android.app.Application
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.easy.view.EasyApplication
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import com.orhanobut.logger.Logger

/**
 * Created by shishoufeng on 2020/11/5.
 * email:shoufengshi@lagou.com
 *
 * desc: 返回主界面demo
 */
class BackMainActivity : BaseEasyActivity() {

    class BackViewModel(application: Application) : AndroidViewModel(application) {

        //...

    }

    val s by lazy(LazyThreadSafetyMode.NONE) {
        println("ss")
        "abc"
    }

    val backViewModel : BackViewModel by viewModels()
    //或
    val viewModel by viewModels<BackViewModel>()


    override fun getLayoutId(): Int {
        return R.layout.activity_jetpack_back_main
    }

    override fun initView() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.backContent, BackListFragment())
            .commitNowAllowingStateLoss()


        val viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                BackViewModel::class.java
            )




    }

    override fun onBackPressed() {
        super.onBackPressed()
        Logger.d("onBackPressed")
    }
}