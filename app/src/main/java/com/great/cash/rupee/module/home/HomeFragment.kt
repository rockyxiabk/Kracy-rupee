package com.great.cash.rupee.module.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.HomeIndexResp
import com.great.cash.rupee.module.model.HomeModel
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.commonbase.BaseFrag
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.FragHomeBinding
import com.great.cash.rupee.module.adapter.HomeLoanAdapter
import com.great.cash.rupee.module.adapter.ProgressAdapter
import com.great.cash.rupee.module.me.CenterActivity
import com.great.cash.rupee.module.user.InputNumberActivity
import com.yinlan.newdatasyc.newwork.DataManagerSDK

class HomeFragment : BaseFrag<FragHomeBinding, HomeModel>(HomeModel::class.java),
    SwipeRefreshLayout.OnRefreshListener {
    private var homeData: HomeIndexResp? = null
    private var isBorrow = false
    private var isRepay = false
    private var isCredited = false
    private var borrowState = ""
    private var isApply = false
    private var adapter: ProgressAdapter? = null
    private var ListAdapter:HomeLoanAdapter?=null
    private var morePayTitle = ""
    private var morePayUrl = ""
    private var moreRefuseTitle = ""
    private var moreRefuseUrl = ""
    override fun getLayout(): Int {
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

        return R.layout.frag_home
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
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

        try {
            dataBing!!.refreshLayout.isRefreshing = true
            onRefresh()
        } catch (e: Exception) {
            errorLog(e.toString())
        }
    }

    override fun initView(rootView: View?, savedInstanceState: Bundle?) {
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

        dataBing?.clickListener = this
        dataBing!!.refreshLayout.setOnRefreshListener(this)
        ListAdapter = HomeLoanAdapter(requireContext());
        dataBing!!.recyclerList.layoutManager=LinearLayoutManager(requireContext())
        dataBing!!.recyclerList.adapter = ListAdapter
    }

    override fun initData() {
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

        dataBing!!.refreshLayout.isRefreshing = true
    }

    override fun onResume() {
        super.onResume()
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

        onRefresh()
    }

    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.iv_loan_fee_detail -> {
                if (isLogin && isBorrow) {
                    bindBundle(LoanFeeDetailActivity::class.java)
                } else {
                    showShort("No Loan Information")
                }
            }
            R.id.btn_apply -> {
                if (isLogin) {
                    if (isRepay) {
                        //跳转还款页面
                        homeData?.borrowId.let {
                            val bundle = Bundle()
                            bundle.putString(Constant.BORROW_ID, it)
                            toOtherActivity(RepayDetailActivity::class.java, bundle)
                        }
                    } else {
                        if (isBorrow) {
                            when (borrowState) {
                                //签章状态 跳转到签章页面
                                "20", "26" -> bindBundle(LoanActivity::class.java)
                                "21", "27" -> {
                                    toRefuseView()
                                }
                            }
                        } else {
                            if (isCredited) {
                                viewModel.statisticsEvent(
                                    EventParams.EVENT_APPLY,
                                    EventParams.EVENT_APPLY_DESC
                                )
                                bindBundle(LoanActivity::class.java)
                            } else {
                                //未认证 跳转到认证页面
                              viewModel.statisticsEvent(
                                    EventParams.EVENT_APPLY_NO_AUTH,
                                    EventParams.EVENT_APPLY_NO_AUTH_DESC
                                )
                                toOtherActivity(CenterActivity::class.java)
                            }
                        }
                    }
                } else {
                    toOtherActivity(InputNumberActivity::class.java)
                }
            }
            R.id.iv_more -> {
                if (morePayTitle.isEmpty() || morePayUrl.isEmpty()) return
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(morePayUrl)
                }
                startActivity(intent)
            }
        }
    }

    private fun toRefuseView() {
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

        if (moreRefuseTitle.isEmpty() || moreRefuseUrl.isEmpty()) return
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(morePayUrl)
        }
        startActivity(intent)
    }

    private fun bindBundle(cls: Class<*>) {
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

        if (homeData == null || homeData?.orderInfo == null) return
        val bundle = Bundle()
        homeData?.orderInfo?.borrowId = homeData?.borrowId
        bundle.putSerializable(Constant.DATA, homeData?.orderInfo)
        toOtherActivity(cls, bundle)
    }

    override fun onRefresh() {
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

        dataBing?.ivMore?.visibility = View.GONE
        viewModel.getLoanState().observe(this, Observer {
            dataBing!!.refreshLayout.isRefreshing = false
            if (null != it) {
                setDataInfo(it)
            } else {
                homeData = null
                isBorrow = false
                isCredited = false
                isRepay = false
                borrowState = ""
                isApply = false
                setBtnTextAndColor(
                    "LOGIN",
                    requireContext().resources.getColor(R.color.white),
                    canClick = true,
                    visible = true
                )
                dataBing!!.tvTitle.text = "Amount"
                dataBing!!.tvMoney.text = "₹ --"
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setDataInfo(dataResp: HomeIndexResp?) {
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

        if (dataBing!!.refreshLayout.isRefreshing) {
            dataBing!!.refreshLayout.isRefreshing = false
        }
        borrowState = dataResp?.orderInfo?.state.toString()
        isCredited = dataResp?.auth?.qualified == 1
        homeData = dataResp
        isBorrow = homeData?.haveBorrow!!
        isRepay = homeData?.needRepay!!

        homeData?.needCatch.let {
            if (it == true) {
                DataManagerSDK.getInstance().SynData(
                    dataResp!!.borrowId,
                    userId,
                    userPhone,
                    Constant.SYC_UPDATEURL
                )
            }
        }

        if (isRepay) {
            dataBing?.llListRoot?.visibility = View.GONE
            dataBing?.llLoanRoot?.visibility = View.VISIBLE
            dataBing?.llProgressDes?.visibility = View.GONE
            dataBing?.tvRepayTips?.visibility = View.VISIBLE
            dataBing?.ivLoanFeeDetail?.visibility = View.VISIBLE
            setBtnTextAndColor(
                "REPAY",
                requireContext().resources.getColor(R.color.white),
                canClick = true,
                visible = true
            )
            if (!homeData!!.orderInfo!!.repaymentRemark!!.contains("Due in")) {
                dataBing!!.tvRepayTips.text =
                    homeData!!.orderInfo!!.repaymentRemark?.replaceAll("\n", " ")
            } else {
                dataBing?.tvRepayTips?.text = homeData?.orderInfo?.repaymentRemark
            }
            showRepayMore()
        } else {
            if (isBorrow) {
                dataBing?.llListRoot?.visibility = View.GONE
                dataBing?.llLoanRoot?.visibility = View.VISIBLE
                dataBing?.llProgressDes?.visibility = View.GONE
                dataBing?.tvRepayTips?.visibility = View.VISIBLE
                when (borrowState) {
                    "20", "26", "10", "22" -> {
                        dataBing?.tvRepayTips?.text = "Submit successfully"
                        setBtnTextAndColor(
                            "REVIEWING",
                            requireContext().resources.getColor(R.color.white),
                            canClick = false,
                            visible = true
                        )
                        dataBing?.ivLoanFeeDetail?.visibility = View.GONE
                    }
                    "29", "31" -> {
                        dataBing?.tvRepayTips?.text =
                            "You will receive your loan \n within 24 hours  in your bank"
                        setBtnTextAndColor(
                            "DISBURSING",
                            requireContext().resources.getColor(R.color.white),
                            canClick = false,
                            visible = true
                        )
                        dataBing?.ivLoanFeeDetail?.visibility = View.VISIBLE
                    }
                    "21", "27" -> {
                        dataBing?.tvRepayTips?.text = "Refused"
                        setBtnTextAndColor(
                            "REFUSED",
                            requireContext().resources.getColor(R.color.white),
                            canClick = false,
                            visible = true
                        )
                        dataBing?.ivLoanFeeDetail?.visibility = View.GONE
                        showRejectMore()
                    }
                    else -> {
                        dataBing?.llProgressDes?.visibility = View.VISIBLE
                        dataBing?.tvRepayTips?.visibility = View.GONE
                        setBtnTextAndColor(
                            "APPLY",
                            requireContext().resources.getColor(R.color.white),
                            canClick = true,
                            visible = true
                        )
                        dataBing?.ivLoanFeeDetail?.visibility = View.GONE
                    }
                }
            } else {

                viewModel.getLoanListState().observe(this, Observer {
                    dataBing?.llListRoot?.visibility = View.VISIBLE
                    dataBing?.llLoanRoot?.visibility = View.GONE
                    ListAdapter?.setData(homeData,it)
                })


                dataBing?.llProgressDes?.visibility = View.VISIBLE
                dataBing?.tvRepayTips?.visibility = View.GONE
                setBtnTextAndColor(
                    "APPLY",
                    requireContext().resources.getColor(R.color.white),
                    canClick = true,
                    visible = true
                )
            }
        }
        dataBing!!.tvMoney.text = "₹ ${homeData?.orderInfo?.amount}"

        if (homeData?.haveBorrow!!) {
            if (homeData?.needRepay!!) {
                dataBing!!.tvTitle.text = "Repayment Amount"
                dataBing!!.tvMoney.text = "₹ ${homeData?.orderInfo?.repaymentAmount}"
            } else {
                dataBing!!.tvTitle.text = "Amount"
            }
        } else {
            dataBing!!.tvTitle.text = "Amount"
        }
        if(!homeData?.processList.isNullOrEmpty()){
            if (adapter===null) {
                adapter = ProgressAdapter()
                val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                dataBing!!.recyclerView.layoutManager = manager
                dataBing!!.recyclerView.adapter = adapter
            }
            adapter!!.setData(homeData?.processList?.toMutableList())
        }
    }

    private fun showRejectMore() {
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

        viewModel.getRejectData().observe(this, Observer {
            if (it != null&&it.openSwitch=="true") {
                setBtnTextAndColor(
                    "Get a new loan",
                    requireContext().resources.getColor(R.color.white),
                    canClick = true,
                    visible = true
                )
                moreRefuseTitle = it.title
                moreRefuseUrl = it.value
            } else {
                setBtnTextAndColor(
                    "REFUSED",
                    requireContext().resources.getColor(R.color.white),
                    canClick = false,
                    visible = true
                )
                moreRefuseTitle = ""
                moreRefuseUrl = ""
            }
        })
    }

    private fun showRepayMore() {
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

        viewModel.getRepayData().observe(this, Observer {
            if (it != null&& it.openSwitch == "true") {
                dataBing?.ivMore?.visibility = View.VISIBLE
                morePayTitle = it.title
                morePayUrl = it.value
            } else {
                dataBing?.ivMore?.visibility = View.GONE
                morePayTitle = ""
                morePayUrl = ""
            }
        })
    }

    private fun setBtnTextAndColor(
        message: String,
        color: Int,
        canClick: Boolean,
        visible: Boolean
    ) {
        dataBing?.btnApply.let {
            it?.text = message
            it?.setTextColor(color)
            it?.isEnabled = canClick
            it?.visibility = if (visible) View.VISIBLE else View.GONE
        }
    }
}
