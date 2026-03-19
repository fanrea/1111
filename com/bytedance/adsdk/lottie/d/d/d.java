package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.d.hc.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d implements mk, u, d.InterfaceC0167d {
    float b;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> cb;
    protected final com.bytedance.adsdk.lottie.model.layer.b d;
    private com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> e;
    private final com.bytedance.adsdk.lottie.gb gb;
    final Paint hc;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> k;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> mk;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Integer> mq;
    private final float[] tc;
    private final List<com.bytedance.adsdk.lottie.d.hc.d<?, Float>> uo;
    private com.bytedance.adsdk.lottie.d.hc.b w;
    private final PathMeasure c = new PathMeasure();
    private final Path u = new Path();
    private final Path an = new Path();
    private final RectF h = new RectF();
    private final List<C0166d> tt = new ArrayList();

    d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.lottie.model.d.c cVar, com.bytedance.adsdk.lottie.model.d.hc hcVar, List<com.bytedance.adsdk.lottie.model.d.hc> list, com.bytedance.adsdk.lottie.model.d.hc hcVar2) {
        com.bytedance.adsdk.lottie.d.d dVar = new com.bytedance.adsdk.lottie.d.d(1);
        this.hc = dVar;
        this.b = 0.0f;
        this.gb = gbVar;
        this.d = bVar;
        dVar.setStyle(Paint.Style.STROKE);
        dVar.setStrokeCap(cap);
        dVar.setStrokeJoin(join);
        dVar.setStrokeMiter(f);
        this.mq = cVar.d();
        this.mk = hcVar.d();
        if (hcVar2 == null) {
            this.k = null;
        } else {
            this.k = hcVar2.d();
        }
        this.uo = new ArrayList(list.size());
        this.tc = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.uo.add(list.get(i).d());
        }
        bVar.d(this.mq);
        bVar.d(this.mk);
        for (int i2 = 0; i2 < this.uo.size(); i2++) {
            bVar.d(this.uo.get(i2));
        }
        com.bytedance.adsdk.lottie.d.hc.d<?, Float> dVar2 = this.k;
        if (dVar2 != null) {
            bVar.d(dVar2);
        }
        this.mq.d(this);
        this.mk.d(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.uo.get(i3).d(this);
        }
        com.bytedance.adsdk.lottie.d.hc.d<?, Float> dVar3 = this.k;
        if (dVar3 != null) {
            dVar3.d(this);
        }
        if (bVar.mq() != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = bVar.mq().d().d();
            this.cb = dVarD;
            dVarD.d(this);
            bVar.d(this.cb);
        }
        if (bVar.uo() != null) {
            this.w = new com.bytedance.adsdk.lottie.d.hc.b(this, bVar, bVar.uo());
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.gb.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.bytedance.adsdk.lottie.d.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.util.List<com.bytedance.adsdk.lottie.d.d.b> r8, java.util.List<com.bytedance.adsdk.lottie.d.d.b> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.bytedance.adsdk.lottie.d.d.b r3 = (com.bytedance.adsdk.lottie.d.d.b) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.lottie.d.d.sy
            if (r4 == 0) goto L1f
            com.bytedance.adsdk.lottie.d.d.sy r3 = (com.bytedance.adsdk.lottie.d.d.sy) r3
            com.bytedance.adsdk.lottie.model.hc.rf$d r4 = r3.getType()
            com.bytedance.adsdk.lottie.model.hc.rf$d r5 = com.bytedance.adsdk.lottie.model.hc.rf.d.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.d(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.bytedance.adsdk.lottie.d.d.b r3 = (com.bytedance.adsdk.lottie.d.d.b) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.lottie.d.d.sy
            if (r4 == 0) goto L55
            r4 = r3
            com.bytedance.adsdk.lottie.d.d.sy r4 = (com.bytedance.adsdk.lottie.d.d.sy) r4
            com.bytedance.adsdk.lottie.model.hc.rf$d r5 = r4.getType()
            com.bytedance.adsdk.lottie.model.hc.rf$d r6 = com.bytedance.adsdk.lottie.model.hc.rf.d.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.bytedance.adsdk.lottie.d.d.d$d> r3 = r7.tt
            r3.add(r0)
        L4c:
            com.bytedance.adsdk.lottie.d.d.d$d r0 = new com.bytedance.adsdk.lottie.d.d.d$d
            r0.<init>(r4)
            r4.d(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.bytedance.adsdk.lottie.d.d.uo
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.bytedance.adsdk.lottie.d.d.d$d r0 = new com.bytedance.adsdk.lottie.d.d.d$d
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.bytedance.adsdk.lottie.d.d.d.C0166d.d(r0)
            com.bytedance.adsdk.lottie.d.d.uo r3 = (com.bytedance.adsdk.lottie.d.d.uo) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.bytedance.adsdk.lottie.d.d.d$d> r8 = r7.tt
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.d.d.d.d(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.lottie.u.d("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.u.tt.hc(matrix)) {
            com.bytedance.adsdk.lottie.u.hc("StrokeContent#draw");
            return;
        }
        this.hc.setAlpha(com.bytedance.adsdk.lottie.u.gb.d((int) ((((i / 255.0f) * ((com.bytedance.adsdk.lottie.d.hc.an) this.mq).tt()) / 100.0f) * 255.0f), 0, 255));
        this.hc.setStrokeWidth(((com.bytedance.adsdk.lottie.d.hc.c) this.mk).tt() * com.bytedance.adsdk.lottie.u.tt.d(matrix));
        if (this.hc.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.u.hc("StrokeContent#draw");
            return;
        }
        d(matrix);
        com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> dVar = this.e;
        if (dVar != null) {
            this.hc.setColorFilter(dVar.h());
        }
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVar2 = this.cb;
        if (dVar2 != null) {
            float fFloatValue = dVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.hc.setMaskFilter(null);
            } else if (fFloatValue != this.b) {
                this.hc.setMaskFilter(this.d.hc(fFloatValue));
            }
            this.b = fFloatValue;
        }
        com.bytedance.adsdk.lottie.d.hc.b bVar = this.w;
        if (bVar != null) {
            bVar.d(this.hc);
        }
        for (int i2 = 0; i2 < this.tt.size(); i2++) {
            C0166d c0166d = this.tt.get(i2);
            if (c0166d.hc != null) {
                d(canvas, c0166d, matrix);
            } else {
                com.bytedance.adsdk.lottie.u.d("StrokeContent#buildPath");
                this.u.reset();
                for (int size = c0166d.d.size() - 1; size >= 0; size--) {
                    this.u.addPath(((uo) c0166d.d.get(size)).c(), matrix);
                }
                com.bytedance.adsdk.lottie.u.hc("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.u.d("StrokeContent#drawPath");
                canvas.drawPath(this.u, this.hc);
                com.bytedance.adsdk.lottie.u.hc("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.u.hc("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.graphics.Canvas r17, com.bytedance.adsdk.lottie.d.d.d.C0166d r18, android.graphics.Matrix r19) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.d.d.d.d(android.graphics.Canvas, com.bytedance.adsdk.lottie.d.d.d$d, android.graphics.Matrix):void");
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.lottie.u.d("StrokeContent#getBounds");
        this.u.reset();
        for (int i = 0; i < this.tt.size(); i++) {
            C0166d c0166d = this.tt.get(i);
            for (int i2 = 0; i2 < c0166d.d.size(); i2++) {
                this.u.addPath(((uo) c0166d.d.get(i2)).c(), matrix);
            }
        }
        this.u.computeBounds(this.h, false);
        float fTt = ((com.bytedance.adsdk.lottie.d.hc.c) this.mk).tt();
        RectF rectF2 = this.h;
        float f = fTt / 2.0f;
        rectF2.set(rectF2.left - f, this.h.top - f, this.h.right + f, this.h.bottom + f);
        rectF.set(this.h);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.u.hc("StrokeContent#getBounds");
    }

    private void d(Matrix matrix) {
        com.bytedance.adsdk.lottie.u.d("StrokeContent#applyDashPattern");
        if (this.uo.isEmpty()) {
            com.bytedance.adsdk.lottie.u.hc("StrokeContent#applyDashPattern");
            return;
        }
        float fD = com.bytedance.adsdk.lottie.u.tt.d(matrix);
        for (int i = 0; i < this.uo.size(); i++) {
            this.tc[i] = this.uo.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.tc;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.tc;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.tc;
            fArr3[i] = fArr3[i] * fD;
        }
        com.bytedance.adsdk.lottie.d.hc.d<?, Float> dVar = this.k;
        this.hc.setPathEffect(new DashPathEffect(this.tc, dVar == null ? 0.0f : fD * dVar.h().floatValue()));
        com.bytedance.adsdk.lottie.u.hc("StrokeContent#applyDashPattern");
    }

    /* renamed from: com.bytedance.adsdk.lottie.d.d.d$d, reason: collision with other inner class name */
    private static final class C0166d {
        private final List<uo> d;
        private final sy hc;

        private C0166d(sy syVar) {
            this.d = new ArrayList();
            this.hc = syVar;
        }
    }
}
