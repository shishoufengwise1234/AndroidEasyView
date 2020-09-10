package com.easy.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.animation.SlideInBottomAnimation
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.easy.view.bean.StringItemBean
import com.easy.view.canvas.CanvasGeometryActivity
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var listAdapter: MainListAdapter
    private lateinit var mDataList: List<StringItemBean>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        listAdapter = MainListAdapter(R.layout.item_text_view)
        listAdapter.adapterAnimation = SlideInBottomAnimation()
        listAdapter.animationEnable = true

        mDataList = mainItemList
        listAdapter.setList(mDataList)
        listAdapter.setOnItemClickListener(this)

        recycler_list.let {
            recycler_list.layoutManager = LinearLayoutManager(this)
            recycler_list.adapter = listAdapter
            recycler_list.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        }

    }

    private val mainItemList: List<StringItemBean>
        get() {
            val list: MutableList<StringItemBean> = ArrayList()
            list.add(StringItemBean(1, "Canvas绘制基本几何图形"))
            list.add(StringItemBean(2, "Drawable 资源设置相关"))
            list.add(StringItemBean(3, "Animation 集合"))
            list.add(StringItemBean(4, "TextView 集合"))

            list.add(StringItemBean(5, "ConstraintLayout 组件"))
            list.add(StringItemBean(7, "Recyclerview 组件"))
            list.add(StringItemBean(9, "Paging 组件"))
            list.add(StringItemBean(11, "ViewPager2 组件"))
            list.add(StringItemBean(14, "CardView 组件"))
            list.add(StringItemBean(16, "CollapsingToolbarLayout 组件"))
            list.add(StringItemBean(16, "CoordinatorLayout 组件"))

            list.add(StringItemBean(30, "Fragment 集合"))
            list.add(StringItemBean(34, "DataBinding 组件"))
            list.add(StringItemBean(39, "ViewModel 组件"))
            list.add(StringItemBean(80, "JetPack Compose组件 (环境目前不支持)"))
            return list
        }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        if (position > mDataList.size) {
            return
        }
        val id = mDataList[position].id
        val intent = Intent()
        val clazz:Class<*>
        clazz = when (id) {
            1 -> CanvasGeometryActivity::class.java

            else -> EmptyActivity::class.java
        }
        intent.setClass(this,clazz)
        startActivity(intent)
    }

    internal class MainListAdapter(layoutResId: Int) :
        BaseQuickAdapter<StringItemBean, MainItemViewHolder>(layoutResId) {
        override fun convert(
            holder: MainItemViewHolder,
            item: StringItemBean
        ) {
            holder.textView!!.text = item.text
        }
    }

    internal class MainItemViewHolder(view: View) : BaseViewHolder(view) {
        var textView: MaterialTextView? = R.id.tv_text_view_item.findView()
    }
}