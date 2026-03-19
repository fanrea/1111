package com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888;

import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.netease.htprotect.〇Ooo.〇o0〇o0.O8〇oO8〇88.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 extends O8 {

    /* renamed from: 〇O8, reason: contains not printable characters */
    private long f392O8;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private long f393o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private o0O0O[] f394oO;

    public o0o0(O8 o8) {
        m867O8oO888(o8.m865O8oO888());
        m872Ooo(o8.m871Ooo());
        m869O8oO888(o8.m870O8());
    }

    private long Oo0() {
        return this.f392O8;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private o0O0O[] m911O() {
        return this.f394oO;
    }

    @Override // com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O8
    /* renamed from: O8〇oO8〇88 */
    public final String mo866O8oO888(Oo0 oo0, Locale locale) {
        o0O0O[] o0o0oArr = this.f394oO;
        if (o0o0oArr.length > 0) {
            return o0o0oArr[0].toString();
        }
        return null;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m912O8oO888(long j) {
        this.f392O8 = j;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m913O8oO888(o0O0O[] o0o0oArr) {
        this.f394oO = o0o0oArr;
    }

    @Override // com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O8
    public final String toString() {
        return "ResourceMapEntry{parent=" + this.f392O8 + ", count=" + this.f393o0o0 + ", resourceTableMaps=" + Arrays.toString(this.f394oO) + '}';
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final void m914Ooo(long j) {
        this.f393o0o0 = j;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    public final long m915oO() {
        return this.f393o0o0;
    }
}
