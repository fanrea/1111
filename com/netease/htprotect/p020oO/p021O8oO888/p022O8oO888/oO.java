package com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888;

import com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.O8〇oO8〇88.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oO extends O8.Ooo {

    /* renamed from: O〇80Oo0O, reason: contains not printable characters */
    private final Oo0 f567O80Oo0O;

    public oO(boolean z, Oo0 oo0) throws IOException {
        this.f561o0o0 = z;
        this.f567O80Oo0O = oo0;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f562oO = oo0.m1106O8(byteBufferAllocate, 16L);
        this.Oo0 = oo0.m1104O8oO888(byteBufferAllocate, 32L);
        this.f560O = oo0.m1104O8oO888(byteBufferAllocate, 40L);
        this.f563o0O0O = oo0.m1106O8(byteBufferAllocate, 54L);
        this.f564 = oo0.m1106O8(byteBufferAllocate, 56L);
        this.f55900oOOo = oo0.m1106O8(byteBufferAllocate, 58L);
        this.f557OO8 = oo0.m1106O8(byteBufferAllocate, 60L);
        this.f558oo0OOO8 = oo0.m1106O8(byteBufferAllocate, 62L);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8.Ooo
    /* renamed from: O8〇oO8〇88 */
    public final O8.O8oO888 mo1108O8oO888(long j, int i) throws IOException {
        return new Ooo(this.f567O80Oo0O, this, j, i);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8.Ooo
    /* renamed from: O8〇oO8〇88 */
    public final O8.AbstractC0683O8 mo1109O8oO888(long j) throws IOException {
        return new o0O0O(this.f567O80Oo0O, this, j);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8.Ooo
    /* renamed from: O8〇oO8〇88 */
    public final O8.o0o0 mo1110O8oO888() throws IOException {
        return new C00oOOo(this.f567O80Oo0O, this);
    }
}
