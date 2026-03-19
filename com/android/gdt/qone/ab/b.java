package com.android.gdt.qone.ab;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b extends a {
    public final String a;
    public final boolean b;

    public b(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final Boolean a(String str) {
        String strA = a.a(str, this.a);
        return (strA == null || strA.isEmpty()) ? Boolean.valueOf(this.b) : Boolean.valueOf("1".equals(strA));
    }
}
