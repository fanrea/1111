package com.kwad.tachikoma.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class RoundAngleImageView extends ImageView {
    private RectF Ex;
    private Path FC;
    private float[] FD;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FC = new Path();
        this.Ex = new RectF();
        this.FD = new float[8];
        int i2 = 0;
        while (true) {
            float[] fArr = this.FD;
            if (i2 >= fArr.length) {
                return;
            }
            fArr[i2] = 8.0f;
            i2++;
        }
    }

    public void setRadius(float f) {
        this.FD = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.FD;
            if (i < fArr.length) {
                fArr[i] = f;
                i++;
            } else {
                postInvalidate();
                return;
            }
        }
    }

    public void setRadius(float[] fArr) {
        this.FD = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.FD;
            if (i < fArr2.length) {
                fArr2[i] = fArr[i];
                i++;
            } else {
                postInvalidate();
                return;
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float[] fArr = this.FD;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.FD;
        float f = fArr2[0] + fArr2[3];
        float f2 = fArr2[1] + fArr2[7];
        this.FC.rewind();
        float f3 = measuredWidth;
        if (f3 >= f) {
            float f4 = measuredHeight;
            if (f4 > f2) {
                this.Ex.set(0.0f, 0.0f, f3, f4);
                this.FC.addRoundRect(this.Ex, this.FD, Path.Direction.CW);
                canvas.clipPath(this.FC);
            }
        }
        super.onDraw(canvas);
    }
}
