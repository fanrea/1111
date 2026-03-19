package com.baidu.mobads.container.landingpage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ App2Activity b;

    s(App2Activity app2Activity, String str) {
        this.b = app2Activity;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.executeJavaScript(this.a);
    }
}
