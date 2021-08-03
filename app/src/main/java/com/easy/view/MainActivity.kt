package com.easy.view

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.animation.SlideInBottomAnimation
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.easy.view.activities.ActivitiesMainActivity
import com.easy.view.animator.AnimationMainActivity
import com.easy.view.bean.StringItemBean
import com.easy.view.canvas.CanvasSimpleActivity
import com.easy.view.databinding.ActivityMainBinding
import com.easy.view.hilt.HiltMainActivity
import com.easy.view.lifecycle.MainLifecycleActivity
import com.easy.view.others.AspectTestActivity
import com.easy.view.scope.ScopeMainActivity
import com.easy.view.sp.SpAnrTestActivity
import com.google.android.material.textview.MaterialTextView
import java.util.*


class MainActivity : AppCompatActivity(), OnItemClickListener {

    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var listAdapter: MainListAdapter
    private lateinit var mDataList: List<StringItemBean>

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        listAdapter = MainListAdapter(R.layout.item_text_view)
        listAdapter.adapterAnimation = SlideInBottomAnimation()
        listAdapter.animationEnable = true

        mDataList = mainItemList
        listAdapter.setList(mDataList)
        listAdapter.setOnItemClickListener(this)

        binding.recyclerList.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = listAdapter
            it.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        }

        //注册监听前后台切换
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())


    }

    private fun getCountry() {
        println(Locale.getDefault().country)
        try {
            val tm = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
            println("simCountryIso = "+tm?.simCountryIso)
            println("networkOperatorName = "+tm?.networkOperatorName)
        } catch (e: java.lang.Exception) {
        }
        val locale: String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            resources.configuration.locales.get(0).country
        } else {
            "null"
        }
        println(locale)

        println("getUserCountry = "+getUserCountry())


    }

    fun getUserCountry(): String? {
        try {
            val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val simCountry = tm.simCountryIso
            if (simCountry != null && simCountry.length == 2) { // SIM country code is available
                return simCountry.toLowerCase(Locale.US)
            } else if (tm.phoneType != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                val networkCountry = tm.networkCountryIso
                if (networkCountry != null && networkCountry.length == 2) { // network country code is available
                    return networkCountry.toLowerCase(Locale.US)
                }
            }
        } catch (e: java.lang.Exception) {
        }
        return null
    }

    override fun getLastNonConfigurationInstance(): Any? {
        Log.d(TAG, "getLastNonConfigurationInstance: ")
        return super.getLastNonConfigurationInstance()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "getLastNonConfigurationInstance: ")

    }

    class ApplicationObserver : LifecycleObserver {

        private val TAG = "ApplicationObserver"

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onForeground() {
            Log.d(TAG, "onForeground: ")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResumed(){
            Log.d(TAG, "onResumed: 活跃中...")

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onBackground() {
            Log.d(TAG, "onBackground: ")
        }
    }

    override fun onResume() {
        try {
            super.onResume()
        }catch (e: Exception){
            e.printStackTrace()
        }
        getCountry()

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


            list.add(StringItemBean(29, "Activity 集合"))
            list.add(StringItemBean(30, "Fragment 集合"))
            list.add(StringItemBean(34, "DataBinding 组件"))
            list.add(StringItemBean(37, "Lifecycle 组件"))

            list.add(StringItemBean(39, "ViewModel 组件"))
            list.add(StringItemBean(42, "Kotlin 协程"))
            list.add(StringItemBean(79, "Hilt 注入"))
            list.add(StringItemBean(80, "JetPack Compose组件 (环境目前不支持)"))
            list.add(StringItemBean(90, "Glide加载图片测试 "))
            list.add(StringItemBean(91, "8.0以下SP ANR 问题测试"))
            list.add(StringItemBean(92, "Aspect测试"))

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
//            1 -> CanvasGeometryActivity::class.java
            1 -> CanvasSimpleActivity::class.java

            3 -> AnimationMainActivity::class.java
            29 -> ActivitiesMainActivity::class.java

            37 -> MainLifecycleActivity::class.java
            42 -> ScopeMainActivity::class.java
            79 -> HiltMainActivity::class.java
            90 -> GlideTestActivity::class.java
            91 -> SpAnrTestActivity::class.java
            92 -> AspectTestActivity::class.java

            else -> EmptyActivity::class.java
        }
        intent.setClass(this, clazz)
        startActivity(intent)
    }

    internal class MainListAdapter(layoutResId: Int) :
        BaseQuickAdapter<StringItemBean, MainItemViewHolder>(layoutResId) {
        override fun convert(
            holder: MainItemViewHolder,
            item: StringItemBean
        ) {
            holder.textView?.text = item.text
        }
    }

    internal class MainItemViewHolder(view: View) : BaseViewHolder(view) {
        var textView: MaterialTextView? = R.id.tv_text_view_item.findView()
    }


}