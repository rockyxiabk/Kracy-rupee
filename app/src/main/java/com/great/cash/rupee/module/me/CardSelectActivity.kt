package com.great.cash.rupee.module.me

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.BankResp
import com.great.cash.rupee.module.model.CardModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.BaseAdapter
import com.great.cash.rupee.databinding.ActSelectCadrBinding
import com.great.cash.rupee.module.home.LauncherActivity
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.view.dialog.DialogUtil
import kotlinx.android.synthetic.main.card_item_layout.view.*

class CardSelectActivity :
    BaseAct<ActSelectCadrBinding, CardModel>(CardModel::class.java) {
    var cardAdapter: Cardadapter? = null
    var borrowId: String? = null
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

        return R.layout.act_select_cadr
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
        cardAdapter = Cardadapter( object : ConfirmListener {
            override fun confirm(bank: BankResp) {
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

                DialogUtil.showCancelConfirmDialog(this@CardSelectActivity,
                    "Are you sure to set this card as the default payment card?",
                    View.OnClickListener {
                        changeBank(bank);
                    },
                    View.OnClickListener { })
            }
        });
        dataBing?.recyclerView?.adapter = cardAdapter
        dataBing?.recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    private fun changeBank(bank: BankResp) {
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

        viewModel.changeBank(bank).observe(this, Observer {
            if (it) {
                getListData()
            }
        })
    }

    override fun initData() {
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

        borrowId = intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString(
            Constant.DATA
        )
    }

    override fun onViewClick(view: View?) {
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

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.tv_add -> {
                toOtherActivity(NewCardActivity::class.java)
            }
        }
    }

    fun getChooseId(): String? {
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

        cardAdapter?.list?.map {
            if (it?.status.equals("1")) {
                return it?.id
            }
        }
        return null
    }

    override fun onResume() {
        super.onResume()
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

        getListData()
    }

    private fun getListData() {
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

        showDialog()
        viewModel.getListData().observe(this, Observer {
            dismissDialog()
            if (it.isEmpty()) {
                dataBing?.recyclerView?.visibility = View.GONE
            } else {
                dataBing?.recyclerView?.visibility = View.VISIBLE
                cardAdapter?.setData(it)
            }
        })
    }

    class Cardadapter(listener: ConfirmListener) : BaseAdapter<BankResp?>() {
        private var listener: ConfirmListener = listener
        override fun getLayoutId(viewType: Int): Int {
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

            return R.layout.card_item_layout
        }

        override fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int, data: BankResp?) {
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

            holder.itemView.bank_name.text = data?.bankName
            holder.itemView.bank_no.text = data?.account
            if (data?.status.equals("1"))
                holder.itemView.iv_select.visibility = View.VISIBLE
            else
                holder.itemView.iv_select.visibility = View.INVISIBLE
            holder.itemView.setOnClickListener(View.OnClickListener {
                if (data != null) {
                    listener.confirm(data)
                }
            })
        }
    }

    interface ConfirmListener {
        fun confirm(bank: BankResp);
    }
}
