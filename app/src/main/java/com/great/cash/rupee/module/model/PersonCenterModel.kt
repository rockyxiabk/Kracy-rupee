package com.great.cash.rupee.module.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.great.cash.rupee.entity.BaseResult
import com.great.cash.rupee.entity.UserAuthResp
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.showShort

class PersonCenterModel : BaseViewModel() {

    fun getCreditInfo(): LiveData<UserAuthResp> {
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

        val liveData = MutableLiveData<UserAuthResp>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
                .userAuth,
            object : BaseObserver<UserAuthResp?>() {
                override fun onSuccess(result: UserAuthResp?, msg: String?) {
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

                    liveData.postValue(result)
                }

                override fun onFailed(result: BaseResult<UserAuthResp?>?) {
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

                    showShort(result?.msg)
                }
            })
        return liveData
    }
}
