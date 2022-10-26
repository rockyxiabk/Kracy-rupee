package com.yinlan.newdatasyc.bean;

/**
 * Date: 2020-03-10 16:13
 * Author: kay lau
 * Description:
 */
public class PermissionCheckInfo {

    private boolean isAccessPermission;
    private String permissionName;

    public boolean isAccessPermission() {
        return isAccessPermission;
    }

    public void setAccessPermission(boolean accessPermission) {
        isAccessPermission = accessPermission;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
