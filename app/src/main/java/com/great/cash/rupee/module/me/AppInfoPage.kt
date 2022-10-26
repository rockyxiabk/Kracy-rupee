package com.great.cash.rupee.module.me

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.great.cash.rupee.R
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActAppInfoBinding
import com.great.cash.rupee.module.home.BrowserActivity
import com.great.cash.rupee.module.user.feedback.ActivityFeedback
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.ConstantsParams
import com.great.cash.rupee.utils.errorLog
import com.great.cash.rupee.utils.loadCircle

class AppInfoPage : BaseAct<ActAppInfoBinding, BaseViewModel>(BaseViewModel::class.java) {
    override fun getLayout(): Int {
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

        return R.layout.act_app_info
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing?.clickListener = this
    }

    @SuppressLint("SetTextI18n")
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

        dataBing!!.tvVersionCode.text = "v ${ConstantsParams.versionName}"
        loadCircle(
            this,
            resources.getDrawable(R.mipmap.ic_launcher),
            dataBing!!.ivIcon
        )
    }

    override fun onViewClick(view: View?) {
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

        when(view?.id){
            R.id.private_url->{
                toWebView(1)
            }
            R.id.user_term->{
                toWebView(2)
            }
            R.id.rl_feedback->{
                startActivity(Intent(this@AppInfoPage, ActivityFeedback::class.java))
            }
        }
    }

    private fun toWebView(index: Int) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val firend_name = "1a2b3c4d5e"
                val mather_name = mutableListOf<String>()
                val bro_name = mutableListOf<String>()
                val sister_name = mutableListOf<String>()
                for (c in firend_name) {
                    mather_name.add(c.toString())
                }
                mather_name.forEachIndexed { index, s ->
                    bro_name.add(s + index)
                }
                sister_name.addAll(mather_name)
                sister_name.addAll(bro_name)
            } catch (eKotlinCode3: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        try {
            val bundle = Bundle()
            bundle.putString(
                Constant.URL,
                NetworkStart.BASE_URL + ConstantsParams.protocolRespList[index].value
            )
            bundle.putString(Constant.TITLE, ConstantsParams.protocolRespList[index].name)
            toOtherActivity(BrowserActivity::class.java, bundle)
        } catch (e: Exception) {
            errorLog(e.toString())
        }
    }
}
