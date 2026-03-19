package com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888;

import com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.O8〇oO8〇88.〇O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O extends O8.AbstractC0683O8 {
    public O(Oo0 oo0, O8.Ooo ooo, long j) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(ooo.f561o0o0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = ooo.Oo0 + (j * ooo.f563o0O0O);
        this.f551O8 = oo0.m1107Ooo(byteBufferAllocate, j2);
        this.f552o0o0 = oo0.m1107Ooo(byteBufferAllocate, 4 + j2);
        this.f553oO = oo0.m1107Ooo(byteBufferAllocate, 8 + j2);
        this.Oo0 = oo0.m1107Ooo(byteBufferAllocate, j2 + 20);
    }
}
