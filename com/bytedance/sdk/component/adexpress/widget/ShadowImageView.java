package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ShadowImageView extends ImageView {
    private Paint d;
    private RectF hc;

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hc.right == getMeasuredWidth() && this.hc.bottom == getMeasuredHeight()) {
            return;
        }
        this.hc.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.hc;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.hc.bottom / 2.0f, this.d);
        super.onDraw(canvas);
    }
}
