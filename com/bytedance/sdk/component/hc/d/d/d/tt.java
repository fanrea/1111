package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.mk;
import com.bytedance.sdk.component.hc.d.uo;
import com.bytedance.sdk.component.hc.d.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends cb {
    public j d;

    public tt(j jVar) {
        this.d = jVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public long d() {
        return this.d.k();
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public long hc() {
        return this.d.uo();
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public int b() {
        j jVar = this.d;
        if (jVar != null) {
            return jVar.b();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public boolean c() {
        return this.d.c();
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public String u() {
        return this.d.u();
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public w an() {
        return new tc(this.d.gb());
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public com.bytedance.sdk.component.hc.d.an h() {
        return new com.bytedance.sdk.component.hc.d.an(this.d.h().d);
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public String d(String str) {
        return this.d.d(str);
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public String d(String str, String str2) {
        return this.d.d(str, str2);
    }

    @Override // com.bytedance.sdk.component.hc.d.cb, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    public String toString() {
        return this.d.toString();
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public uo gb() {
        try {
            return uo.d(this.d.hc().toString());
        } catch (Exception unused) {
            return uo.HTTP_1_1;
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.cb
    public mk tt() {
        if (this.d == null) {
            return null;
        }
        return new mk(this.d.e());
    }
}
