package com.easy.view.scope

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easy.view.utils.logCurrentThread
import com.orhanobut.logger.Logger
import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * Created by shishoufeng on 2020/9/23.
 * email:shoufengshi@lagou.com
 *
 * desc:
 *
 *
 */
class ScopeMainViewModel(application: Application) : AndroidViewModel(application) {

    val requestLiveData = MutableLiveData<Pair<String, String>>()

    fun requestData(args: String) {
        //使用 viewModel 开启协程
        //页面销毁后会自动销毁协程
        viewModelScope.launch {
            logCurrentThread()
            //阻塞 模拟网络请求
            delay(3000)

            Logger.i("请求数据结束 ....")

            val pair = Pair("key", "value")
            requestLiveData.postValue(pair)

            coroutineScope {
                val job1 = async {
                    //网络请求 1
                }
                val job2 = async {
                    //网络请求 2
                }
                Logger.i("网络请求1 数据: {${job1.await()}} + 网络请求2 数据：{${job2.await()}}")
            }
        }


//        thread(start = true,isDaemon = true,contextClassLoader = this.javaClass.classLoader
//            ,name = "defThread",priority = Thread.NORM_PRIORITY) {
//            logCurrentThread()
//            Logger.i("thread ")
    }


    override fun onCleared() {
        super.onCleared()
        Logger.i("onCleared()")
    }


}