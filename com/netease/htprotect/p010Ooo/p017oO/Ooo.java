package com.netease.htprotect.p010Ooo.p017oO;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.nio.ByteBuffer;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static short m1062O8oO888(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & 255);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static byte[] m1063O8oO888(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static int m1064O8(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static void m1065O8(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static long m1066Ooo(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & C00oOOo.f362O8oO888;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static String m1067Ooo(ByteBuffer byteBuffer, int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(byteBuffer.getChar());
        }
        return sb.toString();
    }
}
