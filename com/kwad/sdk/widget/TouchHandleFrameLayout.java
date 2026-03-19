package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TouchHandleFrameLayout extends FrameLayout {
    private GestureDetector cpY;
    private GestureDetector.OnGestureListener cpZ;

    public TouchHandleFrameLayout(Context context) {
        super(context);
        init();
    }

    public TouchHandleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.cpY = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.sdk.widget.TouchHandleFrameLayout.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.cpZ != null) {
                    return TouchHandleFrameLayout.this.cpZ.onDown(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.cpZ != null) {
                    TouchHandleFrameLayout.this.cpZ.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.cpZ != null) {
                    return TouchHandleFrameLayout.this.cpZ.onSingleTapUp(motionEvent);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TouchHandleFrameLayout.this.cpZ != null) {
                    return TouchHandleFrameLayout.this.cpZ.onScroll(motionEvent, motionEvent2, f, f2);
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
                if (TouchHandleFrameLayout.this.cpZ != null) {
                    TouchHandleFrameLayout.this.cpZ.onLongPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TouchHandleFrameLayout.this.cpZ != null) {
                    return TouchHandleFrameLayout.this.cpZ.onFling(motionEvent, motionEvent2, f, f2);
                }
                return false;
            }
        });
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.cpZ = onGestureListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cpZ != null) {
            this.cpY.onTouchEvent(motionEvent);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
