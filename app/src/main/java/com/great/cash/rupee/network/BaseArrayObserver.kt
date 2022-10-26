package com.great.cash.rupee.network

import android.view.View
import com.great.cash.rupee.App
import com.great.cash.rupee.entity.BaseResultArray
import com.great.cash.rupee.entity.ListData
import com.great.cash.rupee.entity.LowEvent
import com.great.cash.rupee.entity.PageBean
import com.great.cash.rupee.utils.SpUtil
import com.great.cash.rupee.utils.goLogin
import com.great.cash.rupee.view.dialog.DialogUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus

abstract class BaseArrayObserver<T> : Observer<BaseResultArray<T>> {
    abstract fun onSuccess(result: ListData<T>?, page: PageBean?)
    abstract fun onFailed(result: BaseResultArray<T>?)
    override fun onComplete() {}
    override fun onNext(result: BaseResultArray<T>) {
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

        when (result.code) {
            200 -> onSuccess(result.data, result.page)
            411, 412 -> {
                SpUtil.clearSP(SpUtil.USER)
                goLogin(App.instance!!)
            }
            410, 413 -> {
                showLoginDialog();
            }
            414 -> {
                showLowDialog(result)
            }
            else -> onFailed(result)
        }
    }

    private fun showLoginDialog() {
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

        DialogUtil.showCancelConfirmDialog(
            App.activity,
            "Your account was just signed in on a new device. If it is not your operation, please change your password in time",
            View.OnClickListener {
                SpUtil.clearSP(SpUtil.USER)
                goLogin(App.instance!!)
            },
            View.OnClickListener {
                SpUtil.clearSP(SpUtil.USER)
                goLogin(App.instance!!)
            })
    }

    private fun showLowDialog(result: BaseResultArray<T>) {
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

        EventBus.getDefault().post(LowEvent(result.msg))
    }

    override fun onError(e: Throwable) {
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

        val result = BaseResultArray<T>()
        result.code = 400
        result.msg = e.message
        onFailed(result)
    }

    override fun onSubscribe(d: Disposable) {}
}
