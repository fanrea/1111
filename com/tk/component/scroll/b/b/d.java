package com.tk.component.scroll.b.b;

import android.os.SystemClock;
import android.support.v7.widget.al;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class d {
    private final h Wd;
    private final g We;
    private float Wf;
    private int Wg;
    private long Wh;
    private VelocityTracker er;
    private int ew;
    private final al pD;

    d(h hVar, g gVar, al alVar) {
        this.Wd = hVar;
        this.We = gVar;
        this.pD = alVar;
    }

    final boolean oe() {
        return this.We.oe();
    }

    final boolean of() {
        if (this.We.oo()) {
            return false;
        }
        this.Wg = 0;
        this.Wf = 0.0f;
        this.Wh = SystemClock.uptimeMillis();
        oh();
        this.We.om();
        if (!this.We.isIdle()) {
            this.pD.dX();
        }
        a(this.Wh, 0, 0.0f, 0.0f);
        return true;
    }

    final boolean s(float f) {
        if (!this.We.oe()) {
            return false;
        }
        this.Wf -= f;
        int iRound = Math.round(this.Wf - this.Wg);
        this.Wg += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.Wd.getOrientation() == 0;
        int i = z ? iRound : 0;
        if (z) {
            iRound = 0;
        }
        float f2 = z ? this.Wf : 0.0f;
        float f3 = z ? 0.0f : this.Wf;
        this.pD.scrollBy(i, iRound);
        a(jUptimeMillis, 2, f2, f3);
        return true;
    }

    final boolean og() {
        if (!this.We.oe()) {
            return false;
        }
        this.We.on();
        VelocityTracker velocityTracker = this.er;
        velocityTracker.computeCurrentVelocity(1000, this.ew);
        if (this.pD.Q((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.Wd.ow();
        return true;
    }

    private void oh() {
        VelocityTracker velocityTracker = this.er;
        if (velocityTracker == null) {
            this.er = VelocityTracker.obtain();
            this.ew = ViewConfiguration.get(this.Wd.getContext()).getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
    }

    private void a(long j, int i, float f, float f2) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.Wh, j, i, f, f2, 0);
        this.er.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }
}
