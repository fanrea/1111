package com.pangrowth.adclog;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k0 extends m0 {
    public k0(s0 s0Var, n0 n0Var, long j, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(n0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 8);
        this.a = s0Var.c(byteBufferAllocate, j2);
        this.b = s0Var.c(byteBufferAllocate, j2 + 4);
    }
}
