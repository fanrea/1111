package com.component.player;

import com.baidu.mobads.container.util.cm;
import com.component.player.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    g(f fVar, String str) {
        this.b = fVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.b("BaseMediaPlayer", "onError" + this.b.a);
        this.b.a = f.a.ERROR;
        this.b.a(new cm("player", 257, this.a));
    }
}
