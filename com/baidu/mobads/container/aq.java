package com.baidu.mobads.container;

import android.animation.ObjectAnimator;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aq implements Runnable {
    final /* synthetic */ k a;

    aq(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (com.baidu.mobads.container.util.x.a(null).a() > 19 && this.a.mObjectAnimatorList != null && this.a.mObjectAnimatorList.size() > 0) {
                Iterator<ObjectAnimator> it = this.a.mObjectAnimatorList.iterator();
                while (it.hasNext()) {
                    it.next().resume();
                }
            }
        } catch (Exception e) {
        }
    }
}
