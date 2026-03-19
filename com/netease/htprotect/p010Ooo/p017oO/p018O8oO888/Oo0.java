package com.netease.htprotect.p010Ooo.p017oO.p018O8oO888;

import java.io.IOException;
import java.io.Writer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class Oo0 extends O8 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final int f513O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private final boolean f514O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final int f515Ooo;

    public Oo0() {
        this(0, Integer.MAX_VALUE, true);
    }

    private Oo0(int i, int i2, boolean z) {
        this.f513O8oO888 = i;
        this.f515Ooo = i2;
        this.f514O8 = z;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Oo0 m1039O8oO888(int i) {
        return m1042Ooo(i, Integer.MAX_VALUE);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Oo0 m1040O8oO888(int i, int i2) {
        return new Oo0(i, i2, true);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static Oo0 m1041Ooo(int i) {
        return m1042Ooo(0, i);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static Oo0 m1042Ooo(int i, int i2) {
        return new Oo0(i, i2, false);
    }

    @Override // com.netease.htprotect.p010Ooo.p017oO.p018O8oO888.O8
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final boolean mo1043O8oO888(int i, Writer writer) throws IOException {
        if (this.f514O8) {
            if (i < this.f513O8oO888 || i > this.f515Ooo) {
                return false;
            }
        } else if (i >= this.f513O8oO888 && i <= this.f515Ooo) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}
