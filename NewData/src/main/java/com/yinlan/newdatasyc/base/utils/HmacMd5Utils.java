package com.yinlan.newdatasyc.base.utils;

import java.io.UnsupportedEncodingException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacMd5Utils {
    private static final String KEY_MAC = "HmacMD5";

    public static String EncryptHMacMd5(byte[] data, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return bytesToHexString(mac.doFinal(data)).toUpperCase();
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if ((src == null) || (src.length <= 0)) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, Exception {
        String src = "{sdfsdfhiosdfj;osjkdag;jsfj;g:zdgsdgg}";
        String sig = EncryptHMacMd5(src.getBytes("UTF-8"), "");
        System.out.println(sig);
    }

}
