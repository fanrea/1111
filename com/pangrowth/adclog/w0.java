package com.pangrowth.adclog;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class w0 extends p0 {
    public w0(s0 s0Var, n0 n0Var, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(n0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = s0Var.c(byteBufferAllocate, n0Var.c + (i * n0Var.f) + 44);
    }
}
