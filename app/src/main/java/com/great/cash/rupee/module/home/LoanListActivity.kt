package com.great.cash.rupee.module.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.great.cash.rupee.R
import com.great.cash.rupee.module.model.LoanModel
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.databinding.ActLoanListBinding
import com.great.cash.rupee.module.adapter.LoanListAdapter

class LoanListActivity :
    BaseAct<ActLoanListBinding, LoanModel>(LoanModel::class.java),
    SwipeRefreshLayout.OnRefreshListener {
    private var adapter: LoanListAdapter? = null
    private var loadMore = false
    private var loadAll = false
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

        return R.layout.act_loan_list
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing!!.clickListener = this
        dataBing!!.refresh.setOnRefreshListener(this)
        dataBing!!.refresh.setColorSchemeColors(resources.getColor(R.color.colorAccent))
    }

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

        adapter = LoanListAdapter()
        val manager = LinearLayoutManager(this)
        dataBing!!.recyclerview.layoutManager = manager
        dataBing!!.recyclerview.adapter = adapter
        dataBing!!.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
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

                val lastPos: Int = manager.findLastVisibleItemPosition()
                debug("pos:$lastPos --list size:${adapter?.getData()?.size}")
                if (lastPos + 1 == adapter?.getData()?.size) {
                    if (!loadAll) {
                        loadData(true)
                    }
                }
            }
        })
        loadData(loadMore)
    }

    private fun loadData(loadMore: Boolean) {
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

        viewModel.loadLoan(loadMore).observe(this, Observer {
            dataBing!!.refresh.isRefreshing = false
            if (null != it) {
                if (it.loadMore) {
                    if (it.page?.isOver == true) {
                        loadAll = true
                    }
                    adapter?.addData(it.list)
                } else {
                    if (it.list.isNullOrEmpty()) {
                        dataBing?.reEmptyView?.visibility = View.VISIBLE
                    } else {
                        dataBing?.reEmptyView?.visibility = View.GONE
                        adapter?.setData(it.list)
                    }
                }
            } else {
                dataBing?.reEmptyView?.visibility = View.VISIBLE
            }
        })
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
            R.id.btn_apply -> {
                finish()
            }
        }
    }

    override fun onRefresh() {
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

        dataBing!!.refresh.isRefreshing = true
        loadData(false)
        loadAll = false
    }
}
