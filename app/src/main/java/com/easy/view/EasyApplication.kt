package com.easy.view

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.easy.view.utils.EASY_VIEW_TAG
import com.orhanobut.logger.*
import java.lang.NullPointerException

/**
 * Created by shishoufeng on 2020/9/6.
 * email:shoufengshi@lagou.com
 *
 *
 * desc: application 初始化
 */
class EasyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // (Optional) Whether to show thread info or not. Default true
            .methodCount(2) // (Optional) How many method line to show. Default 2
            .methodOffset(7) // (Optional) Hides internal method calls up to offset. Default 5
            .logStrategy(LogcatLogStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
            .tag(EASY_VIEW_TAG) // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
        
        registerActivityLifecycleCallbacks(EasyLifecycleCallBack())
    }
}

class EasyLifecycleCallBack : Application.ActivityLifecycleCallbacks{
    
    
    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        Logger.i("onActivityCreated() activity = $activity")
    }

    override fun onActivityStarted(activity: Activity) {
        Logger.i("onActivityStarted() activity = $activity")

    }

    override fun onActivityResumed(activity: Activity) {
        Logger.i("onActivityResumed() activity = $activity")

//        throw NullPointerException("resume is null")
    }

    override fun onActivityPaused(activity: Activity) {
        Logger.i("onActivityPaused() activity = $activity")


    }

    override fun onActivityStopped(activity: Activity) {
        Logger.i("onActivityStopped() activity = $activity")


    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
        Logger.i("onActivitySaveInstanceState() activity = $activity")


    }

    override fun onActivityDestroyed(activity: Activity) {
        Logger.i("onActivityDestroyed() activity = $activity")


    }

}