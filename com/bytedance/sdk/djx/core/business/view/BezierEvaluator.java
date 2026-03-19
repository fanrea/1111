package com.bytedance.sdk.djx.core.business.view;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BezierEvaluator implements TypeEvaluator<PointF> {
    PointF point = new PointF();
    private final PointF pointF1;
    private final PointF pointF2;

    public BezierEvaluator(PointF pointF, PointF pointF2) {
        this.pointF1 = pointF;
        this.pointF2 = pointF2;
    }

    @Override // android.animation.TypeEvaluator
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = 1.0f - f;
        float f3 = f * f;
        float f4 = f3 * f;
        float f5 = f2 * f2;
        float f6 = f5 * f2;
        float f7 = f5 * 3.0f * f;
        float f8 = f2 * 3.0f * f3;
        this.point.x = (pointF.x * f6) + (this.pointF1.x * f7) + (this.pointF2.x * f8) + (pointF2.x * f4);
        this.point.y = (f6 * pointF.y) + (f7 * this.pointF1.y) + (f8 * this.pointF2.y) + (f4 * pointF2.y);
        return this.point;
    }
}
