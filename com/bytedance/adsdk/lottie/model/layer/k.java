package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.lottie.sy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k extends h {
    private Path gb;
    private int tc;
    private int tt;

    public k(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, Context context) {
        super(gbVar, gbVar2);
        this.gb = null;
        this.tt = -1;
        this.tc = -1;
        if (this.h != null) {
            float fD = com.bytedance.adsdk.lottie.u.tt.d();
            this.tt = (int) (this.h.d() * fD);
            this.tc = (int) (this.h.hc() * fD);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.tt, this.tc);
            Path path = new Path();
            this.gb = path;
            float f = fD * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.h, com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        sy syVarD = this.hc.d();
        View viewD = syVarD != null ? syVarD.d("videoview:", null) : null;
        if (this.tt <= 0 || viewD == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        d(i);
        float fGb = gb();
        d(viewD, this.tt, this.tc);
        viewD.setAlpha(fGb);
        canvas.clipPath(this.gb);
        viewD.draw(canvas);
        canvas.restore();
    }

    private static void d(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
