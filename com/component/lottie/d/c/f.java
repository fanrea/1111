package com.component.lottie.d.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.component.lottie.a.b.t;
import com.component.lottie.af;
import com.component.lottie.ax;
import com.component.lottie.ba;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends a {
    private final Paint g;
    private final Rect h;
    private final Rect i;
    private final ax j;
    private com.component.lottie.a.b.a<ColorFilter, ColorFilter> k;
    private com.component.lottie.a.b.a<Bitmap, Bitmap> l;

    f(af afVar, g gVar) {
        super(afVar, gVar);
        this.g = new com.component.lottie.a.a(3);
        this.h = new Rect();
        this.i = new Rect();
        this.j = afVar.g(gVar.g());
    }

    @Override // com.component.lottie.d.c.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapH = h();
        if (bitmapH == null || bitmapH.isRecycled() || this.j == null) {
            return;
        }
        float fA = com.component.lottie.g.g.a();
        this.g.setAlpha(i);
        if (this.k != null) {
            this.g.setColorFilter(this.k.g());
        }
        canvas.save();
        canvas.concat(matrix);
        this.h.set(0, 0, bitmapH.getWidth(), bitmapH.getHeight());
        if (this.b.g()) {
            this.i.set(0, 0, (int) (this.j.a() * fA), (int) (this.j.b() * fA));
        } else {
            this.i.set(0, 0, (int) (bitmapH.getWidth() * fA), (int) (bitmapH.getHeight() * fA));
        }
        canvas.drawBitmap(bitmapH, this.h, this.i, this.g);
        canvas.restore();
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (this.j != null) {
            float fA = com.component.lottie.g.g.a();
            rectF.set(0.0f, 0.0f, this.j.a() * fA, this.j.b() * fA);
            this.a.mapRect(rectF);
        }
    }

    private Bitmap h() {
        Bitmap bitmapG;
        if (this.l != null && (bitmapG = this.l.g()) != null) {
            return bitmapG;
        }
        Bitmap bitmapF = this.b.f(this.c.g());
        if (bitmapF != null) {
            return bitmapF;
        }
        ax axVar = this.j;
        if (axVar != null) {
            return axVar.f();
        }
        return null;
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        super.a((f) t, (com.component.lottie.h.j<f>) jVar);
        if (t == ba.f759K) {
            if (jVar == null) {
                this.k = null;
                return;
            } else {
                this.k = new t(jVar);
                return;
            }
        }
        if (t == ba.N) {
            if (jVar == null) {
                this.l = null;
            } else {
                this.l = new t(jVar);
            }
        }
    }
}
