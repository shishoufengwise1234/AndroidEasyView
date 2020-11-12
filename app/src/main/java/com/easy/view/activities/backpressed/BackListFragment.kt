package com.easy.view.activities.backpressed

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import com.chad.library.adapter.base.BaseQuickAdapter
import com.easy.view.base.BaseEasyListFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.orhanobut.logger.Logger

/**
 * Created by shishoufeng on 2020/11/6.
 * email:shoufengshi@lagou.com
 *
 * desc: 返回列表测试页面
 *
 *
 */
class BackListFragment : BaseEasyListFragment() {


    override fun getContentList(): MutableList<String> {
        val list = arrayListOf<String>()
        for (i in 1..20) {
            list.add("this index  $i")
        }
        return list
    }

    override fun initView() {
        super.initView()

        requireActivity().onBackPressedDispatcher
            .addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Logger.i("back 1")
                    back()
                }
            })
        requireActivity().onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Logger.i("back 2")

                back2()
            }
        })

    }

    private fun back2() {
        activity?.let {
            AlertDialog.Builder(it).setTitle("EasyTitle 2")
                .setMessage("你确定退出吗?")
                .setNegativeButton(
                    "取消"
                ) { dialog, _ ->
                    dialog?.dismiss()
                }
                .setPositiveButton(
                    "确定"
                ) { dialog, _ ->
                    dialog?.dismiss()
                    requireActivity().finish()
                }
                .create()
                .show()
        }

    }

    private fun back() {
        activity?.let {
            AlertDialog.Builder(it).setTitle("EasyTitle 1")
                .setMessage("你确定退出吗?")
                .setNegativeButton(
                    "取消"
                ) { dialog, _ ->
                    dialog?.dismiss()
                }
                .setPositiveButton(
                    "确定"
                ) { dialog, _ ->
                    dialog?.dismiss()
                    requireActivity().finish()
                }
                .create()
                .show()
        }
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {

    }
}