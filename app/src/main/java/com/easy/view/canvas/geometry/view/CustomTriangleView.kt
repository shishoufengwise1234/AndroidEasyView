package com.easy.view.canvas.geometry.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt

/**
 * Created by shishoufeng on 2020/9/6.
 * email:shoufengshi@lagou.com
 *
 *
 * desc: 自定义 三角形view
 */
class CustomTriangleView @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    mContext, attrs, defStyleAttr
) {
    private val paint: Paint

    @ColorInt
    var paintColor = Color.BLACK
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = paintColor
    }

    init {
        paint = Paint()
    }
}