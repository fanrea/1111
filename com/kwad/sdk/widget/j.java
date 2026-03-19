package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private e ka;
    private GestureDetector mGestureDetector;
    private View mView;
    private MotionEvent rz;

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

    public j(Context context, View view, e eVar) {
        this.mView = view;
        view.setOnTouchListener(this);
        this.mGestureDetector = new GestureDetector(context, this);
        this.ka = eVar;
    }

    public j(View view, e eVar) {
        if (view == null) {
            return;
        }
        this.mView = view;
        view.setOnTouchListener(this);
        this.mGestureDetector = new GestureDetector(view.getContext(), this);
        this.ka = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.rz != null && motionEvent.getAction() == 1 && b(this.rz, motionEvent)) {
            return a(view, motionEvent);
        }
        boolean zOnTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        new StringBuilder("onTouch, ").append(motionEvent.getAction()).append("， handled： ").append(zOnTouchEvent);
        if (zOnTouchEvent) {
            return true;
        }
        return a(view, motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        e eVar = this.ka;
        if (eVar == null) {
            return false;
        }
        eVar.a(this.mView);
        return true;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.rz = MotionEvent.obtain(motionEvent);
        } else if (action == 1) {
            MotionEvent motionEvent2 = this.rz;
            if (motionEvent2 != null && b(motionEvent2, motionEvent)) {
                e eVar = this.ka;
                if (eVar != null) {
                    eVar.b(view);
                }
                z = true;
            }
            this.rz = null;
        }
        return z;
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }
}
