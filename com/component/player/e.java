package com.component.player;

import android.view.SurfaceHolder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements p {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    @Override // com.component.player.p
    public void a(SurfaceHolder surfaceHolder) {
        this.a.E = surfaceHolder;
        this.a.w = true;
        this.a.v();
    }

    @Override // com.component.player.p
    public void a() {
        if (this.a.k != null) {
            this.a.k.a();
        }
        this.a.w = false;
    }
}
