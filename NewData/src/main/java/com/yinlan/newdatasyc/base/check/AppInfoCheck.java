package com.yinlan.newdatasyc.base.check;


import android.content.Context;

import com.yinlan.newdatasyc.base.utils.AppUtils;
import com.yinlan.newdatasyc.bean.AppData;

import java.util.ArrayList;
import java.util.List;


public class AppInfoCheck   {

    public static void check(Context context) {
        List<AppData> data = AppUtils.getInstallApps(context,new ArrayList<AppData>());
//        LogUtils.e("info","AppInfoCheck:"+new Gson().toJson(data));
    }

}
