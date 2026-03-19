package com.ss.android.downloadlib.addownload.hc;

import com.bytedance.sdk.component.utils.mq;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public String an;
    public long b;
    public String c;
    public long d;
    public volatile long gb;
    public String h;
    public long hc;
    public String u;

    public d() {
    }

    public d(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.d = j;
        this.hc = j2;
        this.b = j3;
        this.c = str;
        this.u = str2;
        this.an = str3;
        this.h = str4;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.d);
            jSONObject.put("mAdId", this.hc);
            jSONObject.put("mExtValue", this.b);
            jSONObject.put("mPackageName", this.c);
            jSONObject.put("mAppName", this.u);
            jSONObject.put("mLogExtra", this.an);
            jSONObject.put("mFileName", this.h);
            jSONObject.put("mTimeStamp", this.gb);
        } catch (JSONException e) {
            mq.d(e);
        }
        return jSONObject;
    }

    public static d d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        try {
            dVar.d = uo.d(jSONObject, "mDownloadId");
            dVar.hc = uo.d(jSONObject, "mAdId");
            dVar.b = uo.d(jSONObject, "mExtValue");
            dVar.c = jSONObject.optString("mPackageName");
            dVar.u = jSONObject.optString("mAppName");
            dVar.an = jSONObject.optString("mLogExtra");
            dVar.h = jSONObject.optString("mFileName");
            dVar.gb = uo.d(jSONObject, "mTimeStamp");
            return dVar;
        } catch (Exception e) {
            mq.d(e);
            return null;
        }
    }
}
