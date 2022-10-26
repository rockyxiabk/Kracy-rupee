package com.yinlan.newdatasyc.newwork;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 统计错误信息
 */
public class StatisticLogManage {


    public static String statisticLog(String requestUrl, String reqParamStr, String signMsgStr) throws Exception {

        LogUtil.e(requestUrl);

        LogUtil.e("reqParamStr: " + reqParamStr);
        LogUtil.e("signMsgStr: " + signMsgStr);

        String result = "";
        HttpURLConnection conn;

        URL url = new URL(requestUrl);
        conn = (HttpURLConnection) url.openConnection();

        // 设置允许输出
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 设置不用缓存
        conn.setUseCaches(false);
        conn.setRequestProperty("signMsg", signMsgStr);
        // 设置传递方式
        conn.setRequestMethod("POST");
        // 设置维持长连接
        conn.setRequestProperty("Connection", "Keep-Alive");
        // 设置文件字符集:
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", reqParamStr.getBytes().length + ""); //设置文件请求的长度  
        conn.setReadTimeout(180 * 1000);//设置读取超时时间          
        conn.setConnectTimeout(120 * 1000);//设置连接超时时间      
        OutputStream out = conn.getOutputStream();
        out.write(reqParamStr.getBytes());
        out.flush();
        out.close();
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;
            // 创建字节数组输出流,读取输入流的文本数据时,同步把数据写入数组输出流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            // 把字节数组输出流的数据转换成字节数组
            result = new String(bos.toByteArray(), "utf-8");
        } else {
            throw new HttpStateException(String.valueOf(conn.getResponseCode()));
        }
        conn.disconnect();
        return result;
    }

    public static class HttpStateException extends Exception {

        HttpStateException(String exception) {
            super(exception);
        }
    }
}
