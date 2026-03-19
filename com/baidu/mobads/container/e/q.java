package com.baidu.mobads.container.e;

import com.style.widget.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements a.c {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    @Override // com.style.widget.a.c
    public void a() {
    }

    @Override // com.style.widget.a.b
    public void a(String str) {
        this.a.b.sendDislikeClickLog(str, this.a.a);
        this.a.b.dispatchDislikeEvent(this.a.a, "click", str);
        this.a.b.V = false;
    }

    @Override // com.style.widget.a.c
    public void b() {
    }
}
