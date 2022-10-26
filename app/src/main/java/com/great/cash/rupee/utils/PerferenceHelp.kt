package com.great.cash.rupee.utils

import android.content.Context
import android.content.SharedPreferences
import com.great.cash.rupee.App

object SpUtil {
    const val USER = "user"
    const val USER_TOKEN = "user_token"
    const val USER_REFRESH_TOKEN = "refresh_token"
    const val USER_PHONE = "user_phone"
    const val USER_ID = "user_id"
    const val USER_LOGIN = "user_login"
    const val APP_RUN_TIME = "app_run_time"
    const val APP_UUID = "app_uuid"
    const val USER_ImeI = "imei"
    const val IS_FIRST_SHOW = "is_first_show"
    private fun getSp(name: String): SharedPreferences {
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

        return App.instance!!.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    private fun getEditor(name: String): SharedPreferences.Editor {
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

        val preferences = getSp(name)
        return preferences.edit()
    }

    fun getString(name: String, keyName: String?): String? {
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

        return getSp(name).getString(keyName, "")
    }

    fun setString(name: String, keyName: String?, value: String?) {
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

        getEditor(name).putString(keyName, value).apply()
    }

    fun getLong(name: String, keyName: String?): Long {
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

        return getSp(name).getLong(keyName, 0L)
    }

    fun setLong(name: String, keyName: String?, value: Long) {
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

        getEditor(name).putLong(keyName, value).apply()
    }

    fun getInt(name: String, keyName: String?): Int {
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

        return getSp(name).getInt(keyName, 0)
    }

    fun setInt(name: String, keyName: String?, value: Int) {
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

        getEditor(name).putInt(keyName, value).apply()
    }

    fun getBoolean(name: String, keyName: String?): Boolean {
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

        return getSp(name).getBoolean(keyName, false)
    }

    fun setBoolean(name: String, keyName: String?, value: Boolean) {
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

        getEditor(name).putBoolean(keyName, value).apply()
    }

    fun clearSP(name: String) {
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

        getEditor(name).clear().apply()
    }
}

var isFirstShow: Boolean
    get() = SpUtil.getBoolean("setting", SpUtil.IS_FIRST_SHOW)
    set(login) {
        SpUtil.setBoolean("setting", SpUtil.IS_FIRST_SHOW, login)
    }
var userToken: String?
    get() = SpUtil.getString(SpUtil.USER, SpUtil.USER_TOKEN)
    set(userToken) {
        SpUtil.setString(SpUtil.USER, SpUtil.USER_TOKEN, userToken)
    }
var appRunTime: Long
    get() = SpUtil.getLong(SpUtil.USER, SpUtil.APP_RUN_TIME)
    set(appRunTime) {
        SpUtil.setLong(SpUtil.USER, SpUtil.APP_RUN_TIME, appRunTime)
    }
var uuid: String?
    get() = SpUtil.getString(SpUtil.USER, SpUtil.APP_UUID)
    set(uuid) {
        SpUtil.setString(SpUtil.USER, SpUtil.APP_UUID, uuid)
    }
var userPhone: String?
    get() = SpUtil.getString(SpUtil.USER, SpUtil.USER_PHONE)
    set(phoneNum) {
        SpUtil.setString(SpUtil.USER, SpUtil.USER_PHONE, phoneNum)
    }
var userId: String?
    get() = SpUtil.getString(SpUtil.USER, SpUtil.USER_ID)
    set(phoneNum) {
        SpUtil.setString(SpUtil.USER, SpUtil.USER_ID, phoneNum)
    }
var User_imei: String?
    get() = SpUtil.getString(SpUtil.USER, SpUtil.USER_ImeI)
    set(phoneNum) {
        SpUtil.setString(SpUtil.USER, SpUtil.USER_ImeI, phoneNum)
    }
var isLogin: Boolean
    get() = SpUtil.getBoolean(SpUtil.USER, SpUtil.USER_LOGIN)
    set(login) {
        SpUtil.setBoolean(SpUtil.USER, SpUtil.USER_LOGIN, login)
    }
var userRefreshToken: String?
    get() = SpUtil.getString(SpUtil.USER, SpUtil.USER_REFRESH_TOKEN)
    set(refreshToken) {
        SpUtil.setString(SpUtil.USER, SpUtil.USER_REFRESH_TOKEN, refreshToken)
    }

