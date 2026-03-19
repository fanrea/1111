package com.netease.htprotect.p010Ooo.p017oO.p018O8oO888;

import java.io.IOException;
import java.io.Writer;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class O8oO888 extends Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final Ooo[] f512O8oO888;

    public O8oO888(Ooo... oooArr) {
        this.f512O8oO888 = oooArr;
    }

    @Override // com.netease.htprotect.p010Ooo.p017oO.p018O8oO888.Ooo
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final int mo1038O8oO888(CharSequence charSequence, int i, Writer writer) throws IOException {
        for (Ooo ooo : this.f512O8oO888) {
            int iMo1038O8oO888 = ooo.mo1038O8oO888(charSequence, i, writer);
            if (iMo1038O8oO888 != 0) {
                return iMo1038O8oO888;
            }
        }
        return 0;
    }
}
