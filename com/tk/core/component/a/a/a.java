package com.tk.core.component.a.a;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a implements Interpolator {
    protected PointF acA;
    protected PointF acw;
    protected PointF acx;
    protected PointF acy;
    protected PointF acz;

    public static a qQ() {
        return new a(0.42f, 0.0f, 1.0f, 1.0f);
    }

    public static a qR() {
        return new a(0.0f, 0.0f, 0.58f, 1.0f);
    }

    public static a qS() {
        return new a(0.42f, 0.0f, 0.58f, 1.0f);
    }

    public static a qT() {
        return new a(0.0f, 0.0f, 1.0f, 1.0f);
    }

    private a(PointF pointF, PointF pointF2) {
        this.acy = new PointF();
        this.acz = new PointF();
        this.acA = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.acw = pointF;
        this.acx = pointF2;
    }

    public a(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return D(E(f));
    }

    private float D(float f) {
        this.acA.y = this.acw.y * 3.0f;
        this.acz.y = ((this.acx.y - this.acw.y) * 3.0f) - this.acA.y;
        this.acy.y = (1.0f - this.acA.y) - this.acz.y;
        return f * (this.acA.y + ((this.acz.y + (this.acy.y * f)) * f));
    }

    private float E(float f) {
        float F = f;
        for (int i = 1; i < 14; i++) {
            float fG = G(F) - f;
            if (Math.abs(fG) < 0.001d) {
                break;
            }
            F -= fG / F(F);
        }
        return F;
    }

    private float F(float f) {
        return this.acA.x + (f * ((this.acz.x * 2.0f) + (this.acy.x * 3.0f * f)));
    }

    private float G(float f) {
        this.acA.x = this.acw.x * 3.0f;
        this.acz.x = ((this.acx.x - this.acw.x) * 3.0f) - this.acA.x;
        this.acy.x = (1.0f - this.acA.x) - this.acz.x;
        return f * (this.acA.x + ((this.acz.x + (this.acy.x * f)) * f));
    }
}
