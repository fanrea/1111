package com.pangrowth.adclog;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q0 extends n0 {
    public final s0 g;

    public q0(boolean z, s0 s0Var) {
        this.a = z;
        this.g = s0Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        s0Var.a(byteBufferAllocate, 16L);
        this.b = s0Var.c(byteBufferAllocate, 28L);
        this.c = s0Var.c(byteBufferAllocate, 32L);
        this.d = s0Var.a(byteBufferAllocate, 42L);
        this.e = s0Var.a(byteBufferAllocate, 44L);
        this.f = s0Var.a(byteBufferAllocate, 46L);
        s0Var.a(byteBufferAllocate, 48L);
        s0Var.a(byteBufferAllocate, 50L);
    }

    @Override // com.pangrowth.adclog.n0
    public m0 a(long j, int i) {
        return new k0(this.g, this, j, i);
    }

    @Override // com.pangrowth.adclog.n0
    public o0 a(long j) {
        return new t0(this.g, this, j);
    }

    @Override // com.pangrowth.adclog.n0
    public p0 a(int i) {
        return new v0(this.g, this, i);
    }
}
