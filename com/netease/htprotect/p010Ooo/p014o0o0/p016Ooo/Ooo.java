package com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo;

/* renamed from: com.netease.htprotect.〇Ooo.〇o0〇o0.〇Ooo.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final O8oO888[] f466O8oO888;

    public Ooo(int i) {
        this.f466O8oO888 = new O8oO888[i];
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private Integer m999O8(String str) {
        String strM1002O8oO888 = m1002O8oO888(str);
        if (strM1002O8oO888 == null) {
            return null;
        }
        return Integer.valueOf(strM1002O8oO888);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private int m1000Ooo() {
        return this.f466O8oO888.length;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private Long m1001o0o0(String str) {
        String strM1002O8oO888 = m1002O8oO888(str);
        if (strM1002O8oO888 == null) {
            return null;
        }
        return Long.valueOf(strM1002O8oO888);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m1002O8oO888(String str) {
        for (O8oO888 o8oO888 : this.f466O8oO888) {
            if (o8oO888.m980Ooo().equals(str)) {
                return o8oO888.m978O8();
            }
        }
        return null;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m1003O8oO888(int i, O8oO888 o8oO888) {
        this.f466O8oO888[i] = o8oO888;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final O8oO888[] m1004O8oO888() {
        return this.f466O8oO888;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final boolean m1005Ooo(String str) {
        String strM1002O8oO888 = m1002O8oO888(str);
        if (strM1002O8oO888 == null) {
            return false;
        }
        return Boolean.parseBoolean(strM1002O8oO888);
    }
}
