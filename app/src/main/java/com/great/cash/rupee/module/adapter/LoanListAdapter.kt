package com.great.cash.rupee.module.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.LendResp
import com.great.cash.rupee.commonbase.BaseAdapter
import com.great.cash.rupee.module.home.RepayDetailActivity
import com.great.cash.rupee.module.home.RepayInfoActivity
import com.great.cash.rupee.utils.Constant
import kotlinx.android.synthetic.main.layout_item_loan_record.view.*

class LoanListAdapter : BaseAdapter<LendResp?>() {
    override fun getLayoutId(viewType: Int): Int {
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

        return R.layout.layout_item_loan_record
    }

    override fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int, lendResp: LendResp?) {
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

        holder.itemView.tv_money.text = "₹ " + lendResp?.amount
        holder.itemView.tv_date.text = "Application Date: " + lendResp?.createTimeStr
        when (lendResp?.state) {
            "40" -> { //还款成功
                holder.itemView.tv_state.text = "DONE"
                holder.itemView.tv_state.setTextColor(
                    context.resources.getColor(R.color.text_repay_done)
                )
                holder.itemView.btn_repay.visibility = View.GONE
            }
            "50" -> { //逾期
                holder.itemView.tv_state.text = "OVERDUE"
                holder.itemView.tv_state.setTextColor(
                    context.resources.getColor(R.color.text_error)
                )
                holder.itemView.btn_repay.visibility = View.VISIBLE
            }
            else -> { //待还款
                holder.itemView.tv_state.text = "REPAYING"
                holder.itemView.tv_state.setTextColor(
                    context.resources.getColor(R.color.text_orange)
                )
                holder.itemView.btn_repay.visibility = View.VISIBLE
            }
        }
        holder.itemView.card_item.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Constant.BORROW_ID, lendResp?.id)
            val intent = Intent(context, RepayInfoActivity::class.java)
            intent.putExtra(Constant.BUNDLE_DATA, bundle)
            context.startActivity(intent)
        }
        holder.itemView.btn_repay.setOnClickListener {
            //去还款
            val bundle = Bundle()
            bundle.putString(Constant.BORROW_ID, lendResp?.id)
            val intent = Intent(context, RepayDetailActivity::class.java)
            intent.putExtra(Constant.BUNDLE_DATA, bundle)
            context.startActivity(intent)
        }
    }
}
