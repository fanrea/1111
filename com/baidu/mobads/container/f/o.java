package com.baidu.mobads.container.f;

import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements com.style.widget.b.h {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    o(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // com.style.widget.b.h
    public void a() {
        this.b.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 1, this.a));
    }

    @Override // com.style.widget.b.h
    public void b() {
        this.b.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 0, this.a));
    }
}
