package com.baidu.mobads.container;

import com.baidu.mobads.container.o.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class af extends com.baidu.mobads.container.d.a {
    final /* synthetic */ ae a;

    af(ae aeVar) {
        this.a = aeVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        com.baidu.mobads.container.util.h.a(new ag(this));
        this.a.e.splashAdClick("twist", j.a.TWIST_SHAKE_VIEW.c());
        this.a.e.sendSplashShakeLog("onadtwistclick_shake");
        return null;
    }
}
