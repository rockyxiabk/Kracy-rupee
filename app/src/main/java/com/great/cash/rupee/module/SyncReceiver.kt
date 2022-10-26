package com.great.cash.rupee.module

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.great.cash.rupee.entity.BaseResult
import com.great.cash.rupee.entity.SaveStateReq
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.userId

class SyncReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
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

        val synced = intent!!.getBooleanExtra("SyncedState", false)
        val message = intent.getStringExtra("SyncedMsg")
        val borrowId = intent.getStringExtra("SyncedBorrowId")
        val type = intent.getStringExtra("SyncedType")
        val code = intent.getIntExtra("SyncedCode", 0)
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
                .uploadState(SaveStateReq(code.toString(), message, type, if (synced) "1" else "2", borrowId, userId)),
            object : BaseObserver<String?>() {
                override fun onSuccess(result: String?, msg: String?) {
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

                }

                override fun onFailed(result: BaseResult<String?>?) {
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

                }
            })
    }
}
