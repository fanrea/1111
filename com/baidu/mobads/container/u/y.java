package com.baidu.mobads.container.u;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements View.OnTouchListener {
    final /* synthetic */ v a;

    y(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.mClickTracker.a(motionEvent);
        return false;
    }
}
