package com.android.gdt.qone.ak;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;

    public b(String str, String str2, String str3) {
        this.b = str == null ? "" : str;
        this.c = str2 == null ? "" : str2;
        this.a = str3;
    }

    public final String a() {
        return !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.e, com.android.gdt.qone.at.a.a(this.a).a.l).booleanValue() ? "" : this.b;
    }

    public final String b() {
        return !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.f, com.android.gdt.qone.at.a.a(this.a).a.l).booleanValue() ? "" : this.c;
    }

    public final boolean c() {
        String str;
        String str2 = this.b;
        return (str2 == null || str2.isEmpty()) && ((str = this.c) == null || str.isEmpty());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Q16:");
        sb.append(this.b);
        if (TextUtils.isEmpty(this.c)) {
            str = "";
        } else {
            str = "\nQ36:" + this.c;
        }
        sb.append(str);
        return sb.toString();
    }
}
