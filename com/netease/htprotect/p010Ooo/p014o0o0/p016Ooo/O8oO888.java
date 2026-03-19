package com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo;

import android.util.SparseArray;
import com.netease.htprotect.p010Ooo.p014o0o0.oO;
import com.netease.htprotect.p010Ooo.p017oO.Oo0;
import java.util.Locale;

/* renamed from: com.netease.htprotect.〇Ooo.〇o0〇o0.〇Ooo.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private String f451O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private String f452O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private String f453Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private oO f454o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private String f455oO;

    /* renamed from: com.netease.htprotect.〇Ooo.〇o0〇o0.〇Ooo.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    public static class C0680O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private static final SparseArray f456O8oO888 = Oo0.m1051O8oO888();

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static String m983O8oO888(long j) {
            String str = (String) f456O8oO888.get((int) j);
            return str == null ? "AttrId:0x" + Long.toHexString(j) : str;
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private String m972o0o0() {
        return this.f452O8;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private oO m973oO() {
        return this.f454o0o0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m974O8oO888() {
        return this.f451O8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m975O8oO888(com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0 oo0, Locale locale) {
        String str = this.f452O8;
        if (str != null) {
            return str;
        }
        oO oOVar = this.f454o0o0;
        return oOVar != null ? oOVar.m1031O8oO888(oo0, locale) : "";
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m976O8oO888(oO oOVar) {
        this.f454o0o0 = oOVar;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m977O8oO888(String str) {
        this.f451O8oO888 = str;
    }

    public final String toString() {
        return "Attribute{name='" + this.f453Ooo + "', namespace='" + this.f451O8oO888 + "'}";
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final String m978O8() {
        return this.f455oO;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final void m979O8(String str) {
        this.f452O8 = str;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final String m980Ooo() {
        return this.f453Ooo;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final void m981Ooo(String str) {
        this.f453Ooo = str;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public final void m982o0o0(String str) {
        this.f455oO = str;
    }
}
