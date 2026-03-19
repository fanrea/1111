package com.bytedance.sdk.component.b.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class h implements yo {
    private final yo d;

    public h(yo yoVar) {
        if (yoVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.d = yoVar;
    }

    @Override // com.bytedance.sdk.component.b.d.yo
    public void a_(b bVar, long j) throws IOException {
        this.d.a_(bVar, j);
    }

    @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
    public void flush() throws IOException {
        this.d.flush();
    }

    @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return this.d.d();
    }

    @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
    public void close() throws IOException {
        this.d.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.d.toString() + ")";
    }
}
