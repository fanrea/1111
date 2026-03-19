package com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888;

import com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.O8〇oO8〇88.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo extends O8.O8oO888 {
    public Ooo(Oo0 oo0, O8.Ooo ooo, long j, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ooo.f561o0o0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 16);
        this.f547o0o0 = oo0.m1104O8oO888(byteBufferAllocate, j2);
        this.f548oO = oo0.m1104O8oO888(byteBufferAllocate, j2 + 8);
    }
}
