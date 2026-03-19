package com.netease.htprotect.p024.p025O8oO888;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Oo0 implements Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final MessageDigest[] f628O8oO888;

    public Oo0(MessageDigest[] messageDigestArr) {
        this.f628O8oO888 = messageDigestArr;
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.Ooo
    /* renamed from: O8〇oO8〇88 */
    public final void mo1195O8oO888(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        for (MessageDigest messageDigest : this.f628O8oO888) {
            byteBuffer.position(iPosition);
            messageDigest.update(byteBuffer);
        }
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.Ooo
    /* renamed from: O8〇oO8〇88 */
    public final void mo1196O8oO888(byte[] bArr, int i, int i2) {
        for (MessageDigest messageDigest : this.f628O8oO888) {
            messageDigest.update(bArr, i, i2);
        }
    }
}
