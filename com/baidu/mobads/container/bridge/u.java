package com.baidu.mobads.container.bridge;

import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ i b;

    u(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.b.e.t(), this.a, 1).show();
    }
}
