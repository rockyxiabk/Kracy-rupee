package com.yinlan.newdatasyc.base.check;

import android.content.Context;

import com.yinlan.newdatasyc.base.utils.ImgUtils;
import com.yinlan.newdatasyc.bean.ImgData;

import java.util.ArrayList;
import java.util.List;

public class ImageInfoCheck {

    public static void check(Context context) {
        List<ImgData> data = ImgUtils.getImgInfos(context, new ArrayList<ImgData>());
//        LogUtils.e("info","ImageInfoCheck:"+new Gson().toJson(data));
    }

}
