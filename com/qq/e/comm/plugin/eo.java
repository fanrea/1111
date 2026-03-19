package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class eo extends Exception {
    private int a;

    public eo(String str, int i) {
        super(str);
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public eo(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }

    public eo(Throwable th, int i) {
        super(th);
        this.a = i;
    }
}
