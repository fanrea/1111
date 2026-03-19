package com.baidu.mobads.container;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class w implements Runnable {
    final /* synthetic */ k a;

    w(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.doStartOnUIThread();
    }
}
