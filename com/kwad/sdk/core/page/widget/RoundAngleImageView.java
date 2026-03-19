package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class RoundAngleImageView extends ImageView {
    private float[] bEl;
    private Path mPath;
    private RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public void setRadius(float f) {
        this.bEl = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.bEl;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = f;
            i++;
        }
    }

    public void setRadius(float[] fArr) {
        this.bEl = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.bEl;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float[] fArr = this.bEl;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.bEl;
        float f = fArr2[0] + fArr2[3];
        float f2 = fArr2[1] + fArr2[7];
        this.mPath.rewind();
        float f3 = measuredWidth;
        if (f3 >= f) {
            float f4 = measuredHeight;
            if (f4 > f2) {
                this.mRectF.set(0.0f, 0.0f, f3, f4);
                this.mPath.addRoundRect(this.mRectF, this.bEl, Path.Direction.CW);
                canvas.clipPath(this.mPath);
            }
        }
        super.onDraw(canvas);
    }
}
