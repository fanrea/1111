package com.ss.android.downloadlib.addownload.compliance;

import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class h {
    public static void d(String str, long j) {
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        if (uVarU.np()) {
            return;
        }
        uVarU.b.d(str);
        com.ss.android.downloadlib.c.d.d().hc("lp_app_dialog_click", uVarU);
    }

    public static void hc(String str, long j) {
        d(str, null, j);
    }

    public static void d(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.c.d.d().hc(str, jSONObject, com.ss.android.downloadlib.addownload.hc.an.d().u(j));
    }

    public static void d(String str, com.ss.android.downloadlib.addownload.hc.u uVar) {
        com.ss.android.downloadlib.c.d.d().hc(str, uVar);
    }

    public static void d(int i, com.ss.android.downloadlib.addownload.hc.u uVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().hc("lp_compliance_error", jSONObject, uVar);
    }

    public static void d(int i, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.downloadlib.c.d.d().hc("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.hc.an.d().u(j));
    }
}
