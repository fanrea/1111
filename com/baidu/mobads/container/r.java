package com.baidu.mobads.container;

import android.animation.ObjectAnimator;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements Runnable {
    final /* synthetic */ k a;

    r(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.mObjectAnimatorList != null && this.a.mObjectAnimatorList.size() > 0) {
                Iterator<ObjectAnimator> it = this.a.mObjectAnimatorList.iterator();
                while (it.hasNext()) {
                    it.next().cancel();
                }
            }
        } catch (Exception e) {
        }
    }
}
