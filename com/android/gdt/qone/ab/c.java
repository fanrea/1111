package com.android.gdt.qone.ab;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c extends a {
    public final String a;
    public final int b;

    public c(int i, String str) {
        this.a = str;
        this.b = i;
    }

    public final Integer a(String str) {
        String strA = a.a(str, this.a);
        if (strA == null || strA.isEmpty()) {
            return Integer.valueOf(this.b);
        }
        try {
            return Integer.valueOf(Integer.parseInt(strA));
        } catch (Exception e) {
            e.printStackTrace();
            return Integer.valueOf(this.b);
        }
    }
}
