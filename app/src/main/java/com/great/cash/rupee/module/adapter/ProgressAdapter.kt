package com.great.cash.rupee.module.adapter

import android.view.View
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.HomeLoan
import com.great.cash.rupee.commonbase.BaseAdapter
import kotlinx.android.synthetic.main.layout_item_progress.view.*

class ProgressAdapter : BaseAdapter<HomeLoan>() {
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

        return R.layout.layout_item_progress
    }

    override fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int, t: HomeLoan) {
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

        if (holder.adapterPosition == getData().size - 1) {
            holder.itemView.v_line.visibility = View.GONE
        } else {
            holder.itemView.v_line.visibility = View.VISIBLE
        }
        holder.itemView.tv_title.text = t.str
        holder.itemView.tv_desc.text = t.createTimeStr
    }
}
