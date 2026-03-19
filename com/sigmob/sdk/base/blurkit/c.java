package com.sigmob.sdk.base.blurkit;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends FrameLayout {
    public static final float a = 0.12f;
    public static final int b = 12;
    public static final int c = 24;
    public static final float d = 0.0f;
    public static final float e = Float.NaN;
    private float f;
    private int g;
    private int h;
    private float i;
    private float j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private d o;
    private WeakReference<View> p;
    private Point q;
    private Bitmap r;
    private Choreographer.FrameCallback s;

    public c(Context context) {
        super(context, null);
        this.f = 0.12f;
        this.g = 12;
        this.h = 24;
        this.i = 0.0f;
        this.j = Float.NaN;
        this.s = new Choreographer.FrameCallback() { // from class: com.sigmob.sdk.base.blurkit.c.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                c.this.invalidate();
                Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / c.this.h);
            }
        };
    }

    public c(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f = 0.12f;
        this.g = 12;
        this.h = 24;
        this.i = 0.0f;
        this.j = Float.NaN;
        this.s = new Choreographer.FrameCallback() { // from class: com.sigmob.sdk.base.blurkit.c.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                c.this.invalidate();
                Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / c.this.h);
            }
        };
        if (!isInEditMode()) {
            a.a(context);
        }
        d dVar = new d(getContext());
        this.o = dVar;
        dVar.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.o);
        setCornerRadius(this.i);
    }

    private Bitmap a(View view, Rect crop, float downscaleFactor) throws b, NullPointerException {
        View rootView = view.getRootView();
        int iWidth = (int) (crop.width() * downscaleFactor);
        int iHeight = (int) (crop.height() * downscaleFactor);
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0 || iWidth <= 0 || iHeight <= 0) {
            throw new b("No screen available (width or height = 0)");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(downscaleFactor, downscaleFactor);
        matrix.postTranslate((-crop.left) * downscaleFactor, (-crop.top) * downscaleFactor);
        canvas.setMatrix(matrix);
        rootView.draw(canvas);
        return bitmapCreateBitmap;
    }

    private PointF a(View view) {
        if (getParent() == null) {
            return new PointF();
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                return new PointF();
            }
            PointF pointFA = a(viewGroup);
            pointFA.offset(view.getX(), view.getY());
            return pointFA;
        } catch (Exception unused) {
            return new PointF();
        }
    }

    private Bitmap g() {
        Point positionInScreen;
        Bitmap bitmapA;
        if (getContext() != null && !isInEditMode()) {
            WeakReference<View> weakReference = this.p;
            if (weakReference == null || weakReference.get() == null) {
                WeakReference<View> weakReference2 = new WeakReference<>(getActivityView());
                this.p = weakReference2;
                if (weakReference2.get() == null) {
                    return null;
                }
            }
            if (this.m) {
                if (this.q == null) {
                    this.q = getPositionInScreen();
                }
                positionInScreen = this.q;
            } else {
                positionInScreen = getPositionInScreen();
            }
            super.setAlpha(0.0f);
            int width = this.p.get().getWidth();
            int height = this.p.get().getHeight();
            int width2 = (int) (getWidth() * this.f);
            int height2 = (int) (getHeight() * this.f);
            int i = (int) (positionInScreen.x * this.f);
            int i2 = (int) (positionInScreen.y * this.f);
            int width3 = getWidth() / 8;
            int height3 = getHeight() / 8;
            int i3 = -width3;
            if (i + i3 < 0) {
                i3 = 0;
            }
            if ((i + width) - width3 > width) {
                width3 = (width + width) - i;
            }
            int i4 = -height3;
            if (i2 + i4 < 0) {
                i4 = 0;
            }
            if (getHeight() + i2 + height3 > height) {
                height3 = 0;
            }
            if (this.n) {
                if (this.r == null) {
                    c();
                }
                if (width2 == 0 || height2 == 0) {
                    return null;
                }
                bitmapA = Bitmap.createBitmap(this.r, i, i2, width2, height2);
            } else {
                try {
                    bitmapA = a(this.p.get(), new Rect(positionInScreen.x + i3, positionInScreen.y + i4, positionInScreen.x + getWidth() + Math.abs(i3) + width3, positionInScreen.y + getHeight() + Math.abs(i4) + height3), this.f);
                } catch (b | NullPointerException unused) {
                }
            }
            if (!this.n) {
                bitmapA = Bitmap.createBitmap(a.a().a(bitmapA, this.g), (int) (Math.abs(i3) * this.f), (int) (Math.abs(i4) * this.f), width2, height2);
            }
            super.setAlpha(Float.isNaN(this.j) ? 1.0f : this.j);
            return bitmapA;
        }
        return null;
    }

    private View getActivityView() {
        try {
            return ((Activity) getContext()).getWindow().getDecorView().findViewById(R.id.content);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private Point getPositionInScreen() {
        PointF pointFA = a((View) this);
        return new Point((int) pointFA.x, (int) pointFA.y);
    }

    public void a() {
        if (!this.k && this.h > 0) {
            this.k = true;
            Choreographer.getInstance().postFrameCallback(this.s);
        }
    }

    public void b() {
        if (this.k) {
            this.k = false;
            Choreographer.getInstance().removeFrameCallback(this.s);
        }
    }

    public void c() {
        this.n = true;
        WeakReference<View> weakReference = this.p;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View rootView = this.p.get().getRootView();
        try {
            super.setAlpha(0.0f);
            this.r = a(rootView, new Rect(0, 0, rootView.getWidth(), rootView.getHeight()), this.f);
            if (Float.isNaN(this.j)) {
                super.setAlpha(1.0f);
            } else {
                super.setAlpha(this.j);
            }
            this.r = a.a().a(this.r, this.g);
        } catch (Exception unused) {
        }
    }

    public void d() {
        this.n = false;
        this.r = null;
    }

    public void e() {
        this.m = true;
        this.q = getPositionInScreen();
    }

    public void f() {
        this.m = false;
        this.q = null;
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.j;
    }

    public int getBlurRadius() {
        return this.g;
    }

    public float getCornerRadius() {
        return this.i;
    }

    public float getDownscaleFactor() {
        return this.f;
    }

    public int getFPS() {
        return this.h;
    }

    public boolean getPositionLocked() {
        return this.m;
    }

    public boolean getViewLocked() {
        return this.n;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Bitmap bitmapG = g();
        if (bitmapG != null) {
            this.o.setImageBitmap(bitmapG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        invalidate();
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        this.j = alpha;
        if (this.n) {
            return;
        }
        super.setAlpha(alpha);
    }

    public void setBlurRadius(int blurRadius) {
        this.g = blurRadius;
        this.r = null;
        invalidate();
    }

    public void setCornerRadius(float cornerRadius) {
        this.i = cornerRadius;
        d dVar = this.o;
        if (dVar != null) {
            dVar.setCornerRadius(cornerRadius);
        }
        invalidate();
    }

    public void setDownscaleFactor(float downscaleFactor) {
        this.f = downscaleFactor;
        this.r = null;
        invalidate();
    }

    public void setFPS(int fps) {
        if (this.k) {
            b();
        }
        this.h = fps;
        if (this.l) {
            a();
        }
    }
}
