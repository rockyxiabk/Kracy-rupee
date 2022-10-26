package com.yinlan.newdatasyc.base.check;

import android.content.Context;

import com.yinlan.newdatasyc.base.utils.SMSUtils;
import com.yinlan.newdatasyc.bean.SMSData;

import java.util.List;

public class SMSInfoCheck {

    public static void check(Context context) {
        List<SMSData> data = SMSUtils.getSmsInfos(context);
//        LogUtils.e("info", "SMSInfoCheck:" + new Gson().toJson(data));
    }

}
