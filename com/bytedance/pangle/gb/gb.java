package com.bytedance.pangle.gb;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class gb implements mk {
    private final ByteBuffer d;

    gb(ByteBuffer byteBuffer) {
        this.d = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.gb.mk
    public long d() {
        return this.d.capacity();
    }

    @Override // com.bytedance.pangle.gb.mk
    public void d(tc tcVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.d) {
            this.d.position(0);
            int i2 = (int) j;
            this.d.limit(i + i2);
            this.d.position(i2);
            byteBufferSlice = this.d.slice();
        }
        tcVar.d(byteBufferSlice);
    }
}
