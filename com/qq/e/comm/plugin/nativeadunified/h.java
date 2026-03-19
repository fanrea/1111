package com.qq.e.comm.plugin.nativeadunified;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.r5;
import com.qq.e.comm.plugin.u2;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class h implements View.OnTouchListener {
    private final ViewGroup a;
    private boolean b;

    public h(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private boolean a(float f, float f2, int i, int i2) {
        return f < 0.0f || f > ((float) i) || f2 < 0.0f || f2 > ((float) i2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationInWindow(iArr2);
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        int iRound = Math.round(i - i3);
        int iRound2 = Math.round(i2 - i4);
        motionEvent.getActionMasked();
        r5 r5VarD = u2.a().d(this.a);
        if (r5VarD != null) {
            r5VarD.a(motionEvent, false, iRound, iRound2);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        motionEvent.getRawX();
        motionEvent.getRawY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b = true;
        } else if (actionMasked == 1) {
            if (a(x, y, width, height)) {
                this.b = false;
            }
            if (this.b) {
                view.performClick();
            }
        } else if (actionMasked != 2 || a(x, y, width, height)) {
            this.b = false;
        }
        return true;
    }
}
