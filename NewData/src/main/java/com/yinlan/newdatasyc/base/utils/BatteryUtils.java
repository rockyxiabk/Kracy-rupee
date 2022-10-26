package com.yinlan.newdatasyc.base.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

public class BatteryUtils {
    public class BatteryData {
        public int status;
        public int level;
        public int max;
        public int plugged;
    }

    Context mContext;
    Action<BatteryData> mAction1;

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BatteryData data = new BatteryData();
            int rawlevel = intent.getIntExtra("level", -1);
            int scale = intent.getIntExtra("scale", -1);
            int status = intent.getIntExtra("status", -1);
            int plugged = intent.getIntExtra("plugged", 0);
            //int health = intent.getIntExtra("health", -1);
            int level = 0;
            int max = 0;
            if (rawlevel >= 0 && scale > 0) {
                level = (rawlevel * 100) / scale;
            }
            if (scale > 0) {
                max = 100 / scale;
            }
            data.level = level;
            data.status = status;
            data.max = max;
            mAction1.call(data);
            mContext.unregisterReceiver(mReceiver);
        }
    };

    public BatteryUtils(Context context, Action<BatteryData> action) {
        mContext = context;
        BatteryManager batteryManager;
        IntentFilter filter;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            batteryManager = (BatteryManager) context.getSystemService(context.BATTERY_SERVICE);
            BatteryData data = new BatteryData();
            data.level = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            data.status = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS);
            data.max = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
            action.call(data);
        } else {
            filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            context.registerReceiver(mReceiver, filter);
        }
    }
}
