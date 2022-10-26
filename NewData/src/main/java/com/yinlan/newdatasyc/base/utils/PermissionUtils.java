package com.yinlan.newdatasyc.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import com.yinlan.newdatasyc.bean.PermissionCheckInfo;

import androidx.core.content.ContextCompat;

public class PermissionUtils {

    public static PermissionCheckInfo lacksPermissions(Context mContexts, String[] permissions) {
        boolean hasPermission = false;
        PermissionCheckInfo checkInfo = new PermissionCheckInfo();
        for (String permission : permissions) {
            checkInfo.setPermissionName(permission);
            hasPermission = lacksPermission(mContexts, permission);
            if (!hasPermission) {
                checkInfo.setAccessPermission(false);
                return checkInfo;
            }
        }
        checkInfo.setAccessPermission(hasPermission);
        return checkInfo;
    }

    public static boolean lacksPermission(Context mContexts, String permission) {
        return ContextCompat.checkSelfPermission(mContexts, permission) ==
                PackageManager.PERMISSION_GRANTED;
    }
}
