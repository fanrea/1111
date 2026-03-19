package com.baidu.mobads.container.bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ak extends FrameLayout {
    static final float a = 30.0f;
    static final float b = 50.0f;
    static final float c = 8.0f;
    private final int d;
    private c e;
    private final BitmapDrawable f;
    private a g;
    private final int h;
    private final int i;
    private final int j;
    private boolean k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private d p;
    private b q;

    public interface b {
        boolean a(int i, KeyEvent keyEvent);
    }

    public interface c {
        void a();
    }

    public enum a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);

        private final int h;

        a(int i2) {
            this.h = i2;
        }

        int b() {
            return this.h;
        }
    }

    public ak(Context context, Bitmap bitmap) {
        super(context);
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        this.q = null;
        this.f = new BitmapDrawable(context.getResources(), bitmap);
        this.g = a.TOP_RIGHT;
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.h = (int) (displayMetrics.density * 50.0f);
        this.i = (int) (displayMetrics.density * a);
        this.j = (int) (displayMetrics.density * 8.0f);
        setWillNotDraw(false);
    }

    public void a(c cVar) {
        this.e = cVar;
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.g = aVar;
        this.k = true;
        invalidate();
    }

    public void a(boolean z) {
        if (this.f.setVisible(z, false)) {
            invalidate(this.m);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.k = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.k) {
            this.k = false;
            this.l.set(0, 0, getWidth(), getHeight());
            a(this.g, this.l, this.m);
            this.o.set(this.m);
            this.o.inset(this.j, this.j);
            b(this.g, this.o, this.n);
            this.f.setBounds(this.n);
        }
        if (this.f.isVisible()) {
            this.f.draw(canvas);
        }
    }

    public void a(a aVar, Rect rect, Rect rect2) {
        a(aVar, this.h, rect, rect2);
    }

    private void b(a aVar, Rect rect, Rect rect2) {
        a(aVar, this.i, rect, rect2);
    }

    private void a(a aVar, int i, Rect rect, Rect rect2) {
        Gravity.apply(aVar.b(), i, i, rect, rect2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a((int) motionEvent.getX(), (int) motionEvent.getY(), this.d)) {
            b(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                b(true);
                return true;
            case 1:
                if (a()) {
                    if (this.p == null) {
                        this.p = new d();
                    }
                    postDelayed(this.p, ViewConfiguration.getPressedStateDuration());
                    b();
                }
                return true;
            case 2:
            default:
                return true;
            case 3:
                b(false);
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z == a()) {
            return;
        }
        this.f.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
        invalidate(this.m);
    }

    boolean a() {
        return this.f.getState() == SELECTED_STATE_SET;
    }

    boolean a(int i, int i2, int i3) {
        return i >= this.m.left - i3 && i2 >= this.m.top - i3 && i < this.m.right + i3 && i2 < this.m.bottom + i3;
    }

    private void b() {
        playSoundEffect(0);
        if (this.e != null) {
            this.e.a();
        }
    }

    private final class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ak.this.b(false);
        }
    }

    public void a(b bVar) {
        this.q = bVar;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.q == null) {
            return false;
        }
        return this.q.a(i, keyEvent);
    }
}
