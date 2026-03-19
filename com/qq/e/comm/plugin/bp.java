package com.qq.e.comm.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bp {
    private String a;
    private String[] b;
    private int c;
    private long d;

    private bp() {
    }

    public String a() {
        return this.a;
    }

    public String[] c() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public boolean d() {
        if (!TextUtils.isEmpty(this.a)) {
            long j = this.d;
            if (j <= 0 || j > SystemClock.elapsedRealtime()) {
                return true;
            }
        }
        return false;
    }

    public static bp a(JSONObject jSONObject, long j) {
        int length;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("market_info");
        if (ln.b(jSONObjectOptJSONObject)) {
            return null;
        }
        bp bpVar = new bp();
        bpVar.c = jSONObjectOptJSONObject.optInt("mt");
        bpVar.a = jSONObjectOptJSONObject.optString("dl");
        long jOptLong = jSONObjectOptJSONObject.optLong("et");
        if (jOptLong > 0) {
            bpVar.d = (jOptLong * 60000) + j;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(Config.PACKAGE_NAME);
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArrayOptJSONArray.optString(i);
            }
            bpVar.b = strArr;
        }
        return bpVar;
    }
}
