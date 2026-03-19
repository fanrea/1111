package com.component.feed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements View.OnClickListener {
    final /* synthetic */ m a;

    q(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.a.ay || !(this.a.r instanceof com.baidu.mobads.container.nativecpu.a)) {
            if (this.a.ah) {
                this.a.ag.setVisibility(0);
                this.a.ag.postDelayed(new r(this), com.alipay.sdk.m.u.b.a);
                this.a.as.setVisibility(0);
                this.a.as.postDelayed(new s(this), com.alipay.sdk.m.u.b.a);
                this.a.ar.setVisibility(0);
                this.a.ar.postDelayed(new t(this), com.alipay.sdk.m.u.b.a);
                return;
            }
            return;
        }
        this.a.r.handleClick(view);
    }
}
