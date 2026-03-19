package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends View {
    private Path a;
    private Path b;
    private Paint c;

    public f(Context context) {
        super(context);
        this.a = new Path();
        this.b = new Path();
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.c.setColor(-1);
        this.c.setAntiAlias(true);
        this.c.setAlpha(153);
        a();
    }

    public f(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }

    public f(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a();
    }

    private void a() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                f.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int width = getWidth();
        int width2 = getWidth();
        if (width <= 0 || width2 <= 0) {
            return;
        }
        int iMin = Math.min(width, width2);
        this.c.reset();
        this.a.reset();
        this.b.reset();
        this.c.setStrokeWidth(Dips.dipsToIntPixels(1.0f, getContext()));
        float f = iMin;
        float f2 = width / 2.0f;
        float f3 = width2 / 2.0f;
        this.a.addCircle(f2, f3, 0.45f * f, Path.Direction.CCW);
        this.b.addCircle(f2, f3, f * 0.35f, Path.Direction.CCW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.setColor(-16777216);
        this.c.setAlpha(102);
        this.c.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.a, this.c);
        this.c.setColor(-1);
        this.c.setAlpha(76);
        this.c.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.a, this.c);
        this.c.setAlpha(127);
        canvas.drawPath(this.b, this.c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        b();
    }
}
