package com.bytedance.adsdk.d.d.hc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements h {
    protected ByteBuffer d;

    public c() {
        b(com.sigmob.sdk.archives.tar.d.b);
    }

    public void d(byte b) {
        this.d.put(b);
    }

    public void d(byte[] bArr) {
        this.d.put(bArr);
    }

    public int d() {
        return this.d.position();
    }

    public void c(int i) {
        this.d.position(i + d());
    }

    public byte[] hc() {
        return this.d.array();
    }

    public void b(int i) {
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.d = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.d.clear();
    }
}
