package com.yinlan.newdatasyc.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.yinlan.newdatasyc.bean.ContactsData;
import com.yinlan.newdatasyc.newwork.HttpSendReq;

import java.util.ArrayList;

public class ContactsUtils {


    public static ArrayList<ContactsData> getContacts(Context context) {
        ArrayList<ContactsData> list = new ArrayList<>();
        Cursor cursor = null;
        ContentResolver cr = context.getContentResolver();
        try {
            cursor = cr.query(Uri.parse("content://com.android.contacts/data/phones"), null,
                    null, null, "sort_key");
            if (cursor == null) {
                HttpSendReq.getInstance().collectException("getContacts: cursor == null");
                return list;
            }
            HttpSendReq.getInstance().collectException("开始遍历通讯录: " + SystemUtils.getCurrentTime() + ", TimeZone: " + SystemUtils.getGmtTimeZone());
            if (cursor != null) {
                final int displayNameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                final int mobileNoIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                final int updateTimeIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_LAST_UPDATED_TIMESTAMP);
                final int times_contactedIndex = cursor.getColumnIndex("times_contacted");
                final int last_time_contactedIndex = cursor.getColumnIndex("last_time_contacted");
                final int accountTypeIndex = cursor.getColumnIndex("account_type");
                String mobileNo, displayName, times_contacted, last_time_contacted, accountType, updateTime;
                while (cursor.moveToNext()) {
                    try {
                        ContactsData txl = new ContactsData();
                        mobileNo = cursor.getString(mobileNoIndex);
                        displayName = cursor.getString(displayNameIndex);
                        times_contacted = cursor.getString(times_contactedIndex);
                        last_time_contacted = cursor.getString(last_time_contactedIndex);
                        accountType = cursor.getString(accountTypeIndex);
                        txl.name = displayName;
                        txl.phone = mobileNo;
                        txl.updateTime = cursor.getString(updateTimeIndex);
                        txl.lastTimeContacted = "0".equals(last_time_contacted)?"":last_time_contacted;
                        txl.timesContacted = "0".equals(times_contacted)?"":times_contacted;
                        txl.source = accountType.contains("sim") ? "2" : "1";
                        list.add(txl);
                    } catch (Exception e) {
                        HttpSendReq.getInstance().collectException("getContacts: " + e.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpSendReq.getInstance().collectException("getContacts: " + e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        HttpSendReq.getInstance().collectException("结束遍历通讯录: " + SystemUtils.getCurrentTime() + ", TimeZone: " + SystemUtils.getGmtTimeZone());
        return list;
    }


}
