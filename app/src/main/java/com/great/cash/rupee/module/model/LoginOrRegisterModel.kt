package com.great.cash.rupee.module.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appsflyer.AppsFlyerProperties
import com.great.cash.rupee.entity.*
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseArrayObserver
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.*

class LoginOrRegisterModel : BaseViewModel() {
    var phoneNumber: MutableLiveData<String> = MutableLiveData()

    fun checkPhone(phoneNumber: String?): LiveData<Boolean> {
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

        this.phoneNumber.value = phoneNumber!!
        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).isExists(
                PhoneStateReq(phoneNumber!!, ConstantsParams.imei!!)
            ), object : BaseObserver<PhoneStateEntity?>() {
                override fun onSuccess(result: PhoneStateEntity?, msg: String?) {
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

                    if (result?.isExists == PHONE_EXIST_CODE) {
                        liveData.postValue(true)
                    } else {
                        liveData.postValue(false)
                    }
                }

                override fun onFailed(result: BaseResult<PhoneStateEntity?>?) {
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

                    liveData.postValue(null)
                    showShort(result!!.msg)
                }
            })
        return liveData
    }
    fun loadH5List(): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).helpList(),
            object : BaseArrayObserver<ProtocolResp?>() {
                override fun onSuccess(result: ListData<ProtocolResp?>?, page: PageBean?) {
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

                    liveData.postValue(false)
                }
            })
        return liveData
    }
    fun logIn(phoneNumber: String?, pwd: String?): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        if (pwd.isNullOrEmpty()) {
            showShort("Please enter your password")
            liveData.postValue(false)
        }

        if (pwd!!.length < 6 || pwd!!.length > 16) {
            showShort("The length of the password is 6-16 bits")
            liveData.postValue(false)
        }
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).login(
            LogonReq(
                phoneNumber!!,
                MD5Util.encryptMD5(pwd)!!,
                ConstantsParams.imei!!,
                ConstantsParams.mac!!,
                AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID)
            )
        ),
            object : BaseObserver<UserInfomationEntity?>() {
                override fun onSuccess(result: UserInfomationEntity?, msg: String?) {
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

                    isLogin = true
                    userId = result!!.userId
                    userPhone = phoneNumber
                    userToken = result.token
                    userRefreshToken = result.refreshToken
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<UserInfomationEntity?>?) {
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

                    showShort(result!!.msg)
                    liveData.postValue(false)
                }
            })
        return liveData
    }

    fun changePwd(oldPwd: String, newPwd: String): LiveData<Boolean> {
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
            NetworkStart.createApi(CommonApi::class.java)
            .changeLoginPwd(PasswardReq(oldPwd, newPwd)),
            object : BaseObserver<String?>() {
                override fun onSuccess(result: String?, msg: String?) {
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

                    showShort(msg)
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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

                    showShort(result?.msg)
                    liveData.postValue(false)
                }
            })
        return liveData
    }

    fun register(
        phoneNumber: String?,
        pwd: String,
        code: String,
        gpsAdid: String
    ): LiveData<Boolean> {
        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .register(RegReq(phoneNumber, pwd, code, gpsAdid,AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID))),
            object : BaseObserver<UserInfomationEntity?>() {
                override fun onSuccess(result: UserInfomationEntity?, msg: String?) {
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

                    showLong("Congratulations on successful registration")
                    isLogin = true
                    userId = result?.userId
                    userToken = result?.token
                    userRefreshToken = result?.refreshToken
                    userPhone = phoneNumber
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<UserInfomationEntity?>?) {
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
                    liveData.postValue(false)
                }

            })
        return liveData
    }

    fun getPhoneCode(phoneNumber: String?, type: String): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        val sms = MsgCodeReq(
            phoneNumber!!,
            MD5Util.encryptMD5(MD5Util.APP_KEY + phoneNumber + type),
            type
        )
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).sendSms(sms),
            object : BaseObserver<MsgResp?>() {
                override fun onSuccess(result: MsgResp?, msg: String?) {
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

                    showShort(result?.message)
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<MsgResp?>?) {
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
                    liveData.postValue(false)
                }

            })
        return liveData
    }

    fun forgotPwd(phoneNumber: String?, pwd: String, code: String): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        val smsCodeReq = MsgCodeReq(
            phoneNumber,
            MD5Util.encryptMD5(MD5Util.APP_KEY + phoneNumber + SMS_TYPE_REGISTER),
            "",
            MD5Util.encryptMD5(pwd),
            pwd,
            code
        )
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).forgotPwd(smsCodeReq),
            object : BaseObserver<String?>() {
                override fun onSuccess(result: String?, msg: String?) {
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

                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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
                    liveData.postValue(false)
                }

            })
        return liveData
    }
}
