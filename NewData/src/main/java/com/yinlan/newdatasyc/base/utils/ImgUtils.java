package com.yinlan.newdatasyc.base.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.provider.MediaStore;
import android.text.TextUtils;

import com.yinlan.newdatasyc.bean.ImgData;
import com.yinlan.newdatasyc.newwork.HttpSendReq;

import java.util.ArrayList;
import java.util.List;


public class ImgUtils {


    public static List<ImgData> getImgInfos(Context context, ArrayList<ImgData> list) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (cursor == null) {
                HttpSendReq.getInstance().collectException("getImgInfos: cursor == null");
                return list;
            }

            while (cursor.moveToNext()) {
                //获取图片的名称
                String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                //获取图片的生成日期
                byte[] data = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                String path = new String(data, 0, data.length - 1);
                String pathLow = path.toLowerCase();
                initImgData(list, name, pathLow);
            }
        } catch (Exception e) {
            HttpSendReq.getInstance().collectException("getImgInfos: " + e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return list;
    }


    private static void initImgData(ArrayList<ImgData> listData, String name, String path) {
        try {
            if (path.contains("/dcim/camera/") || path.contains("/dcim/100media/") || path.contains("/dcim/100andro/")) {
                ExifInterface exifInterface = new ExifInterface(path);
                String smodel = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
                String smake = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
                String swidth = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
                String sheight = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
                String sdate = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
                String slatitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
                String slatitudeRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
                String latitudeG = String.valueOf(LatLonRational2FloatConverter.convertRationalLatLonToFloat(slatitude, slatitudeRef));
                String slongitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
                String slongitudeRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
                String longitudeG = String.valueOf(LatLonRational2FloatConverter.convertRationalLatLonToFloat(slongitude, slongitudeRef));
                ImgData infoBean = new ImgData();
                infoBean.time = sdate;
                infoBean.height = sheight;
                infoBean.name = name;
                infoBean.latitude = latitudeG;
                infoBean.longitude = longitudeG;
                infoBean.width = swidth;
                infoBean.model = smodel;
                infoBean.make = smake;
                listData.add(infoBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpSendReq.getInstance().collectException("initImgData: " + e.toString());
        }
    }
}
