package com.yinlan.newdatasyc.base.utils;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.File;
import java.lang.reflect.Method;

public class StorageUtils {

    private static final int INTERNAL_STORAGE = 0;
    private static final int EXTERNAL_STORAGE = 1;


    /**
     * 获取 手机 RAM 信息
     */
    public static long getRAMTotal(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo outInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(outInfo);
        return outInfo.totalMem;
    }

    public static long getRAMAvailable(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo outInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(outInfo);
        return outInfo.availMem;
    }

    /**
     * 获取手机内部存储空间
     */
    public static long getInternalTotal() {
        File file = Environment.getDataDirectory();
        StatFs statFs = new StatFs(file.getPath());
        long blockSizeLong = statFs.getBlockSizeLong();
        long blockCountLong = statFs.getBlockCountLong();
        return blockCountLong * blockSizeLong;

    }

    /**
     * 获取手机内部可用存储空间
     */
    public static long getInternalAvailable() {
        File file = Environment.getDataDirectory();
        StatFs statFs = new StatFs(file.getPath());
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        return availableBlocksLong * blockSizeLong;
    }


    /**
     * 获取手机外部存储空间
     */
    public static long getExternalTotal() {
        File file = Environment.getExternalStorageDirectory();
        StatFs statFs = new StatFs(file.getPath());
        long blockSizeLong = statFs.getBlockSizeLong();
        long blockCountLong = statFs.getBlockCountLong();
        return blockCountLong * blockSizeLong;
    }

    /**
     * 获取手机外部可用存储空间
     */
    public static long getExternalAvailable() {
        File file = Environment.getExternalStorageDirectory();
        StatFs statFs = new StatFs(file.getPath());
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        return availableBlocksLong * blockSizeLong;
    }

    /**
     * 判断SD是否挂载
     */
    public static boolean isSDCardMount() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取手机存储 ROM 信息
     * <p>
     * type： 用于区分内置存储于外置存储的方法
     * <p>
     * 内置SD卡 ：INTERNAL_STORAGE = 0;
     * <p>
     * 外置SD卡： EXTERNAL_STORAGE = 1;
     **/
    public static boolean getStorageInfo(Context context, int type) {

        String path = getStoragePath(context, type);
        /**
         * 无外置SD 卡判断
         * **/
        if (isSDCardMount() == false || TextUtils.isEmpty(path) || path == null)
            return false;
        else
            return true;


    }

    /**
     * 使用反射方法 获取手机存储路径
     **/
    public static String getStoragePath(Context context, int type) {

        StorageManager sm = (StorageManager) context
                .getSystemService(Context.STORAGE_SERVICE);
        try {
            Method getPathsMethod = sm.getClass().getMethod("getVolumePaths",
                    String.class);
            String[] path = (String[]) getPathsMethod.invoke(sm, Object.class);

            switch (type) {
                case INTERNAL_STORAGE:
                    return path[type];
                case EXTERNAL_STORAGE:
                    if (path.length > 1) {
                        return path[type];
                    } else {
                        return null;
                    }

                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * SD 卡信息
     */

    public static String getSDCardInfo() {

        SDCardInfo sd = new SDCardInfo();
        if (!isSDCardMount())
            return "SD card 未挂载!";

        sd.isExist = true;
        StatFs sf = new StatFs(Environment.getExternalStorageDirectory()
                .getPath());

        sd.totalBlocks = sf.getBlockCountLong();
        sd.blockByteSize = sf.getBlockSizeLong();
        sd.availableBlocks = sf.getAvailableBlocksLong();
        sd.availableBytes = sf.getAvailableBytes();
        sd.freeBlocks = sf.getFreeBlocksLong();
        sd.freeBytes = sf.getFreeBytes();
        sd.totalBytes = sf.getTotalBytes();
        return sd.toString();
    }


    public static class SDCardInfo {
        boolean isExist;
        long totalBlocks;
        long freeBlocks;
        long availableBlocks;
        long blockByteSize;
        long totalBytes;
        long freeBytes;
        long availableBytes;

        @Override
        public String toString() {
            return "isExist=" + isExist + "\ntotalBlocks=" + totalBlocks
                    + "\nfreeBlocks=" + freeBlocks + "\navailableBlocks="
                    + availableBlocks + "\nblockByteSize=" + blockByteSize
                    + "\ntotalBytes=" + totalBytes + "\nfreeBytes=" + freeBytes
                    + "\navailableBytes=" + availableBytes;
        }
    }

    // add start by wangjie for SDCard TotalStorage
    public static String getSDCardTotalStorage(long totalByte) {

        double byte2GB = totalByte / 1024.00 / 1024.00 / 1024.00;
        double totalStorage;
        if (byte2GB > 1) {
            totalStorage = Math.ceil(byte2GB);
            if (totalStorage > 1 && totalStorage < 3) {
                return 2.0 + "GB";
            } else if (totalStorage > 2 && totalStorage < 5) {
                return 4.0 + "GB";
            } else if (totalStorage >= 5 && totalStorage < 10) {
                return 8.0 + "GB";
            } else if (totalStorage >= 10 && totalStorage < 18) {
                return 16.0 + "GB";
            } else if (totalStorage >= 18 && totalStorage < 34) {
                return 32.0 + "GB";
            } else if (totalStorage >= 34 && totalStorage < 50) {
                return 48.0 + "GB";
            } else if (totalStorage >= 50 && totalStorage < 66) {
                return 64.0 + "GB";
            } else if (totalStorage >= 66 && totalStorage < 130) {
                return 128.0 + "GB";
            }
        } else {
            // below 1G return get values
            totalStorage = totalByte / 1024.00 / 1024.00;

            if (totalStorage >= 515 && totalStorage < 1024) {
                return 1 + "GB";
            } else if (totalStorage >= 260 && totalStorage < 515) {
                return 512 + "MB";
            } else if (totalStorage >= 130 && totalStorage < 260) {
                return 256 + "MB";
            } else if (totalStorage > 70 && totalStorage < 130) {
                return 128 + "MB";
            } else if (totalStorage > 50 && totalStorage < 70) {
                return 64 + "MB";
            }
        }

        return totalStorage + "GB";
    }

    public static final int STORAGE_AUDIO = 1;
    public static final int STORAGE_IMAGE = 2;
    public static final int STORAGE_VIDEO = 3;

    /**
     * 获取所有文件
     **/
    public static int getFilesByType(Context context, int type) {
        int count = 0;
        Cursor c = null;
        ContentResolver mContentResolver = null;
        try {
            mContentResolver = context.getContentResolver();
            if (type == StorageUtils.STORAGE_AUDIO) {
                c = mContentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            } else if (type == StorageUtils.STORAGE_IMAGE) {
                c = mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            } else if (type == StorageUtils.STORAGE_VIDEO) {
                c = mContentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            }
            while (c.moveToNext()) {
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return count;
    }

}