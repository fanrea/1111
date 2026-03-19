package com.android.gdt.qone.v;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static volatile c a;

    public static synchronized a a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public abstract void a(long j, Runnable runnable);

    public abstract void a(Runnable runnable);
}
