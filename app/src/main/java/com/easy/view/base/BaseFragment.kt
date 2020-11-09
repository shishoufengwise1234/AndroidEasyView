package com.easy.view.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder
import com.orhanobut.logger.Logger

/**
 * Created by shishoufeng on 2020/9/6.
 * email:shoufengshi@lagou.com
 *
 * desc: 抽象fragment 层
 *
 *
 */
abstract class BaseFragment : Fragment() {

    private val TAG = this.javaClass.simpleName

    private var mContext:Context? = null

    private lateinit var mContentView:View


    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.mContext = context

        Logger.i(TAG," ： onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.i(TAG," ： onCreate()")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContentView = layoutInflater.inflate(getLayoutId(),container,false)

        return mContentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()



    override fun onStart() {
        super.onStart()
        Logger.i(TAG," ： onStart()")
    }


    override fun onResume() {
        super.onResume()
        Logger.i(TAG," ： onResume()")
    }

    override fun onPause() {
        super.onPause()
        Logger.i(TAG," ： onPause()")
    }

    override fun onStop() {
        super.onStop()
        Logger.i(TAG," ： onStop()")
    }


    override fun onDestroyView() {
        super.onDestroyView()

        Logger.i(TAG," ： onDestroyView()")
    }

    override fun onDetach() {
        super.onDetach()
        Logger.i(TAG," ： onDetach()")
    }


    override fun onDestroy() {
        super.onDestroy()
        Logger.i(TAG," ： onDestroy()")
    }



}