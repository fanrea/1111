package com.component.feed;

import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements Runnable {
    final /* synthetic */ x a;

    y(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.x()) {
            Toast.makeText(this.a.a.getContext(), "注意！当前处于非Wi-Fi网络下观看", 1).show();
        }
    }
}
