package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class j extends c.d {
    public j(f fVar, c.b bVar, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.xr ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.xC = fVar.c(byteBufferAllocate, bVar.xt + (i * bVar.xw) + 44);
    }
}
