package com.baidu.mobads.container.landingpage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements Runnable {
    final /* synthetic */ App2Activity a;

    q(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.finishActivity();
    }
}
