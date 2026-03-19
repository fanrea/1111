package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tc {
    private final String a;
    private final e2 b;

    private tc(String str, e2 e2Var) {
        this.a = str;
        this.b = e2Var;
    }

    String a() {
        return this.a;
    }

    String b() {
        e2 e2Var = this.b;
        if (e2Var == null) {
            return null;
        }
        return e2Var.c();
    }

    public static tc c() {
        return a(null, null);
    }

    public static tc a(String str) {
        return a(str, null);
    }

    public static tc a(String str, e2 e2Var) {
        return new tc(str, e2Var);
    }
}
