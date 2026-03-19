package com.pangrowth.adclog;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u0 extends o0 {
    public u0(s0 s0Var, n0 n0Var, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(n0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = n0Var.b + (j * n0Var.d);
        this.a = s0Var.c(byteBufferAllocate, j2);
        this.b = s0Var.b(byteBufferAllocate, 8 + j2);
        this.c = s0Var.b(byteBufferAllocate, 16 + j2);
        this.d = s0Var.b(byteBufferAllocate, j2 + 40);
    }
}
