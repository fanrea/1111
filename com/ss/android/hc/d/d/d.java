package com.ss.android.hc.d.d;

import com.ss.android.d.d.hc.gb;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements com.ss.android.d.d.b.d {
    protected int an;
    protected boolean b;
    protected boolean c;
    protected Object cb;
    protected int d;
    protected Object e;
    protected JSONObject h;
    protected int hc;
    protected boolean tt;
    protected boolean u;
    protected boolean gb = true;
    protected boolean tc = true;
    protected boolean mk = true;
    protected boolean mq = true;
    protected boolean uo = true;
    protected gb k = null;

    @Override // com.ss.android.d.d.b.d
    public int an() {
        return 1;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean u() {
        return false;
    }

    @Override // com.ss.android.d.d.b.d
    public int d() {
        return this.d;
    }

    @Override // com.ss.android.d.d.b.d
    public int hc() {
        return this.hc;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean b() {
        return this.b;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean c() {
        return this.c;
    }

    @Override // com.ss.android.d.d.b.d
    public Object h() {
        return this.e;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean gb() {
        return this.u;
    }

    @Override // com.ss.android.d.d.b.d
    public int tt() {
        return this.an;
    }

    @Override // com.ss.android.d.d.b.d
    public JSONObject tc() {
        return this.h;
    }

    @Override // com.ss.android.d.d.b.d
    public Object mk() {
        return this.cb;
    }

    @Override // com.ss.android.d.d.b.d
    public void d(int i) {
        this.hc = i;
    }

    @Override // com.ss.android.d.d.b.d
    public void hc(int i) {
        this.d = i;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean mq() {
        return this.gb;
    }

    @Override // com.ss.android.d.d.b.d
    public void d(boolean z) {
        this.gb = z;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean uo() {
        return this.tt;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean k() {
        return this.tc;
    }

    public void b(boolean z) {
        this.tt = z;
    }

    @Override // com.ss.android.d.d.b.d
    public void hc(boolean z) {
        this.tc = z;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean e() {
        return this.mk;
    }

    @Override // com.ss.android.d.d.b.d
    public boolean cb() {
        return this.mq;
    }

    public void d(Object obj) {
        this.cb = obj;
    }

    public void d(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public boolean w() {
        return this.uo;
    }

    public void c(boolean z) {
        this.uo = z;
    }

    public gb yo() {
        return this.k;
    }

    public void d(gb gbVar) {
        this.k = gbVar;
    }

    /* renamed from: com.ss.android.hc.d.d.d$d, reason: collision with other inner class name */
    public static final class C0761d {
        d d = new d();

        @Deprecated
        public C0761d b(boolean z) {
            return this;
        }

        public C0761d d(int i) {
            this.d.d = i;
            return this;
        }

        public C0761d hc(int i) {
            this.d.hc = i;
            return this;
        }

        public C0761d d(boolean z) {
            this.d.b = z;
            return this;
        }

        public C0761d hc(boolean z) {
            this.d.c = z;
            return this;
        }

        public C0761d c(boolean z) {
            this.d.u = z;
            return this;
        }

        public C0761d b(int i) {
            this.d.an = i;
            return this;
        }

        public C0761d d(JSONObject jSONObject) {
            this.d.h = jSONObject;
            return this;
        }

        public C0761d d(Object obj) {
            this.d.cb = obj;
            return this;
        }

        public C0761d u(boolean z) {
            this.d.gb = z;
            return this;
        }

        public C0761d an(boolean z) {
            this.d.tt = z;
            return this;
        }

        public C0761d h(boolean z) {
            this.d.tc = z;
            return this;
        }

        public C0761d gb(boolean z) {
            this.d.mk = z;
            return this;
        }

        public C0761d tt(boolean z) {
            this.d.mq = z;
            return this;
        }

        public C0761d tc(boolean z) {
            this.d.uo = z;
            return this;
        }

        public d d() {
            return this.d;
        }
    }
}
