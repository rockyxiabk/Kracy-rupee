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
public class HttpAsyncTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = HttpAsyncTask.class.getSimpleName();

    private String reqUrl;
    private String reqJsonStr;
    private String signMsg;

    public HttpAsyncTask(String reqUrl, String reqJsonStr, String signMsg) {
        this.reqUrl = reqUrl;
        this.reqJsonStr = reqJsonStr;
        this.signMsg = signMsg;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        if (TextUtils.isEmpty(reqUrl)) {
            LogUtil.e(TAG, "reqUrl = null");
            return null;
        }
        try {
            String result = StatisticLogManage.statisticLog(reqUrl, reqJsonStr, signMsg);
            LogUtil.e(TAG, "req result: " + result);
        } catch (UnknownHostException e) {
            LogUtil.e(TAG, "UnknownHostException doInBackground: " + e.toString());
        } catch (SocketTimeoutException e) {
            LogUtil.e(TAG, "SocketTimeoutException doInBackground: " + e.toString());
        } catch (StatisticLogManage.HttpStateException e) {
            LogUtil.e(TAG, "Exception doInBackground: " + e.toString());
        } catch (Exception e) {
            LogUtil.e(TAG, "doInBackground: " + e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}
