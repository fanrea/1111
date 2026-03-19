package com.baidu.mobads.container.e;

import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements com.baidu.mobads.container.activity.v {
    final /* synthetic */ l a;

    o(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.mobads.container.activity.v
    public void d() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void e() {
    }

    @Override // com.baidu.mobads.container.activity.v
    public void f() {
        if (this.a.mAdContainerCxt != null) {
            this.a.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 1));
        }
        if (this.a.b != null && this.a.v()) {
            this.a.S = 4;
            this.a.a(this.a.S);
        }
    }

    @Override // com.baidu.mobads.container.activity.v
    public void g() {
        if (this.a.mAdContainerCxt != null) {
            this.a.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 0));
        }
        com.baidu.mobads.container.activity.e.a().b(this.a.c);
        this.a.S = 7;
        this.a.a(this.a.S);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void h() {
        if (this.a.mAdContainerCxt != null) {
            this.a.mAdContainerCxt.s().dispatchEvent(new cm("adPrivacyClick"));
        }
        if (this.a.b != null && this.a.v()) {
            this.a.S = 4;
            this.a.a(this.a.S);
        }
    }

    @Override // com.baidu.mobads.container.activity.v
    public void i() {
        if (this.a.mAdContainerCxt != null) {
            this.a.mAdContainerCxt.s().dispatchEvent(new cm("onADPrivacyLpClose"));
        }
        com.baidu.mobads.container.activity.e.a().b(this.a.c);
        this.a.S = 7;
        this.a.a(this.a.S);
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
