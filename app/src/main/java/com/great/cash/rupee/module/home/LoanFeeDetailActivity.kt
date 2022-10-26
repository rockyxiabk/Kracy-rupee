package com.great.cash.rupee.module.home

import android.os.Bundle
import android.view.View
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.HomeOrderInfoBean
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActLoanFeeDetailBinding
import com.great.cash.rupee.view.dialog.DialogUtil

class LoanFeeDetailActivity :
    BaseAct<ActLoanFeeDetailBinding, BaseViewModel>(BaseViewModel::class.java) {
    private var orderInfo: HomeOrderInfoBean? = null
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

        return R.layout.act_loan_fee_detail
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing!!.clickListener = this

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

        orderInfo = intent.getBundleExtra(Constant.BUNDLE_DATA)!!
            .getSerializable(Constant.DATA) as HomeOrderInfoBean?
        orderInfo?.let {
            dataBing!!.tvDis.text = "₹ ${it.realAmount}"
            dataBing!!.tvRepay.text = "₹ ${it.repaymentAmount}"
            dataBing!!.tvInter.text = "₹ ${it.interest}"
            dataBing!!.tvPro.text = "₹ ${it.onceHandlingFee}"
            dataBing!!.tvAm.text = "₹ ${it.onceServiceFee}"
            dataBing!!.tvGst.text = "₹ ${it.gstFee}"
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

        when (view?.id) {
            R.id.btn_back -> {
                finish()
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

    private fun showTips(title: String, content: String) {
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

        DialogUtil.showFeeDescDialog(this, title, content)
    }
}
