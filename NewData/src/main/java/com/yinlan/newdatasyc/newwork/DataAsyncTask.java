package com.yinlan.newdatasyc.newwork;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


/**
 * Date: 2020/5/25 下午4:01
 * Author: kay lau
 * Description:
 */
public class DataAsyncTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = DataAsyncTask.class.getSimpleName();

    private String reqUrl;
    private String reqJsonStr;
    private String signMsg;

    public DataAsyncTask(String reqUrl, String reqJsonStr, String signMsg) {
        this.reqUrl = reqUrl;
        this.reqJsonStr = reqJsonStr;
        this.signMsg = signMsg;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        if (TextUtils.isEmpty(reqUrl)) {
            LogUtil.e("reqUrl = null");
            return null;
        }
        String result = null;
        try {
            result = StatisticLogManage.statisticLog(reqUrl, reqJsonStr, signMsg);
            LogUtil.e("req result: " + result);
        } catch (UnknownHostException e) {
            LogUtil.e("UnknownHostException doInBackground: " + e.toString());
        } catch (SocketTimeoutException e) {
            LogUtil.e("SocketTimeoutException doInBackground: " + e.toString());
        } catch (StatisticLogManage.HttpStateException e) {
            LogUtil.e("Exception doInBackground: " + e.toString());
        } catch (Exception e) {
            LogUtil.e("doInBackground: " + e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}
