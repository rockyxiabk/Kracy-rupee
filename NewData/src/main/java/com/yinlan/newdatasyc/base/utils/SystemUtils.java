package com.yinlan.newdatasyc.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.google.gson.Gson;
import com.yinlan.newdatasyc.bean.SenSorData;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@SuppressLint("MissingPermission")
public class SystemUtils {
    public static String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
    }


    //获取版本号
    public static String getAppVersionName(Context context) {
        String version = "";
        try {
            version = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public static int getAppVersionCode(Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static long getAppInstallTime(Context context) {
        long installed = 0;
        try {
            installed = context
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return installed;

    }
    public static List<ScanResult> getWifiList(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> scanWifiList = wifiManager.getScanResults();
        List<ScanResult> wifiList = new ArrayList<>();
        if (scanWifiList != null && scanWifiList.size() > 0) {
            HashMap<String, Integer> signalStrength = new HashMap<String, Integer>();
            for (int i = 0; i < scanWifiList.size(); i++) {
                ScanResult scanResult = scanWifiList.get(i);

                if (!scanResult.SSID.isEmpty()) {
                    String key = scanResult.SSID + " " + scanResult.capabilities;
                    if (!signalStrength.containsKey(key)) {
                        signalStrength.put(key, i);
                        wifiList.add(scanResult);
                    }
                }
            }
        } else {

        }
        return wifiList;
    }


    public static int getAndroidSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    //获取手机操作系统版本号
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    //设备名称
    public static String getDeviceName() {
        return Build.DEVICE;
    }

    //获取手机型号
    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static Locale getLocale(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        return locale;
    }

    //获取手机IMEI
    public static String getIMEI(Context context) {
        String imei = null;
        TelephonyManager telephonyManager = null;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //获取IMEI号
            imei = telephonyManager.getDeviceId();
        } catch (Exception e) {

        }
        if (imei == null) {
            imei = "";
        }
        return imei;
    }


    //运营商
    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    //获取CPU总数
    public static int getNumCores() {
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                if (Pattern.matches("cpu[0-9]", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }
        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            //Print exception
            // Log.d(TAG, "CPU Count: Failed.");
            e.printStackTrace();
            //Default to return 1 core
            return 1;
        }
    }

    public static String getPhoneNum(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String phoneId = tm.getLine1Number();
            return phoneId;
        } catch (Exception e) {
            return "";
        }

    }

    public static String getTimeZone() {
        Calendar mDummyDate;
        mDummyDate = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        mDummyDate.setTimeZone(now.getTimeZone());
        mDummyDate.set(now.get(Calendar.YEAR), 11, 31, 13, 0, 0);
        return now.getTimeZone().getID();
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        String dateString = sdf.format(date);
        return dateString;
    }

    public static String getGmtTimeZone() {
        int _t = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            _t = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / (3600 * 1000);
        }
        return String.valueOf(_t);
    }
//    public static String getTimeZoneText(TimeZone tz, boolean includeName) {
//        Date now = new Date();
//        SimpleDateFormat gmtFormatter = new SimpleDateFormat("ZZZZ");
//        gmtFormatter.setTimeZone(tz);
//        String gmtString = gmtFormatter.format(now);
//        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
//        Locale l = Locale.getDefault();
//        boolean isRtl = TextUtils.getLayoutDirectionFromLocale(l) == View.LAYOUT_DIRECTION_RTL;
//        gmtString = bidiFormatter.unicodeWrap(gmtString,
//                isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
//        if (!includeName) {
//            return gmtString;
//        }
//
//        return gmtString;
//    }

    public static String getOperator(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String operator = tm.getSimOperatorName();
            return operator;
        } catch (Exception e) {
            return "";
        }
    }

    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    //是否模拟器
    public static boolean isSimulator(Context context) {
        String url = "tel:" + "123456";
        Intent intent = new Intent();
        intent.setData(Uri.parse(url));
        intent.setAction(Intent.ACTION_DIAL);
        // 是否可以处理跳转到拨号的 Intent
        boolean canCallPhone = intent.resolveActivity(context.getPackageManager()) != null;
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.toLowerCase()
                .contains("vbox") || Build.FINGERPRINT.toLowerCase()
                .contains("test-keys") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL
                .contains("MuMu") || Build.MODEL.contains("virtual") || Build.SERIAL.equalsIgnoreCase("android") || Build.MANUFACTURER
                .contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk"
                .equals(Build.PRODUCT) || ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName()
                .toLowerCase()
                .equals("android") || !canCallPhone;
    }

    //出厂时间
    public static long getDeliveryTime() {
        return Build.TIME;
    }

    //设备序列号
    public static String getSerial() {
        return Build.SERIAL;
    }

    public static boolean isRootSystem() {
        if (isRootSystem1() || isRootSystem2()) {
            //  可加其他判断 如是否装了权限管理的apk，大多数root 权限 申请需要app配合，也有不需要的，这个需要改su源码。因为管理su权限的app太多，无法列举所有的app，特别是国外的，暂时不做判断是否有root权限管理app
            //多数只要su可执行就是root成功了，但是成功后用户如果删掉了权限管理的app，就会造成第三方app无法申请root权限，此时是用户删root权限管理app造成的。
            //市场上常用的的权限管理app的包名   com.qihoo.permmgr  com.noshufou.android.su  eu.chainfire.supersu   com.kingroot.kinguser  com.kingouser.com  com.koushikdutta.superuser
            //com.dianxinos.superuser  com.lbe.security.shuame com.geohot.towelroot 。。。。。。
            return true;
        } else {
            return false;
        }
    }

    private static boolean isRootSystem1() {
        File f = null;
        final String kSuSearchPaths[] = {"/system/bin/", "/system/xbin/",
                "/system/sbin/", "/sbin/", "/vendor/bin/"};
        try {
            for (int i = 0; i < kSuSearchPaths.length; i++) {
                f = new File(kSuSearchPaths[i] + "su");
                if (f != null && f.exists() && f.canExecute()) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean isRootSystem2() {
        List<String> pros = Arrays.asList(System.getenv("PATH").split(":"));
        File f = null;
        try {
            for (int i = 0; i < pros.size(); i++) {
                f = new File(pros.get(i), "su");
                System.out.println("f.getAbsolutePath():" + f.getAbsolutePath());
                if (f != null && f.exists() && f.canExecute()) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static void getGaid(final Context context, final Action<String> action) {
        new Thread() {
            public void run() {
                String gaid = null;
                try {
                    gaid = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (action != null) {
                    action.call(gaid);
                }
            }
        }.start();
    }


    public static final int NETWORK_NONE = 0; // 没有网络连接
    public static final int NETWORK_WIFI = 1; // wifi连接
    public static final int NETWORK_2G = 2; // 2G
    public static final int NETWORK_3G = 3; // 3G
    public static final int NETWORK_4G = 4; // 4G
    public static final int NETWORK_5G = 5; // 4G

    public static String getNetworkTypeName(Context context) {
        int state = getNetworkType(context);
        switch (state) {
            case NETWORK_NONE: // 没有网络连接
                return "none";
            case NETWORK_WIFI: // wifi连接
                return "wifi";
            case NETWORK_2G: // 2G
                return "2G";
            case NETWORK_3G: // 3G
                return "3G";
            case NETWORK_4G: // 4G
                return "4G";
            case NETWORK_5G: // 手机流量
                return "5G";

        }
        return "none";
    }


    public static int getNetworkType(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); // 获取网络服务
        if (null == connManager) { // 为空则认为无网络
            return NETWORK_NONE;
        }
        // 获取网络类型，如果为空，返回无网络
        NetworkInfo activeNetInfo = connManager.getActiveNetworkInfo();
        if (activeNetInfo == null || !activeNetInfo.isAvailable()) {
            return NETWORK_NONE;
        }
        // 判断是否为WIFI
        NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (null != wifiInfo) {
            NetworkInfo.State state = wifiInfo.getState();
            if (null != state) {
                if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                    return NETWORK_WIFI;
                }
            }
        }
        // 若不是WIFI，则去判断是2G、3G、4G网
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int networkType = telephonyManager.getNetworkType();
        switch (networkType) {
            // 2G网络
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return NETWORK_2G;
            // 3G网络
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NETWORK_3G;
            // 4G网络
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NETWORK_4G;
//            case TelephonyManager.NETWORK_TYPE_NR:
//                return NETWORK_5G;
            default:
                return NETWORK_2G;
        }
    }

    public static String getSensorListString(Context context) {
        List<SenSorData> senSorDatas = new ArrayList<>();
        // 获取传感器管理器
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        // 获取全部传感器列表
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor item : sensors) {
            SenSorData senSorData = new SenSorData();
            senSorData.name = item.getName();
            senSorData.type = String.valueOf(item.getType());
            senSorData.maxRange = String.valueOf(item.getMaximumRange());
            senSorData.minDelay = String.valueOf(item.getMinDelay());
            senSorData.power = String.valueOf(item.getPower());
            senSorData.resolution = String.valueOf(item.getResolution());
            senSorData.vendor = item.getVendor();
            senSorData.version = String.valueOf(item.getVersion());
            senSorDatas.add(senSorData);
        }
        try{
            return new Gson().toJson(senSorDatas);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public static int getNumAvailableCores() {
        return  Runtime.getRuntime().availableProcessors();
    }
}
