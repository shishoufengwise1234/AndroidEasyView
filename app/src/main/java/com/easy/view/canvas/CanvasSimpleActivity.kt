package com.easy.view.canvas

import android.graphics.Color
import com.easy.view.base.BaseEasyActivity
import com.easy.view.databinding.ActivityCanvasSimpleBinding
import java.util.*

/**
 * Created by shishoufeng on 2021/1/11.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单示例画布view
 *
 */
class CanvasSimpleActivity : BaseEasyActivity<ActivityCanvasSimpleBinding>() {


    override val binding: ActivityCanvasSimpleBinding
        get() = ActivityCanvasSimpleBinding.inflate(layoutInflater)

    override fun initView() {

        val colors = arrayOf(
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.DKGRAY,
            Color.RED,
            Color.YELLOW,
            Color.MAGENTA
        )
        val random = Random()

        binding.btnSwitchBgColor.setOnClickListener {
            val colorId = random.nextInt(colors.size)

            binding.circleExSimple.bgColor = colors[colorId]
        }

    }
}