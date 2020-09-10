package com.easy.view.canvas

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import com.easy.view.base.BaseFragmentStateAdapter
import com.easy.view.canvas.geometry.CustomTriangleFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_canvas_geometry_simple.*
import java.util.*

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 *
 *
 * desc:  canvas 绘制基本几何图形
 */
class CanvasGeometryActivity : BaseEasyActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun getLayoutId(): Int {
        return R.layout.activity_canvas_geometry_simple
    }

    override fun initView() {

        tabLayout = tab_layout
        viewPager = view_pager

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