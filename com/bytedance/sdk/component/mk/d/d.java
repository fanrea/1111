package com.bytedance.sdk.component.mk.d;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.mk.c.c;
import com.bytedance.sdk.component.mk.c.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private c an;
    private com.bytedance.sdk.component.mk.b.d b;
    private String c;
    private JSONObject d;
    private String gb;
    private c h;
    private Map<String, Object> hc;
    private com.bytedance.sdk.component.mk.c.hc mk;
    private int tc = 1;
    private Map<String, Object> tt;
    private String u;

    public d(com.bytedance.sdk.component.mk.b.d dVar, JSONObject jSONObject, Map<String, Object> map) {
        this.b = dVar;
        this.d = jSONObject;
        this.hc = map;
    }

    public d(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.d = jSONObject;
        this.hc = map;
    }

    public Map<String, Object> d() {
        return this.hc;
    }

    public Map<String, Object> hc() {
        return this.tt;
    }

    public JSONObject b() {
        return this.d;
    }

    public void d(String str) {
        this.u = str;
    }

    public String c() {
        return this.u;
    }

    public c u() {
        return this.an;
    }

    public void d(c cVar) {
        if (cVar instanceof hc) {
            this.an = cVar;
        } else {
            this.h = cVar;
        }
    }

    private void gb() {
        if (this.tc != 2) {
            com.bytedance.sdk.component.mk.b.d dVar = this.b;
            if (dVar == null) {
                return;
            } else {
                this.gb = dVar.hc();
            }
        }
        if (!TextUtils.isEmpty(this.gb)) {
            this.c = Uri.parse(this.gb).getHost();
        }
        if (!TextUtils.isEmpty(this.c)) {
            String str = this.c.split("/")[0];
            this.c = str;
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                iIndexOf = this.c.length();
            }
            this.c = this.c.substring(0, iIndexOf);
        }
        hc(this.gb);
    }

    private void hc(String str) {
        JSONObject jSONObjectD = com.bytedance.sdk.component.mk.gb.hc.d(str);
        if (jSONObjectD == null) {
            return;
        }
        Iterator<String> itKeys = jSONObjectD.keys();
        this.tt = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObjectD.opt(next);
                if (objOpt instanceof String) {
                    objOpt = d((String) objOpt, this.d);
                }
                this.tt.put(next, objOpt);
            }
        }
    }

    private static Object d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            return (str.startsWith("${") && str.endsWith(i.d)) ? com.bytedance.adsdk.hc.hc.d.d(str.substring(2, str.length() - 1)).d(jSONObject) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public void d(com.bytedance.sdk.component.mk.c.hc hcVar) {
        this.mk = hcVar;
    }

    public void an() {
        gb();
        com.bytedance.sdk.component.mk.c.hc hcVar = this.mk;
        if (hcVar != null) {
            hcVar.d();
        } else {
            com.bytedance.sdk.component.mk.h.d.d().d(this.c, this, new com.bytedance.sdk.component.mk.c.d() { // from class: com.bytedance.sdk.component.mk.d.d.1
            });
        }
    }

    public void d(Map<String, Object> map) {
        u uVarHc;
        u uVarHc2;
        c cVar = this.an;
        if (cVar != null && (uVarHc2 = cVar.hc()) != null) {
            uVarHc2.d(this, map);
        }
        c cVar2 = this.h;
        if (cVar2 == null || (uVarHc = cVar2.hc()) == null) {
            return;
        }
        uVarHc.d(this, map);
    }

    public void hc(Map<String, Object> map) {
        u uVarHc;
        u uVarHc2;
        c cVar = this.an;
        if (cVar != null && (uVarHc2 = cVar.hc()) != null) {
            uVarHc2.hc(this, this.hc);
        }
        c cVar2 = this.h;
        if (cVar2 == null || (uVarHc = cVar2.hc()) == null) {
            return;
        }
        uVarHc.hc(this, map);
    }

    public com.bytedance.sdk.component.mk.b.d h() {
        return this.b;
    }
}
