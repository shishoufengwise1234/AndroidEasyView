package com.easy.view.canvas

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.easy.view.base.BaseEasyActivity
import com.easy.view.base.BaseFragmentStateAdapter
import com.easy.view.canvas.geometry.CustomTriangleFragment
import com.easy.view.databinding.ActivityCanvasGeometrySimpleBinding
import com.google.android.material.tabs.TabLayout
import java.util.*

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 *
 *
 * desc:  canvas 绘制基本几何图形
 */
class CanvasGeometryActivity : BaseEasyActivity<ActivityCanvasGeometrySimpleBinding>() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override val binding: ActivityCanvasGeometrySimpleBinding
        get() = ActivityCanvasGeometrySimpleBinding.inflate(layoutInflater)

    override fun initView() {

        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        tabLayout.setupWithViewPager(viewPager, true)

        val fragmentStateAdapter = BaseFragmentStateAdapter(supportFragmentManager)
        viewPager.adapter = fragmentStateAdapter
        fragmentStateAdapter.fragments = fragmentList
    }

    private val fragmentList: List<Fragment>
        get() {
            val fragments: MutableList<Fragment> = ArrayList()
            fragments.add(CustomTriangleFragment())
            return fragments
        }
}