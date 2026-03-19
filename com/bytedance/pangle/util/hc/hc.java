package com.bytedance.pangle.util.hc;

import com.baidu.mobads.container.util.cm;
import com.bytedance.pangle.c.hc;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.api.an;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static boolean d(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new d(new com.bytedance.pangle.util.hc.d.d().d(str)).d(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 == 1) {
                i5 = hc.d.d;
            } else if (i2 == 2) {
                i5 = hc.d.hc;
            } else {
                i4 = 0;
                String str3 = "rmSo:" + z2 + " rmDex:" + z;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                d(i4, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
                return true;
            }
            i4 = i5;
            String str32 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str32)));
            d(i4, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str32);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    if (i2 == 1) {
                        i3 = hc.d.b;
                    } else {
                        i3 = i2 == 2 ? hc.d.c : 0;
                    }
                    String str4 = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
                    d(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, str4);
                }
                return false;
            } finally {
            }
        }
    }

    private static void d(int i, String str, int i2, long j, Throwable th, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.hc.d(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.hc.d(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.hc.d(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.hc.hc(Long.valueOf(j))));
            jSONObject2.putOpt(cm.V, str2 + com.bytedance.pangle.log.hc.d(th));
        } catch (JSONException e) {
            an.d(e);
        }
        com.bytedance.pangle.c.hc.d().d(com.bytedance.pangle.c.hc.tc, jSONObject, jSONObject3, jSONObject2);
    }
}
