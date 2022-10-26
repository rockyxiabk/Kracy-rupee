package com.yinlan.newdatasyc.base.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.yinlan.newdatasyc.bean.AppData;
import com.yinlan.newdatasyc.newwork.HttpSendReq;

import java.util.List;

public class AppUtils {

    public static List<AppData> getInstallApps(Context context, List<AppData> appInfos) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfos = null;
        try {
            packageInfos = packageManager.getInstalledPackages(0);
            if (packageInfos != null) {
                for (int i = 0; i < packageInfos.size(); i++) {
                    PackageInfo packageInfo = packageInfos.get(i);
                    //过滤掉系统app
                    AppData myAppInfo = new AppData();
                    myAppInfo.appName = (packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    myAppInfo.pkgName = packageInfo.packageName;
                    myAppInfo.version = packageInfo.versionName;
                    myAppInfo.installTime = packageInfo.firstInstallTime;
                    myAppInfo.updateTime = packageInfo.lastUpdateTime;
                    myAppInfo.isPreInstalled = (packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0 ? "1" : "0";
//                        myAppInfo.flags = String.valueOf(packageInfo.applicationInfo.flags);
//                        myAppInfo.app_type = String.valueOf((packageInfo.applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM) == 0?0:1);
                    appInfos.add(myAppInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpSendReq.getInstance().collectException("getInstallApps: " + e.toString());
        }
        return appInfos;
    }
}
