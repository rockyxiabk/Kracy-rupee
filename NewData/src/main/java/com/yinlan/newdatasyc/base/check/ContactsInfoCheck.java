package com.yinlan.newdatasyc.base.check;

import android.content.Context;

import com.yinlan.newdatasyc.base.utils.ContactsUtils;
import com.yinlan.newdatasyc.bean.ContactsData;

import java.util.List;


public class ContactsInfoCheck {

    public static void check(Context context) {
        List<ContactsData> data = ContactsUtils.getContacts(context);
//        LogUtils.e("info","ContactsInfoCheck:"+new Gson().toJson(data));
    }

}
