package com.bytedance.sdk.component.b.hc.d.b;

import com.bytedance.sdk.component.b.hc.cb;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h implements jh.d {
    private final he an;
    private final b b;
    private final com.bytedance.sdk.component.b.hc.d.hc.b c;
    private final List<jh> d;
    private final cb gb;
    private final com.bytedance.sdk.component.b.hc.u h;
    private final com.bytedance.sdk.component.b.hc.d.hc.h hc;
    private final int mk;
    private int mq;
    private final int tc;
    private final int tt;
    private final int u;

    public h(List<jh> list, com.bytedance.sdk.component.b.hc.d.hc.h hVar, b bVar, com.bytedance.sdk.component.b.hc.d.hc.b bVar2, int i, he heVar, com.bytedance.sdk.component.b.hc.u uVar, cb cbVar, int i2, int i3, int i4) {
        this.d = list;
        this.c = bVar2;
        this.hc = hVar;
        this.b = bVar;
        this.u = i;
        this.an = heVar;
        this.h = uVar;
        this.gb = cbVar;
        this.tt = i2;
        this.tc = i3;
        this.mk = i4;
    }

    public com.bytedance.sdk.component.b.hc.tt u() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh.d
    public int hc() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh.d
    public int b() {
        return this.tc;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh.d
    public int c() {
        return this.mk;
    }

    public com.bytedance.sdk.component.b.hc.d.hc.h an() {
        return this.hc;
    }

    public b h() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh.d
    public com.bytedance.sdk.component.b.hc.u call() {
        return this.h;
    }

    public cb gb() {
        return this.gb;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh.d
    public he d() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh.d
    public j d(he heVar) throws IOException {
        return d(heVar, this.hc, this.b, this.c);
    }

    public j d(he heVar, com.bytedance.sdk.component.b.hc.d.hc.h hVar, b bVar, com.bytedance.sdk.component.b.hc.d.hc.b bVar2) throws Exception {
        if (this.u >= this.d.size()) {
            throw new AssertionError();
        }
        this.mq++;
        if (this.b != null && !this.c.d(heVar.d())) {
            throw new IllegalStateException("network interceptor " + this.d.get(this.u - 1) + " must retain the same host and port");
        }
        if (this.b != null && this.mq > 1) {
            throw new IllegalStateException("network interceptor " + this.d.get(this.u - 1) + " must call proceed() exactly once");
        }
        h hVar2 = new h(this.d, hVar, bVar, bVar2, this.u + 1, heVar, this.h, this.gb, this.tt, this.tc, this.mk);
        jh jhVar = this.d.get(this.u);
        try {
            j jVarD = jhVar.d(hVar2);
            if (bVar != null && this.u + 1 < this.d.size() && hVar2.mq != 1) {
                throw new IllegalStateException("network interceptor " + jhVar + " must call proceed() exactly once");
            }
            if (jVarD == null) {
                throw new NullPointerException("interceptor " + jhVar + " returned a null response");
            }
            if (jVarD.gb() != null) {
                return jVarD;
            }
            throw new IllegalStateException("interceptor " + jhVar + " returned a response with no body");
        } catch (Exception e) {
            throw e;
        }
    }
}
