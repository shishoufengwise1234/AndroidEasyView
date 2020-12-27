package com.easy.view.lifecycle.simple.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easy.view.http.HttpHelps
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by shishoufeng on 2020/12/26.
 * email:shoufengshi@lagou.com
 *
 * desc: lifecycle 示例viewModel
 *
 */
class LifecycleSimpleViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        private const val TAG = "LifecycleSimpleViewMode"
    }

    var RepositoriesNameListLiveData = MutableLiveData<MutableList<String>>()


    fun requestMyGitHubRepositories() {
        viewModelScope.launch(Dispatchers.Main) {
            Log.i(TAG, "begin request requestMyGitHubRepositories ...")

            val resp = withContext(Dispatchers.IO) {
                try {
                    Log.i(TAG, "getMyRepositories: ")
                    HttpHelps.get().gitHubApiService().getMyGitHubRepositories()
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
            Log.i(TAG, "requestMyGitHubRepositories: after request ...")
            if (resp?.isSuccessful == true) {
                withContext(Dispatchers.IO) {
                    val itemList = resp.body()?.filterNotNull()?.toMutableList()
                    val nameList = mutableListOf<String>()
                    itemList?.forEach {
                        nameList.add(it.name)
                    }
                    RepositoriesNameListLiveData.postValue(nameList)
                }
            } else {
                RepositoriesNameListLiveData.postValue(null)
            }
        }
    }


}