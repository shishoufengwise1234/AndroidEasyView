package com.easy.view.bean

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.easy.view.const.Constants

/**
 * Created by shishoufeng on 2020/8/30.
 * email:shoufengshi@lagou.com
 *
 *
 * desc: 字符串数据bean
 */
public class StringItemBean : MultiItemEntity {

    constructor(int:Int,content: CharSequence){
        id = int
        text = content;
    }

    constructor(charSequence: CharSequence){
        text = charSequence
    }

    var id = 0
    var text: CharSequence? = null

    //自定义viewType
    var viewType = Constants.VIEW_TYPE_DEFAULT

    override val itemType: Int
        get() = viewType
}