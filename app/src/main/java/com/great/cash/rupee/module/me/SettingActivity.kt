package com.great.cash.rupee.module.me

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.great.cash.rupee.R
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.databinding.ActSettingBinding
import com.great.cash.rupee.module.home.BrowserActivity
import com.great.cash.rupee.module.user.InputNumberActivity
import com.great.cash.rupee.module.user.feedback.ActivityFeedback
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.view.dialog.DialogUtil

class SettingActivity :
    BaseAct<ActSettingBinding, BaseViewModel>(BaseViewModel::class.java) {
    override fun getLayout(): Int {
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

        return R.layout.act_setting
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing?.clickListener = this
    }

    override fun initData() {
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

    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.private_url -> {
                toWebView(1)
            }
            R.id.user_term -> {
                toWebView(2)
            }
            R.id.rl_about -> {
                startActivity(Intent(this@SettingActivity, AppInfoPage::class.java))
            }
            R.id.rl_feedback -> {
                startActivity(Intent(this@SettingActivity, ActivityFeedback::class.java))
            }
            R.id.btn_logout -> {
                if (isLogin) {
                    DialogUtil.showCancelConfirmDialog(this,
                        getString(R.string.logout_account_tips),
                        View.OnClickListener {
                            SpUtil.clearSP(SpUtil.USER)
                            showShort(getString(R.string.exit_login))
                            toOtherActivity(InputNumberActivity::class.java)
                            finish()
                        },
                        View.OnClickListener {

                        })
                } else {
                    toOtherActivity(InputNumberActivity::class.java)
                }
            }
        }
    }

    private fun toWebView(index: Int) {
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
