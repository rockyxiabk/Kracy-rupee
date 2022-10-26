package com.great.cash.rupee.module.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.LendDetailResp
import com.great.cash.rupee.module.model.RePayModel
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.utils.errorLog
import com.great.cash.rupee.utils.goActivity
import com.great.cash.rupee.utils.userId
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActRepayInfoBinding

class RepayInfoActivity :
    BaseAct<ActRepayInfoBinding, RePayModel>(RePayModel::class.java) {
    private var borrowId: String? = null
    private var invoiceUrl: String? = null
    override fun getLayout(): Int {
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

        return R.layout.act_repay_info
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
                Constant.BORROW_ID)
        debug("borrowId:${borrowId}")
        showDialog()
        viewModel.findInfo(borrowId).observe(this, Observer {
            dismissDialog()
            setPaymentInfo(it)
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setPaymentInfo(detailResp: LendDetailResp?) {
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

        detailResp?.let {
            try {
                invoiceUrl = it.invoice
                dataBing!!.tvAmount.text = "₹" + it.amount
                dataBing!!.tvAppDate.text = it.applicationDate
                dataBing!!.tvDisbursalBank.text = it.bankName
                dataBing!!.tvAccountNo.text = it.cardNo
                dataBing!!.tvRepaymentMoney.text = "₹" + it.repayment
                dataBing!!.tvDueDate.text = it.repayTime
                dataBing!!.llInvoice.visibility =
                    if (TextUtils.isEmpty(it.invoice)) View.GONE else View.VISIBLE
            } catch (e: Exception) {
                errorLog(e.toString())
            }
        }
    }

    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.tv_check -> {
                val url: String =
                    NetworkStart.BASE_URL + "/protocol/esignProtocolPreview.htm?borrowId=${borrowId}&userId=${userId}"
                val bundle = Bundle()
                bundle.putString(Constant.TITLE, "Check")
                bundle.putString(Constant.URL, url)
                toOtherActivity(BrowserActivity::class.java, bundle)
            }
            R.id.tv_invoice -> {
                goActivity(this, invoiceUrl)
            }
        }
    }
}
