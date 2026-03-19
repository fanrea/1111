package com.baidu.mobads.container.util.g;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ int b;

    e(View view, int i) {
        this.a = view;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.performHapticFeedback(1, 2);
        } catch (Throwable th) {
        }
        c.a(this.a, this.b - 1);
    }
}
