package com.great.cash.rupee.module.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.great.cash.rupee.entity.*
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseArrayObserver
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.ConstantsParams
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.utils.userRefreshToken
import com.great.cash.rupee.utils.userToken

class StartModel : BaseViewModel() {
    fun loadH5List(): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).helpList(),
            object : BaseArrayObserver<ProtocolResp?>() {
                override fun onSuccess(result: ListData<ProtocolResp?>?, page: PageBean?) {
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

                    result?.list?.map {
                        ConstantsParams.protocolRespList.add(
                            ProtocolResp(
                                it!!.name,
                                it.code,
                                it.value
                            )
                        )
                    }
                    debug(ConstantsParams.protocolRespList.toString())
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResultArray<ProtocolResp?>?) {
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

                    liveData.postValue(false)
                }
            })
        return liveData
    }

    fun checkState(): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .aLogin(AutoLogonReq(userRefreshToken!!)),
            object : BaseObserver<UserInfomationEntity?>() {
                override fun onSuccess(result: UserInfomationEntity?, msg: String?) {
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

                    userRefreshToken = result?.refreshToken
                    userToken = result?.token
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<UserInfomationEntity?>?) {
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

                    liveData.postValue(false)
                }
            })

        return liveData
    }
}
