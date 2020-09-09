package com.easy.view.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.blankj.utilcode.util.CollectionUtils

/**
 * Created by shishoufeng on 2020/9/6.
 * email:shoufengshi@lagou.com
 *
 * desc: 通用fragment 适配器
 *
 *
 */
class BaseFragmentStateAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    lateinit var fragments: List<Fragment>

    override fun getCount(): Int {
        return CollectionUtils.size(fragments)
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }


}