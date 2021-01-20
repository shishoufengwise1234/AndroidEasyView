package com.easy.view.canvas.geometry.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.easy.view.R
import kotlin.math.min

/**
 * Created by shishoufeng on 2021/1/11.
 * email:shoufengshi@lagou.com
 *
 * desc: 自定义圆
 *
 */
class CircleView @JvmOverloads constructor(
    private val mContext: Context,
    attributeSet: AttributeSet? = null,
    defAttarStyleId: Int = 0
) : View(mContext, attributeSet, defAttarStyleId) {

    @ColorInt
    var bgColor: Int = Color.WHITE
        set(value) {
            field = value

            paint.color = bgColor
            invalidate()
        }

    private val paint = Paint()

    init {
        paint.style = Paint.Style.FILL
        paint.flags = Paint.ANTI_ALIAS_FLAG

        val array = mContext.obtainStyledAttributes(R.styleable.CircleView)
        bgColor = array.getColor(R.styleable.CircleView_bgColor, Color.WHITE)

        array.recycle()

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = bgColor
        canvas?.let {
            val w = width
            val h = height

            val pl = paddingLeft
            val pr = paddingRight
            val pt = paddingTop
            val pb = paddingBottom

            val usableWidth = w - (pl + pr)
            val usableHeight = h - (pt + pb)

            val radius = min(usableWidth, usableHeight) / 2.0f
            val cx = pl + usableWidth / 2.0f
            val cy = pt + usableHeight / 2.0f

            it.drawCircle(cx, cy, radius, paint)
        }
    }
}