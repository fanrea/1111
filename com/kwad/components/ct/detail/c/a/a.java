package com.kwad.components.ct.detail.c.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.widget.TouchHandleFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private int abR;
    private TouchHandleFrameLayout azp;
    private GestureDetector.OnGestureListener azq;
    private CtAdTemplate azr;

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.azp = (TouchHandleFrameLayout) getRootView();
        this.abR = this.aop.abR;
        this.azr = this.aop.mAdTemplate;
        GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ct.detail.c.a.a.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                com.kwad.components.ct.e.b.JK().R(a.this.azr);
                return false;
            }
        };
        this.azq = onGestureListener;
        this.azp.setOnGestureListener(onGestureListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.azp.setOnGestureListener(null);
    }
}
