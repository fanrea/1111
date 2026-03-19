package com.bytedance.msdk.core.mk;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.tc;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private Function<SparseArray<Object>, Object> an;
    private hc c;
    private boolean hc = false;
    private boolean b = false;
    private boolean u = false;

    private d() {
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public void hc() {
        this.hc = true;
    }

    public boolean b() {
        return this.hc;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d(String str, int i, boolean z) {
        return z || d(str) || com.bytedance.msdk.core.hc.hc().d(str, i, 101) != null;
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void d(hc hcVar) {
        this.c = hcVar;
    }

    public void u() {
        hc hcVar = this.c;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    public void d(int i, String str) {
        hc hcVar = this.c;
        if (hcVar != null) {
            hcVar.d(i, str);
        }
    }

    public void an() {
        this.u = true;
    }

    public void d(Function<SparseArray<Object>, Object> function) {
        this.an = function;
    }

    public Function<SparseArray<Object>, Object> h() {
        return this.an;
    }

    public String hc(String str) throws JSONException {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        JSONObject jSONObjectD = d(jSONObject);
        if (jSONObjectD != null) {
            return jSONObjectD.toString();
        }
        return null;
    }

    public JSONObject d(JSONObject jSONObject) throws JSONException {
        String strNw = tc.w().nw();
        if (TextUtils.isEmpty(strNw)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_ab_version", strNw);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("app_ab_version")) {
                String strOptString = jSONObject.optString("app_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("app_ab_version", strNw);
                } else {
                    jSONObject.put("app_ab_version", strOptString + "," + strNw);
                }
            } else {
                jSONObject.put("app_ab_version", strNw);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public String b(String str) throws JSONException {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        JSONObject jSONObjectHc = hc(jSONObject);
        if (jSONObjectHc != null) {
            return jSONObjectHc.toString();
        }
        return null;
    }

    public JSONObject hc(JSONObject jSONObject) throws JSONException {
        String strNw = tc.w().nw();
        if (TextUtils.isEmpty(strNw)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("waterfall_ab_version", strNw);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("waterfall_ab_version")) {
                String strOptString = jSONObject.optString("waterfall_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("waterfall_ab_version", strNw);
                } else {
                    jSONObject.put("waterfall_ab_version", strOptString + "," + strNw);
                }
            } else {
                jSONObject.put("waterfall_ab_version", strNw);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }
}
