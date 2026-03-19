package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class e extends c.b {
    private final f xD;

    public e(boolean z, f fVar) {
        this.xr = z;
        this.xD = fVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.type = fVar.d(byteBufferAllocate, 16L);
        this.xs = fVar.b(byteBufferAllocate, 32L);
        this.xt = fVar.b(byteBufferAllocate, 40L);
        this.xu = fVar.d(byteBufferAllocate, 54L);
        this.xv = fVar.d(byteBufferAllocate, 56L);
        this.xw = fVar.d(byteBufferAllocate, 58L);
        this.xx = fVar.d(byteBufferAllocate, 60L);
        this.xy = fVar.d(byteBufferAllocate, 62L);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public final c.d br(int i) {
        return new j(this.xD, this, 0);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public final c.AbstractC0388c j(long j) {
        return new h(this.xD, this, j);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public final c.a a(long j, int i) {
        return new b(this.xD, this, j, i);
    }
}
