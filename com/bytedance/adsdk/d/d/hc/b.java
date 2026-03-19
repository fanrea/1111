package com.bytedance.adsdk.d.d.hc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements an {
    private final ByteBuffer d;

    public b(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public long d(long j) throws IOException {
        this.d.position((int) (r0.position() + j));
        return j;
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public byte c_() throws IOException {
        return this.d.get();
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public void d_() throws IOException {
        this.d.position(0);
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public int b() {
        return this.d.position();
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public int d(byte[] bArr, int i, int i2) throws IOException {
        this.d.get(bArr, i, i2);
        return i2;
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public int c() throws IOException {
        return this.d.limit() - this.d.position();
    }

    @Override // com.bytedance.adsdk.d.d.hc.an
    public InputStream u() throws IOException {
        return new ByteArrayInputStream(this.d.array());
    }
}
