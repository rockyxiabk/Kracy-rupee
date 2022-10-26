package com.great.cash.rupee.network

import android.text.TextUtils
import com.google.gson.Gson
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.utils.MD5Util.encryptMD5
import okhttp3.*
import okio.Buffer
import java.io.File
import java.io.IOException
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.*

class SignInterceptor : Interceptor {
    var headerParamsMap: MutableMap<String, String> = HashMap()
    var commomParams: TreeMap<String?, String?> = TreeMap()

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
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

        var request = chain.request()
        val requestBuilder = request.newBuilder()
        val headerBuilder = request.headers.newBuilder()

        headerParamsMap.clear()
        commomParams.clear()
        commomParams["mobileType"] = "2"
        commomParams["versionNumber"] = ConstantsParams.versionName
        commomParams["appFlag"] = Constant.APP_NAME
        commomParams["channelCode"] = Constant.CHANNEL_VALUE
        if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(userPhone)) {
            commomParams["userId"] = userId
            commomParams["token"] = userToken
        }

        //set signMsg
        debug(request.method)
        headerParamsMap.clear()
        headerParamsMap = if (request.method == "POST") {
            if (null != request.body && request.body is MultipartBody) {
                signHeadParams(commomParams)
            } else {
                val signMap: SortedMap<String?, String?> = TreeMap(commomParams)
                val bodyToMap = requestBodyToMap(request.body)
                if (bodyToMap!!.isNotEmpty()) {
                    bodyToMap.entries.forEach {
                        signMap[it.key.toString()] = it.value.toString()
                    }
                }
                signHeadParams(signMap)
            }
        } else {
            signHeadParams(getUrlToMap(request.url.toString(), commomParams))
        }

        //set header
        if (headerParamsMap.isNotEmpty()) {
            for ((key, value) in headerParamsMap) {
                headerBuilder.add(key, value)
            }
        }
        debug("header:$headerParamsMap")
        requestBuilder.headers(headerBuilder.build())

        //set body
        if (request.method == "POST") {
            if (null != request.body && request.body is MultipartBody) {
                val multipartBodyBuilder = MultipartBody.Builder()
                multipartBodyBuilder.setType(MultipartBody.FORM)
                // add new params to new multipartBodyBuilder
                if (commomParams.size > 0) {
                    for ((key, value) in commomParams) {
                        multipartBodyBuilder.addFormDataPart(key!!, value!!)
                    }
                }
                // add old parts to new multipartBodyBuilder
                for (part in (request.body as MultipartBody?)!!.parts) {
                    multipartBodyBuilder.addPart(part)
                }
                requestBuilder.post(multipartBodyBuilder.build())
                debug("request multipartBody:")
            } else {
                val formBodyBuilder = FormBody.Builder()
                // add new params to new formBodyBuilder
                if (commomParams.size > 0) {
                    for ((key, value) in commomParams) {
                        formBodyBuilder.add(key!!, value!!)
                    }
                }
                // add old params to new formBodyBuilder
                val formBody = formBodyBuilder.build()
                val finalBodyMap: SortedMap<String?, String?> = TreeMap()
                val bodyToMap = requestBodyToMap(request.body)
                if (bodyToMap!!.isNotEmpty()) {
                    bodyToMap.entries.forEach {
                        finalBodyMap[it.key.toString()] = it.value.toString()
                    }
                }
                if (commomParams!!.isNotEmpty()) {
                    commomParams.entries.forEach {
                        finalBodyMap[it.key.toString()] = it.value.toString()
                    }
                }
                val postParamsStr = getPostParamsStr(finalBodyMap)
                requestBuilder.post(RequestBody.create(formBody.contentType(), postParamsStr))
                debug("request body:$postParamsStr")
            }
        } else {
            injectParamsIntoUrl(request, requestBuilder, commomParams)
        }
        request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun signHeadParams(bodyParamsMap: SortedMap<String?, String?>): SortedMap<String, String> {
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

        val sign = mapToSignMsg(bodyParamsMap)
        val headMap: SortedMap<String, String> = TreeMap()
        headMap["signMsg"] = sign
        headMap["token"] = userToken
        return headMap
    }

    private fun mapToSignMsg(bodyParamsMap: SortedMap<String?, String?>): String {
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

        var sign = ""
        try {
            val it: Iterator<*> = bodyParamsMap.entries.iterator()
            val sb = StringBuilder()
            while (it.hasNext()) {
                val entry = it.next() as Map.Entry<*, *>
                if (entry.value is File) continue  //URLEncoder.encode(, "UTF-8")
                sb.append(entry.key).append("=")
                    .append(entry.value.toString()).append("|")
            }
            sign = if (sb.toString().length > 1) {
                sb.toString().substring(0, sb.length - 1)
            } else {
                sb.toString()
            }
            sign = encryptMD5(MD5Util.APP_KEY + userToken + sign)!!
        } catch (e: Exception) {
            e.printStackTrace()
            sign = ""
        }
        return sign
    }

    private fun getUrlToMap(
        url: String,
        bodyParamsMap: SortedMap<String?, String?>
    ): SortedMap<String?, String?> {
        val signMap: SortedMap<String?, String?> = TreeMap()
        signMap.putAll(bodyParamsMap)
        if (url.split("\\?".toRegex()).toTypedArray().size > 1) {
            val paramStr = url.split("\\?".toRegex()).toTypedArray()[1]
            val params = paramStr.split("&".toRegex()).toTypedArray()
            var temp: SortedMap<String?, String?>
            for (i in params.indices) {
                temp = TreeMap()
                val s = params[i].split("=".toRegex()).toTypedArray()
                if (s.size > 1) {
                    temp[s[0]] = URLDecoder.decode(s[1], "UTF-8")
                } else {
                    temp[s[0]] = ""
                }
                signMap.putAll(temp)
            }
        }
        return signMap
    }

    // func to inject params into url
    private fun injectParamsIntoUrl(
        request: Request,
        requestBuilder: Request.Builder,
        paramsMap: Map<String?, String?>
    ) {
        val httpUrlBuilder = request.url.newBuilder()
        if (paramsMap.isNotEmpty()) {
            for ((key, value) in paramsMap) {
                httpUrlBuilder.addQueryParameter(key!!, value)
            }
        }
        requestBuilder.url(httpUrlBuilder.build())
    }

    private fun requestBodyToMap(requestBody: RequestBody?): SortedMap<*, *>? {
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

        return try {
            val buffer = Buffer()
            requestBody?.writeTo(buffer)
            val result = buffer.readUtf8()
            try {
                Gson().fromJson(result, SortedMap::class.java)
            } catch (e: Exception) {
                null
            }
        } catch (e: IOException) {
            null
        }
    }

    private fun getPostParamsStr(map: SortedMap<*, *>?): String {
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

        val it: Iterator<*> = map!!.entries.iterator()
        val sb = StringBuilder()
        try {
            while (it.hasNext()) {
                val entry = it.next() as Map.Entry<*, *>
                sb.append(entry.key).append("=")
                    .append(URLEncoder.encode(entry.value.toString(), "UTF-8")).append("&")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return if (sb.toString().length > 1) {
            sb.toString().substring(0, sb.length - 1)
        } else {
            sb.toString()
        }
    }
}
