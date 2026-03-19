package com.component.player;

import android.view.Surface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements r {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    @Override // com.component.player.r
    public void a(Surface surface) {
        this.a.D = surface;
        this.a.w = true;
        this.a.v();
    }

    @Override // com.component.player.r
    public void a() {
        if (this.a.k != null) {
            this.a.k.a();
        }
        this.a.w = false;
    }
}
