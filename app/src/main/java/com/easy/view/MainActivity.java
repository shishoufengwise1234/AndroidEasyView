package com.easy.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.easy.view.bean.StringItemBean;
import com.easy.view.canvas.CanvasGeometryActivity;
import com.google.android.material.textview.MaterialTextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @BindView(R.id.recycler_list)
    RecyclerView recyclerList;

    private MainListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listAdapter = new MainListAdapter(R.layout.item_text_view);
        listAdapter.setAdapterAnimation(new SlideInBottomAnimation());
        listAdapter.setAnimationEnable(true);

        recyclerList.setLayoutManager(new LinearLayoutManager(this));
        recyclerList.setAdapter(listAdapter);
        recyclerList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        listAdapter.setList(getMainItemList());

        listAdapter.setOnItemClickListener(this);


    }

    private Collection<StringItemBean> getMainItemList() {
        List<StringItemBean> list = new ArrayList<>();

        list.add(new StringItemBean(1, "Canvas绘制基本几何图形"));


        return list;
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, CanvasGeometryActivity.class);
                break;
            default:
                intent.setClass(this, EmptyActivity.class);
                break;
        }

        startActivity(intent);
    }

    static class MainListAdapter extends BaseQuickAdapter<StringItemBean, MainItemViewHolder> {


        public MainListAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(@NotNull MainItemViewHolder mainItemViewHolder, StringItemBean stringItemBean) {
            mainItemViewHolder.textView.setText(stringItemBean.getText());
        }
    }

    static class MainItemViewHolder extends BaseViewHolder {

        MaterialTextView textView;

        public MainItemViewHolder(@NotNull View view) {
            super(view);

            textView = findView(R.id.tv_text_view_item);
        }


    }


}
