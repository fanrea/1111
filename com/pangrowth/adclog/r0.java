package com.pangrowth.adclog;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class r0 extends n0 {
    public final s0 g;

    public r0(boolean z, s0 s0Var) {
        this.a = z;
        this.g = s0Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        s0Var.a(byteBufferAllocate, 16L);
        this.b = s0Var.b(byteBufferAllocate, 32L);
        this.c = s0Var.b(byteBufferAllocate, 40L);
        this.d = s0Var.a(byteBufferAllocate, 54L);
        this.e = s0Var.a(byteBufferAllocate, 56L);
        this.f = s0Var.a(byteBufferAllocate, 58L);
        s0Var.a(byteBufferAllocate, 60L);
        s0Var.a(byteBufferAllocate, 62L);
    }

    @Override // com.pangrowth.adclog.n0
    public m0 a(long j, int i) {
        return new l0(this.g, this, j, i);
    }

    @Override // com.pangrowth.adclog.n0
    public o0 a(long j) {
        return new u0(this.g, this, j);
    }

    @Override // com.pangrowth.adclog.n0
    public p0 a(int i) {
        return new w0(this.g, this, i);
    }
}
