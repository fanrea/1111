package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements Runnable {
    final /* synthetic */ l a;

    y(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.az != null) {
            this.a.i.remove(this.a.az);
            this.a.az.setVisibility(8);
        }
    }
}
