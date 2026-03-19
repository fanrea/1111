package com.android.gdt.qone.ab;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d extends a {
    public final String a;
    public final String b;

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a(String str) {
        String strA = a.a(str, this.a);
        return (strA == null || strA.isEmpty()) ? this.b : strA;
    }
}
