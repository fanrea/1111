package com.ss.texturerender.touch;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TouchHelper extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    private static final String LOG_TAG = "TR_TouchHelper";
    private GestureDetector mGestureDetector;
    private ArrayList<GestureDetector.SimpleOnGestureListener> mGestureListener;
    private ScaleGestureDetector mScaleGestureDetector;
    private ArrayList<ScaleGestureDetector.OnScaleGestureListener> mScaleGestureListener;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public TouchHelper(Context context) {
        this.mGestureDetector = new GestureDetector(context, this);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, this);
    }

    public void register(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        if (this.mGestureListener == null) {
            this.mGestureListener = new ArrayList<>();
        }
        if (this.mGestureListener.contains(simpleOnGestureListener)) {
            return;
        }
        this.mGestureListener.add(simpleOnGestureListener);
    }

    public void unregister(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        ArrayList<GestureDetector.SimpleOnGestureListener> arrayList = this.mGestureListener;
        if (arrayList != null) {
            arrayList.remove(simpleOnGestureListener);
        }
    }

    public void register(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        if (this.mScaleGestureListener == null) {
            this.mScaleGestureListener = new ArrayList<>();
        }
        if (this.mScaleGestureListener.contains(onScaleGestureListener)) {
            return;
        }
        this.mScaleGestureListener.add(onScaleGestureListener);
    }

    public void unregister(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        ArrayList<ScaleGestureDetector.OnScaleGestureListener> arrayList = this.mScaleGestureListener;
        if (arrayList != null) {
            arrayList.remove(onScaleGestureListener);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector != null && motionEvent.getPointerCount() == 1) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (this.mScaleGestureDetector == null || motionEvent.getPointerCount() != 2) {
            return false;
        }
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ArrayList<GestureDetector.SimpleOnGestureListener> arrayList = this.mGestureListener;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<GestureDetector.SimpleOnGestureListener> it = this.mGestureListener.iterator();
        while (it.hasNext()) {
            it.next().onScroll(motionEvent, motionEvent2, f, f2);
        }
        return true;
    }

    public void release() {
        ArrayList<GestureDetector.SimpleOnGestureListener> arrayList = this.mGestureListener;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        ArrayList<ScaleGestureDetector.OnScaleGestureListener> arrayList = this.mScaleGestureListener;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<ScaleGestureDetector.OnScaleGestureListener> it = this.mScaleGestureListener.iterator();
        while (it.hasNext()) {
            it.next().onScale(scaleGestureDetector);
        }
        return true;
    }
}
