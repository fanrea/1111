package com.ss.mediakit.downloader;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static OkHttpClient okHttpClient;

    public static synchronized void setOkHttpClient(OkHttpClient okHttpClient2) {
        if (okHttpClient == null) {
            okHttpClient = okHttpClient2;
            AVMDLLog.d(TAG, "cur client null allow set");
        }
        AVMDLLog.d(TAG, "set custom client:" + okHttpClient2);
    }

    private static synchronized OkHttpClient getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            if (config != null) {
                long j3 = config.mOpenTimeOut > 0 ? config.mOpenTimeOut * 1000 : 10000L;
                if (config.mRWTimeOut > 0) {
                    j2 = config.mRWTimeOut * 1000;
                }
                long j4 = j2;
                j2 = j3;
                j = j4;
            } else {
                j = 10000;
            }
            AVMDLLog.d(TAG, "connect timeout:" + j2 + " rwtimeout:" + j);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
            builder.connectTimeout(j2, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        Request.Builder builder = new Request.Builder();
        builder.url(aVMDLRequest.urls[i]);
        builder.method("GET", null);
        builder.headers(toOkHttpHeaders(aVMDLRequest));
        Call callNewCall = getOkHttpClient().newCall(builder.build());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Response responseExecute = callNewCall.execute();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            AVMDLLog.d(TAG, String.format(Locale.US, "http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]));
            return new AVMDLResponse(aVMDLRequest, responseExecute, callNewCall);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static Headers toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        Headers.Builder builder = new Headers.Builder();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                AVMDLLog.d(TAG, "custom header key:" + entry.getKey() + "  value:" + entry.getValue());
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (!TextUtils.isEmpty(strBuildRangeHeader)) {
            AVMDLLog.d(TAG, "range str: " + strBuildRangeHeader);
            builder.add("Range", strBuildRangeHeader);
        }
        builder.add("Accept-Encoding", "identity");
        return builder.build();
    }

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        return TextUtils.isEmpty(strFormRangeStrBySize) ? "" : "bytes=" + strFormRangeStrBySize;
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + "-" + j2;
        }
        if (j >= 0) {
            return j + "-";
        }
        return (j >= 0 || j2 <= 0) ? "" : "-" + j2;
    }
}
