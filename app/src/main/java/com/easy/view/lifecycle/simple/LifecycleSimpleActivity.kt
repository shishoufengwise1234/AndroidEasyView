package com.easy.view.lifecycle.simple

import androidx.activity.viewModels
import com.easy.view.base.BaseEasyActivity
import com.easy.view.databinding.ActivitySimpleLifecycleBinding
import com.easy.view.lifecycle.simple.vm.LifecycleSimpleViewModel

/**
 * Created by shishoufeng on 2020/12/26.
 * email:shoufengshi@lagou.com
 *
 * desc: 简单示例
 *
 *
 */
class LifecycleSimpleActivity : BaseEasyActivity<ActivitySimpleLifecycleBinding>() {

    override val binding: ActivitySimpleLifecycleBinding
        get() = ActivitySimpleLifecycleBinding.inflate(layoutInflater)

    private val viewModel by viewModels<LifecycleSimpleViewModel>()


    override fun initView() {
        viewModel.RepositoriesNameListLiveData.observe(this) {
            binding.listContentView.setData(it)
        }
        binding.btnSendReqGithub.setOnClickListener {
            viewModel.requestMyGitHubRepositories()
        }

    }
}