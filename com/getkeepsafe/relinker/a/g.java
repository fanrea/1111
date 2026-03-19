package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class g extends c.AbstractC0388c {
    public g(f fVar, c.b bVar, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(bVar.xr ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = bVar.xs + (j * bVar.xu);
        this.xz = fVar.c(byteBufferAllocate, j2);
        this.offset = fVar.c(byteBufferAllocate, 4 + j2);
        this.xA = fVar.c(byteBufferAllocate, 8 + j2);
        this.xB = fVar.c(byteBufferAllocate, j2 + 20);
    }
}
