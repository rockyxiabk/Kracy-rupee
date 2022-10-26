package com.great.cash.rupee.module.model

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.great.cash.rupee.entity.*
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseObserver
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.network.CommonApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.net.URLDecoder
import java.util.*
import kotlin.collections.HashMap

class PersonModel : BaseViewModel() {

    fun getPerinfo(): LiveData<AuthInfoResp> {
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

        val liveData = MutableLiveData<AuthInfoResp>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
                .realNameAuthInfo(),
            object : BaseObserver<AuthInfoResp?>() {
                override fun onSuccess(result: AuthInfoResp?, msg: String?) {
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

                    liveData.postValue(result)
                }

                override fun onFailed(result: BaseResult<AuthInfoResp?>?) {
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
                }
            })
        return liveData
    }

    fun getFaceScore(livenessId: String?): LiveData<Boolean>{
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

        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).getFaceScore(livenessId),
            object : BaseObserver<FaceScoreResponse?>() {
                override fun onSuccess(result: FaceScoreResponse?, msg: String?) {
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

                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResult<FaceScoreResponse?>?) {
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

                    showShort(result?.msg)
                }
            })
        return liveData
    }
    fun getCardInfo(imageType: Int, file: File): LiveData<CardInfoResp> {
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

        var data = MutableLiveData<CardInfoResp>()
        var map = TreeMap<String, Any?>()
        map["image"] = file
        when (imageType) {
            1011 -> {
                map["imageType"] = "AADHAAR_FRONT"
            }
            1012 -> {
                map["imageType"] = "AADHAAR_BACK"
            }
            1013 -> {
                map["imageType"] = "PAN_FRONT"
            }
        }
        var header = HashMap<String, String?>()
        header["token"] = userToken
        header["signMsg"] = getSignMsg(map)
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .getCardInfo(header, getRequestBody(map)),
            object : BaseObserver<CardInfoResp?>() {
                override fun onSuccess(CardInfoResp: CardInfoResp?, msg: String?) {
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

                    CardInfoResp?.type = imageType
                    CardInfoResp?.success = true
                    data.postValue(CardInfoResp)
                }

                override fun onFailed(result: BaseResult<CardInfoResp?>?) {
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
                    var info = CardInfoResp()
                    info.type = imageType
                    info.success = false
                    info.msg = result?.msg
                    data.postValue(info)
                }
            })
        return data
    }

    fun matchFace(frontPaht: File, panPaht: File, facePaht: File): LiveData<Boolean> {
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

        var ta = MutableLiveData<Boolean>()
        val map = TreeMap<String, Any?>()
        map["adImage"] = frontPaht
        map["panImage"] = panPaht
        map["faceImage"] = facePaht
        var header = HashMap<String, String?>()
        header["token"] = userToken
        header["signMsg"] = getSignMsg(map)
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .matchFaceAndImage(header, getRequestBody(map)),
            object : BaseObserver<String?>() {
                override fun onSuccess(result: String?, msg: String?) {
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

                    ta.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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
                    ta.postValue(false)
                }
            })
        return ta
    }

    fun checkScore(aadScore: Int, panScore: Int): LiveData<Boolean> {
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

        var ta = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).userFaceMatch(panScore, aadScore),
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

                    ta.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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

                    ta.postValue(false)
                }
            }
        )
        return ta
    }

    fun saveInfo(
        nameStr: String,
        panNoString: String,
        aadString: String,
        birthString: String,
        sexString: String,
        pinString: String,
        addString: String,
        frontJson: String?,
        backJson: String?,
        panJson: String?,
        frontPaht: File?,
        backPaht: File?,
        panPaht: File?,
        facePaht: File?
    ): MutableLiveData<Boolean> {
        var data = MutableLiveData<Boolean>()

        var map = TreeMap<String, Any?>()
        map["realName"] = nameStr
        map["idNo"] = aadString
        map["dateOfBirth"] = birthString
        map["gender"] = sexString
        map["pinCode"] = pinString
        map["idAddr"] = addString
        map["panCode"] = panNoString
        map["adBackJson"] = backJson
        map["adFrontJson"] = frontJson
        map["panJson"] = panJson
        map["frontImg"] = frontPaht
        map["backImg"] = backPaht
        map["panImg"] = panPaht
        map["livingImg"] = facePaht
        map["mobileType"] = "2"
        var header = HashMap<String, String?>()
        header["token"] = userToken
        header["signMsg"] = getSignMsg(map)
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .realNameAuthSave(header, getRequestBody(map)),
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

                    data.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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

                    showShort(result?.msg)
                    data.postValue(false)
                    statisticsEvent(EventParams.EVENT_OCR_FAILED, EventParams.EVENT_OCR_FAILED_DESC)
                }
            })
        return data
    }

    fun getRequestBody(map: Map<String, Any?>): Map<String, RequestBody>? {
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

        val params: MutableMap<String, RequestBody> =
            java.util.HashMap()
        for ((key, value) in map) {
            if (TextUtils.isEmpty(key) || null == value) {
                continue
            }
            if (value is File) {
                val file = value
                params[key.toString() + "\"; filename=\"" + file.name + ""] =
                    RequestBody.create(MultipartBody.FORM, file)
            } else {
                params[key as String] = RequestBody.create(MultipartBody.FORM, (value as String?)!!)
            }
        }
        return params
    }

    fun getSignMsg(bodyParamsMap: TreeMap<String, Any?>): String {
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

        var map = TreeMap<String, Any?>(bodyParamsMap)
        map["userId"] = userId
        map["token"] = userToken
        map["mobileType"] = "2"
        map["appFlag"] = Constant.APP_NAME
        map["versionNumber"] = Constant.APP_VERSION
        map["channelCode"] = Constant.CHANNEL_VALUE
        var sign = ""
        try {
            val it: Iterator<*> = map.entries.iterator()
            val sb = StringBuilder()
            while (it.hasNext()) {
                val entry = it.next() as Map.Entry<*, *>
                if (entry.value is File) continue  //URLEncoder.encode(, "UTF-8")
                sb.append(entry.key).append("=")
                    .append(URLDecoder.decode(entry.value.toString(), "UTF-8")).append("|")
            }
            sign = if (sb.toString().length > 1) {
                sb.toString().substring(0, sb.length - 1)
            } else {
                sb.toString()
            }
            sign = MD5Util.encryptMD5(MD5Util.APP_KEY + userToken + sign)!!
        } catch (e: Exception) {
            e.printStackTrace()
            sign = ""
        }
        return sign
    }

    fun submitFeedback(content:String, pathList: ArrayList<String>): LiveData<Boolean> {
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

        var ta = MutableLiveData<Boolean>()
        val map = TreeMap<String, Any?>()
        for (i in pathList.indices) {
            val file = File(pathList[i])
            when (i) {
                0 -> {
                    map["opinionImgFir"]=file
                }
                1 -> {
                    map["opinionImgSec"]=file
                }
                2->{
                    map["opinionImgThr"]=file
                }
            }
        }
        map["opinion"] = content
        var header = HashMap<String, String?>()
        header["token"] = userToken
        header["signMsg"] = getSignMsg(map)
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java)
            .submitFeedback(header, getRequestBody(map)),
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

                    ta.postValue(true)
                }

                override fun onFailed(result: BaseResult<String?>?) {
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
                    ta.postValue(false)
                }
            })
        return ta
    }
}
