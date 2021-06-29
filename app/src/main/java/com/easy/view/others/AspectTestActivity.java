package com.easy.view.others;

import android.util.Log;
import android.view.View;

import com.easy.view.base.BaseEasyActivity;
import com.easy.view.databinding.ActivityAspectTestBinding;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Created by shishufeng on 2021/6/22
 * desc: aspect 代码织入测试
 */
public class AspectTestActivity extends BaseEasyActivity<ActivityAspectTestBinding> {

    private static final String TAG = "AspectTestActivity";

    @Nullable
    @Override
    protected ActivityAspectTestBinding getBinding() {
        return ActivityAspectTestBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initView() {
        Objects.requireNonNull(getBinding()).btnFastClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: fast click");
            }
        });
    }
}
