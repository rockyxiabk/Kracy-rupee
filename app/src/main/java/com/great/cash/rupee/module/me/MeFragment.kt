package com.great.cash.rupee.module.me

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.great.cash.rupee.R
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.commonbase.BaseFrag
import com.great.cash.rupee.databinding.FragMeBinding
import com.great.cash.rupee.module.home.BrowserActivity
import com.great.cash.rupee.module.home.LoanActivity
import com.great.cash.rupee.module.home.LoanListActivity
import com.great.cash.rupee.module.user.InputNumberActivity
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.view.dialog.DialogUtil

class MeFragment : BaseFrag<FragMeBinding, BaseViewModel>(BaseViewModel::class.java) {

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
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

        try {
            initData()
        } catch (e: java.lang.Exception) {
            errorLog(e.toString())
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

        return R.layout.frag_me
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
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

        dataBing?.clickListener = this
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

        setPersonInfo()
    }

    override fun onResume() {
        super.onResume()
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

        setPersonInfo()
    }

    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.ll_certification -> {
                toOtherActivity(CenterActivity::class.java)
            }
            R.id.ll_help -> {
                toWebView(0)
            }
            R.id.ll_recorder -> {
                toOtherActivity(LoanListActivity::class.java)
            }
            R.id.ll_setting -> {
                toOtherActivity(SettingActivity::class.java)
            }
        }
    }

    private fun setPersonInfo() {
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

        if (TextUtils.isEmpty(userPhone)) {
            dataBing!!.tvName.setText(R.string.login_register)
            dataBing!!.tvPhone.text = getText(R.string.phone_number)
        } else {
            dataBing!!.tvName.setText(R.string.hello)
            dataBing!!.tvPhone.text = userPhone?.hidePhoneMiddleNumber()
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
