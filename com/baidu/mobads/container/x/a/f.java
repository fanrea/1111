package com.baidu.mobads.container.x.a;

import android.animation.ObjectAnimator;
import com.baidu.mobads.container.util.x;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements Runnable {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (x.a(null).a() > 19 && this.a.mObjectAnimatorList != null && this.a.mObjectAnimatorList.size() > 0) {
                Iterator it = this.a.mObjectAnimatorList.iterator();
                while (it.hasNext()) {
                    ((ObjectAnimator) it.next()).resume();
                }
            }
        } catch (Exception e) {
        }
    }
}
