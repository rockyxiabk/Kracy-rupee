package com.yinlan.newdatasyc.newwork;

import android.content.Context;

import com.google.gson.Gson;
import com.yinlan.newdatasyc.base.utils.Base64Util;
import com.yinlan.newdatasyc.base.utils.HmacMd5Utils;
import com.yinlan.newdatasyc.bean.CallbackBean;

/**
 * @CreateDate: 2020/9/8 15:44
 * @Description:
 * @Author: kayLau
 */
public class HttpSendReq {

    private static HttpSendReq instance;

    private String appId = "";
    private String appSecret;
    private String uploadUrl;
    private String phoneNum = "";
    private Context context;
    private String transactionId = "";
    private String borrowId = "";

    private HttpSendReq() {
    }

    public synchronized static HttpSendReq getInstance() {
        if (instance == null) {
            instance = new HttpSendReq();
        }
        return instance;
    }

    public void onPostReq(String reqUrl, String reqJsonStr, String signMsg) {
        new DataAsyncTask(reqUrl, reqJsonStr, signMsg).execute();
    }


    public void uploadSdkLog(String syncType, boolean syncState, int syncCode, String syncMsg, int uploadCount) {
        CallbackBean customEventBean = new CallbackBean();
        if (getContext() != null) {
            customEventBean.setPackageName(getContext().getPackageName());
        }
        customEventBean.setAppId(getAppId());
        customEventBean.setSdkVer("1.0.0");
        customEventBean.setSyncCode(syncCode);
        customEventBean.setSyncMsg(syncMsg);
        customEventBean.setSyncState(syncState);
        customEventBean.setBorrowId(getBorrowId());
        customEventBean.setTransactionId(getTransactionId());
        customEventBean.setUserPhone(getPhoneNum());
        customEventBean.setUploadCount(uploadCount);
        customEventBean.setSyncType(syncType);

        String toJson = new Gson().toJson(customEventBean).trim();
        LogUtil.e("uploadSyncStatus: " + toJson);
        toJson = Base64Util.encode(toJson.getBytes());
        String sign;
        try {
            sign = HmacMd5Utils.EncryptHMacMd5(toJson.getBytes("UTF-8"), getAppSecret());
        } catch (Exception e) {
            sign = "";
            collectException("uploadSyncSdkLog: " + e.toString());
        }
        String url = getUploadUrl() + "/api/v1/log/post";
        StringBuffer bufferReq = new StringBuffer();
        bufferReq.append("sdklog").append("=").append(toJson);
        HttpSendReq.getInstance().onPostReq(url, bufferReq.toString(), sign);
    }

    public void collectException(String errorMsg) {
        uploadSdkLog(DataManagerSDK.TYPE_COMMON, false, -2, errorMsg, 0);
    }

    public void collectException(String syncType, String errorMsg) {
        uploadSdkLog(syncType, false, -2, errorMsg, 0);
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Context getContext() {
        return context;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getBorrowId() {
        return borrowId;
    }
}
