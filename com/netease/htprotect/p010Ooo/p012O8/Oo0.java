package com.netease.htprotect.p010Ooo.p012O8;

import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.oO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class Oo0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final List f259O8oO888 = new ArrayList();

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final List f260Ooo = new ArrayList();

    /* renamed from: com.netease.htprotect.〇Ooo.〇O8.Oo0$O8〇oO8〇88, reason: invalid class name */
    public static class O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        final String f261O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        final String f262Ooo;

        private O8oO888(String str, String str2) {
            this.f261O8oO888 = str;
            this.f262Ooo = str2;
        }

        /* synthetic */ O8oO888(String str, String str2, byte b) {
            this(str, str2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            O8oO888 o8oO888 = (O8oO888) obj;
            String str = this.f261O8oO888;
            if (str == null && o8oO888.f261O8oO888 != null) {
                return false;
            }
            if (this.f262Ooo == null && o8oO888.f262Ooo != null) {
                return false;
            }
            if (str != null && !str.equals(o8oO888.f261O8oO888)) {
                return false;
            }
            String str2 = this.f262Ooo;
            return str2 == null || str2.equals(o8oO888.f262Ooo);
        }

        public final int hashCode() {
            return (this.f261O8oO888.hashCode() * 31) + this.f262Ooo.hashCode();
        }
    }

    Oo0() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m736O8oO888(String str) {
        if (str == null) {
            return null;
        }
        for (O8oO888 o8oO888 : this.f259O8oO888) {
            if (o8oO888.f262Ooo.equals(str)) {
                return o8oO888.f261O8oO888;
            }
        }
        return null;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final List m737O8oO888() {
        if (this.f260Ooo.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f260Ooo);
        this.f260Ooo.clear();
        return arrayList;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m738O8oO888(com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.Oo0 oo0) {
        O8oO888 o8oO888 = new O8oO888(oo0.m984O8oO888(), oo0.m986Ooo(), (byte) 0);
        this.f259O8oO888.add(o8oO888);
        this.f260Ooo.add(o8oO888);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m739O8oO888(oO oOVar) {
        O8oO888 o8oO888 = new O8oO888(oOVar.m1006O8oO888(), oOVar.m1008Ooo(), (byte) 0);
        this.f259O8oO888.remove(o8oO888);
        this.f260Ooo.remove(o8oO888);
    }
}
