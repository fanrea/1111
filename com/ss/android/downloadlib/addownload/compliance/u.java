package com.ss.android.downloadlib.addownload.compliance;

import com.baidu.mobads.container.util.cm;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import com.ss.android.downloadlib.h.uo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    private int an;
    private int b;
    private int c;
    private boolean d;
    private String e;
    private String gb;
    private String h;
    private d hc;
    private hc k;
    private long mk;
    private String mq;
    private String tc;
    private int tt;
    private int u = 15;
    private String uo;

    public void d(boolean z) {
        this.d = z;
    }

    public void d(d dVar) {
        this.hc = dVar;
    }

    public void d(int i) {
        this.b = i;
    }

    public void hc(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.u = i;
    }

    public void c(int i) {
        this.an = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public void hc(String str) {
        this.gb = str;
    }

    public int d() {
        return this.tt;
    }

    public void u(int i) {
        this.tt = i;
    }

    public void b(String str) {
        this.tc = str;
    }

    public void d(long j) {
        this.mk = j;
    }

    public void d(hc hcVar) {
        this.k = hcVar;
    }

    public void c(String str) {
        this.e = str;
    }

    public void u(String str) {
        this.mq = str;
    }

    public String hc() {
        return this.uo;
    }

    public void an(String str) {
        this.uo = str;
    }

    public static class d {
        private String an;
        private long b;
        private long c;
        private String d;
        private String gb;
        private List<C0750d> h;
        private String hc;
        private String mk;
        private String mq;
        private String tc;
        private String tt;
        private String u;

        public void d(String str) {
            this.d = str;
        }

        public void hc(String str) {
            this.hc = str;
        }

        public void d(long j) {
            this.b = j;
        }

        public void hc(long j) {
            this.c = j;
        }

        public void b(String str) {
            this.u = str;
        }

        public void c(String str) {
            this.an = str;
        }

        public void u(String str) {
            this.gb = str;
        }

        public void d(List<C0750d> list) {
            this.h = list;
        }

        public void an(String str) {
            this.tt = str;
        }

        public void h(String str) {
            this.tc = str;
        }

        public void gb(String str) {
            this.mk = str;
        }

        public void tt(String str) {
            this.mq = str;
        }

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.u$d$d, reason: collision with other inner class name */
        public static class C0750d {
            private String d;
            private String hc;

            public void d(String str) {
                this.d = str;
            }

            public void hc(String str) {
                this.hc = str;
            }
        }
    }

    public static class hc {
        private int d;
        private String hc;

        public void d(int i) {
            this.d = i;
        }

        public void d(String str) {
            this.hc = str;
        }
    }

    public String toString() {
        return d(this);
    }

    public static String d(u uVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(uVar.d ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(uVar.b));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(uVar.c));
            jSONObject.putOpt("market_online_status", Integer.valueOf(uVar.u));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(uVar.an));
            jSONObject.putOpt(n.p, uVar.h);
            jSONObject.putOpt("hijack_url", uVar.gb);
            jSONObject.putOpt("code", Integer.valueOf(uVar.tt));
            jSONObject.putOpt(cm.V, uVar.tc);
            jSONObject.putOpt("request_duration", Long.valueOf(uVar.mk));
            jSONObject.putOpt("auth_info", hc(uVar.hc));
            jSONObject.putOpt("status", hc(uVar.k));
            jSONObject.putOpt("back_web_url", uVar.e);
            jSONObject.putOpt("hw_app_id", uVar.mq);
            jSONObject.putOpt("deep_link", uVar.uo);
        } catch (JSONException e) {
            com.ss.android.downloadlib.u.b.d().d(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    public static u h(String str) throws JSONException {
        u uVar = new u();
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVarD = d(jSONObject);
            hc hcVarHc = hc(jSONObject);
            uVar.d(dVarD);
            uVar.d(hcVarHc);
            uVar.d(jSONObject.optInt("show_auth", 0) == 1);
            uVar.d(jSONObject.optInt("download_permit"));
            uVar.hc(jSONObject.optInt("appstore_permit"));
            uVar.b(jSONObject.optInt("market_online_status", 15));
            uVar.c(jSONObject.optInt("hijack_permit"));
            uVar.d(jSONObject.optString(n.p));
            uVar.hc(jSONObject.optString("hijack_url"));
            uVar.u(jSONObject.optInt("code"));
            uVar.b(jSONObject.optString(cm.V));
            uVar.d(jSONObject.optLong("request_duration", 0L));
            uVar.c(jSONObject.optString("back_web_url"));
            uVar.u(jSONObject.optString("hw_app_id"));
            uVar.an(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "ComplianceResult fromJson");
        }
        return uVar;
    }

    private static d d(JSONObject jSONObject) throws JSONException {
        d dVar = new d();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                dVar.d(jSONObjectOptJSONObject.optString("app_name"));
                dVar.hc(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                dVar.d(uo.d(jSONObjectOptJSONObject, "update_time"));
                dVar.hc(uo.d(jSONObjectOptJSONObject, "size"));
                dVar.b(jSONObjectOptJSONObject.optString("developer_name"));
                dVar.c(jSONObjectOptJSONObject.optString(n.p));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    d(jSONArrayOptJSONArray, arrayList);
                    dVar.d(arrayList);
                }
                dVar.u(jSONObjectOptJSONObject.optString("permission_classify_url"));
                dVar.an(jSONObjectOptJSONObject.optString("policy_url"));
                dVar.h(jSONObjectOptJSONObject.optString("icon_url"));
                dVar.gb(jSONObjectOptJSONObject.optString("download_url"));
                dVar.tt(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "ComplianceResult getAuthInfo");
        }
        return dVar;
    }

    private static JSONObject hc(d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (dVar != null) {
            jSONObject.putOpt("app_name", dVar.d);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, dVar.hc);
            jSONObject.putOpt("update_time", Long.valueOf(dVar.b));
            jSONObject.putOpt("size", Long.valueOf(dVar.c));
            jSONObject.putOpt("developer_name", dVar.u);
            jSONObject.putOpt("policy_url", dVar.tt);
            jSONObject.putOpt("icon_url", dVar.tc);
            jSONObject.putOpt("download_url", dVar.mk);
            jSONObject.putOpt("permissions", b(dVar));
            jSONObject.putOpt("permission_classify_url", dVar.gb);
            jSONObject.putOpt("desc_url", dVar.mq);
        }
        return jSONObject;
    }

    private static hc hc(JSONObject jSONObject) throws JSONException {
        hc hcVar = new hc();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                hcVar.d(jSONObjectOptJSONObject.optInt("status"));
                hcVar.d(jSONObjectOptJSONObject.optString(cm.V));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.u.b.d().d(e, "ComplianceResult getStatus");
        }
        return hcVar;
    }

    private static JSONObject hc(hc hcVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hcVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(hcVar.d));
            jSONObject.putOpt(cm.V, hcVar.hc);
        }
        return jSONObject;
    }

    private static void d(JSONArray jSONArray, List<d.C0750d> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                d.C0750d c0750d = new d.C0750d();
                c0750d.d(jSONObjectOptJSONObject.optString("permission_name"));
                c0750d.hc(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0750d);
            }
        }
    }

    private static JSONArray b(d dVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<d.C0750d> list = dVar.h;
        if (list != null && list.size() > 0) {
            for (d.C0750d c0750d : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0750d.d);
                jSONObject.putOpt("permission_desc", c0750d.hc);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
