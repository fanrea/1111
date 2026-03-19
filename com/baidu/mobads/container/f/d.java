package com.baidu.mobads.container.f;

import com.baidu.mobads.container.activity.v;
import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements v {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    d(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // com.baidu.mobads.container.activity.v
    public void d() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void e() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void f() {
        this.b.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 1, this.a));
    }

    @Override // com.baidu.mobads.container.activity.v
    public void g() {
        this.b.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 0, this.a));
        com.baidu.mobads.container.activity.e.a().b(this.b.m);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void h() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void i() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void j() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void k() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void l() {
    }
}
