package com.great.cash.rupee.module.model

import androidx.lifecycle.MutableLiveData
import com.great.cash.rupee.entity.*
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.utils.showShort

class BaseInfoModel : BaseViewModel() {
    fun saveInfo(
        fir: String,
        middle: String,
        last: String,
        edu: String,
        acc: String,
        num: String,
        loan: String,
        marital: String,
        email: String,
        occupation: String,
        sarlary: String,
        method: String
    ):MutableLiveData<Boolean>{
        var data = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
                .personalInfoAuthSave(PelopleAuthReq(fir,middle,last,edu,acc,num,loan,marital,email,occupation,sarlary,method)),
            object : BaseObserver<String?>() {
                override fun onSuccess(result: String?, msg: String?) {
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

                    data.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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
                    statisticsEvent(EventParams.EVENT_INFO_FAILED, EventParams.EVENT_INFO_FAILED_DESC+result?.msg)
                    data.postValue(false)
                }
            }
        )
        return data
    }

    fun getSelectData(): MutableLiveData<DictListResp> {
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

        var data = MutableLiveData<DictListResp>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
                .dictList(
                    "EDUCATIONAL_STATE,MARITAL_STATE,ACCOMMODATION_TYPE,POSITION," +
                            "LOAN_PURPOSE,SALARY_RANGE,CHILDREN_NUMBER,SALARY_TYPE"
                ),
            object : BaseObserver<DictListResp?>() {
                override fun onSuccess(result: DictListResp?, msg: String?) {
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

                    data.postValue(result)
                }

                override fun onFailed(result: BaseResult<DictListResp?>?) {
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

                    showShort(result?.msg)
                }
            }
        )
        return data;
    }

    fun getInfoData(): MutableLiveData<PersonalAuthResp> {
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

        var data = MutableLiveData<PersonalAuthResp>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .personalInfoAuthInfo(),
            object : BaseObserver<PersonalAuthResp?>() {
                override fun onSuccess(result: PersonalAuthResp?, msg: String?) {
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

                    data.postValue(result)
                }

                override fun onFailed(result: BaseResult<PersonalAuthResp?>?) {
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
                }

            })
        return data
    }
}
