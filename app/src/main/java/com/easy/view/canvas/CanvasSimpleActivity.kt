package com.easy.view.canvas

import android.graphics.Color
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import kotlinx.android.synthetic.main.activity_canvas_simple.*
import java.util.*

/**
 * Created by shishoufeng on 2021/1/11.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单示例画布view
 *
 */
class CanvasSimpleActivity:BaseEasyActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_canvas_simple
    }

    override fun initView() {

        val colors = arrayOf(Color.BLACK,Color.BLUE,Color.CYAN,Color.DKGRAY,Color.RED,Color.YELLOW,Color.MAGENTA)
        val random = Random()

        btnSwitchBgColor.setOnClickListener {
            val colorId = random.nextInt(colors.size)

            circleExSimple.bgColor = colors[colorId]
        }

    }
}