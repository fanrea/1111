package com.component.a.g.c;

import android.view.View;
import com.baidu.mobads.container.components.e.b;
import com.component.a.i.c;
import com.component.interfaces.RemoteReflectInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements c.a {
    final /* synthetic */ com.component.a.f.e a;
    final /* synthetic */ com.component.a.a.d b;
    final /* synthetic */ g c;

    i(g gVar, com.component.a.f.e eVar, com.component.a.a.d dVar) {
        this.c = gVar;
        this.a = eVar;
        this.b = dVar;
    }

    @Override // com.component.a.i.c.a
    public boolean a(View view) {
        com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.c.mAppContext).b(this.c.mAdInfo.getAppPackageName());
        if (bVarB == null) {
            return false;
        }
        b.a aVarI = bVarB.i();
        if ((aVarI == b.a.DOWNLOADING || aVarI == b.a.INITING) && this.c.c) {
            if (this.c.d && this.c.mFlyweight != null) {
                com.component.a.f.d dVar = new com.component.a.f.d(view, com.component.a.g.b.q, this.a);
                dVar.a(com.component.a.g.b.q);
                this.c.mFlyweight.a(dVar);
            } else {
                bVarB.a(2);
                return true;
            }
        }
        return false;
    }

    @Override // com.component.a.i.c.a
    public boolean b(View view) {
        String appPackageName = this.c.mAdInfo.getAppPackageName();
        com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.c.mAppContext).b(appPackageName);
        if (bVarB == null || bVarB.i() == b.a.COMPLETED) {
            return false;
        }
        this.b.post(new j(this));
        RemoteReflectInterface.cancelDlByPk(appPackageName);
        return true;
    }
}
