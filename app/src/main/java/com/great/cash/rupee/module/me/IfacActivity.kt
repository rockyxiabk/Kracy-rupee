package com.great.cash.rupee.module.me

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.BankBranchResp
import com.great.cash.rupee.module.model.CardModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.BaseAdapter
import com.great.cash.rupee.databinding.ActIfscBinding
import kotlinx.android.synthetic.main.ifsc_item_layout.view.*

class IfacActivity : BaseAct<ActIfscBinding, CardModel>(CardModel::class.java) {
    var adapter: Adapter? = null
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

        return R.layout.act_ifsc
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

        val m = windowManager
        val d = m.defaultDisplay //为获取屏幕宽、高

        val p = window.attributes //获取对话框当前的参数值

        p.height = (d.height * 0.8).toInt() //高度设置为屏幕的0.6

        p.width = d.width
        p.alpha = 1.0f //设置本身透明度

        p.dimAmount = 0.5f //设置窗口外黑暗度

        window.attributes = p
        window.setGravity(Gravity.BOTTOM)
        window.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        setLightBar(true)
        adapter = Adapter();
        dataBing?.recyclerCode?.layoutManager = LinearLayoutManager(this)
        dataBing?.recyclerCode?.adapter = adapter
        adapter?.item = object : Item {
            override fun Item(data: BankBranchResp?) {
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

                if (data?.grade === 1) {
                    dataBing?.tvData1?.text = data.name
                    dataBing?.tvData1?.visibility = View.VISIBLE
                    dataBing?.tvData2?.visibility = View.GONE
                    dataBing?.tvData3?.visibility = View.GONE
                } else if (data?.grade === 2) {
                    dataBing?.tvData2?.text = data.name
                    dataBing?.tvData1?.visibility = View.VISIBLE
                    dataBing?.tvData2?.visibility = View.VISIBLE
                } else if (data?.grade === 3) {
                    dataBing?.tvData3?.text = data.name
                    dataBing?.tvData3?.visibility = View.VISIBLE
                } else {
                    val intent = Intent()
                    intent.putExtra("code", data?.ifsc)
                    setResult(RESULT_OK, intent)
                    finish()
                }
                data?.id?.let { getListData(it) }
            }
        }
    }

    override fun initData() {
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

        getListData(0);
    }

    fun getListData(id: Int) {
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

        viewModel.getCodeList(id).observe(this, Observer {
            adapter?.setData(it)
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

    }

    interface Item {
        fun Item(data: BankBranchResp?)
    }

    class Adapter : BaseAdapter<BankBranchResp?>() {
        var item: Item? = null
        override fun getLayoutId(viewType: Int): Int {
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

            return R.layout.ifsc_item_layout
        }

        override fun onBindViewHolderImpl(
            holder: BaseViewHolder,
            position: Int,
            t: BankBranchResp?
        ) {
            holder.itemView.desc.text = t?.address
            holder.itemView.title.text = t?.name
            holder.itemView.setOnClickListener {
                if (item != null) {
                    item?.Item(t)
                }
            }
        }
    }

}
