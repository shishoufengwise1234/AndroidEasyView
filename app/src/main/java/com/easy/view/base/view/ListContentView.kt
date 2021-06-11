package com.easy.view.base.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.easy.view.R
import com.easy.view.databinding.LayoutRecyclerListBinding
import com.google.android.material.textview.MaterialTextView

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
) : FrameLayout(mContext, attributeSet, defStyleAttribute) {

    private var mAdapter: ListContentAdapter
    private var binding = LayoutRecyclerListBinding.inflate(LayoutInflater.from(mContext),this,true)

    init {
        var typedArray: TypedArray? = null
        try {
            typedArray = mContext.obtainStyledAttributes(R.styleable.ListContentView)

            binding.recyclerList.layoutManager =
                when (typedArray.getInt(R.styleable.ListContentView_listManager, 1)) {
                    2 -> GridLayoutManager(
                        mContext,
                        typedArray.getInt(R.styleable.ListContentView_gridManagerCount, 2)
                    )
                    else -> LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
                }
        } finally {
            typedArray?.recycle()
        }

        mAdapter = ListContentAdapter()
        binding.recyclerList.addItemDecoration(DividerItemDecoration(mContext, LinearLayout.VERTICAL))

        binding.recyclerList.adapter = mAdapter


    }

    fun setData(contentList: MutableList<String>) {
        mAdapter.setList(contentList)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        mAdapter.setOnItemClickListener(listener)
    }

    private inner class ListContentAdapter(layoutRes: Int = R.layout.item_text_view) :
        BaseQuickAdapter<String, ContentViewHolder>(layoutRes) {
        override fun convert(holder: ContentViewHolder, item: String) {
            holder.textView?.text = item
        }
    }

    private class ContentViewHolder(itemView: View) : BaseViewHolder(itemView) {
        var textView: MaterialTextView? = R.id.tv_text_view_item.findView()
    }


}