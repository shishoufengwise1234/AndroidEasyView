package com.easy.view;

import android.view.MotionEvent;

import com.easy.view.base.BaseEasyActivity;

/**
 * Created by shishoufeng on 2020/9/5.
 * email:shoufengshi@lagou.com
 * <p>
 * desc:  空页面展示
 */
public class EmptyActivity extends BaseEasyActivity {


    @Override
    public int getLayoutId() {
        return R.layout.layout_common_empty;
    }

    @Override
    public void initView() {


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL){
            finish();
        }
        return super.onTouchEvent(event);
    }
}
