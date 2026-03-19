package com.bytedance.sdk.component.panglearmor.d.d.hc.hc;

import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.d.hc.hc;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    public static long d(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return hc(byteBuffer, byteBuffer.position() + 16);
    }

    public static long hc(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return hc(byteBuffer, byteBuffer.position() + 12);
    }

    public static int b(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return d(byteBuffer, byteBuffer.position() + 10);
    }

    public static Pair<ByteBuffer, Long> d(hc hcVar) throws IOException {
        if (hcVar.d() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairD = d(hcVar, 0);
        return pairD != null ? pairD : d(hcVar, 65535);
    }

    private static Pair<ByteBuffer, Long> d(hc hcVar, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long jD = hcVar.d();
        if (jD < 22) {
            return null;
        }
        int iMin = ((int) Math.min(i, jD - 22)) + 22;
        long j = jD - iMin;
        ByteBuffer byteBufferD = hcVar.d(j, iMin);
        byteBufferD.order(ByteOrder.LITTLE_ENDIAN);
        int iU = u(byteBufferD);
        if (iU == -1) {
            return null;
        }
        byteBufferD.position(iU);
        ByteBuffer byteBufferSlice = byteBufferD.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return new Pair<>(byteBufferSlice, Long.valueOf(j + iU));
    }

    private static int u(ByteBuffer byteBuffer) {
        c(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, 65535);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && d(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    static void c(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int d(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    static long hc(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & C00oOOo.f362O8oO888;
    }
}
