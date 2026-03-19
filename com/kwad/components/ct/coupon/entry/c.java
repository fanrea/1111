package com.kwad.components.ct.coupon.entry;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static float anG = 0.0f;
    private static float anH = 60.0f;
    private float Nd;
    private float Ne;
    private float Nf;
    private float Ng;
    private Rect anI;
    private boolean anJ;

    public final void a(Rect rect) {
        this.anI = rect;
        com.kwad.sdk.core.d.c.d("CouponEntryDragHelper", "setDragRect: " + rect.toShortString());
    }

    public final void F(final View view) {
        com.kwad.sdk.core.d.c.d("CouponEntryDragHelper", "with: " + view);
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ct.coupon.entry.c.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                com.kwad.sdk.core.d.c.d("CouponEntryDragHelper", "onTouch: " + motionEvent.getAction());
                if (motionEvent.getAction() == 0) {
                    c.this.anJ = false;
                    c.this.Nf = rawX;
                    c.this.Ng = rawY;
                    c.this.Nd = rawX;
                    c.this.Ne = rawY;
                } else {
                    if (motionEvent.getAction() == 2) {
                        float f = rawX - c.this.Nf;
                        float f2 = rawY - c.this.Ng;
                        com.kwad.sdk.core.d.c.d("CouponEntryDragHelper", "onTouch: dx==" + f + ",dy==" + f2);
                        if (!c.this.anJ) {
                            c cVar = c.this;
                            cVar.anJ = Math.abs(cVar.Nd - rawX) > 10.0f && Math.abs(c.this.Ne - rawY) > 10.0f;
                        }
                        c.this.a(view, f, f2);
                        c.this.Nf = rawX;
                        c.this.Ng = rawY;
                    } else if (motionEvent.getAction() == 1) {
                        com.kwad.sdk.core.d.c.d("CouponEntryDragHelper", "ACTION_UP: mHasMove=" + c.this.anJ);
                        float unused = c.anG = view.getX();
                        float unused2 = c.anH = view.getY();
                        return c.this.anJ;
                    }
                }
                return false;
            }
        });
    }

    public final void a(View view, float f, float f2) {
        if (view != null) {
            float translationX = view.getTranslationX() + f;
            float translationY = view.getTranslationY() + f2;
            Rect rect = this.anI;
            if (rect != null) {
                float f3 = rect.left;
                float f4 = this.anI.top;
                float width = this.anI.right - view.getWidth();
                float height = this.anI.bottom - view.getHeight();
                if (translationX < f3) {
                    translationX = f3;
                }
                if (translationY < f4) {
                    translationY = f4;
                }
                if (translationX > width) {
                    translationX = width;
                }
                if (translationY > height) {
                    translationY = height;
                }
            }
            view.setTranslationX(translationX);
            view.setTranslationY(translationY);
        }
    }

    public static float xU() {
        return anG;
    }

    public static float xV() {
        return anH;
    }
}
