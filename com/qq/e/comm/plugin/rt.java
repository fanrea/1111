package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class rt implements il {
    private final long a;
    private volatile long b;
    private ll c;

    public rt(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public long b() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.kl
    public long a() {
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.kl
    public void a(ll llVar) {
        this.c = llVar;
    }

    @Override // com.qq.e.comm.plugin.il
    public void a(long j) {
        this.b = j;
        ll llVar = this.c;
        if (llVar != null) {
            llVar.a(a(), b());
        }
    }
}
