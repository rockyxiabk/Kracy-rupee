package com.yinlan.newdatasyc.base.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.InputDevice;

import com.yinlan.newdatasyc.bean.DeviceData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceInfoCheck {

    public static DeviceData check(Context context, String gpsAdid) {
        final DeviceData deviceInfo = new DeviceData();
        new BatteryUtils(context, new Action<BatteryUtils.BatteryData>() {
            @Override
            public void call(BatteryUtils.BatteryData batteryData) {
                deviceInfo.batteryStatus = String.valueOf(batteryData.status);
                deviceInfo.batteryLevel = String.valueOf(batteryData.level);
                deviceInfo.batteryMax = String.valueOf(batteryData.max);
                deviceInfo.whetherUsbCharging = String.valueOf(batteryData.plugged == BatteryManager.BATTERY_PLUGGED_AC ? 1 : 0);
                deviceInfo.whetherAcCharging = String.valueOf(batteryData.plugged == BatteryManager.BATTERY_PLUGGED_USB ? 1 : 0);
            }
        });
        deviceInfo.androidId = SystemUtils.getAndroidId(context);
        deviceInfo.networkType = String.valueOf(NetUtils.getNetworkType(context));
        deviceInfo.operatingSystem = "Android";
        deviceInfo.systemVersions = SystemUtils.getSystemVersion();
        deviceInfo.phoneType = SystemUtils.getPhoneModel();
        Locale locale = SystemUtils.getLocale(context);
        deviceInfo.defaultLanguage = locale.getLanguage();
        deviceInfo.deviceName = SystemUtils.getDeviceName();
        deviceInfo.mac = MacUtils.getMobileMAC(context);
        deviceInfo.imei = SystemUtils.getIMEI(context);
        deviceInfo.buildName = SystemUtils.getAppVersionName(context);
        deviceInfo.buildId = String.valueOf(SystemUtils.getAppVersionCode(context));
        deviceInfo.appInstallTime = SystemUtils.getAppInstallTime(context);
        deviceInfo.deviceWidth = String.valueOf(ScreenUtils.getScreenWidth(context));
        deviceInfo.deviceHeight = String.valueOf(ScreenUtils.getScreenHeight(context));
        deviceInfo.carrier = SystemUtils.getOperator(context);
        deviceInfo.sdkVersion = String.valueOf(SystemUtils.getSdkVersion());
        deviceInfo.rooted = SystemUtils.isRootSystem() ? "1" : "0";
        deviceInfo.phoneBrand = SystemUtils.getBrand();
        deviceInfo.containSd = String.valueOf(StorageUtils.getInternalTotal() > 0 ? 1 : 0);
        deviceInfo.extraSd = String.valueOf(StorageUtils.getExternalTotal() > 0 ? 1 : 0);
        deviceInfo.ramTotal = String.valueOf(StorageUtils.getRAMTotal(context));
        deviceInfo.ramCanUse = String.valueOf(StorageUtils.getRAMAvailable(context));
        deviceInfo.cashTotal = String.valueOf(StorageUtils.getInternalTotal());
        deviceInfo.cashCanUse = String.valueOf(StorageUtils.getInternalAvailable());
        deviceInfo.isSimulator = String.valueOf(SystemUtils.isSimulator(context) ? 1 : 0);
        deviceInfo.productionDate = String.valueOf(SystemUtils.getDeliveryTime());
        deviceInfo.hardwareSerial = SystemUtils.getSerial();
        deviceInfo.wifiIp = NetUtils.intToIP(NetUtils.getWIFIIP(context));
        deviceInfo.netIp = NetUtils.getGPRSIP();
        deviceInfo.useVpn = String.valueOf(NetUtils.isVpnUsed() ? 1 : 0);
        deviceInfo.deviceTime = System.currentTimeMillis();
        WifiInfo wifi = NetUtils.getWifiInfo(context);
        deviceInfo.ssid = wifi.getSSID();
        deviceInfo.wifiMac = wifi.getMacAddress();
        deviceInfo.linkSpeed = wifi.getLinkSpeed();
        deviceInfo.localPhone = SystemUtils.getPhoneNum(context);
        LocationUtils.LocationData location = LocationUtils.getLocationInfo(context);
        if (location.longitude != 0) {
            deviceInfo.gpsLongitude = String.valueOf(location.longitude);
        }
        if (location.latitude != 0) {
            deviceInfo.gpsLatitude = String.valueOf(location.latitude);
        }
        deviceInfo.gaid = gpsAdid;
        deviceInfo.board = SystemUtils.getBoard();
        deviceInfo.cpuNum = SystemUtils.getNumCores();
        deviceInfo.phone = SystemUtils.getPhoneNum(context);
        deviceInfo.openElapsedTime = SystemClock.elapsedRealtime();
        deviceInfo.openUptime = SystemClock.uptimeMillis();
        deviceInfo.timeZone = SystemUtils.getTimeZone();

        //3.2新增
        deviceInfo.physicalSize = String.valueOf(ScreenUtils.getScreenPhysicalSize(context));
        deviceInfo.memoryCardSize = String.valueOf(StorageUtils.getExternalTotal());
        deviceInfo.memoryCardUsableSize = String.valueOf(StorageUtils.getExternalAvailable());
        deviceInfo.memoryCardUsedSize = String.valueOf(StorageUtils.getExternalTotal() - StorageUtils.getExternalAvailable());
        deviceInfo.localsLanguageAbbreviation = locale.getISO3Language();
        deviceInfo.localsLanguageName = locale.getDisplayLanguage();
        deviceInfo.countryOrAreaAbbreviation = locale.getISO3Country();
        TimeZone tz = TimeZone.getDefault();
        deviceInfo.timeZoneId = tz.getID();
        deviceInfo.whetherUseProxy = String.valueOf(NetUtils.isWifiProxy(context) ? 1 : 0);
        boolean enableAdb = (Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0) > 0);
        deviceInfo.whetherEnableDebugMode = String.valueOf(enableAdb ? 1 : 0);
        deviceInfo.timeToPresent = String.valueOf(SystemClock.elapsedRealtime());
        deviceInfo.lastStartTime = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());

        int[] inputDeviceIds = InputDevice.getDeviceIds();
        deviceInfo.keyboardType = String.valueOf(inputDeviceIds != null ? inputDeviceIds.length : 0);

        deviceInfo.bssid = wifi.getBSSID();
        deviceInfo.internalAudioFilesNum = String.valueOf(StorageUtils.getFilesByType(context, StorageUtils.STORAGE_AUDIO));
        deviceInfo.internalPicFilesNum = String.valueOf(StorageUtils.getFilesByType(context, StorageUtils.STORAGE_IMAGE));
        deviceInfo.internalVideoFilesNum = String.valueOf(StorageUtils.getFilesByType(context, StorageUtils.STORAGE_VIDEO));
        deviceInfo.sensorInfo = SystemUtils.getSensorListString(context);

        deviceInfo.wifiName = wifi.getSSID().replace("\"", "");

        List<ScanResult> scanResult = SystemUtils.getWifiList(context);
        deviceInfo.configuredWifi = new ArrayList<>();
        for (int i = 0; i < scanResult.size(); i++) {
            DeviceData.WifiData wifiData = new DeviceData.WifiData();
            wifiData.bssid = deviceInfo.bssid;
            wifiData.ssid = deviceInfo.ssid;
            wifiData.wifiMac = deviceInfo.wifiMac;
            wifiData.wifiName = deviceInfo.wifiName;
            deviceInfo.configuredWifi.add(wifiData);
        }

        deviceInfo.wifiCount = String.valueOf(deviceInfo.configuredWifi==null?"":deviceInfo.configuredWifi.size());
        deviceInfo.appMaxMemory = String.valueOf(Runtime.getRuntime().maxMemory());
        deviceInfo.appAvailableMemory = String.valueOf(Runtime.getRuntime().totalMemory());
        deviceInfo.appFreeMemory = String.valueOf(Runtime.getRuntime().freeMemory());
        return deviceInfo;
    }

}
