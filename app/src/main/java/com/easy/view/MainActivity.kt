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
            list.add(StringItemBean(2, "JetPack Compose组件"))
            return list
        }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        if (position > mDataList.size) {
            return
        }
        val id = mDataList[position].id
        val intent = Intent()
        when (id) {
            1 -> intent.setClass(this, CanvasGeometryActivity::class.java)
            2 -> intent.setClass(this, CanvasGeometryActivity::class.java)
            else -> intent.setClass(this, EmptyActivity::class.java)
        }
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