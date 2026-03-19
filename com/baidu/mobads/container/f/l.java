package com.baidu.mobads.container.f;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements View.OnTouchListener {
    final /* synthetic */ b a;

    l(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.mClickTracker.a(0);
        this.a.mClickTracker.b(view);
        this.a.mClickTracker.a(motionEvent);
        return false;
    }
}
