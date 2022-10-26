package com.great.cash.rupee.module.adapter

import com.great.cash.rupee.R
import com.great.cash.rupee.entity.PermissionEntity
import com.great.cash.rupee.commonbase.BaseAdapter
import kotlinx.android.synthetic.main.layout_permission_item.view.*

class PermissionAdapter() : BaseAdapter<PermissionEntity>() {
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

        return R.layout.layout_permission_item
    }

    override fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int, t: PermissionEntity) {
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

        holder.itemView.iv_icon.setImageResource(t.resId)
        holder.itemView.tv_title.text = t.title
        if ("SMS" == t.title||"Contacts list"==t.title){
            holder.itemView.tv_des.setTextColor(context.resources.getColor(R.color.text_color12))
        }else{
            holder.itemView.tv_des.setTextColor(context.resources.getColor(R.color.text_color3))
        }
        holder.itemView.tv_des.text = t.des
    }
}
