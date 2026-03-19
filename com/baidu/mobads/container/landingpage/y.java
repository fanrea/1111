package com.baidu.mobads.container.landingpage;

import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ App2Activity b;

    y(App2Activity app2Activity, String str) {
        this.b = app2Activity;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.b.stateEvent(com.baidu.mobads.container.components.h.b.i);
        this.b.myLoadUrl(this.b.curWebview, this.a, false, "http://mobads.baidu.com/" + com.baidu.mobads.container.util.t.f(this.b.mProxyActivity));
    }
}
