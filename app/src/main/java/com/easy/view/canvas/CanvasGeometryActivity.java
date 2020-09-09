package com.easy.view.canvas;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.easy.view.R;
import com.easy.view.base.BaseEasyActivity;
import com.easy.view.base.BaseFragmentStateAdapter;
import com.easy.view.canvas.geometry.CustomTriangleFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 * <p>
 * desc:  canvas 绘制基本几何图形
 */
public class CanvasGeometryActivity extends BaseEasyActivity {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;




    @Override
    public int getLayoutId() {
        return R.layout.activity_canvas_geometry_simple;
    }

    @Override
    public void initView() {

        tabLayout.setupWithViewPager(viewPager, true);

        BaseFragmentStateAdapter fragmentStateAdapter = new BaseFragmentStateAdapter(getSupportFragmentManager());

        viewPager.setAdapter(fragmentStateAdapter);

        fragmentStateAdapter.setFragments(getFragmentList());
    }

    private List<? extends Fragment> getFragmentList() {
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new CustomTriangleFragment());







        return fragments;
    }
}
