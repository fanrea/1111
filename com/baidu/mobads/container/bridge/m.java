package com.baidu.mobads.container.bridge;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ i b;

    m(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.h(this.a);
    }
}
