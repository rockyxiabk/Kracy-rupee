package com.great.cash.rupee.module.user

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.Observer
import com.appsflyer.AppsFlyerLib
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.SMS_TYPE_REGISTER
import com.great.cash.rupee.module.model.LoginOrRegisterModel
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.ConstantsParams
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.utils.errorLog
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActLogBinding
import com.great.cash.rupee.module.home.BrowserActivity
import com.great.cash.rupee.module.home.LauncherActivity

class LogonActivity : BaseAct<ActLogBinding, LoginOrRegisterModel>(
    LoginOrRegisterModel::class.java
) {
    private var phoneNumber: String? = null
    private var showPwd = false
    private var isCanSubmit = false
    private var isAgreement = true
    private var code = ""
    private var pwd = ""
    private val timer: CountDownTimer = object : CountDownTimer(60000, 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
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

            dataBing!!.btnGetCode.isEnabled = false
            try {
                dataBing!!.btnGetCode.text = "${(millisUntilFinished / 1000)} Second"
            } catch (e: Exception) {
                errorLog(e.toString())
            }
        }

        override fun onFinish() {
            //--------------------------kotlin junk code-----------------------------
            try {
               val user_address = "poiy9868dsak"
               val addresses = arrayListOf<String>()
               val position = hashMapOf<String, Any>()
               with(position) {
                   for (c in user_address) {
                       put("key$c", c)
                   }
               }
               position.forEach {
                   addresses.add(it.key + "=" + it.value)
               }
               addresses.clear()
           } catch (eKotlinCode5: Exception) {
           }
            //--------------------------kotlin junk code-----------------------------

            try {
                dataBing!!.btnGetCode.isEnabled = true
                dataBing!!.btnGetCode.text = getText(R.string.get)
            } catch (e: Exception) {
                errorLog(e.toString())
            }
        }
    }

    override fun getLayout(): Int {
            //--------------------------kotlin junk code-----------------------------
            try {
               val user_address = "poiy9868dsak"
               val addresses = arrayListOf<String>()
               val position = hashMapOf<String, Any>()
               with(position) {
                   for (c in user_address) {
                       put("key$c", c)
                   }
               }
               position.forEach {
                   addresses.add(it.key + "=" + it.value)
               }
               addresses.clear()
           } catch (eKotlinCode5: Exception) {
           }
            //--------------------------kotlin junk code-----------------------------

        return R.layout.act_log
    }

    override fun initView(savedInstanceState: Bundle?) {
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        setLightBar(true)
        dataBing!!.clickListener = this
        dataBing!!.etInputCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
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

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

                code = s.toString()
                isCanSubmit = pwd.length >= 6 && code.length >= 4
            }

            override fun afterTextChanged(s: Editable) {
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

                dataBing!!.btnSubmit.isEnabled = isCanSubmit
            }
        })
        dataBing!!.etInputPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
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

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

                pwd = s.toString()
                isCanSubmit = pwd.length >= 6 && code.length >= 4
            }

            override fun afterTextChanged(s: Editable) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

                dataBing!!.btnSubmit.isEnabled = isCanSubmit
            }
        })
      viewModel.statisticsEvent(
            EventParams.EVENT_REGISTER_BEGIN,
            EventParams.EVENT_REGISTER_BEGIN_DESC
        )
        val style = SpannableStringBuilder()
        style.append(resources.getString(R.string.agreement))
        val clickableTeam: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
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

                toWebView(2)
            }
        }
        style.setSpan(clickableTeam, 30, 44, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        val clickablePrivacy: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
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

                toWebView(1)
            }
        }
        style.setSpan(clickablePrivacy, 47, 63, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        val foregroundColorSpan = ForegroundColorSpan(resources.getColor(R.color.colorAccent))
        style.setSpan(foregroundColorSpan, 30, 63, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        dataBing!!.tvAgreement.text = style
        dataBing!!.tvAgreement.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun initData() {
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        viewModel.loadH5List()
        try {
            phoneNumber = intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString("phone")
        } catch (e: Exception) {
            errorLog(e.toString())
        }
    }

    override fun onViewClick(view: View?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        when (view!!.id) {
            R.id.iv_back -> {
                val bundle = Bundle()
                bundle.putString("phone", phoneNumber)
                toOtherActivityAndFinish(InputNumberActivity::class.java, bundle)
            }
            R.id.btn_get_code -> {
                showDialog()
                viewModel.getPhoneCode(phoneNumber, SMS_TYPE_REGISTER).observe(this, Observer {
                    dismissDialog()
                    if (it) {
                        dataBing!!.btnGetCode.isEnabled = false
                        timer.start()
                    }
                })

            }
            R.id.iv_agree -> {
                isAgreement = !isAgreement
                dataBing!!.ivAgree.setImageResource(if (isAgreement) R.mipmap.tongguo else R.mipmap.weigx)
            }
            R.id.iv_show_pwd -> {
                showPwd = !showPwd
                if (showPwd) {
                    dataBing!!.etInputPwd.transformationMethod =
                        HideReturnsTransformationMethod.getInstance()
                    dataBing!!.ivShowPwd.setImageResource(R.mipmap.xianshi)
                } else {
                    dataBing!!.etInputPwd.transformationMethod =
                        PasswordTransformationMethod.getInstance()
                    dataBing!!.ivShowPwd.setImageResource(R.mipmap.buxianshimm)
                }
                dataBing!!.etInputPwd.setSelection(dataBing!!.etInputPwd.text.length)
            }
            R.id.btn_submit -> {
                if (isAgreement) {
                    showDialog()
                    val appsFlyerId: String = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
                    viewModel.register(phoneNumber, pwd, code, appsFlyerId).observe(this, Observer {
                        dismissDialog()
                        timer.onFinish()
                        if (it) {
                            viewModel.statisticsEvent(
                                EventParams.EVENT_REGISTER_END,
                                EventParams.EVENT_REGISTER_END_DESC
                            )
                            toOtherActivityAndFinishCurrent(LauncherActivity::class.java)
                        }
                    })
                } else {
                    showMsg("Please Read And Agree the Agreement")
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
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

        return false
    }

    private fun toWebView(index: Int) {
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

        debug("current index:${index}")
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
