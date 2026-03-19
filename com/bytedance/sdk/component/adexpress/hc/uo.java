package com.bytedance.sdk.component.adexpress.hc;

import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo {
    private String an;
    private String b;
    private View ba;
    private tt c;
    private boolean cb;
    private JSONObject d;
    private int de;
    private int e;
    private boolean fs;
    private String gb;
    private String h;
    private u hc;
    private boolean he;
    private JSONObject j;
    private int jh;
    private Map<String, String> k;
    private long mk;
    private int mq;
    private String mt;
    private double np;
    private int r;
    private int rf;
    private boolean s;
    private int sy;
    private int tc;
    private boolean tt;
    private int u;
    private String uo;
    private String us;
    private String v;
    private JSONObject vv;
    private String w;
    private int yi;
    private int yo;
    private final boolean z;
    private JSONObject zw;

    public uo(d dVar) {
        this.fs = true;
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
        this.u = dVar.u;
        this.an = dVar.an;
        this.h = dVar.h;
        this.gb = dVar.gb;
        this.tt = dVar.tt;
        this.tc = dVar.tc;
        this.mk = dVar.mk;
        this.mq = dVar.mq;
        this.uo = dVar.uo;
        this.k = dVar.k;
        this.e = dVar.e;
        this.cb = dVar.cb;
        this.w = dVar.w;
        this.yo = dVar.yo;
        this.rf = dVar.rf;
        this.jh = dVar.jh;
        this.sy = dVar.sy;
        this.de = dVar.de;
        this.v = dVar.v;
        this.np = dVar.np;
        this.yi = dVar.yi;
        this.he = dVar.he;
        this.vv = dVar.vv;
        this.zw = dVar.zw;
        this.j = dVar.j;
        this.s = dVar.s;
        this.us = dVar.us;
        this.z = dVar.z;
        this.fs = dVar.fs;
        this.r = dVar.ba;
        this.mt = dVar.r;
        this.ba = dVar.mt;
    }

    public String d() {
        return this.mt;
    }

    public View hc() {
        return this.ba;
    }

    public boolean b() {
        return this.he;
    }

    public double c() {
        return this.np;
    }

    public JSONObject u() {
        u uVar;
        if (this.d == null && (uVar = this.hc) != null) {
            this.d = uVar.d();
        }
        return this.d;
    }

    public String an() {
        return this.b;
    }

    public tt h() {
        return this.c;
    }

    public int gb() {
        return this.u;
    }

    public boolean tt() {
        return this.fs;
    }

    public int tc() {
        return this.yi;
    }

    public boolean mk() {
        return this.tt;
    }

    public long mq() {
        return this.mk;
    }

    public int uo() {
        return this.mq;
    }

    public Map<String, String> k() {
        return this.k;
    }

    public int e() {
        return this.e;
    }

    public boolean cb() {
        return this.cb;
    }

    public String w() {
        return this.w;
    }

    public void d(int i) {
        this.u = i;
    }

    public int yo() {
        return this.yo;
    }

    public int rf() {
        return this.rf;
    }

    public int jh() {
        return this.jh;
    }

    public JSONObject sy() {
        return this.vv;
    }

    public JSONObject de() {
        return this.zw;
    }

    public JSONObject v() {
        return this.j;
    }

    public int np() {
        return this.sy;
    }

    public int yi() {
        return this.de;
    }

    public boolean he() {
        return this.s;
    }

    public String vv() {
        return this.us;
    }

    public boolean zw() {
        return this.z;
    }

    public int j() {
        return this.r;
    }

    public static class d {
        private String an;
        private String b;
        private int ba;
        private tt c;
        private boolean cb;
        private JSONObject d;
        private int de;
        private int e;
        private String gb;
        private String h;
        private u hc;
        private JSONObject j;
        private int jh;
        private Map<String, String> k;
        private long mk;
        private int mq;
        private View mt;
        private double np;
        private String r;
        private int rf;
        private boolean s;
        private int sy;
        private int tc;
        private boolean tt;
        private int u;
        private String uo;
        private String us;
        private String v;
        private JSONObject vv;
        private String w;
        private int yi;
        private int yo;
        private JSONObject zw;
        private boolean he = true;
        private boolean z = true;
        private boolean fs = true;

        public d d(boolean z) {
            this.fs = z;
            return this;
        }

        public d d(JSONObject jSONObject) {
            this.d = jSONObject;
            return this;
        }

        public d d(String str) {
            this.b = str;
            return this;
        }

        public d d(tt ttVar) {
            this.c = ttVar;
            return this;
        }

        public d d(int i) {
            this.u = i;
            return this;
        }

        public d hc(String str) {
            this.an = str;
            return this;
        }

        public d b(String str) {
            this.h = str;
            return this;
        }

        public d c(String str) {
            this.gb = str;
            return this;
        }

        public d hc(boolean z) {
            this.tt = z;
            return this;
        }

        public d hc(int i) {
            this.tc = i;
            return this;
        }

        public d b(int i) {
            this.mq = i;
            return this;
        }

        public d u(String str) {
            this.uo = str;
            return this;
        }

        public d d(Map<String, String> map) {
            this.k = map;
            return this;
        }

        public d c(int i) {
            this.e = i;
            return this;
        }

        public d an(String str) {
            this.w = str;
            return this;
        }

        public d u(int i) {
            this.yo = i;
            return this;
        }

        public d an(int i) {
            this.rf = i;
            return this;
        }

        public d h(int i) {
            this.jh = i;
            return this;
        }

        public d gb(int i) {
            this.sy = i;
            return this;
        }

        public d tt(int i) {
            this.de = i;
            return this;
        }

        public d h(String str) {
            this.v = str;
            return this;
        }

        public d b(boolean z) {
            this.s = z;
            return this;
        }

        public d gb(String str) {
            this.us = str;
            return this;
        }

        public d tc(int i) {
            this.ba = i;
            return this;
        }

        public uo d() {
            return new uo(this);
        }

        public d hc(JSONObject jSONObject) {
            this.vv = jSONObject;
            return this;
        }

        public d b(JSONObject jSONObject) {
            this.zw = jSONObject;
            return this;
        }

        public d c(JSONObject jSONObject) {
            this.j = jSONObject;
            return this;
        }

        public d tt(String str) {
            this.r = str;
            return this;
        }

        public d d(View view) {
            this.mt = view;
            return this;
        }
    }
}
