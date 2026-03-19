package com.netease.htprotect.p024.p026Ooo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.netease.htprotect.〇〇.〇Ooo.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f677O8oO888 = 8;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final int f678O8 = 12;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f679Ooo = 10;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final int f680o0o0 = 16;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static ByteBuffer m1255O8oO888(ByteBuffer byteBuffer, int i, long j, long j2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.put(byteBuffer.slice());
        byteBufferAllocate.flip();
        Oo0.m1243O8oO888(byteBufferAllocate, 8, i);
        Oo0.m1243O8oO888(byteBufferAllocate, 10, i);
        Oo0.m1244O8oO888(byteBufferAllocate, 12, j);
        Oo0.m1244O8oO888(byteBufferAllocate, 16, j2);
        return byteBufferAllocate;
    }
}
