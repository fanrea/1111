package com.baidu.mobads.container.components.a;

import android.os.Handler;
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements Runnable {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b = new Handler();
        this.a.b.postDelayed(new h(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
