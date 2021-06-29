package com.easy.view.utils

import android.view.View
import com.easy.view.R


/**
 * Created by shishufeng on 2021/6/22
 * desc: 检查快速点击
 */
object CheckFastClick {

    /**
     * 判断是否属于快速点击
     *
     * @param view     点击的View
     * @param interval 快速点击的阈值
     * @return true：快速点击
     */
    @JvmStatic
    fun isFastClick(view: View, interval: Long): Boolean {
        val key: Int = R.id.view_click_time

        // 最近的点击时间
        val currentClickTime = System.currentTimeMillis()
        if (null == view.getTag(key)) {
            // 1. 第一次点击

            // 保存最近点击时间
            view.setTag(key, currentClickTime)
            return false
        }
        // 2. 非第一次点击

        // 上次点击时间
        return if (currentClickTime - (view.getTag(key) as? Long ?: 0L) < interval) {
            // 未超过时间间隔，视为快速点击
            true
        } else {
            // 保存最近点击时间
            view.setTag(key, currentClickTime)
            false
        }
    }

}