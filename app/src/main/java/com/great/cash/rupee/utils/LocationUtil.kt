package com.great.cash.rupee.utils

import android.annotation.SuppressLint
import android.content.Context
import android.location.*
import android.util.Log
import java.util.*

object LocationUtil {
    var longitude = 0.0
    var latitude = 0.0
    var detailAddress = "unknown"

    @SuppressLint("MissingPermission")
    fun initLocation(context: Context) {
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

        val location = getLocation(context) ?: return
        latitude = location.latitude
        longitude = location.longitude
        detailAddress = getDetailAddress(context, location)
        Log.e(
            "-------?",
            "latitude:$latitude     longitude:$longitude   detailAddress:$detailAddress"
        )
    }

    @SuppressLint("MissingPermission")
    fun getLocation(context: Context): Location? {
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

        var location: Location? = null
        try {
            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {  //从gps获取经纬度
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (location == null) { //当GPS信号弱没获取到位置的时候再从网络获取
                    location = getLocationByNetwork(context)
                }
            } else {    //从网络获取经纬度
                location = getLocationByNetwork(context)
            }
        } catch (e: java.lang.Exception) {
            Log.e("--->", e.message!!)
        }
        return location
    }

    private fun getDetailAddress(context: Context, location: Location?): String {
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

        var result: List<Address>? = null
        try {
            if (location != null) {
                val gc = Geocoder(context, Locale.getDefault())
                result = gc.getFromLocation(
                    location.latitude,
                    location.longitude, 1
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "unKnown"
        }
        return if (result == null || result.isEmpty()) {
            "unKnown"
        } else {
            result[0].getAddressLine(0)
        }
    }

    /**
     * 获取地理位置，先根据GPS获取，再根据网络获取
     *
     * @return
     */
    @SuppressLint("MissingPermission")
    private fun getLocationByNetwork(context: Context): Location? {
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

        var location: Location? = null
        val locationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    1000,
                    0f,
                    LocationListener { }
                )
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            }
        } catch (e: java.lang.Exception) {
            Log.e("---->", e.message!!)
        }
        return location
    }
}
