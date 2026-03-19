package com.alliance.ssp.ad.x;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: NMNativeFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector a;

    public f(c cVar, GestureDetector gestureDetector) {
        this.a = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        return false;
    }
}
