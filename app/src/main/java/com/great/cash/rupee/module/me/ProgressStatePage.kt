package com.great.cash.rupee.module.me

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.HomeLoan
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActProgressStateBinding
import com.great.cash.rupee.module.adapter.ProgressAdapter
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.debug

class ProgressStatePage :
    BaseAct<ActProgressStateBinding, BaseViewModel>(BaseViewModel::class.java) {
    private var homeLoanList = mutableListOf<HomeLoan>()
    private var adapter: ProgressAdapter? = null
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

        return R.layout.act_progress_state
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
        adapter = ProgressAdapter()
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        dataBing!!.recyclerView.layoutManager = manager
        dataBing!!.recyclerView.adapter = adapter
    }

    override fun initData() {
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

        val bundleExtra = intent.getBundleExtra(Constant.BUNDLE_DATA)
        homeLoanList =
            (bundleExtra?.getSerializable(Constant.DATA) as List<HomeLoan>).toMutableList()
        debug(homeLoanList.size)
        adapter!!.setData(homeLoanList)
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

        finish()
    }
}
