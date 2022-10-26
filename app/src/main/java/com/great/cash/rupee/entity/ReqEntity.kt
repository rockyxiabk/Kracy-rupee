package com.great.cash.rupee.entity

import android.os.Build
import android.text.TextUtils
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.ConstantsParams
import com.great.cash.rupee.utils.LocationUtil
import com.great.cash.rupee.utils.MD5Util
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

data class PermissionEntity(var title: String, var resId: Int, var des: String)

data class ApplyLendReq(
    var client: String = "android",
    var address: String,
    var coordinate: String,
    var ip: String,
    var imei: String,
    var appRunTime: String,
    var riskType: String,
    var appName: String
)

data class AutoLogonReq(var refresh_token: String?)

data class PhoneStateReq(var phone: String, var imei: String)

data class LogonReq(var loginName: String, var loginPwd: String, var imei: String, var mac: String, var appflyerCustomerUserId: String)

class RegReq(var loginName: String?, pwd: String?, code: String, gpsAdid: String?, appflyerCustomerUserId: String?) {
    var loginPwd: String? = null
    var vcode: String? = null
    var client: String? = null
    var imei: String? = null
    var mac: String? = null
    var ip: String? = null
    var operatingSystem: String? = null
    var phoneBrand: String? = null
    var phoneMark: String? = null
    var phoneType: String? = null
    var systemVersions: String? = null
    var versionCode: String? = null
    var versionName: String? = null
    var registerAddr: String? = null
    var registerCoordinate: String? = null
    var channelCode: String? = null
    var appflyerCustomerUserId: String? = null
    var gpsAdId: String? = null
    var androidId: String? = null
    var deviceWidth: String? = null
    var deviceHeight: String? = null
    var telephony: String? = null
    var defaultLanguage: String? = null
    var securityPatch: String? = null
    var sdkVersion: String? = null
    var rooted: Boolean? = false
    var productionDate: String? = null
    var serial: String? = null
    var containSD: Boolean? = false
    var ramCanUse: String? = null
    var ramTotal: String? = null
    var cashCanUse: String? = null
    var cashTotal: String? = null
    var extraSD: Boolean? = false

    companion object {
        fun formatter(date: Any?): String {
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

            return if (date == null) {
                ""
            } else {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                sdf.format(Date(getLong(date.toString())))
            }
        }

        fun getLong(args: String?): Long {
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

            return try {
                if (TextUtils.isEmpty(args)) {
                    0L
                } else {
                    BigDecimal(args).toLong()
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                0L
            }
        }
    }

    init {
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

        loginPwd = MD5Util.encryptMD5(pwd!!)
        vcode = code
        client = "android"
        gpsAdId = gpsAdid
        this.imei = ConstantsParams.imei
        this.mac = ConstantsParams.mac
        this.ip = ConstantsParams.ip
        operatingSystem = "android"
        this.appflyerCustomerUserId = appflyerCustomerUserId
        phoneBrand = ConstantsParams.deviceBrand
        phoneMark = ConstantsParams.imei
        phoneType = ConstantsParams.deviceModel
        systemVersions = Build.VERSION.RELEASE
        this.versionCode = ConstantsParams.versionCode.toString()
        this.versionName = ConstantsParams.versionName
        registerAddr = LocationUtil.detailAddress
        registerCoordinate = LocationUtil.longitude.toString() + "," + LocationUtil.latitude
        channelCode = Constant.CHANNEL_VALUE
        this.androidId = ConstantsParams.androidId
        deviceWidth = ConstantsParams.screenWidth.toString()
        deviceHeight = ConstantsParams.screenHeight.toString()
        telephony = ConstantsParams.operatorName!!
        defaultLanguage = ConstantsParams.language
        securityPatch = Build.VERSION.SECURITY_PATCH
        sdkVersion = Build.VERSION.RELEASE
        rooted = false
        productionDate = formatter(Build.TIME)
        serial = Build.SERIAL
        ramCanUse = ConstantsParams.availSize
        ramTotal = ConstantsParams.totalSize
        containSD = false
        cashCanUse = ConstantsParams.availableRomSize
        cashTotal = ConstantsParams.totalRomSize
        extraSD = false
    }
}

data class PasswardReq(var oldPwd: String, var newPwd: String)

class PageReq(var current: String, var pageSize: String) {
    var total = "0"
    var pages = "0"
}

data class PelopleAuthReq(
    var firstName: String?,
    var middleName: String?,
    var lastName: String?,
    var educationalQualification: String?,
    var accommodationType: String?,
    var childrenNumber: String?,
    var loanPurpose: String?,
    var marital: String?,
    var email: String?,
    var occupation: String?,
    var salaryRange: String?,
    var salarySource: String?
)

const val SMS_TYPE_REGISTER = "register"
const val SMS_TYPE_FINDREG = "findReg"

data class MsgCodeReq(
    var phone: String? = null,
    var signMsg: String? = null,
    var type: String? = null,
    var newPwd: String? = null,
    var confirmPassword: String? = null,
    var vcode: String? = null
)

data class UserOcrReq(var type: String, var info: String)

data class BankReq(var ifscCode: String, var bankAccount: String)

data class ContactsReq(
    var name: String,
    var phone: String,
    var relation: String,
    var type: String
)

data class PayNoReq(
    var borrowId: String? = "",
    var failStr: String? = "",
    var orderNo: String? = "",
    var code: Int? = 0
)

data class PayYesReq(
    var borrowId: String? = "",
    var razorpayOrderId: String? = "",
    var razorpayPaymentId: String? = "",
    var orderNo: String? = ""
)

data class LendReq(var borrowId: String? = "")

data class CachReq(var gpsAdId: String? = "",
                   var riskData:String?="",
                   var code:String?=""

)

data class SubBankReq(var bankAccountId: String? = "")

data class YesInfoReq(
    var borrowId: String? = "",
    var bankAccountId: String? = "",
    var success: Boolean? = true,
    var result: String? = "success"
)

data class SaveStateReq(
    var code: String?,
    var message: String?,
    var type: String?,
    var reportStatus: String?,
    var borrowId: String? = "",
    var userId: String? = ""
)

class NPReq
