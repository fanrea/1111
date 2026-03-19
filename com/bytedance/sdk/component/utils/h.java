package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends TouchDelegate {
    private Rect b;
    private boolean c;
    private View d;
    private Rect hc;
    private int u;

    public h(Rect rect, View view) {
        super(rect, view);
        this.hc = rect;
        this.u = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.b = rect2;
        int i = this.u;
        rect2.inset(-i, -i);
        this.d = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zContains;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z = this.c;
                zContains = z ? this.b.contains(x, y) : true;
                z = z;
            } else if (action != 3) {
                zContains = true;
                z = false;
            } else {
                boolean z2 = this.c;
                this.c = false;
                z = z2;
                zContains = true;
            }
        } else if (this.hc.contains(x, y)) {
            this.c = true;
            zContains = true;
        } else {
            this.c = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.d;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.u * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
