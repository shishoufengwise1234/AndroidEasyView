package com.easy.view.activities.backpressed

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



    override fun getLayoutId(): Int {
        return R.layout.activity_jetpack_back_main
    }

    override fun initView() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.backContent, BackListFragment())
            .commitNowAllowingStateLoss()






    }

    override fun onBackPressed() {
        super.onBackPressed()
        Logger.d("onBackPressed")
    }
}