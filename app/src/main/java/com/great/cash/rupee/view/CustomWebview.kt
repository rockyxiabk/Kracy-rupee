package com.great.cash.rupee.view

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

class CustomWebview : WebView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    //实时滑动监控
    //参数l代表滑动后当前位置，old代表原来原值
    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        mScrollInterface!!.onSChanged(l, t, oldl, oldt)
    }

    var mScrollInterface: ScrollInterface? = null

    //监控滑动
    fun setOnCustomScrollChangeListener(scrollInterface: ScrollInterface?) {
        mScrollInterface = scrollInterface
    }

    interface ScrollInterface {
        fun onSChanged(l: Int, t: Int, oldl: Int, oldt: Int)
    }
}