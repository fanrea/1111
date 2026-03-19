package com.style.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class af implements View.OnTouchListener {
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private boolean a = true;
    private boolean b = true;
    private int c = 0;
    private boolean k = false;

    public void a(boolean z) {
        this.a = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public void a(int i) {
        this.c = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.k = false;
                    this.d = rawX;
                    this.e = rawY;
                    this.f = rawX;
                    this.g = rawY;
                    int[] iArr = new int[2];
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.getLocationInWindow(iArr);
                        this.h = viewGroup.getMeasuredHeight();
                        this.i = viewGroup.getMeasuredWidth();
                        this.j = iArr[1];
                        break;
                    }
                    break;
                case 1:
                    if (!this.k) {
                        this.k = Math.sqrt(Math.pow((double) Math.abs(this.f - this.d), 2.0d) + Math.pow((double) Math.abs(this.g - this.e), 2.0d)) > ((double) ViewConfiguration.get(view.getContext()).getScaledTouchSlop());
                    }
                    if (this.b && this.k) {
                        if (view.getX() + (view.getWidth() / 2.0f) <= this.i / 2.0f) {
                            view.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.c).start();
                            break;
                        } else {
                            view.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x((this.i - view.getWidth()) - this.c).start();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (rawX >= 0.0f && rawX <= this.i && rawY >= this.j && rawY <= this.h + this.j) {
                        float f = rawX - this.f;
                        float f2 = rawY - this.g;
                        float x = view.getX() + f;
                        float y = view.getY() + f2;
                        float width = this.i - view.getWidth();
                        float height = this.h - view.getHeight();
                        float fMax = Math.max(this.c, Math.min(x, width - this.c));
                        float fMax2 = Math.max(this.c, Math.min(y, height - this.c));
                        view.setX(fMax);
                        view.setY(fMax2);
                        this.f = rawX;
                        this.g = rawY;
                        break;
                    }
                    break;
            }
        }
        return this.k;
    }
}
