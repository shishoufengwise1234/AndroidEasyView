package com.easy.view.utils

import com.orhanobut.logger.Logger

/**
 * Created by shishoufeng on 2020/9/23.
 * email:shoufengshi@lagou.com
 *
 * desc:
 *
 *
 */
const val EASY_VIEW_TAG = "EasyView"

fun logCurrentThread(TAG: String = EASY_VIEW_TAG) {
    Logger.t(TAG)
        .i("thread name ${Thread.currentThread().name}")
}