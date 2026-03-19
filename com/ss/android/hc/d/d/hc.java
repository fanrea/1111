package com.ss.android.hc.d.d;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements com.ss.android.d.d.b.hc {
    protected String an;
    protected String b;
    protected String c;
    protected String d;
    protected JSONObject e;
    protected String gb;
    protected String h;
    protected String hc;
    protected JSONObject k;
    protected String mq;
    protected int tt;
    protected String u;
    protected transient Object uo;
    protected boolean tc = true;
    protected boolean mk = false;

    @Override // com.ss.android.d.d.b.hc
    public String d() {
        return this.mq;
    }

    @Override // com.ss.android.d.d.b.hc
    public String hc() {
        return this.d;
    }

    @Override // com.ss.android.d.d.b.hc
    public String b() {
        return this.hc;
    }

    @Override // com.ss.android.d.d.b.hc
    public String c() {
        return this.b;
    }

    @Override // com.ss.android.d.d.b.hc
    public String u() {
        return this.c;
    }

    @Override // com.ss.android.d.d.b.hc
    public String an() {
        return this.u;
    }

    @Override // com.ss.android.d.d.b.hc
    public String h() {
        return this.an;
    }

    @Override // com.ss.android.d.d.b.hc
    public String gb() {
        return this.h;
    }

    @Override // com.ss.android.d.d.b.hc
    public String tt() {
        return this.gb;
    }

    @Override // com.ss.android.d.d.b.hc
    public Object tc() {
        return this.uo;
    }

    @Override // com.ss.android.d.d.b.hc
    public int mk() {
        return this.tt;
    }

    @Override // com.ss.android.d.d.b.hc
    public boolean mq() {
        return this.tc;
    }

    @Override // com.ss.android.d.d.b.hc
    public boolean uo() {
        return this.mk;
    }

    @Override // com.ss.android.d.d.b.hc
    public JSONObject k() {
        return this.k;
    }

    @Override // com.ss.android.d.d.b.hc
    public JSONObject e() {
        return this.e;
    }

    public void d(Object obj) {
        this.uo = obj;
    }

    public void hc(String str) {
        this.d = str;
    }

    public void d(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public void hc(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void b(String str) {
        this.hc = str;
    }

    @Override // com.ss.android.d.d.b.hc
    public void d(int i) {
        this.tt = i;
    }

    @Override // com.ss.android.d.d.b.hc
    public void d(String str) {
        this.mq = str;
    }

    public static final class d {
        hc d = new hc();

        @Deprecated
        public d gb(String str) {
            return this;
        }

        @Deprecated
        public d hc(boolean z) {
            return this;
        }

        public d d(String str) {
            this.d.d = str;
            return this;
        }

        public d hc(String str) {
            this.d.hc = str;
            return this;
        }

        public d b(String str) {
            this.d.b = str;
            return this;
        }

        public d c(String str) {
            this.d.c = str;
            return this;
        }

        public d u(String str) {
            this.d.u = str;
            return this;
        }

        public d an(String str) {
            this.d.an = str;
            return this;
        }

        public d h(String str) {
            this.d.h = str;
            return this;
        }

        public d tt(String str) {
            this.d.gb = str;
            return this;
        }

        public d d(Object obj) {
            this.d.uo = obj;
            return this;
        }

        public d d(int i) {
            this.d.tt = i;
            return this;
        }

        public d d(boolean z) {
            this.d.tc = z;
            return this;
        }

        public d b(boolean z) {
            this.d.mk = z;
            return this;
        }

        public d tc(String str) {
            this.d.mq = str;
            return this;
        }

        public d d(JSONObject jSONObject) {
            this.d.k = jSONObject;
            return this;
        }

        public d hc(JSONObject jSONObject) {
            this.d.e = jSONObject;
            return this;
        }

        public hc d() {
            return this.d;
        }
    }
}
