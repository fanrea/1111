package com.bytedance.sdk.component.b.d;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends jh {
    private jh d;

    public tt(jh jhVar) {
        if (jhVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.d = jhVar;
    }

    public final jh d() {
        return this.d;
    }

    public final tt d(jh jhVar) {
        if (jhVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.d = jhVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public jh d(long j, TimeUnit timeUnit) {
        return this.d.d(j, timeUnit);
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public long n_() {
        return this.d.n_();
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public boolean b() {
        return this.d.b();
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public long o_() {
        return this.d.o_();
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public jh d(long j) {
        return this.d.d(j);
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public jh u() {
        return this.d.u();
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public jh an() {
        return this.d.an();
    }

    @Override // com.bytedance.sdk.component.b.d.jh
    public void h() throws IOException {
        this.d.h();
    }
}
