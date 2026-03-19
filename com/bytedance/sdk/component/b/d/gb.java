package com.bytedance.sdk.component.b.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class gb implements rf {
    private final rf d;

    public gb(rf rfVar) {
        if (rfVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.d = rfVar;
    }

    public final rf hc() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public long d(b bVar, long j) throws IOException {
        return this.d.d(bVar, j);
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return this.d.d();
    }

    @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.d.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.d.toString() + ")";
    }
}
