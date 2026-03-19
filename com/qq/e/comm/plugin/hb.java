package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class hb implements Runnable {
    private final gb a;
    private bb b;
    private volatile boolean c;
    private b d;
    private a e;
    private final String f;
    private volatile dq g;
    private final cb h;
    private volatile double i = 0.0d;
    private double j;

    /* compiled from: A */
    interface a {
        void a(File file);
    }

    /* compiled from: A */
    interface b {
        void a(String str);
    }

    hb(String str, gb gbVar, bb bbVar, cb cbVar) {
        this.a = gbVar;
        this.b = bbVar;
        this.f = str;
        this.h = cbVar;
        this.j = gbVar.c();
    }

    @Override // java.lang.Runnable
    public void run() throws JSONException {
        this.c = true;
        a(false);
        if (this.i > this.j) {
            this.j = this.i;
            a(true);
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(this.f);
        }
        this.c = false;
    }

    private void a(boolean z) throws JSONException {
        File file = (this.a.b() == null || TextUtils.isEmpty(this.a.d())) ? null : new File(this.a.b(), this.a.d());
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(file);
        }
        this.g = new dq(this.a.g(), file, this.a.k() ? 3 : 1, this.h, this.a.i(), this.a.f());
        this.g.a(this.b);
        this.g.a(this.j);
        this.g.b(z);
        if (this.a.i()) {
            b10.a(1402203, this.a.a(), Integer.valueOf(v5.a("vcrn")));
        }
        if (!this.g.i() && this.a.i()) {
            ja jaVar = new ja();
            jaVar.a("rs", this.a.g());
            b10.b(1402204, this.a.a(), Integer.valueOf(this.g.b()), jaVar);
        }
        this.g.b();
        this.g.a();
    }

    boolean b() {
        return this.c;
    }

    gb a() {
        return this.a;
    }

    void a(double d) {
        this.i = d;
    }

    public void a(bb bbVar) {
        if (bbVar != null) {
            this.b = bbVar;
            if (this.g != null) {
                this.g.a(bbVar);
            }
        }
    }

    void a(a aVar) {
        this.e = aVar;
    }

    void a(b bVar) {
        this.d = bVar;
    }
}
