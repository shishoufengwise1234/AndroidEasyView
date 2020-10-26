package com.easy.view.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseBinderAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.easy.view.R
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.layout_recycler_list.view.*

/**
 * Created by shishoufeng on 2020/10/26.
 * email:shoufengshi@lagou.com
 *
 * desc: list 列表view 快速实现列表展示
 *
 */
class ListContentView @JvmOverloads constructor(
    private val mContext: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : FrameLayout(mContext, attributeSet, defStyleAttribute), OnItemClickListener {



    init {
        LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_list, this, true)

        recycler_list.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        val mAdapter = ListContentAdapter()
        recycler_list.adapter = mAdapter

        mAdapter.setOnItemClickListener(this)

    }

    fun setData(contentList: List<String>) {

    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {

    }

    private inner class ListContentAdapter(layoutRes: Int = R.layout.item_text_view) :
        BaseQuickAdapter<String, ContentViewHolder>(layoutRes) {
        override fun convert(holder: ContentViewHolder, item: String) {
            holder.textView?.text = item
        }
    }

    private inner class ContentViewHolder(itemView: View) : BaseViewHolder(itemView) {
        var textView: MaterialTextView? = R.id.tv_text_view_item.findView()
    }


}