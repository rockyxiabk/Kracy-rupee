package com.yinlan.newdatasyc.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import java.util.List;

public class LocationUtils {

    public static class LocationData {
        public double longitude;//经度
        public double latitude; //纬度
    }




    public static LocationData getLocationInfo(Context context) {
        LocationData location = new LocationData();
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        //获取所有的可用的位置提供器
        List<String> providerList = locationManager.getProviders(true);
        String provider;
        if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else if (providerList.contains(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else {
            return location;
        }
        @SuppressLint("MissingPermission") Location l = locationManager.getLastKnownLocation(provider);
        if (l != null) {
            location.latitude = l.getLatitude();
            location.longitude = l.getLongitude();
        }
        return location;
    }
}
