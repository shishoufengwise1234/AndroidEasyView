package com.easy.view.http

import com.easy.view.api.GitHubApiService
import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.time.Duration

/**
 * Created by shishoufeng on 2020/12/26.
 * email:shoufengshi@lagou.com
 *
 * desc: http 请求帮助类
 *
 *
 */

class HttpHelps private constructor() {

    companion object {
        private const val TAG = "HttpHelps"

        fun get() = HttpHolder.httpHelps
    }


    lateinit var retrofit: Retrofit

    private var gson = GsonBuilder()
        .serializeNulls()
        .serializeSpecialFloatingPointValues()
        .create()

    private var client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(Duration.ofSeconds(30L))
        .readTimeout(Duration.ofSeconds(30L))
        .writeTimeout(Duration.ofSeconds(30L))
        .eventListener(object : EventListener() {

            override fun callEnd(call: Call) {
                super.callEnd(call)
                Logger.i("callEnd: ")
            }

            override fun callFailed(call: Call, ioe: IOException) {
                super.callFailed(call, ioe)
                Logger.i("callFailed: ")
            }

            override fun callStart(call: Call) {
                super.callStart(call)
                Logger.i("callStart: ")
            }

            override fun canceled(call: Call) {
                super.canceled(call)
                Logger.i("canceled: ")
            }

            override fun connectEnd(
                call: Call,
                inetSocketAddress: InetSocketAddress,
                proxy: Proxy,
                protocol: Protocol?
            ) {
                super.connectEnd(call, inetSocketAddress, proxy, protocol)
                Logger.i("connectEnd: ")
            }

            override fun connectFailed(
                call: Call,
                inetSocketAddress: InetSocketAddress,
                proxy: Proxy,
                protocol: Protocol?,
                ioe: IOException
            ) {
                super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe)
                Logger.i("connectFailed: ")
            }

            override fun connectStart(
                call: Call,
                inetSocketAddress: InetSocketAddress,
                proxy: Proxy
            ) {
                super.connectStart(call, inetSocketAddress, proxy)
                Logger.i("connectStart: ")
            }

            override fun connectionAcquired(call: Call, connection: Connection) {
                super.connectionAcquired(call, connection)
                Logger.i("connectionAcquired: ")
            }
        })
        .build()


    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.github.com/")
            .client(client)
            .build()
    }


    private object HttpHolder {
        val httpHelps = HttpHelps()
    }

    private val gitHubApiService = retrofit.create(GitHubApiService::class.java)

    fun gitHubApiService(): GitHubApiService = gitHubApiService


}

//class HeaderInterceptor:Interceptor{
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        request.header()
//    }
//
//}