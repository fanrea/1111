package com.baidu.mobads.container.v.b;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements View.OnTouchListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.mClickTracker.a(0);
        this.a.mClickTracker.a(motionEvent);
        return false;
    }
}
