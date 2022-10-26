package com.great.cash.rupee.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.os.storage.StorageManager
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.text.format.Formatter
import android.util.DisplayMetrics
import android.view.WindowManager
import com.appsflyer.AppsFlyerLib
import com.great.cash.rupee.App
import com.great.cash.rupee.entity.ProtocolResp
import com.google.android.gms.location.LocationServices
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

object ConstantsParams {
    var packageName: String? = null
    var versionName: String? = null
    var versionCode = 0
    var imei = ""
    var gpsAdid = ""
    var imsi: String? = null
    var net: String? = null
    var mac: String? = null
    var ip: String = ""
    var apn: String? = null
    var deviceId: String? = null
    var deviceBrand: String? = null
    var deviceOsVersion: String? = null
    var deviceModel: String? = null

    var androidId: String? = null
    var screenWidth = 0
    var screenHeight = 0
    var densityDpi = 0
    var totalSize: String? = null
    var availSize: String? = null
    var operatorName: String? = null
    var hasSdCard = false
    var serial: String? = null
    var language: String? = null
    var totalRomSize: String? = null
    var availableRomSize: String? = null

    /**
     * {"name":"Help Center","code":"h5_help","value":"/h5/help.htm?appFlag=100014"}
     * {"name":"Privacy Policy","code":"protocol_privacy","value":"/h5/protocol_privacy.jsp"},
     * {"name":"Terms of Service","code":"protocol_register","value":"/h5/protocol_register.jsp"}
     */
    val protocolRespList = mutableListOf<ProtocolResp>()
//    var altitude = 0.0
//    var latitude = 0.0
//    var detailAddress = ""
    var mContext: Context? = null

    @SuppressLint("MissingPermission")
    fun init(context: Context) {
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

        val packageManager = context.packageManager
        val packInfo: PackageInfo
        packageName = context.packageName
        mContext = context
        try {
            packInfo = packageManager.getPackageInfo(packageName!!, 0)
            versionName = packInfo.versionName
            versionCode = packInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            errorLog(e.toString())
        }
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        // getSimOperatorName就可以直接获取到运营商的名字
        operatorName = telephonyManager.simOperatorName
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        try {
            imsi = tm.subscriberId
        } catch (e: Exception) {
            errorLog(e.toString())
        }
        androidId = Settings.System.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        imei = getOnlyId(context)
        getGpsAdId(context);
        try {
            val buf = StringBuffer()
            var networkInterface: NetworkInterface? = null
            networkInterface = NetworkInterface.getByName("eth1")
            if (networkInterface == null) {
                networkInterface = NetworkInterface.getByName("wlan0")
            }
            mac = if (networkInterface == null) {
                "02:00:00:00:00:02"
            } else {
                val addr = networkInterface.hardwareAddress
                for (b in addr) {
                    buf.append(String.format("%02X:", b))
                }
                if (buf.length > 0) {
                    buf.deleteCharAt(buf.length - 1)
                }
                buf.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            mac = "02:00:00:00:00:02"
        }
        ip = try {
            getIp(context)
        } catch (e: Exception) {
            e.printStackTrace()
            "127.0.0.1"
        }
        deviceId = try {
            val manager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            manager.deviceId
        } catch (e: Exception) {
            ""
        }
        try {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                windowManager.defaultDisplay.getRealMetrics(displayMetrics)
            }
            screenWidth = displayMetrics.widthPixels
            screenHeight = displayMetrics.heightPixels
            densityDpi = displayMetrics.densityDpi
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            val path = Environment.getExternalStorageDirectory()
            val stat = StatFs(path.path)
            val blockSize = stat.blockSize.toLong()
            val totalBlocks = stat.blockCount.toLong()
            val availableBlocks = stat.availableBlocks.toLong()
            totalSize = Formatter.formatFileSize(context, totalBlocks * blockSize)
            availSize = Formatter.formatFileSize(context, availableBlocks * blockSize)
        } catch (e: Exception) {
            errorLog(e.toString())
        }
        try {
            val path = Environment.getDataDirectory()
            val stat = StatFs(path.path)
            val blockCount = stat.blockCount.toLong()
            val blockSize = stat.blockSize.toLong()
            val availableBlocks = stat.availableBlocks.toLong()
            totalRomSize = Formatter.formatFileSize(context, blockCount * blockSize)
            availableRomSize = Formatter.formatFileSize(context, blockCount * availableBlocks)
        } catch (e: Exception) {
            errorLog(e.toString())
        }
        try {
            val manager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetworkInfo
            if (networkInfo != null && networkInfo.isConnected) {
                net = networkInfo.typeName
                apn = networkInfo.extraInfo
            } else {
                net = ""
                apn = ""
            }
        } catch (e: Exception) {
            errorLog(e.toString())
        }
//        initLocation()
        hasSdCard = isSDMounted(context)
        deviceBrand = Build.BRAND
        serial = Build.SERIAL
        deviceOsVersion = Build.VERSION.RELEASE
        deviceModel = Build.MODEL
        language = Locale.getDefault().language
    }

    private fun getGpsAdId(context: Context) {
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

//        Adjust.getGoogleAdId(context, object : OnDeviceIdsRead {
//            override fun onGoogleAdIdRead(googleAdId: String?) {
//                googleAdId?.let {
//                    gpsAdid = it
//                    if (imei.isNullOrEmpty()) {
//                        gpsAdid?.let {
//                            imei = it
//                        }
//                    }
//                }
//            }
//        })
    }

    @SuppressLint("MissingPermission")
    private fun initLocation() {
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

        try {
            val locationProviderClient =
                LocationServices.getFusedLocationProviderClient(App.instance!!)
            locationProviderClient.lastLocation
                .addOnSuccessListener { location: Location? ->
//                    if (null != location) {
//                        altitude = location.longitude
//                        latitude = location.latitude
//                        detailAddress = getDetailAddress(location)
//                        errorLog("----latitude:$latitude---altitude:$altitude detailAddress：$detailAddress")
//                        errorLog(location.toString())
//                    } else {
//                        errorLog("location null")
//                        GeoInfo.initGeoInfo(App.instance!!)
//                    }
                }
        } catch (e: Exception) {
            errorLog(e.toString())
        }
    }

    private fun getDetailAddress(location: Location?): String {
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

        var result: List<Address>? = null
        try {
            if (location != null) {
                val gc = Geocoder(mContext, Locale.getDefault())
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

    private fun isSDMounted(context: Context): Boolean {
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
            val path = getStoragePath(context)
            !(!isSDCardMount() || TextUtils.isEmpty(path))
        } catch (e: Exception) {
            false
        }
    }

    private fun getOnlyId(context: Context): String {
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

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                return AppsFlyerLib.getInstance().getAppsFlyerUID(context)
            }
            val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return if (tm != null) {
                tm.deviceId
            } else {
                AppsFlyerLib.getInstance().getAppsFlyerUID(context)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return AppsFlyerLib.getInstance().getAppsFlyerUID(context)
        }
    }
    fun getDeviceUUID(): String {
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

        if (uuid.isNullOrEmpty()) {
            uuid = buildDeviceUUID()
        }
        return if (uuid.isNullOrEmpty()) "000000000000000" else uuid!!
    }

    fun getBuildInfo(): String? {
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

        //这里选用了几个不会随系统更新而改变的值
        val buildSB = StringBuffer()
        buildSB.append(Build.BRAND).append("/")
        buildSB.append(Build.PRODUCT).append("/")
        buildSB.append(Build.DEVICE).append("/")
        buildSB.append(Build.ID).append("/")
        buildSB.append(Build.VERSION.INCREMENTAL)
        return buildSB.toString()
    }
    private fun buildDeviceUUID(): String? {
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

        if ("9774d56d682e549c" == androidId) {
            val random = Random()
            androidId = (Integer.toHexString(random.nextInt())
                    + Integer.toHexString(random.nextInt())
                    + Integer.toHexString(random.nextInt()))
        }
        return UUID(androidId.hashCode().toLong(), getBuildInfo().hashCode().toLong()).toString()
    }

    fun isExtraSDCard(context: Context): Boolean {
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
            val path = getStoragePath(context)
            !(!isSDCardMount() || TextUtils.isEmpty(path))
        } catch (e: Exception) {
            false
        }
    }

    private fun isSDCardMount(): Boolean {
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

        return try {
            Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * 使用反射方法 获取手机存储路径
     */
    private fun getStoragePath(context: Context): String {
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

        try {
            val sm = context.getSystemService(Context.STORAGE_SERVICE) as StorageManager
            val getPathsMethod = sm.javaClass.getMethod(
                "getVolumePaths",
                String::class.java
            )
            val path = getPathsMethod.invoke(
                sm,
                Any::class.java
            ) as Array<String>
            return if (path.size > 1) {
                path[0]
            } else {
                ""
            }
        } catch (e: Exception) {
            errorLog(e.toString())
        }
        return ""
    }

    private fun getIp(context: Context): String {
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

        val info =
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        if (info != null && info.isConnected) {
            if (info.type == ConnectivityManager.TYPE_MOBILE) { //当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    val en = NetworkInterface.getNetworkInterfaces()
                    while (en.hasMoreElements()) {
                        val intf = en.nextElement()
                        val enumIpAddr = intf.inetAddresses
                        while (enumIpAddr.hasMoreElements()) {
                            val inetAddress = enumIpAddr.nextElement()
                            if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                                return inetAddress.getHostAddress()
                            }
                        }
                    }
                } catch (e: SocketException) {
                    return "192.168.1.1"
                }
            } else if (info.type == ConnectivityManager.TYPE_WIFI) { //当前使用无线网络
                val wifiManager =
                    App.instance!!.getSystemService(Context.WIFI_SERVICE) as WifiManager
                val wifiInfo = wifiManager.connectionInfo
                return iP2StringIP(wifiInfo.ipAddress)
            }
        } else {
            return "192.168.1.1"
        }
        return "192.168.1.1"
    }

    private fun iP2StringIP(ip: Int): String {
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

        return (ip and 0xFF).toString() + "." +
                (ip shr 8 and 0xFF) + "." +
                (ip shr 16 and 0xFF) + "." +
                (ip shr 24 and 0xFF)
    }
}
