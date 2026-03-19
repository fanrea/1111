package com.netease.htprotect.p010Ooo.p017oO.p018O8oO888;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.O8〇oO8〇88.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class oO extends Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final HashMap f518O8oO888 = new HashMap();

    /* renamed from: 〇O8, reason: contains not printable characters */
    private final int f519O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final int f520Ooo;

    public oO(CharSequence[]... charSequenceArr) {
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        if (charSequenceArr != null) {
            int i3 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.f518O8oO888.put(charSequenceArr2[0].toString(), charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i2 = length < i2 ? length : i2;
                if (length > i3) {
                    i3 = length;
                }
            }
            i = i3;
        }
        this.f520Ooo = i2;
        this.f519O8 = i;
    }

    @Override // com.netease.htprotect.p010Ooo.p017oO.p018O8oO888.Ooo
    /* renamed from: O8〇oO8〇88 */
    public final int mo1038O8oO888(CharSequence charSequence, int i, Writer writer) throws IOException {
        int length = this.f519O8;
        if (i + length > charSequence.length()) {
            length = charSequence.length() - i;
        }
        while (length >= this.f520Ooo) {
            CharSequence charSequence2 = (CharSequence) this.f518O8oO888.get(charSequence.subSequence(i, i + length).toString());
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return length;
            }
            length--;
        }
        return 0;
    }
}
