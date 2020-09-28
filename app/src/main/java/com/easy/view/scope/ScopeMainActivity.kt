package com.easy.view.scope

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.ToastUtils
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import com.easy.view.utils.logCurrentThread
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main_scope.*
import kotlinx.coroutines.*

/**
 * Created by shishoufeng on 2020/9/23.
 * email:shoufengshi@lagou.com
 *
 * desc: 协程测试主界面
 */
class ScopeMainActivity : BaseEasyActivity() {

    private lateinit var viewModel: ScopeMainViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_main_scope
    }

    override fun initView() {
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(ScopeMainViewModel::class.java)

        viewModel.requestLiveData.observe(this,{
            logCurrentThread()
            Logger.i(it.toString())

            ToastUtils.showShort(it.toString())
        })


        btnScopeSwitchThread.setOnClickListener(this)
        btnScopeViewModelSimple.setOnClickListener(this)


    }


    override fun onViewsClick(id: Int?) {
        when (id) {
            R.id.btnScopeSwitchThread -> {
                switchThreadSimple()
            }
            R.id.btnScopeViewModelSimple ->{
                viewModel.requestData("122")
            }
        }
    }


    //使用协程可以将耗时代码放到后台执行，执行完成之后自动切换到主线程，没有多余的回调处理等好处
    private fun switchThreadSimple() {
        GlobalScope.launch(Dispatchers.Main, CoroutineStart.DEFAULT) {
            switchChildThread1()
            switchUiThread1()
            switchChildThread2()
            switchUiThread2()
            switchChildThread3()
            switchUiThread3()
        }
    }

    private fun switchUiThread3() {
        logCurrentThread()
        Toast.makeText(this@ScopeMainActivity, "显示切换成功", Toast.LENGTH_SHORT).show()
    }

    private suspend fun switchChildThread3() {
        withContext(Dispatchers.IO) {
            logCurrentThread()
        }
    }

    private fun switchUiThread2() {
        logCurrentThread()

    }

    private suspend fun switchChildThread2() {
        withContext(Dispatchers.IO) {
            logCurrentThread()
        }

    }

    //切换到UI线程执行
    private fun switchUiThread1() {
        logCurrentThread()
    }

    //切换到子线程执行
    private suspend fun switchChildThread1() {
        withContext(Dispatchers.IO) {
            logCurrentThread()
        }
    }


}