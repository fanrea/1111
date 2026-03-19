package com.baidu.mobads.container;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class al implements Runnable {
    final /* synthetic */ k a;

    al(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.doStopOnUIThread();
    }
}
