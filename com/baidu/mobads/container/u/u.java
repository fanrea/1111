package com.baidu.mobads.container.u;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u implements View.OnTouchListener {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.a.mClickTracker.a(0);
        this.a.a.mClickTracker.a(motionEvent);
        return false;
    }
}
