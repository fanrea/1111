package com.baidu.mobads.container.s;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements View.OnTouchListener {
    final /* synthetic */ s a;

    y(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.r.a(motionEvent);
        return false;
    }
}
