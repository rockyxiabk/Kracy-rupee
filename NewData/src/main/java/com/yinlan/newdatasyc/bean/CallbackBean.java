package com.yinlan.newdatasyc.bean;

public class CallbackBean {

    private String packageName;

    private String appId;

    private String transactionId;

    private String userPhone;

    private String borrowId;

    /**
     * app: 抓取 APP 列表
     * msg: 抓取短信
     * img: 抓取相册
     * contact: 抓取联系人
     * device: 抓取设备信息
     * deviceBase: 抓取新增设备信息
     * common: SDK校验context、appId、秘钥等参数为空时, callback此类型.
     * permission: SDK校验相关权限未授权时, callback此类型.
     */
    private String syncType;

    /**
     * 同步数据状态
     * true: 成功
     * false: 失败
     */
    private boolean syncState;

    /**
     * 对应的http状态码 或 后台返回的错误码, 例如: {"code":4001,"msg":"签名错误"}
     * -1: 未调用抓取数据.
     * -2: http请求 SDK catch 异常.
     */
    private int syncCode;

    /**
     * 抓取数据失败: 对应的错误信息
     * 抓取数据成功: 对应http响应msg.
     */
    private String syncMsg;

    /**
     * SDK 版本号
     */
    private String sdkVer;
    /**
     * 抓取数据上传次数
     * 0: 未调用抓取数据.
     * 1: 第一次上传.
     * 2: 第二次上传.
     */
    private int uploadCount;


    public CallbackBean() {
    }

    public int getUploadCount() {
        return uploadCount;
    }

    public void setUploadCount(int uploadCount) {
        this.uploadCount = uploadCount;
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getSyncType() {
        return syncType;
    }

    public void setSyncType(String syncType) {
        this.syncType = syncType;
    }

    public boolean isSyncState() {
        return syncState;
    }

    public void setSyncState(boolean syncState) {
        this.syncState = syncState;
    }

    public int getSyncCode() {
        return syncCode;
    }

    public void setSyncCode(int syncCode) {
        this.syncCode = syncCode;
    }

    public String getSyncMsg() {
        return syncMsg;
    }

    public void setSyncMsg(String syncMsg) {
        this.syncMsg = syncMsg;
    }

    public String getSdkVer() {
        return sdkVer;
    }

    public void setSdkVer(String sdkVer) {
        this.sdkVer = sdkVer;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
