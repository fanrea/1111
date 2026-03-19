package com.fendasz.moku.planet.common.network.interceptor;

import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.utils.LogUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LogInterceptor implements Interceptor {
    public static String TAG = "LogInterceptor";
    public static int httpId;

    private static boolean isDebug() {
        return false;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        httpId = createRandomNumber(1000, 9999);
        Request request = chain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Response responseProceed = chain.proceed(chain.request());
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        MediaType mediaType = responseProceed.body().get$contentType();
        String strString = responseProceed.body().string();
        if (isDebug()) {
            LogUtils.logD(TAG, httpId + "----------Start----------------");
            LogUtils.logD(TAG, httpId + "==URL=>" + request.url());
        }
        String strMethod = request.method();
        if (isDebug()) {
            LogUtils.logD(TAG, httpId + "==METHOD=>" + strMethod);
            if (request.body() != null) {
                LogUtils.logD(TAG, httpId + "==REQUEST=>" + request.body().toString());
            }
        }
        Set<String> setNames = request.headers().names();
        if (setNames != null && !setNames.isEmpty()) {
            HashMap map = new HashMap();
            for (String str : setNames) {
                map.put(str, request.header(str));
            }
            if (isDebug()) {
                LogUtils.logD(TAG, httpId + "==HEADERS=>" + JSON.toJSON(map));
            }
        }
        if (request.method().equals(strMethod)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody formBody = (FormBody) request.body();
                for (int i = 0; i < formBody.size(); i++) {
                    sb.append(formBody.encodedName(i) + "=" + formBody.encodedValue(i) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                if (isDebug()) {
                    LogUtils.logD(TAG, httpId + "==PARAMS=>" + sb.toString());
                }
            }
        }
        if (isDebug() && strString != null) {
            if (strString.length() >= 4000) {
                logLong(strString);
            } else {
                LogUtils.logD(TAG, httpId + "==REPONSE=>" + strString);
            }
            LogUtils.logD(TAG, httpId + "----------End:" + jCurrentTimeMillis2 + "millisecond----------");
        }
        return responseProceed.newBuilder().body(ResponseBody.create(mediaType, strString)).build();
    }

    private static int createRandomNumber(int i, int i2) {
        return (int) (i + (Math.random() * i2));
    }

    public static void logLong(String str) {
        int length = 2001 - TAG.length();
        while (str.length() > length) {
            LogUtils.logD(TAG, str.substring(0, length));
            str = str.substring(length);
        }
        LogUtils.logD(TAG, str);
    }
}
