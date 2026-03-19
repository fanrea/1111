package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b extends c.a {
    public b(f fVar, c.b bVar, long j, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.xr ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 16);
        this.xp = fVar.b(byteBufferAllocate, j2);
        this.xq = fVar.b(byteBufferAllocate, j2 + 8);
    }
}
