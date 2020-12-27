package com.easy.view.lifecycle.simple

import androidx.activity.viewModels
import com.easy.view.R
import com.easy.view.base.BaseEasyActivity
import com.easy.view.lifecycle.simple.vm.LifecycleSimpleViewModel
import kotlinx.android.synthetic.main.activity_simple_lifecycle.*

/**
 * Created by shishoufeng on 2020/12/26.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单示例
 *
 *
 */
class LifecycleSimpleActivity : BaseEasyActivity() {

    private val viewModel by viewModels<LifecycleSimpleViewModel>()


    override fun getLayoutId(): Int {
        return R.layout.activity_simple_lifecycle
    }

    override fun initView() {
        viewModel.RepositoriesNameListLiveData.observe(this) {
            listContentView?.setData(it)
        }
        btnSendReqGithub?.setOnClickListener {
            viewModel.requestMyGitHubRepositories()
        }

    }
}