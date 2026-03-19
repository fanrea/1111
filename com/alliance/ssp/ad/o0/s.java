package com.alliance.ssp.ad.o0;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: myGestureListener.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class s extends GestureDetector.SimpleOnGestureListener {
    public com.alliance.ssp.ad.t.a a;

    public s(com.alliance.ssp.ad.t.a aVar) {
        this.a = aVar;
    }

    public final void a(MotionEvent motionEvent) {
        com.alliance.ssp.ad.t.a aVar = this.a;
        if (aVar != null) {
            aVar.M = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getRawX()).toString();
            this.a.N = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getRawY()).toString();
            this.a.R = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getX()).toString();
            this.a.S = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getY()).toString();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        com.alliance.ssp.ad.t.a aVar = this.a;
        if (aVar == null) {
            return false;
        }
        aVar.f716K = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getRawX()).toString();
        this.a.L = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getRawY()).toString();
        this.a.M = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getRawX()).toString();
        this.a.N = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getRawY()).toString();
        this.a.P = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getX()).toString();
        this.a.Q = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getY()).toString();
        this.a.R = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getX()).toString();
        this.a.S = com.alliance.ssp.ad.a.b.a("").append((int) motionEvent.getY()).toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a.I = String.valueOf(jCurrentTimeMillis);
        this.a.Z = String.valueOf((int) (jCurrentTimeMillis / 1000));
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        a(motionEvent2);
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        a(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        a(motionEvent);
        return false;
    }
}
