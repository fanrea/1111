package com.bytedance.msdk.core.tc;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private List<an> an;
    private String b;
    private gb c;
    private String d;
    private JSONObject gb;
    private List<gb> h;
    private String hc;
    private double mk;
    private int tc;
    private double tt;
    private d u;

    public double d() {
        return this.tt;
    }

    public void d(String str) {
        try {
            this.tt = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public int hc() {
        return this.tc;
    }

    public void d(int i) {
        this.tc = i;
    }

    public double b() {
        return this.mk;
    }

    public void hc(String str) {
        try {
            this.mk = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public List<gb> c() {
        return this.h;
    }

    public void d(List<gb> list) {
        this.h = list;
    }

    public List<an> u() {
        return this.an;
    }

    public void hc(List<an> list) {
        this.an = list;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.hc = str;
    }

    public String an() {
        return this.b;
    }

    public void u(String str) {
        this.b = str;
    }

    public void d(gb gbVar) {
        this.c = gbVar;
    }

    public void d(d dVar) {
        this.u = dVar;
    }

    public void d(JSONObject jSONObject) {
        this.gb = jSONObject;
    }

    public JSONObject h() {
        return this.gb;
    }

    public boolean gb() {
        d dVar = this.u;
        return (dVar == null || TextUtils.isEmpty(dVar.d)) ? false : true;
    }

    public List<tc> tt() {
        d dVar = this.u;
        if (dVar == null) {
            return null;
        }
        return dVar.hc;
    }

    public static class d {
        private String d;
        private List<tc> hc = new ArrayList();

        public void d(String str) {
            this.d = str;
        }

        public void d(List<tc> list) {
            this.hc = list;
        }
    }
}
