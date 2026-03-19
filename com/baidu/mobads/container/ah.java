package com.baidu.mobads.container;

import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.s.ab;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ah implements ab.a {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ int c;
    final /* synthetic */ k d;

    ah(k kVar, int i, boolean z, int i2) {
        this.d = kVar;
        this.a = i;
        this.b = z;
        this.c = i2;
    }

    @Override // com.baidu.mobads.container.s.ab.a
    public void a(int i) {
        if (this.a == 1 && this.b) {
            switch (i) {
                case 1:
                    if (this.c != 2) {
                        this.d.removeShakeView();
                    }
                    this.d.splashAdClick("shake", j.a.SHAKE_VIEW.c());
                    this.d.sendSplashShakeLog("onadshake_click");
                    break;
                case 2:
                    this.d.splashAdClick("twist", j.a.TWIST_SHAKE_VIEW.c());
                    this.d.removeShakeView();
                    this.d.sendSplashShakeLog("onadtwistclick_click");
                    break;
            }
        }
    }
}
