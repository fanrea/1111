package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends FrameLayout {
    private float bKv;
    private RectF bKw;
    private Path mPath;

    public c(Context context) {
        this(context, null);
        setLayerType(1, null);
        this.bKv = com.kwad.sdk.c.a.a.a(context, 4.0f);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setLayerType(1, null);
        this.bKv = com.kwad.sdk.c.a.a.a(context, 4.0f);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(1, null);
        this.bKv = com.kwad.sdk.c.a.a.a(context, 4.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int iSave = canvas.save();
        RectF rectF = this.bKw;
        if (rectF == null) {
            this.mPath = new Path();
            this.bKw = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.bKw.bottom = canvas.getHeight();
            this.mPath.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f = this.bKv;
        fArr[0] = f;
        fArr[1] = f;
        fArr[2] = f;
        fArr[3] = f;
        fArr[4] = f;
        fArr[5] = f;
        fArr[6] = f;
        fArr[7] = f;
        this.mPath.addRoundRect(this.bKw, fArr, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public void setRadius(float f) {
        this.bKv = f;
        invalidate();
    }

    public float getRadius() {
        return this.bKv;
    }
}
