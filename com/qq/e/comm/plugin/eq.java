package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class eq implements kl, ll {
    private final long a;
    private final int b;
    private final il[] c;
    private ll d;

    public eq(long j, long[] jArr, long[] jArr2) {
        this.a = j;
        int length = jArr.length;
        this.b = length;
        this.c = new il[length];
        for (int i = 0; i < this.b; i++) {
            this.c[i] = new rt(jArr[i], jArr2[i]);
            this.c[i].a(this);
        }
    }

    @Override // com.qq.e.comm.plugin.kl
    public long a() {
        long jA = 0;
        for (il ilVar : this.c) {
            jA += ilVar.a();
        }
        return jA;
    }

    public long b() {
        return this.a;
    }

    public il a(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.c[i];
    }

    @Override // com.qq.e.comm.plugin.ll
    public void a(long j, long j2) {
        ll llVar = this.d;
        if (llVar != null) {
            llVar.a(a(), b());
        }
    }

    @Override // com.qq.e.comm.plugin.kl
    public void a(ll llVar) {
        this.d = llVar;
    }
}
