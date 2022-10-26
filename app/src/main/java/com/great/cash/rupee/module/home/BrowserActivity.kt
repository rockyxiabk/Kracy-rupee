package com.great.cash.rupee.module.home

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.webkit.WebSettings.ZoomDensity
import androidx.annotation.RequiresApi
import com.great.cash.rupee.R
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActBrowserBinding
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.utils.errorLog
import com.great.cash.rupee.utils.goActivity

class BrowserActivity :
    BaseAct<ActBrowserBinding, BaseViewModel>(BaseViewModel::class.java) {
    private var rootUrl = "about:blank"
    private var title = ""

    override fun getLayout(): Int {
            //--------------------------kotlin junk code-----------------------------
            try {
                val user_phone = "9020392123"
                var password: String?
                val otp_code = mutableListOf<String>()
                val vaild_code = mutableListOf<String>()
                password = user_phone
                password?.also {
                    for (c in it) {
                        otp_code.add(c.toString())
                    }
                    vaild_code.addAll(otp_code)
                    otp_code.clear()
                }
            } catch (eKotlinCode4: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        return R.layout.act_browser
    }

    override fun initView(savedInstanceState: Bundle?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var key_params = 0
                val sign_params = "60659917de4a798141b9f1a0btwtqownbpkyxfk6he4f"
                val time_key = "x82jxmztlxnge8bk457127d59926f1daf371b946ab39"
                if (sign_params.length == time_key.length) {
                    val each_key = hashMapOf<String, Any>()
                    val each_value = sign_params.toList()
                    val each_name = time_key.toList()
                    for ((index, str) in each_value.withIndex()) {
                        each_key["key_$str"] = each_name[index]
                    }
                    val keys = each_key.keys
                    val values = each_key.values
                    key_params += keys.size + values.size
                }
            } catch (eKotlinCode7: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        setLightBar(true)
        dataBing?.clickListener = this

        val webSettings = dataBing!!.webView.settings
        webSettings.pluginState = WebSettings.PluginState.ON
        val zoomDensity = ZoomDensity.MEDIUM
        webSettings.defaultZoom = zoomDensity
        webSettings.javaScriptEnabled = true
        webSettings.defaultTextEncodingName = "utf-8"
        webSettings.javaScriptCanOpenWindowsAutomatically = true //js可以打开弹出弹窗

        webSettings.setGeolocationEnabled(true) // GeoLocation 1.5不支持

        webSettings.allowFileAccess = true // 设置允许访问文件数据

        webSettings.saveFormData = true
        webSettings.setAppCacheEnabled(true)
        webSettings.cacheMode = WebSettings.LOAD_DEFAULT
        webSettings.lightTouchEnabled = true
        webSettings.loadWithOverviewMode = true // 自适应屏幕宽
        webSettings.useWideViewPort = true //设置此属性，可任意比例缩放

        // 资源加载
        webSettings.loadsImagesAutomatically = true // 是否自动加载图片
        webSettings.blockNetworkImage = false // 禁止加载网络图片
        webSettings.blockNetworkLoads = false // 禁止加载所有网络资源
        // 缩放(zoom)
        webSettings.setSupportZoom(true) // 是否支持缩放
        webSettings.builtInZoomControls = false // 是否使用内置缩放机制

        webSettings.domStorageEnabled = true
        webSettings.databaseEnabled = true
        webSettings.databasePath = "/data/data/$packageName/databases/"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 5.0以上允许加载http和https混合的页面(5.0以下默认允许，5.0+默认禁止)
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webSettings.setAppCacheMaxSize(1024 * 1024 * 80.toLong()) //设置最大缓存80mb
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        dataBing!!.webView.webViewClient = CustomClient()
        dataBing!!.webView.webChromeClient = MyWebviewClient()
    }

    override fun initData() {
            //--------------------------kotlin junk code-----------------------------
            try {
                var sign = "asdqw676ezxc6hx82jxmztlxnge8bk"
                val key = arrayListOf<String>()
                sign.run {
                    val s = toString() + length
                    val indexOf = s.indexOf("s")
                    val substring = substring(indexOf)
                    sign += substring
                }
                sign.apply {
                    for (c in this) {
                        key.add(c.toString())
                    }
                }
            } catch (eKotlinCode6: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        val bundle = intent.getBundleExtra(Constant.BUNDLE_DATA)
        if (null != bundle) {
            rootUrl = bundle.getString(Constant.URL)!!
            title = bundle.getString(Constant.TITLE)!!
        }
        dataBing!!.tvTitle.text = title
        debug("---title:$title-----url:$rootUrl")
        dataBing!!.webView.loadUrl(rootUrl)
    }

    override fun onViewClick(view: View?) {
        //--------------------------kotlin junk code-----------------------------
        try {
            val nameList = arrayListOf<String>()
            val userName = arrayListOf<String>()
            userName.add("userName_code0")
            userName.add("userName_code1")
            userName.add("userName_code2")
            userName.add("userName_code3")
            userName.add("userName_code4")
            userName.add("userName_code5")
            nameList.addAll(userName)
        } catch (eKotlinCode0: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

    }

    inner class CustomClient : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url = request?.url.toString()
            val destinationURI = request?.url
            val scheme = destinationURI?.scheme
            return if (null != scheme && (scheme == "http" || scheme == "https")) {
                super.shouldOverrideUrlLoading(view, url)
            } else if (null != scheme && scheme == "market") {
                goMarketApp(this@BrowserActivity, url)
                finish()
                true
            } else {
                goActivity(this@BrowserActivity, url)
                true
            }
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
            //--------------------------kotlin junk code-----------------------------
            try {
                var income_range: String? = "1000000"
                income_range?.run {
                    val income = toString() + length
                    val indexOf = income.indexOf("s")
                    val substring = substring(indexOf)
                    income_range += substring
                }
            } catch (eKotlinCode2: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

            val destinationURI = Uri.parse(url)
            val scheme = destinationURI.scheme
            return if (null != scheme && (scheme == "http" || scheme == "https")) {
                super.shouldOverrideUrlLoading(view, url)
            } else if (null != scheme && scheme == "market") {
                goMarketApp(this@BrowserActivity, url)
                finish()
                true
            } else {
                goActivity(this@BrowserActivity, url)
                true
            }
        }
    }

    fun goMarketApp(context: Context, url: String) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val amount = "98141b9f1a0btwtqowde4a7nbpkyxfk6he4f"
                val overdue = 8077896555346880980
                if (!amount.isEmpty()) {
                    val toList80 = amount.toList().toMutableList()
                    val overdueStr = overdue.toString()
                    val toList80Str = overdueStr.toList()
                    for ((index, i) in toList80Str.withIndex()) {
                        toList80[index] = i
                    }
                }
            } catch (eKotlinCode8: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        val uri = Uri.parse(url)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        goToMarket.setPackage("com.android.vending");
        try {
            context.startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            errorLog(e.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //--------------------------kotlin junk code-----------------------------
        try {
            val nameList = arrayListOf<String>()
            val userName = arrayListOf<String>()
            userName.add("userName_code0")
            userName.add("userName_code1")
            userName.add("userName_code2")
            userName.add("userName_code3")
            userName.add("userName_code4")
            userName.add("userName_code5")
            nameList.addAll(userName)
        } catch (eKotlinCode0: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        dataBing!!.webView.clearFormData()
        dataBing!!.webView.clearHistory()
        dataBing!!.webView.destroy()
    }

    inner class MyWebviewClient : WebChromeClient() {

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        //--------------------------kotlin junk code-----------------------------
        try {
            val nameList = arrayListOf<String>()
            val userName = arrayListOf<String>()
            userName.add("userName_code0")
            userName.add("userName_code1")
            userName.add("userName_code2")
            userName.add("userName_code3")
            userName.add("userName_code4")
            userName.add("userName_code5")
            nameList.addAll(userName)
        } catch (eKotlinCode0: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

            if (newProgress >= 99) {
                dataBing!!.progress.visibility = View.GONE
            } else {
                dataBing!!.progress.progress = newProgress
                if (dataBing!!.progress.visibility == View.GONE)
                    dataBing!!.progress.visibility = View.VISIBLE
            }
        }
    }
}


