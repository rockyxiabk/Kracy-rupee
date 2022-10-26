package com.great.cash.rupee.view.dialog

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.Button
import android.widget.TextView
import com.great.cash.rupee.R
import com.great.cash.rupee.view.CustomWebview

class PermissionDialog(
    context: Context, privacyUrl: String, listenerCancel: View.OnClickListener,
    listenerConfir: View.OnClickListener
) : Dialog(context) {
    private val privacyUrl: String = privacyUrl
    private val listenerCancel: View.OnClickListener = listenerCancel
    private val listenerConfir: View.OnClickListener = listenerConfir
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_permission_layout)
        val window = window
        val params = window!!.attributes
        window.setBackgroundDrawableResource(R.color.transparent)
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        params.gravity = Gravity.BOTTOM
        window.attributes = params
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        val btn_cancel: TextView = findViewById<Button>(R.id.btn_cancel)
        val btn_confirm: TextView = findViewById<Button>(R.id.btn_confirm)
        val web_view: CustomWebview = findViewById<CustomWebview>(R.id.coutomer_view)
        btn_cancel.setOnClickListener(View.OnClickListener { view ->
            dismiss()
            listenerCancel.onClick(view)
        })
        btn_confirm.setOnClickListener(View.OnClickListener { view ->
            dismiss()
            listenerConfir.onClick(view)
        })
        val setting: WebSettings = web_view.getSettings()
        setting.setSupportZoom(true)
        setting.builtInZoomControls = false
        setting.cacheMode = WebSettings.LOAD_NO_CACHE
        setting.useWideViewPort = true
        setting.loadWithOverviewMode = true
        setting.javaScriptEnabled = true
        setting.savePassword = false
        setting.domStorageEnabled = true
        setting.defaultTextEncodingName = "utf-8"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setting.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        web_view.loadUrl(privacyUrl)
        web_view.setOnCustomScrollChangeListener(object : CustomWebview.ScrollInterface {
            override fun onSChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
                val contentHeight: Float = web_view.contentHeight * web_view.scale
                //WebView的现高度
                val currentHeight: Int = web_view.height + web_view.scrollY
                if (contentHeight - currentHeight < 10) {  //尽量不要用==0，有时候精度问题导致无法完全相等(自己调试即可)
                    btn_confirm.isEnabled = true
                }
            }
        })
    }
}