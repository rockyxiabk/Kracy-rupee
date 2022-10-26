package com.great.cash.rupee.module.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.RepayDetailResp
import com.great.cash.rupee.entity.RepayInfoResp
import com.great.cash.rupee.module.model.RePayModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActRepayDetailBinding
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.view.dialog.DialogUtil


class RepayDetailActivity :
    BaseAct<ActRepayDetailBinding, RePayModel>(RePayModel::class.java) {
    private var borrowId: String? = null
    private var orderNo: String? = null
    private var  repayDetail:RepayDetailResp?=null
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

        return R.layout.act_repay_detail
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing!!.clickListener = this
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

        borrowId =
            intent.getBundleExtra(Constant.BUNDLE_DATA)?.getString(
                Constant.BORROW_ID
            )
        debug("borrowId:${borrowId}")
        showDialog()
        viewModel.getDetail(borrowId).observe(this, Observer {
            dismissDialog()
            setPaymentInfo(it)
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setPaymentInfo(repayDetailResp: RepayDetailResp?) {
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

        repayDetailResp?.let {
            repayDetail = it
            dataBing!!.tvLoanedAmount.text = "₹ " + it.amount
            dataBing!!.tvReceiveAmount.text = "₹ " + it.received
            dataBing!!.tvApplyDate.text = it.applicationTimeStr
            dataBing!!.tvInterestFee.text = "₹ " + it.interestFee
            dataBing!!.tvProgressFee.text = "₹ " + it.processingFee
            dataBing!!.tvAssessmentFee.text = "₹ " + it.assessmentFee
            dataBing!!.tvGstFee.text = "₹ " + it.gstFee
            dataBing!!.tvRepayment.text = "₹ " + it.repayment
            dataBing!!.tvDueDate.text = it.repayTimeStr
            dataBing!!.tvAmount.text = "₹ " + it.repayment
            dataBing!!.btnExtend.visibility =if (it.canExtension) View.VISIBLE else View.GONE
        }
    }

    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.btn_submit -> {
                showDialog()
                borrowId?.let {
                    getRepayDataUrl(it,false)
                }
            }
            R.id.btn_extend->{
                repayDetail?.let {
                    DialogUtil.showExtendDialog(this@RepayDetailActivity,it.extensionDate,it.extensionFee,it.extensionAmount){
                        borrowId?.let {itt->
                            showDialog()
                            getRepayDataUrl(itt,true)
                        }
                    }
                }
            }
        }
    }

    private fun getRepayDataUrl(it: String,extend:Boolean) {
        viewModel.getInfo(it,extend).observe(this, Observer {
            dismissDialog()
            startPay(it)
        })
    }

    private fun startPay(repayInfo: RepayInfoResp?) {
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

        viewModel.statisticsEvent(EventParams.EVENT_REPAY_CLICK, EventParams.EVENT_REPAY_CLICK_DESC)
        repayInfo?.let {
            it.repayUrl?.let { it ->
                val bundle = Bundle()
                bundle.putString(
                    Constant.URL,
                    it
                )
                bundle.putString(Constant.TITLE, "Repay Money")
                toOtherActivity(RepayActivity::class.java, bundle)
                finish()
            }
        }
    }

}
