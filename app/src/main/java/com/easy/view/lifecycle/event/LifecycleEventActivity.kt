package com.easy.view.lifecycle.event

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import kotlinx.android.synthetic.main.activity_lifecycle_event.*

/**
 * Created by shishoufeng on 2021/1/6.
 * email:shoufengshi@lagou.com
 *
 * desc: 测试lifecycle 生命周期demo
 *
 *
 */
class LifecycleEventActivity : BaseEasyActivity() {

    private val sb = StringBuilder()
    private val simpleEvent = SimpleEvent()


    override fun getLayoutId(): Int {
        return R.layout.activity_lifecycle_event
    }

    override fun initView() {

    }

    override fun onResume() {
        super.onResume()

        sb.append("onResume() 中注册: ").append("\n\n")
        lifecycle.addObserver(simpleEvent)

    }

    override fun onDestroy() {
        super.onDestroy()

//        sb.append("onDestroy() 中注册 ").append("\n\n")
//        lifecycle.addObserver(simpleEvent)

        val s = "4"
        s.toIntOrNull()
        s.toInt()
    }

    //测试在不同生命周期注册lifecycle 观察者 并将回调结果显示在界面上
    inner class SimpleEvent: LifecycleEventObserver{

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//            Logger.i("event : ${event.name}")
            sb.append(event.name).append("\n")

            tvEventContent?.text = sb
        }

    }


}