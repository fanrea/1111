package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class v00 implements u00 {
    private int a;
    private long b;
    private String c;

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.a + ", time=" + this.b + ", content='" + this.c + "'}";
    }

    v00(int i, String str) {
        this.a = i;
        this.c = str;
        this.b = -1L;
    }

    @Override // com.qq.e.comm.plugin.u00
    public int a() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.u00
    public String c() {
        return this.c;
    }

    v00(String str, long j) {
        this.a = -1;
        this.b = j;
        this.c = str;
    }

    @Override // com.qq.e.comm.plugin.u00
    public long b() {
        return this.b;
    }
}
