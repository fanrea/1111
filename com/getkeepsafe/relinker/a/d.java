package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d extends c.b {
    private final f xD;

    public d(boolean z, f fVar) {
        this.xr = z;
        this.xD = fVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.type = fVar.d(byteBufferAllocate, 16L);
        this.xs = fVar.c(byteBufferAllocate, 28L);
        this.xt = fVar.c(byteBufferAllocate, 32L);
        this.xu = fVar.d(byteBufferAllocate, 42L);
        this.xv = fVar.d(byteBufferAllocate, 44L);
        this.xw = fVar.d(byteBufferAllocate, 46L);
        this.xx = fVar.d(byteBufferAllocate, 48L);
        this.xy = fVar.d(byteBufferAllocate, 50L);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public final c.d br(int i) {
        return new i(this.xD, this, 0);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public final c.AbstractC0388c j(long j) {
        return new g(this.xD, this, j);
    }

    @Override // com.getkeepsafe.relinker.a.c.b
    public final c.a a(long j, int i) {
        return new a(this.xD, this, j, i);
    }
}
