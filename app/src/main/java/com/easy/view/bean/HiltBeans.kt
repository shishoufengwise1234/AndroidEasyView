package com.easy.view.bean

import javax.inject.Inject

/**
 * Created by shishoufeng on 2020/11/17.
 * email:shoufengshi@lagou.com
 *
 * desc:
 *
 *
 */

data class HiltText(var id: Int, var text: String) {


    @Inject constructor() : this(1, "Test Text")
}

class HiltBeans {
}