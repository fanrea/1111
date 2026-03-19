package com.bytedance.sdk.component.panglearmor.d.d.d;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static com.bytedance.sdk.component.panglearmor.d.d.b.hc d(com.bytedance.sdk.component.panglearmor.d.hc.hc hcVar) throws com.bytedance.sdk.component.panglearmor.d.d.b.d, IOException {
        Pair<ByteBuffer, Long> pairD = com.bytedance.sdk.component.panglearmor.d.d.hc.hc.d.d(hcVar);
        if (pairD == null) {
            throw new com.bytedance.sdk.component.panglearmor.d.d.b.d("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairD.first;
        long jLongValue = ((Long) pairD.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jD = com.bytedance.sdk.component.panglearmor.d.d.hc.hc.d.d(byteBuffer);
        if (jD > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.d.d.b.d("ZIP Central Directory start offset out of range: " + jD + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jHc = com.bytedance.sdk.component.panglearmor.d.d.hc.hc.d.hc(byteBuffer);
        long j = jD + jHc;
        if (j > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.d.d.b.d("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
        }
        return new com.bytedance.sdk.component.panglearmor.d.d.b.hc(jD, jHc, com.bytedance.sdk.component.panglearmor.d.d.hc.hc.d.b(byteBuffer), jLongValue, byteBuffer);
    }

    public static d d(com.bytedance.sdk.component.panglearmor.d.hc.hc hcVar, com.bytedance.sdk.component.panglearmor.d.d.b.hc hcVar2) throws Exception {
        long jD = hcVar2.d();
        long jHc = hcVar2.hc() + jD;
        long jC = hcVar2.c();
        if (jHc != jC) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jHc + ", EoCD start: " + jC);
        }
        if (jD < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jD)));
        }
        ByteBuffer byteBufferD = hcVar.d(jD - 24, 24);
        byteBufferD.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferD.getLong(8) != 2334950737559900225L || byteBufferD.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j = byteBufferD.getLong(0);
        if (j < byteBufferD.capacity() || j > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
        }
        long j2 = (int) (8 + j);
        long j3 = jD - j2;
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferD2 = hcVar.d(j3, 8);
        byteBufferD2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = byteBufferD2.getLong(0);
        if (j4 != j) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
        }
        return new d(j3, hcVar.d(j3, j2));
    }

    public static class d {
        private final long d;
        private final com.bytedance.sdk.component.panglearmor.d.hc.hc hc;

        public d(long j, com.bytedance.sdk.component.panglearmor.d.hc.hc hcVar) {
            this.d = j;
            this.hc = hcVar;
        }

        public long d() {
            return this.d;
        }

        public com.bytedance.sdk.component.panglearmor.d.hc.hc hc() {
            return this.hc;
        }
    }
}
