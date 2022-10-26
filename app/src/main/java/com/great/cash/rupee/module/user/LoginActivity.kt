package com.great.cash.rupee.module.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.R
import com.great.cash.rupee.module.model.LoginOrRegisterModel
import com.great.cash.rupee.utils.ActManager
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.errorLog
import com.great.cash.rupee.utils.isPhoneNumber
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActLogonBinding
import com.great.cash.rupee.module.home.LauncherActivity

class LoginActivity : BaseAct<ActLogonBinding, LoginOrRegisterModel>(
    LoginOrRegisterModel::class.java
) {
    private var phoneNumber: String? = ""
    private var pwd: String? = ""
    private var exitTime: Long = 0
    private var source: Boolean = false//true 为异地登陆下进入该页面
    override fun getLayout(): Int {
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

        return R.layout.act_logon
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing!!.clickListener = this
        dataBing!!.etInputPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
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

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
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

                pwd = s.toString()
                checkNum()
            }

            override fun afterTextChanged(s: Editable?) {
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
        })

        dataBing!!.tvInputPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
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

                phoneNumber = s.toString()
                checkNum()
            }

            override fun afterTextChanged(s: Editable?) {
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

            }
        })
        viewModel.statisticsEvent(
            EventParams.EVENT_LOGIN_BEGIN,
            EventParams.EVENT_LOGIN_BEGIN_DESC
        )
    }

    fun checkNum() {
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

        dataBing!!.btnLogin.isEnabled = phoneNumber!!.isPhoneNumber() && pwd!!.length in 6..16
    }

    override fun initData() {
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

        source = intent.getBooleanExtra("source", false)
        try {
            phoneNumber = intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString("phone")
            dataBing!!.tvInputPhone.setText(phoneNumber)
        } catch (e: Exception) {
            errorLog(e.toString())
        }
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

        when (view!!.id) {
            R.id.iv_back1 -> {
                if (source) {
                    if (System.currentTimeMillis() - exitTime <= 2000) {
                        finish()
                        ActManager.finishAll()
                    } else {
                        exitTime = System.currentTimeMillis()
                        showMsg(getString(R.string.exit_app_tips))
                    }
                } else {
                    toInputNumberAct()
                }
            }
            R.id.tv_forget_pwd -> {
                val bundle = Bundle()
                bundle.putString("phone", phoneNumber)
                toOtherActivity(NoPwdActivity::class.java, bundle)
            }
            R.id.btn_login -> {
                showDialog()
                viewModel.logIn(phoneNumber, pwd).observe(this, Observer {
                    if (it) {
                     viewModel.statisticsEvent(
                            EventParams.EVENT_LOGIN_END,
                            EventParams.EVENT_LOGIN_END_DESC
                        )
                        toOtherActivityAndFinishCurrent(LauncherActivity::class.java)
                    }
                    dismissDialog()
                })
            }
        }
    }

    override fun onBackPressed() {
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

        if (source) {
            backAgain()
        } else {
            toInputNumberAct()
        }
    }

    private fun toInputNumberAct() {
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

        val bundle = Bundle()
        bundle.putString("phone", phoneNumber)
        toOtherActivityAndFinish(InputNumberActivity::class.java, bundle)
    }

    private fun backAgain() {
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

        if (System.currentTimeMillis() - exitTime > 2000) {
            exitTime = System.currentTimeMillis()
            showMsg(getString(R.string.exit_app_tips))
        } else {
            finish()
            ActManager.finishAll()
        }
    }
}
