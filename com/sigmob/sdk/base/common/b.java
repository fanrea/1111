package com.sigmob.sdk.base.common;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends GestureDetector.SimpleOnGestureListener {
    private static final int b = 4;
    private static final float c = 100.0f;
    private static final float d = 100.0f;
    boolean a;
    private final BaseAdUnit e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private int j;
    private float k;
    private a l = a.UNSET;
    private View m;

    /* renamed from: com.sigmob.sdk.base.common.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.GOING_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.GOING_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    enum a {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED
    }

    b(View view, BaseAdUnit adUnit) {
        this.f = 100.0f;
        if (view != null && view.getWidth() > 0) {
            this.f = Math.min(100.0f, view.getWidth() / 3.0f);
        }
        this.a = false;
        this.m = view;
        this.e = adUnit;
    }

    private void a(float currentPositionX) {
        if (currentPositionX > this.k) {
            this.l = a.GOING_RIGHT;
        }
    }

    private boolean a(MotionEvent e1, MotionEvent e2) {
        if (e1 == null || e2 == null) {
            return false;
        }
        return Math.abs(e2.getY() - e1.getY()) > 100.0f;
    }

    private void b(float currentPositionX) {
        if (d(currentPositionX) && g(currentPositionX)) {
            this.l = a.GOING_LEFT;
            this.k = currentPositionX;
        }
    }

    private void c(float currentPositionX) {
        if (e(currentPositionX) && f(currentPositionX)) {
            this.l = a.GOING_RIGHT;
            this.k = currentPositionX;
        }
    }

    private boolean d(float currentPosition) {
        if (this.i) {
            return true;
        }
        if (currentPosition < this.k + this.f) {
            return false;
        }
        this.h = false;
        this.i = true;
        return true;
    }

    private void e() {
        int i = this.j + 1;
        this.j = i;
        if (i >= 4) {
            this.l = a.FINISHED;
        }
    }

    private boolean e(float currentPosition) {
        if (this.h) {
            return true;
        }
        if (currentPosition > this.k - this.f) {
            return false;
        }
        this.i = false;
        this.h = true;
        e();
        return true;
    }

    private boolean f(float currentPositionX) {
        return currentPositionX > this.g;
    }

    private boolean g(float currentPositionX) {
        return currentPositionX < this.g;
    }

    void a() {
        a aVar = a.FINISHED;
        b();
    }

    void b() {
        this.j = 0;
        this.l = a.UNSET;
    }

    void c() {
        this.a = false;
    }

    boolean d() {
        return this.a;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (e1 == null || e2 == null) {
            return false;
        }
        if (this.l == a.FINISHED) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        if (a(e1, e2)) {
            this.l = a.FAILED;
        } else {
            int i = AnonymousClass1.a[this.l.ordinal()];
            if (i == 1) {
                this.k = e1.getX();
                a(e2.getX());
            } else if (i == 2) {
                b(e2.getX());
            } else if (i == 3) {
                c(e2.getX());
            }
            this.g = e2.getX();
        }
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        this.a = true;
        return super.onSingleTapUp(e);
    }
}
