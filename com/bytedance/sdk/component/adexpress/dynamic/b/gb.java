package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private float an;
    private float b;
    private float c;
    private String d;
    private float gb;
    private float h;
    private float hc;
    private boolean k;
    private gb mk;
    private List<List<gb>> mq;
    private List<gb> tc;
    private u tt;
    private float u;
    private String uo;
    private Map<String, String> e = new HashMap();
    private Map<Integer, String> cb = new HashMap();

    public String d() {
        return this.uo;
    }

    public void d(String str) {
        this.uo = str;
    }

    public Map<Integer, String> hc() {
        return this.cb;
    }

    public void d(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.cb.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString(com.alipay.sdk.m.p0.b.d));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String b() {
        return this.d;
    }

    public void hc(String str) {
        this.d = str;
    }

    public float c() {
        return this.c;
    }

    public void d(float f) {
        this.c = f;
    }

    public float u() {
        return this.u;
    }

    public void hc(float f) {
        this.u = f;
    }

    public float an() {
        return this.hc;
    }

    public void b(float f) {
        this.hc = f;
    }

    public float h() {
        return this.b;
    }

    public void c(float f) {
        this.b = f;
    }

    public float gb() {
        return this.an;
    }

    public void u(float f) {
        this.an = f;
    }

    public float tt() {
        return this.h;
    }

    public void an(float f) {
        this.h = f;
    }

    public void h(float f) {
        this.gb = f;
    }

    public u tc() {
        return this.tt;
    }

    public void d(u uVar) {
        this.tt = uVar;
    }

    public List<gb> mk() {
        return this.tc;
    }

    public void d(List<gb> list) {
        this.tc = list;
    }

    public void d(gb gbVar) {
        this.mk = gbVar;
    }

    public gb mq() {
        return this.mk;
    }

    public int uo() {
        an anVarU = this.tt.u();
        return anVarU.ru() + anVarU.yn();
    }

    public int k() {
        an anVarU = this.tt.u();
        return anVarU.wl() + anVarU.q();
    }

    public float e() {
        an anVarU = this.tt.u();
        return uo() + anVarU.e() + anVarU.cb() + (anVarU.mq() * 2.0f);
    }

    public float cb() {
        an anVarU = this.tt.u();
        return k() + anVarU.w() + anVarU.k() + (anVarU.mq() * 2.0f);
    }

    public void hc(List<List<gb>> list) {
        this.mq = list;
    }

    public List<List<gb>> w() {
        return this.mq;
    }

    public boolean yo() {
        List<gb> list = this.tc;
        return list == null || list.size() <= 0;
    }

    public boolean rf() {
        return this.k;
    }

    public void d(boolean z) {
        this.k = z;
    }

    public Map<String, String> jh() {
        return this.e;
    }

    public void d(String str, String str2) {
        this.e.put(str, str2);
    }

    public void sy() {
        List<List<gb>> list = this.mq;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<gb> list2 : this.mq) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.mq = arrayList;
    }

    public boolean de() {
        return TextUtils.equals(this.tt.u().zw(), "flex");
    }

    public String v() {
        return this.tt.u().v();
    }

    public void b(String str) {
        this.tt.u().an(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.d + "', x=" + this.hc + ", y=" + this.b + ", width=" + this.an + ", height=" + this.h + ", remainWidth=" + this.gb + ", rootBrick=" + this.tt + ", childrenBrickUnits=" + this.tc + '}';
    }

    public boolean np() {
        return this.tt.u().gw() < 0 || this.tt.u().fy() < 0 || this.tt.u().qy() < 0 || this.tt.u().nf() < 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String d(int r10) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.b.gb.d(int):java.lang.String");
    }
}
