package com.netease.htprotect.p024.p025O8oO888;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 implements Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final ByteBuffer f627O8oO888;

    public O8oO888(ByteBuffer byteBuffer) {
        this.f627O8oO888 = byteBuffer;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private ByteBuffer m1194O8oO888() {
        return this.f627O8oO888;
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.Ooo
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void mo1195O8oO888(ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        try {
            this.f627O8oO888.put(byteBuffer);
        } catch (BufferOverflowException e) {
            throw new IOException("Insufficient space in output buffer for " + iRemaining + " bytes", e);
        }
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.Ooo
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void mo1196O8oO888(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f627O8oO888.put(bArr, i, i2);
        } catch (BufferOverflowException e) {
            throw new IOException("Insufficient space in output buffer for " + i2 + " bytes", e);
        }
    }
}
