package com.great.cash.rupee.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserInfomationEntity(
    var userId: String,
    var token: String,
    var refreshToken: String
)

const val PHONE_NOT_EXIST_CODE = "10"
const val PHONE_EXIST_CODE = "20"

data class PhoneStateEntity(var isExists: String)

class ApplyLendResp : Serializable {
    var needCatchWaitingTime = 0
    var borrowId: Long = 0
    var needCatch = false
}

class AuthInfoResp {
    var backImg: String = ""
    var frontImg: String = ""
    var dateOfBirth: String? = null
    var idAddr: String? = null
    var idNo: String? = null
    var livingImg: String = ""
    var panCode: String? = null
    var panImg: String = ""
    var phone: String? = null
    var pinCode: String? = null
    var realName: String? = null
    var sex: String? = null
    var type: String? = null
}

class CardInfoResp {
    //front
    var birthday: String? = null
    var gender: String? = null
    var name: String? = null
    var idNumber: String? = null

    //back
    var other: String? = null
    var addressAll: String? = null
    var pin: String? = null
    var subdistrict: String? = null
    var district: String? = null
    var state: String? = null
    var fatherName: String? = null

    var type: Int = 0
    var success: Boolean = true
    var msg:String?=""
}

class BankResp {
    var id: String? = null
    var bankName: String? = null
    var account: String? = null
    var status: String? = null //status  1 选中  2未选中
}
class HomeLoanResp {
    var id: String = ""
    var productName: String = ""
    var productLogo: String = ""
    var productAmount: String = ""
    var productStatus: String = ""// 1、可申请 2、 申请已满 3、审核中 4、拒绝
    var productInterest: String = ""
    var merchantId: String = ""
}
class BankBranchResp {
    var id: Int = 0
    var name: String? = null
    var code: String? = null
    var parentId: Int = 0
    var grade = 0
    var ifsc: String? = null
    var micrCode: String? = null
    var address: String? = null
    var contact: String? = null
    var district: String? = null
    var bankName: String? = null
    var isSelected = false
}

class FaceScoreResponse {
    var livenessScore = 0.0
    var detectionResult: String? = null
}
class ContactInfoResp {
    var id: Long = 0
    var name: String? = null
    var phone: String? = null
    var relation: String? = null
    var type: String? = null

    companion object {
        const val TYPE_ZHI = "10"
        const val TYPE_OTHER = "20"
    }
}

class DictListResp {
    @SerializedName("salaryTypeList")
    var salaryTypeList: List<TypeInfo>? = null

    @SerializedName("positionList")
    var positionList: List<TypeInfo>? = null

    @SerializedName("maritalStateList")
    var maritalStateList: List<TypeInfo>? = null

    @SerializedName("salaryRangeList")
    var salaryRangeList: List<TypeInfo>? = null

    @SerializedName("kinsfolkRelationList")
    var kinsfolkRelationList: List<TypeInfo>? = null
    var loanPurposeList: List<TypeInfo>? = null
    var accommodationTypeList: List<TypeInfo>? = null
    var childrenNumberList: List<TypeInfo>? = null
    var educationalStateList: List<TypeInfo>? = null

    class TypeInfo(
        var value: String, var code: String
    )

    companion object {
        const val TYPE_KINSFOLK_RELATION = "KINSFOLK_RELATION"
        const val TYPE_SALARY_RANGE = "SALARY_RANGE"
        const val TYPE_MARITAL_STATE = "MARITAL_STATE"
        const val TYPE_POSITION = "POSITION"
        const val TYPE_SALARY_TYPE = "SALARY_TYPE"
        const val TYPE_ACCOMMODATION_TYPE = "ACCOMMODATION_TYPE"
        const val TYPE_CHILDREN_NUMBER = "CHILDREN_NUMBER"
        const val TYPE_LOAN_PURPOSE = "LOAN_PURPOSE"
        const val TYPE_EDUCATION = "EDUCATIONAL_STATE"
    }
}

class DaoliuResp : Serializable {
    var rejectDiversion: Diversion? = null
    var repayDiversion: Diversion? = null
}

class Diversion : Serializable {
    var openSwitch: String = "false"
    var title: String = ""
    var value: String = ""
}

class HomeIndexResp : Serializable {
    var needCatch = false
    var needRepay = false
    var auth: HomeAuthBean? = null
    var haveBorrow = false
    var orderInfo: HomeOrderInfoBean? = null
    var title: String? = null
    var borrowId: String? = null
    var processList: List<HomeLoan>? = null
}

class HomeAuthBean : Serializable {
    var result = 0
    var qualified = 0
    var total = 0
}

class HomeLoan : Serializable {
    var msg: String? = null
    var type = 0
    var id = 0
    var createTime: String? = null
    var createTimeStr: String? = null
    var str: String? = null
    var state: String? = null
    var remark: String? = null
}

class HomeOrderInfoBean : Serializable {
    var realAmount: String? = null
    var onceHandlingFee: String? = null
    var amount: String? = null
    var repaymentAmount: String? = null
    var dayLimit: String? = null
    var repayTime: String? = null
    var interest: String? = null
    var onceServiceFee: String? = null
    var repaymentRemark: String? = null
    var remark: String? = null
    var state: String? = null
    var applicationDate: String? = null
    var gstFee: String? = null
    var borrowId: String? = null
    var bankAccount: String? = null
    var bankName: String? = null
    var riskType: String = ""
}

class LendDetailResp {
    var invoice: String? = null
    var amount: String? = null
    var tenure: String? = null
    var bankName: String? = null
    var cardNo: String? = null
    var state: String? = null
    var applicationDate: String? = null
    var repayment: String? = null
    var repayTime: String? = null
    var actualRepayment: String? = null
    var actualRepayTime: String? = null
    var protocolUrl: String? = null

    @SerializedName("list")
    var list: List<ListBean>? = null

    class ListBean {
        var id: String? = null
        var userId: String? = null
        var state: String? = null
        var remark: String? = null
        var createTime: String? = null
        var type: String? = null
        var createTimeStr: String? = null
        var str: String? = null
    }
}

class LendResp {
    var id: String? = null
    var userId = 0
    var orderNo: String? = null
    var amount: String? = null
    var realAmount = 0.0
    var fee = 0.0
    var createTime: String? = null
    var timeLimit: String? = null
    var state: String? = null
    var stateStr: String? = null
    var createTimeStr: String? = null
    var cardId = 0
    var serviceFee = 0.0
    var infoAuthFee = 0.0
    var interest = 0.0
    var client: String? = null
}

data class LoadRespData(
    var list: MutableList<LendResp?>,
    var page: PageBean? = null,
    var loadMore: Boolean = false
)

class PersonalAuthResp {
    var userId: String? = null
    var salary: String? = null
    var marital: String? = null
    var firstName: String? = null
    var middleName: String? = null
    var lastName: String? = null
    var email: String? = null
    var occupation: String? = null
    var salaryType: String? = null
    var accommodationType: String? = null
    var childrenNumber: String? = null
    var loanPurpose: String? = null
    var education: String? = null
}

data class ProtocolResp(var name: String, var code: String, var value: String)

class RepayDetailResp {
    var borrowId: Long = 0
    var repayment = 0.0
    var applicationTime: String? = null
    var applicationTimeStr: String? = null
    var repayTime: String? = null
    var repayTimeStr: String? = null
    var state: String? = null
    var penaltyDay = 0
    var dueDay = 0
    var amount = 0.0
    var gstFee = 0.0
    var tenure: String? = null
    var received = 0.0
    var penaltyAmount = 0.0
    var interestFee = 0.0
    var processingFee = 0.0
    var assessmentFee = 0.0
    var penaltyAmout = 0.0
    var extensionAmount: String = ""
    var extensionFee: String = ""
    var extensionDate: String = ""
    var canExtension = false
}

class RepayInfoResp {
    var repayUrl: String? = null
}

class MsgResp : Serializable {
    var state: String? = null
    var message: String? = null
}

class UserAuthResp {
    var realNameAuthState: String = ""
    var contactState: String = ""
    var personalInfoState: String = ""
    var bankCardState: String = ""

    fun isRealNameOK(): Boolean {
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

        return realNameAuthState == STATE_30
    }

    fun isInfoNameOK(): Boolean {
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

        return personalInfoState == STATE_30
    }

    fun isReferenceOK(): Boolean {
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

        return contactState == STATE_30
    }

    fun isBankOK(): Boolean {
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

        return bankCardState == STATE_30
    }


    companion object {
        const val STATE_10 = "10"
        const val STATE_20 = "20"
        const val STATE_30 = "30"
    }
}
