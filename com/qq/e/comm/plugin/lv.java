package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lv {
    private static Class a;
    private static Class b;

    static {
        try {
            a = Class.forName("androidx.recyclerview.widget.RecyclerView");
            Class.forName("androidx.recyclerview.widget.RecyclerView$LayoutParams");
        } catch (ClassNotFoundException unused) {
            a = null;
        }
        try {
            b = Class.forName("android.support.v7.widget.RecyclerView");
        } catch (ClassNotFoundException unused2) {
            b = null;
        }
    }

    public static boolean a() {
        return a != null;
    }

    public static void b() {
        b10.a(9130035, null, Integer.valueOf(a != null ? 1 : b != null ? 2 : -1));
    }
}
