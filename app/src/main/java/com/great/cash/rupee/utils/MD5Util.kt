package com.great.cash.rupee.utils

import android.util.Base64
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object MD5Util {
    const val APP_KEY_PRO = "LjsiLOSNPwlsiodalkshiIM9Clpipltu"
    const val APP_KEY_DEBUG = "tTKCMaugwk1QDf5mBdRlxIM9CAsuORWH"
    var APP_KEY = if (Constant.debug) APP_KEY_DEBUG else APP_KEY_PRO

    /**
     * 字符串加密md5
     * @param src str
     * @return String
     */
    fun encryptMD5(src: String): String? {
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

        debug(src)
        val md: MessageDigest = try {
            MessageDigest.getInstance("MD5")
        } catch (e: NoSuchAlgorithmException) {
            return null
        }
        val b = md.digest(src.toByteArray())
        val buf = StringBuilder()
        var i: Int
        var offset = 0
        val l = b.size
        while (offset < l) {
            i = b[offset].toInt()
            if (i < 0) i += 256
            if (i < 16) buf.append("0")
            buf.append(Integer.toHexString(i))
            offset++
        }
        return buf.toString().toUpperCase()
    }

    /**
     * 字符Base64加密
     *
     * @param str str
     * @return String
     */
    fun encodeToString(str: String): String {
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

        return Base64.encodeToString(str.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT)
    }

    /**
     * 字符Base64解密
     *
     * @param str str
     * @return String
     */
    fun decodeToString(str: String): String {
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

        return String(Base64.decode(str.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT))
    }
}
