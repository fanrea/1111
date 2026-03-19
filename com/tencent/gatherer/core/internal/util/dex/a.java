package com.tencent.gatherer.core.internal.util.dex;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.nio.ByteBuffer;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a {
    public static short a(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & 255);
    }

    public static long b(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & C00oOOo.f362O8oO888;
    }

    public static void a(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(i);
    }

    public static byte[] b(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static void a(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, d.a(j));
    }
}
