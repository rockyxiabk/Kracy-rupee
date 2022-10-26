package com.yinlan.newdatasyc.base.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.yinlan.newdatasyc.newwork.HttpSendReq;
import com.yinlan.newdatasyc.newwork.LogUtil;

import java.util.List;
import java.util.Locale;

/**
 * Date: 2020/7/23 上午11:53
 * Author: kay lau
 * Description:
 */
public class LocationUtil {

    private static LocationUtil instance = null;

    private static FusedLocationProviderClient fusedLocationProviderClient;
    private static LocationRequest locationRequest;
    private static LocationCallback locationCallback;
    private Context mContext;
    public static String mAddressLine = "---";
    public static String mAdminArea = "---";
    public static String mSubAdminArea = "---";
    private LocationManager locationManager;

    private LocationUtil() {
    }

    public static synchronized LocationUtil getInstance() {
        if (instance == null) {
            instance = new LocationUtil();
        }
        return instance;
    }


    @SuppressLint("MissingPermission")
    public void init(Context context) {
        this.mContext = context;
//        registerLocation(context);
    }

    private void registerLocation(Context context) {
        if (fusedLocationProviderClient == null) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
            locationRequest = new LocationRequest();
        }
    }

    private static void setLocOption() {
        locationRequest.setInterval(60 * 1000); //请求时间间隔
        locationRequest.setFastestInterval(5 * 1000);//最快时间间隔
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    /*********************** GOOGLE地图定位 *****************************/
    public static String address = "";
    public static double lat = 0;
    public static double lon = 0;


    /**
     * 判断GPS是否开启
     */
    public static boolean isOpen(final Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager != null && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        //        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps) {//|| network) {
            return true;
        }
        return false;
    }

    @SuppressLint("MissingPermission")
    public void closeGps() {
        if (locationCallback != null) {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
            locationCallback = null;
        }
        if (locationManager != null) {
            locationManager.removeUpdates(listener);
        }
    }

    public void getGps() {
        boolean location = PermissionUtils.lacksPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION);
        if (!isOpen(mContext.getApplicationContext()) && !location) {
            LogUtil.d("!isOpen");
            HttpSendReq.getInstance().collectException("getGps: GPS 位置权限, 未开启");
        } else {
//            openGps(new OnPosChanged() {
//                @Override
//                public void changed(Location location) {
//                    if (location == null) {
//                        HttpSendReq.getInstance().collectException("getGps: location == null");
//                    } else {
//                        HttpSendReq.getInstance().collectException("getGps: location != null");
//                        getLocation(location);
//                    }
//                }
//            });

            obtainLocation(mContext);
        }
    }

    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            getLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    @SuppressLint("MissingPermission")
    private void obtainLocation(Context context) {
        Criteria criteria = null;
        try {
            criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(Criteria.POWER_LOW);
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (!TextUtils.isEmpty(bestProvider)) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                locationManager.requestLocationUpdates(bestProvider, 1000, 30.0F, listener);
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                getLocation(lastKnownLocation);
            } else {
                HttpSendReq.getInstance().collectException("LocationUtil.obtainLocation: bestProvider is null");
            }
        } catch (Exception e) {
            HttpSendReq.getInstance().collectException("LocationUtil.obtainLocation: " + e.toString());
        }
    }

    private void getLocation(Location location) {
        List<Address> addressList = getAddress(location);
        if (addressList != null && !addressList.isEmpty()) {
            Address detail = addressList.get(0);
            if (detail != null) {
                lon = detail.getLongitude();
                lat = detail.getLatitude();

                String addressLine = detail.getAddressLine(0);
                if (!TextUtils.isEmpty(addressLine)) {
                    mAddressLine = addressLine;
                }
                String adminArea = detail.getAdminArea();
                if (!TextUtils.isEmpty(adminArea)) {
                    mAdminArea = adminArea;
                }
                String subAdminArea = detail.getSubAdminArea();
                String subLocality = detail.getSubLocality();
                if (!TextUtils.isEmpty(subAdminArea)) {
                    mSubAdminArea = subAdminArea;
                } else {
                    mSubAdminArea = subLocality;
                }

//                LogUtil.d("longitude: " + lon);
//                LogUtil.d("latitude: " + lat);
//                LogUtil.d("addressLine: " + mAddressLine);
//                LogUtil.d("adminArea: " + mAdminArea);
//                LogUtil.d("subAdminArea: " + mSubAdminArea);
//
//                LogUtil.d("detail: " + detail.toString());
            }

        } else {
//            LogUtil.d("unknown");
            HttpSendReq.getInstance().collectException("LocationUtil.getLocation: unknown");
        }
    }

    private List<Address> getAddress(Location location) {
        List<Address> result = null;
        try {
            if (location != null) {
                Geocoder gc = new Geocoder(mContext, Locale.getDefault());
                result = gc.getFromLocation(location.getLatitude(),
                        location.getLongitude(), 1);
            } else {
                HttpSendReq.getInstance().collectException("LocationUtil.getAddress: location is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpSendReq.getInstance().collectException("LocationUtil.getAddress: " + e.toString());
            LogUtil.d(e.toString());
        }
        return result;
    }
}
