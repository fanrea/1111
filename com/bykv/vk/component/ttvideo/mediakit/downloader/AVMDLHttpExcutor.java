package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.hc.d.an;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.e;
import com.bytedance.sdk.component.hc.d.hc;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import com.bytedance.sdk.component.hc.d.uo;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static mq okHttpClient;

    private static synchronized mq getOkHttpClient() {
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
            mq.d dVar = new mq.d();
            dVar.d(Collections.singletonList(uo.HTTP_1_1));
            dVar.d(j2, TimeUnit.MILLISECONDS).hc(j, TimeUnit.MILLISECONDS).b(j, TimeUnit.MILLISECONDS);
            okHttpClient = dVar.d();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        k.d dVar = new k.d();
        dVar.d(aVMDLRequest.urls[i]);
        dVar.d("GET", (e) null);
        dVar.d(toOkHttpHeaders(aVMDLRequest));
        hc hcVarD = getOkHttpClient().d(dVar.hc());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            cb cbVarD = hcVarD.d();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, cbVarD, hcVarD);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static an toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        an.d dVar = new an.d();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                entry.getKey();
                entry.getValue();
                dVar.hc(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            dVar.hc("Range", strBuildRangeHeader);
        }
        dVar.hc("Accept-Encoding", "identity");
        return dVar.d();
    }

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        if (strFormRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(String.valueOf(strFormRangeStrBySize));
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
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(j2));
    }
}
