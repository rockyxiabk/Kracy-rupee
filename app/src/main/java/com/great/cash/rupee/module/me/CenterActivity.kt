package com.great.cash.rupee.module.me

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.UserAuthResp
import com.great.cash.rupee.module.model.PersonCenterModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActCenterBinding

class CenterActivity :
    BaseAct<ActCenterBinding, PersonCenterModel>(PersonCenterModel::class.java) {
    var userAuthResp: UserAuthResp = UserAuthResp()
    override fun getLayout(): Int {
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

        return R.layout.act_center
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing?.clickListener = this
        viewModel.statisticsEvent(EventParams.EVENT_AUTH_TOTAL, EventParams.EVENT_AUTH_TOTAL_DESC)
    }

    override fun onResume() {
        super.onResume()
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

        showDialog()
        viewModel.getCreditInfo().observe(this, Observer {
            dismissDialog()
            userAuthResp = it
            dataBing!!.ivName.setImageResource(if (it.isRealNameOK()) R.mipmap.hkcg else R.mipmap.tixing)
            dataBing!!.ivInfo.setImageResource(if (it.isInfoNameOK()) R.mipmap.hkcg else R.mipmap.tixing)
            dataBing!!.ivReference.setImageResource(if (it.isReferenceOK()) R.mipmap.hkcg else R.mipmap.tixing)
            dataBing!!.ivBank.setImageResource(if (it.isBankOK()) R.mipmap.hkcg else R.mipmap.tixing)
        })
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

        when (view?.id) {
            R.id.ll_credit -> {
                var bundle = Bundle()
                bundle.putString("state", userAuthResp.realNameAuthState)
                toOtherActivity(PersonActivity::class.java, bundle)
            }
            R.id.ll_base_info -> {
                if (!userAuthResp.isRealNameOK()) {
                    showMsg("Please complete in order")
                    return
                }
                var bundle = Bundle()
                bundle.putString("state", userAuthResp.personalInfoState)
                toOtherActivity(InfoActivity::class.java, bundle)
            }
            R.id.ll_reference -> {
                if (!userAuthResp.isRealNameOK() || !userAuthResp.isInfoNameOK()) {
                    showMsg("Please complete in order")
                    return
                }
                var bundle = Bundle();
                bundle.putString("state", userAuthResp.contactState);
                toOtherActivity(ReferenceActivity::class.java, bundle)
            }
            R.id.ll_bank -> {
                if (!userAuthResp.isRealNameOK() || !userAuthResp.isReferenceOK()) {
                    showMsg("Please complete in order")
                    return
                }
                if (userAuthResp.isBankOK()) {
                    var bundle = Bundle();
                    toOtherActivity(CardSelectActivity::class.java, bundle)
                } else {
                    var bundle = Bundle();
                    toOtherActivity(NewCardActivity::class.java, bundle)
                }

            }
            R.id.iv_back -> {
                finish()
            }
        }
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

    }
}
