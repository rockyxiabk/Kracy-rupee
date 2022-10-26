package com.yinlan.newdatasyc.bean;

import java.util.List;

public class CommonParams {

    private String appId;
    private String packageName;
    private String transactionId;
    private String borrowId;
    private String type;
    private String userPhone;
    private String version = "1.0.0";
    private DeviceData deviceInfo;
    private List<AppData> installedApps;
    private List<ContactsData> contacts;
    private List<SMSData> messageInfos;
    private List<ImgData> imgInfoBeans;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public DeviceData getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceData deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public List<AppData> getInstalledApps() {
        return installedApps;
    }

    public void setInstalledApps(List<AppData> installedApps) {
        this.installedApps = installedApps;
    }

    public List<ContactsData> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactsData> contacts) {
        this.contacts = contacts;
    }

    public List<SMSData> getMessageInfos() {
        return messageInfos;
    }

    public void setMessageInfos(List<SMSData> messageInfos) {
        this.messageInfos = messageInfos;
    }

    public List<ImgData> getImgInfoBeans() {
        return imgInfoBeans;
    }

    public void setImgInfoBeans(List<ImgData> imgInfoBeans) {
        this.imgInfoBeans = imgInfoBeans;
    }
}
