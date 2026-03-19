package com.baidu.mobads.container.e;

import android.animation.ObjectAnimator;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class by implements Runnable {
    final /* synthetic */ l a;

    by(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.a.aB.iterator();
        while (it.hasNext()) {
            ((ObjectAnimator) it.next()).cancel();
        }
    }
}
