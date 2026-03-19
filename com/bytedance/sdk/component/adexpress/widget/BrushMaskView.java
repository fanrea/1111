package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BrushMaskView extends View {
    private static final String d = "BrushMaskView";
    private BitmapDrawable an;
    private Bitmap b;
    private Canvas c;
    private Paint gb;
    private Paint h;
    private Paint hc;
    private Paint u;

    public void setEraserSize(float f) {
        this.h.setStrokeWidth(f);
        this.gb.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.hc.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(d(i), d(i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.b;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.u);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d(i, i2);
    }

    private void d(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.b = bitmapCreateBitmap;
            Canvas canvas = this.c;
            if (canvas == null) {
                this.c = new Canvas(this.b);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.c.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.hc);
            if (this.an != null) {
                this.an.setBounds(new Rect(0, 0, i, i2));
                this.an.draw(this.c);
            }
        } catch (Exception e) {
            mq.c(d, e.getMessage());
        }
    }

    private int d(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.an = null;
        } else {
            this.an = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }
}
