package com.easy.view.api

import com.easy.view.bean.RepositoriesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by shishoufeng on 2020/12/26.
 * email:shoufengshi@lagou.com
 *
 * desc: apiService
 *
 *
 */
interface GitHubApiService {


    @GET("/users/{username}/repos")
    suspend fun getMyGitHubRepositories(@Path("username") userName: String = "shishoufengwise1234"): Response<MutableList<RepositoriesItem?>>


}