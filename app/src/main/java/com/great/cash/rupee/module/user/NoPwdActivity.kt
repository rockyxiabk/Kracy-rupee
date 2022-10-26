package com.great.cash.rupee.module.user

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.SMS_TYPE_FINDREG
import com.great.cash.rupee.module.model.LoginOrRegisterModel
import com.great.cash.rupee.utils.errorLog
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActNoPwdBinding

class NoPwdActivity : BaseAct<ActNoPwdBinding, LoginOrRegisterModel>(
    LoginOrRegisterModel::class.java
) {
    private var showPwd = false
    private var phoneNumber = ""
    private var code = ""
    private var pwd = ""
    private val countDownTimer: CountDownTimer = object : CountDownTimer(60000, 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
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

        return R.layout.act_no_pwd
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
//        dataBing!!.etInputPhone.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
//                phoneNumber = s.toString()
//                dataBing!!.btnSubmit.isEnabled =
//                    phoneNumber.length >= 10 && code.isNotEmpty() && pwd.length >= 6 && pwd.length <= 16
//            }
//
//            override fun afterTextChanged(editable: Editable) {}
//        })
        dataBing!!.etInputCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
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

            }

            override fun onTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
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
                dataBing!!.btnSubmit.isEnabled =
                    phoneNumber.length >= 10 && code.isNotEmpty() && pwd.length >= 6 && pwd.length <= 16
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        dataBing!!.etInputPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
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

            override fun onTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
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
                dataBing!!.btnSubmit.isEnabled =
                    phoneNumber.length >= 10 && code.isNotEmpty() && pwd.length >= 6 && pwd.length <= 16
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }

    override fun initData() {
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

        try {
            phoneNumber =
                intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString("phone").toString()
            dataBing!!.etInputPhone.setText(phoneNumber)
        } catch (e: Exception) {
            errorLog(e.toString())
        }
    }

    override fun onViewClick(view: View?) {
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

        when (view!!.id) {
            R.id.btn_get_code -> {
                showDialog()
                viewModel.getPhoneCode(phoneNumber, SMS_TYPE_FINDREG).observe(this, Observer {
                    dismissDialog()
                    if (it) {
                        dataBing!!.btnGetCode.isEnabled = false
                        countDownTimer.start()
                    }
                })
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
                showDialog()
                viewModel.forgotPwd(phoneNumber, pwd, code).observe(this, Observer {
                    dismissDialog()
                    if (it) {
                        showMsg(getString(R.string.pwd_change_success))
                        dataBing!!.etInputCode.setText(code)
                        dataBing!!.etInputPwd.setText(pwd)
                        countDownTimer.onFinish()
                        finish()
                    }
                })
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
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

        return false
    }
}
