package com.kwad.sdk.widget.swipe;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d {
    private boolean cqt = false;

    protected abstract void b(View view, MotionEvent motionEvent);

    protected abstract boolean n(MotionEvent motionEvent);

    protected abstract boolean o(MotionEvent motionEvent);

    public final void dx(boolean z) {
        this.cqt = !z;
    }

    public final void d(View view, MotionEvent motionEvent) {
        if (this.cqt) {
            return;
        }
        b(view, motionEvent);
    }

    public final boolean e(View view, MotionEvent motionEvent) {
        return !this.cqt && n(motionEvent);
    }

    public final boolean f(View view, MotionEvent motionEvent) {
        return !this.cqt && o(motionEvent);
    }
}
