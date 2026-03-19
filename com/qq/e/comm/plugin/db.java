package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class db extends Exception {
    private final String a;
    private final int b;

    public db(int i, String str) {
        super(str);
        this.b = i;
        this.a = str;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public db(int i, String str, Throwable th) {
        super(str, th);
        this.b = i;
        this.a = str;
    }
}
