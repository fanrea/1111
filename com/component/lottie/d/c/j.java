package com.component.lottie.d.c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.component.lottie.a.b.t;
import com.component.lottie.af;
import com.component.lottie.ba;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends a {
    private final RectF g;
    private final Paint h;
    private final float[] i;
    private final Path j;
    private final g k;
    private com.component.lottie.a.b.a<ColorFilter, ColorFilter> l;

    j(af afVar, g gVar) {
        super(afVar, gVar);
        this.g = new RectF();
        this.h = new com.component.lottie.a.a();
        this.i = new float[8];
        this.j = new Path();
        this.k = gVar;
        this.h.setAlpha(0);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(gVar.p());
    }

    @Override // com.component.lottie.d.c.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.k.p());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.d.a() == null ? 100 : this.d.a().g().intValue())) / 100.0f) * 255.0f);
        this.h.setAlpha(iIntValue);
        if (this.l != null) {
            this.h.setColorFilter(this.l.g());
        }
        if (iIntValue > 0) {
            this.i[0] = 0.0f;
            this.i[1] = 0.0f;
            this.i[2] = this.k.r();
            this.i[3] = 0.0f;
            this.i[4] = this.k.r();
            this.i[5] = this.k.q();
            this.i[6] = 0.0f;
            this.i[7] = this.k.q();
            matrix.mapPoints(this.i);
            this.j.reset();
            this.j.moveTo(this.i[0], this.i[1]);
            this.j.lineTo(this.i[2], this.i[3]);
            this.j.lineTo(this.i[4], this.i[5]);
            this.j.lineTo(this.i[6], this.i[7]);
            this.j.lineTo(this.i[0], this.i[1]);
            this.j.close();
            canvas.drawPath(this.j, this.h);
        }
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.g.set(0.0f, 0.0f, this.k.r(), this.k.q());
        this.a.mapRect(this.g);
        rectF.set(this.g);
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        super.a((j) t, (com.component.lottie.h.j<j>) jVar);
        if (t == ba.f759K) {
            if (jVar == null) {
                this.l = null;
            } else {
                this.l = new t(jVar);
            }
        }
    }
}
