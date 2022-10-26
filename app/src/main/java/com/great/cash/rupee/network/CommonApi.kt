package com.great.cash.rupee.network

import com.great.cash.rupee.entity.*
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

interface CommonApi {
    @POST("api/borrow/confirm.htm")
    fun getLoanInfo(@Body req: NPReq?): Observable<BaseResult<HomeOrderInfoBean?>>

    @POST("api/borrow/findIndex.htm")
    fun indexInfo(@Body req: NPReq?): Observable<BaseResult<HomeIndexResp?>>

    @POST("api/productInfo/findProductListByMerchantId.htm")
    fun indexListInfo(@Body req: NPReq?): Observable<BaseResultArray<HomeLoanResp?>>

    @POST("api/act/borrow/save.htm")
    fun applyMoney(@Body req: ApplyLendReq?): Observable<BaseResult<ApplyLendResp?>>

    @POST("api/act/getSdkReportStatusNew.htm")
    fun uploadState(@Body req: SaveStateReq): Observable<BaseResult<String?>>

    @GET("api/h5/list.htm")
    fun helpList(): Observable<BaseResultArray<ProtocolResp?>>

    @POST("/api/common/diversion/switch.htm")
    fun reqDaoliuData(@Body req: NPReq?): Observable<BaseResult<DaoliuResp?>>

    @get:GET("/api/act/mine/userAuth/getUserAuth.htm")
    val userAuth: Observable<BaseResult<UserAuthResp?>>

    @GET("/api/act/dict/list.htm")
    fun dictList(@Query("type") type: String?): Observable<BaseResult<DictListResp?>>

    @POST("/api/act/user/userOcr.htm")
    fun userOcr(@Body req: UserOcrReq?): Observable<BaseResult<String?>>

    @GET("/api/act/user/userFaceMatch.htm")
    fun userFaceMatch(
        @Query("panFaceMatch") panFaceMatch: Int,
        @Query("aadHarFaceMatch") aadharFaceMatch: Int
    ): Observable<BaseResult<String?>>

    @POST("/api/act/mine/contact/saveOrUpdate.htm")
    fun saveOrUpdate(@Body contactsReq: ContactsReq?): Observable<BaseResult<String?>>

    @GET("/api/act/mine/contact/getContactInfoList.htm")
    fun contactInfoList(): Observable<BaseResultArray<ContactInfoResp?>>


    @GET("/event/act/user/saveUserEventStatistics.htm")
    fun statisticsEvent(@Query("imei") imei: String?, @Query("pageId") pageId: String?,
                        @Query("pageName") pageName: String?): Observable<BaseResult<Void?>>

    /**
     * ifscCode string 是 - 5000 ifscCode
     * bankAccount string 是 - - 银⾏账号
     */
    @POST("/api/act/bankAccount/binding.htm")
    fun bankBinding(@Body req: BankReq?): Observable<BaseResult<String?>>

    @Multipart
    @POST("/api/act/mine/userInfo/realNameAuthSave.htm")
    fun realNameAuthSave(
        @HeaderMap head: Map<String, String?>?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody?>?
    ): @JvmSuppressWildcards Observable<BaseResult<String?>>

    /**
     * 获取检测分数
     * @return
     */
    @GET("/api/act/mine/liveness/getScore.htm")
    fun getFaceScore(@Query("livenessId") livenessId: String?): Observable<BaseResult<FaceScoreResponse?>>

    /**
     * 设置默认银行卡
     * @return
     */
    @POST("/api/act/bankAccount/setDefault.htm")
    fun setDefault(@Body bankAccountId: SubBankReq?): Observable<BaseResult<Void?>>


    @Multipart
    @POST("/api/act/mine/ocr/imageScan.htm")
    fun getCardInfo(
        @HeaderMap head: Map<String, String?>?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody?>?
    ): Observable<BaseResult<CardInfoResp?>>


    @Multipart
    @POST("/api/act/mine/face/comparison.htm")
    fun matchFaceAndImage(
        @HeaderMap head: Map<String, String?>?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody?>?
    ): Observable<BaseResult<String?>>


    @Multipart
    @POST("/api/act/mine/opinion/submit.htm")
    fun submitFeedback(
        @HeaderMap head: Map<String, String?>?,
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody?>?
    ): Observable<BaseResult<String?>>

    @GET("/api/act/mine/userInfo/getRealNameAuthInfo.htm")
    fun realNameAuthInfo(): Observable<BaseResult<AuthInfoResp?>>

    @GET("/api/act/mine/userInfo/personalInfoAuthInfo.htm")
    fun personalInfoAuthInfo(): Observable<BaseResult<PersonalAuthResp?>>

    @POST("/api/act/mine/userInfo/personalInfoAuthSave.htm")
    fun personalInfoAuthSave(@Body req: PelopleAuthReq?): Observable<BaseResult<String?>>

    @POST("api/act/borrow/saveEsignInfo.htm")
    fun confirmInfo(@Body confirm: YesInfoReq?): Observable<BaseResult<String?>>

    @POST("api/act/bankAccount/nameCheck.htm")
    fun submitBank(@Body checkReq: SubBankReq?): Observable<BaseResult<String?>>

    @GET("/api/act/bankAccount/bankBranch.htm")
    fun bankIfscCodeLsit(@Query("parentId") parentId: Int): Observable<BaseResultArray<BankBranchResp?>>

    @GET("/api/act/bankAccount/info.htm")
    fun bankLsit(): Observable<BaseResultArray<BankResp?>>

    @POST("/api/act/user/changeLoginPwd.htm")
    fun changeLoginPwd(@Body req: PasswardReq?): Observable<BaseResult<String?>>

    @POST("api/act/mine/borrow/page.htm")
    fun payList(@Body pageReq: PageReq): Observable<BaseResultArray<LendResp?>>

    @GET("api/act/borrow/findBorrow.htm")
    fun findInfo(@Query("borrowId") borrowId: String?): Observable<BaseResult<LendDetailResp?>>

    /**
     * 还款详情
     */
    @GET("api/act/repay/getInfo.htm")
    fun getRepayDetails(@Query("borrowId") id: String, @Query("isExtension") extend: Boolean): Observable<BaseResult<RepayInfoResp?>>

    /**
     * 还款详情
     */
    @POST("api/act/borrow/findRepayDetail.htm")
    fun getDetails(@Body result: LendReq): Observable<BaseResult<RepayDetailResp?>>

    /**
     * 还款详情
     */
    @POST("api/act/fyrisk/catch.htm")
    fun updateCachState(@Body result: CachReq): Observable<BaseResult<Void?>>

    /**
     * 还款成功
     */
    @POST("api/act/razorPay/confirmMoreAccountRepayment.htm")
    fun paySucc(@Body paySuccessReq: PayYesReq): Observable<BaseResult<Void?>>

    @POST("api/act/razorPay/confirmMoreAccountRepaymentFail.htm")
    fun payFailed(@Body payFailReq: PayNoReq): Observable<BaseResult<Void?>>
    /**
     * {
     * "code": 200,
     * "msg": "successful"
     * "data":{
     * "isExists":"10"
     * }
     * }
     */
    @POST("api/user/isPhoneExists.htm")
    fun isExists(@Body req: PhoneStateReq?): Observable<BaseResult<PhoneStateEntity?>>

    /**
     * {
     * "msg":"The login was successful.",
     * "code":200,
     * "data": {
     * "userId":1,
     * "token":"2db6c3212bd04b1c9d338031d3152b22",
     * "refreshToken":"2002071457311195"
     * }
     * }
     */
    @POST("api/user/login.htm")
    fun login(@Body req: LogonReq?): Observable<BaseResult<UserInfomationEntity?>>

    /**
     * {
     * "msg":"The login was successful.",
     * "code":200,
     * "data": {
     * "userId":1,
     * "token":"2db6c3212bd04b1c9d338031d3152b22",
     * "refreshToken":"2002071457311195"
     * }
     * }
     */
    @POST("api/user/autoLogin.htm")
    fun aLogin(@Body req: AutoLogonReq?): Observable<BaseResult<UserInfomationEntity?>>

    /**
     * {
     * "msg":"The login was successful.",
     * "code":200,
     * "data": {
     * "userId":1,
     * "token":"2db6c3212bd04b1c9d338031d3152b22",
     * "refreshToken":"2002071457311195"
     * }
     * }
     */
    @POST("api/user/register.htm")
    fun register(@Body req: RegReq?): Observable<BaseResult<UserInfomationEntity?>>

    /**
     * {
     * "msg":"successful",
     * "data":{
     * "state":"10",
     * "message":"yifasong"
     * },
     * "code":200
     * }
     */
    @POST("api/user/sendSms.htm")
    fun sendSms(@Body req: MsgCodeReq?): Observable<BaseResult<MsgResp?>>

    /**
     * {
     * "code": 200,
     * "msg": "Password modified successfully"
     * }
     */
    @POST("api/user/login/forgetPwd.htm")
    fun forgotPwd(@Body req: MsgCodeReq?): Observable<BaseResult<String?>>
}
