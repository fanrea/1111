package com.baidu.mobads.container.e;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bv extends RelativeLayout {
    final /* synthetic */ l a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bv(l lVar, Context context) {
        super(context);
        this.a = lVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.a.mClickTracker.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
}
