package com.baidu.mobads.container.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    e(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.d.a(this.b.b, this.a);
    }
}
