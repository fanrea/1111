package com.bytedance.sdk.djx.net;

import android.os.SystemClock;
import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.djx.net.log.Upload4AppLog;
import com.bytedance.sdk.djx.utils.LG;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RequestLogUtil {
    public static final String REQUEST_COST = "t_sdk_request_cost";
    public static final String REQUEST_PARSE_COST = "t_sdk_request_parse_cost";
    private static final String TAG = "RequestLogUtil";

    public static void sendRequestLog(String str, long j, boolean z, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", "2.9.0.2");
            if (j > 0) {
                jSONObject.put("cost", SystemClock.elapsedRealtime() - j);
            }
            jSONObject.put("relativePath", str);
            jSONObject.put("result", z ? "1" : "0");
            jSONObject.put(e.s, str2);
        } catch (Throwable th) {
            LG.e(TAG, "sendRequestLog error:" + th.getMessage());
        }
        Upload4AppLog.DEFAULT.send(REQUEST_COST, null, jSONObject, null);
    }

    public static void sendRequestBeanParseLog(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", "2.9.0.2");
            jSONObject.put("cost", j);
            jSONObject.put("beanClassName", str);
        } catch (Throwable th) {
            LG.e(TAG, "sendRequestBeanParseLog error:" + th.getMessage());
        }
        Upload4AppLog.DEFAULT.send(REQUEST_PARSE_COST, null, jSONObject, null);
    }
}
