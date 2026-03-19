package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements Interpolator {
    protected PointF b;
    protected PointF c;
    protected PointF d;
    protected PointF hc;
    protected PointF u;

    public d(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.b = new PointF();
        this.c = new PointF();
        this.u = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.d = pointF;
        this.hc = pointF2;
    }

    public d(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return d(hc(f));
    }

    protected float d(float f) {
        this.u.y = this.d.y * 3.0f;
        this.c.y = ((this.hc.y - this.d.y) * 3.0f) - this.u.y;
        this.b.y = (1.0f - this.u.y) - this.c.y;
        return f * (this.u.y + ((this.c.y + (this.b.y * f)) * f));
    }

    protected float hc(float f) {
        float fB = f;
        for (int i = 1; i < 14; i++) {
            float fC = c(fB) - f;
            if (Math.abs(fC) < 0.001d) {
                break;
            }
            fB -= fC / b(fB);
        }
        return fB;
    }

    private float b(float f) {
        return this.u.x + (f * ((this.c.x * 2.0f) + (this.b.x * 3.0f * f)));
    }

    private float c(float f) {
        this.u.x = this.d.x * 3.0f;
        this.c.x = ((this.hc.x - this.d.x) * 3.0f) - this.u.x;
        this.b.x = (1.0f - this.u.x) - this.c.x;
        return f * (this.u.x + ((this.c.x + (this.b.x * f)) * f));
    }
}
