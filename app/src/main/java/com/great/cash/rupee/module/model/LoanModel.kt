package com.great.cash.rupee.module.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.great.cash.rupee.entity.*
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseArrayObserver
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.*

class LoanModel : BaseViewModel() {
    private var page = 0
    private var pagerSize = 0

    fun loadLoan(loadMore: Boolean): MutableLiveData<LoadRespData?> {
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

        val liveData = MutableLiveData<LoadRespData?>()
        if (loadMore) {
            page++
        } else {
            page = 1
            pagerSize = 10
        }
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).payList(
                PageReq("$page", "$pagerSize")
            ), object : BaseArrayObserver<LendResp?>() {
                override fun onSuccess(result: ListData<LendResp?>?, page: PageBean?) {
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

                    var list = mutableListOf<LendResp?>()
                    result?.list?.let { list.addAll(it) }
                    liveData.postValue(LoadRespData(list, page, loadMore))
                }

                override fun onFailed(result: BaseResultArray<LendResp?>?) {
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

                    showShort(result?.msg)
                    liveData.postValue(null)
                }
            }
        )
        return liveData
    }

    fun updateCachState(appsFlyerUID: String?, data: String?, code: Int): MutableLiveData<Boolean>  {
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

        var value = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).updateCachState(
                CachReq(appsFlyerUID, data, "$code")
            ), object : BaseObserver<Void?>() {
                override fun onSuccess(result: Void?, msg: String?) {
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

                    value.postValue(true)
                }

                override fun onFailed(result: BaseResult<Void?>?) {
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

                    value.postValue(false)
                }
            })
        return value
    }

    fun applyAmount(riskType: String, appName: String): LiveData<ApplyLendResp> {
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

        val liveData = MutableLiveData<ApplyLendResp>()
        val req = ApplyLendReq(
            "android",
            LocationUtil.detailAddress,
            "${LocationUtil.longitude},${LocationUtil.latitude}",
            ConstantsParams.ip,
            ConstantsParams.imei,
            "${System.currentTimeMillis() - appRunTime}",
            riskType,
            appName
        )
        errorLog(req.toString())
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).applyMoney(req),
            object : BaseObserver<ApplyLendResp?>() {
                override fun onSuccess(result: ApplyLendResp?, msg: String?) {
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

                    liveData.postValue(result)
                }

                override fun onFailed(result: BaseResult<ApplyLendResp?>?) {
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

                    showShort(result?.msg)
                    liveData.postValue(null)
                }
            })
        return liveData
    }

    fun getLoanInfo(): LiveData<HomeOrderInfoBean> {
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

        val liveData = MutableLiveData<HomeOrderInfoBean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).getLoanInfo(NPReq()),
            object : BaseObserver<HomeOrderInfoBean?>() {
                override fun onSuccess(result: HomeOrderInfoBean?, msg: String?) {
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

                    liveData.postValue(result)
                }

                override fun onFailed(result: BaseResult<HomeOrderInfoBean?>?) {
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

                    showShort(result?.msg)
                    liveData.postValue(null)
                }
            })
        return liveData
    }
}
