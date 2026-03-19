package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path Nb;
    private Paint Nc;
    private float Nd;
    private float Ne;
    private float Nf;
    private float Ng;
    private int Nh;
    private a Ni;
    private GestureDetector mGestureDetector;

    public interface a {
        void a(float f, float f2, float f3, float f4);

        void c(MotionEvent motionEvent);
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.Nh = Color.parseColor("#66ffffff");
        init();
    }

    public KsSplashSlidePathView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nh = Color.parseColor("#66ffffff");
        init();
    }

    private void init() {
        this.Nb = new Path();
        Paint paint = new Paint();
        this.Nc = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.Nc.setStrokeWidth(com.kwad.sdk.c.a.a.a(getContext(), 15.0f));
        this.Nc.setStyle(Paint.Style.STROKE);
        this.Nc.setColor(this.Nh);
        this.Nc.setDither(true);
        this.mGestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.Ni == null) {
                    return false;
                }
                KsSplashSlidePathView.this.Ni.c(motionEvent);
                return true;
            }
        });
    }

    public void setOnSlideTouchListener(a aVar) {
        this.Ni = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d(motionEvent);
        return true;
    }

    private void d(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Nb.reset();
            this.Nd = motionEvent.getX();
            float y = motionEvent.getY();
            this.Ne = y;
            float f = this.Nd;
            this.Nf = f;
            this.Ng = y;
            this.Nb.moveTo(f, y);
            invalidate();
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            d(motionEvent.getX(), motionEvent.getY());
            invalidate();
            return;
        }
        this.Nb.reset();
        invalidate();
        a aVar = this.Ni;
        if (aVar != null) {
            aVar.a(this.Nd, this.Ne, motionEvent.getX(), motionEvent.getY());
        }
    }

    private void d(float f, float f2) {
        float fAbs = Math.abs(f - this.Nf);
        float fAbs2 = Math.abs(f2 - this.Ng);
        if (fAbs >= 3.0f || fAbs2 >= 3.0f) {
            Path path = this.Nb;
            float f3 = this.Nf;
            float f4 = this.Ng;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.Nf = f;
            this.Ng = f2;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.Nb, this.Nc);
    }
}
