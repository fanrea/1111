package com.netease.htprotect.p010Ooo.p017oO.p018O8oO888;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.O8〇oO8〇88.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
abstract class Ooo {
    Ooo() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private Ooo m1044O8oO888(Ooo... oooArr) {
        Ooo[] oooArr2 = new Ooo[oooArr.length + 1];
        oooArr2[0] = this;
        System.arraycopy(oooArr, 0, oooArr2, 1, oooArr.length);
        return new O8oO888(oooArr2);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1045O8oO888(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m1046O8oO888(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence == null) {
            return;
        }
        int length = charSequence.length();
        int length2 = 0;
        while (length2 < length) {
            int iMo1038O8oO888 = mo1038O8oO888(charSequence, length2, writer);
            if (iMo1038O8oO888 == 0) {
                char[] chars = Character.toChars(Character.codePointAt(charSequence, length2));
                writer.write(chars);
                length2 += chars.length;
            } else {
                for (int i = 0; i < iMo1038O8oO888; i++) {
                    length2 += Character.charCount(Character.codePointAt(charSequence, length2));
                }
            }
        }
    }

    /* renamed from: O8〇oO8〇88 */
    public abstract int mo1038O8oO888(CharSequence charSequence, int i, Writer writer) throws IOException;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m1047O8oO888(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            m1046O8oO888(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
