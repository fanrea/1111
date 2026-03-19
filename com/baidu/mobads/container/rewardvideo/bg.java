package com.baidu.mobads.container.rewardvideo;

import com.baidu.mobads.container.rewardvideo.g;
import com.component.a.g.c.aa;
import com.style.widget.viewpager2.State;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bg implements g.a {
    final /* synthetic */ NativeRewardActivity a;

    bg(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.baidu.mobads.container.rewardvideo.g.a
    public void a(com.component.a.d.c cVar) {
        if (cVar == this.a.k) {
            if (this.a.aq != null) {
                this.a.aq.l();
            }
            if (this.a.ar != null) {
                this.a.ar.l();
            }
            Iterator it = this.a.ay.iterator();
            while (it.hasNext()) {
                ((aa.j) it.next()).l();
            }
        }
        if (cVar == this.a.ar && this.a.T) {
            c(cVar);
            return;
        }
        if ((cVar instanceof aa.i) && (!this.a.mActivityLifecycle.b().isAtLeast(State.RESUMED) || !this.a.J || this.a.v)) {
            c(cVar);
        } else {
            this.a.onDialogShow(cVar);
        }
    }

    @Override // com.baidu.mobads.container.rewardvideo.g.a
    public void b(com.component.a.d.c cVar) {
        if (cVar == this.a.ar) {
            int iF = this.a.ar.f();
            if (this.a.x != null && iF > 0) {
                this.a.bj.a(iF);
                this.a.e((this.a.r - (this.a.x.g() / 1000)) - (iF / 1000));
            }
        }
        this.a.onDialogDismiss(cVar);
    }

    @Override // com.baidu.mobads.container.rewardvideo.g.a
    public void c(com.component.a.d.c cVar) {
        if (cVar instanceof aa.i) {
            ((aa.i) cVar).l();
        }
    }
}
