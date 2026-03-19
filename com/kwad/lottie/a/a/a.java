package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.kwad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a implements d, j, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final com.kwad.lottie.model.layer.a bln;
    private final float[] blp;
    final Paint blq;
    private final com.kwad.lottie.a.b.a<?, Float> blr;
    private final com.kwad.lottie.a.b.a<?, Integer> bls;
    private final List<com.kwad.lottie.a.b.a<?, Float>> blt;
    private final com.kwad.lottie.a.b.a<?, Float> blu;
    private com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> blv;
    private final PathMeasure blj = new PathMeasure();
    private final Path blk = new Path();
    private final Path bll = new Path();
    private final RectF blm = new RectF();
    private final List<C0567a> blo = new ArrayList();

    a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.kwad.lottie.model.a.d dVar, com.kwad.lottie.model.a.b bVar, List<com.kwad.lottie.model.a.b> list, com.kwad.lottie.model.a.b bVar2) {
        Paint paint = new Paint(1);
        this.blq = paint;
        this.bjz = fVar;
        this.bln = aVar;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        this.bls = dVar.Rj();
        this.blr = bVar.Rj();
        if (bVar2 == null) {
            this.blu = null;
        } else {
            this.blu = bVar2.Rj();
        }
        this.blt = new ArrayList(list.size());
        this.blp = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.blt.add(list.get(i).Rj());
        }
        aVar.a(this.bls);
        aVar.a(this.blr);
        for (int i2 = 0; i2 < this.blt.size(); i2++) {
            aVar.a(this.blt.get(i2));
        }
        com.kwad.lottie.a.b.a<?, Float> aVar2 = this.blu;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.bls.b(this);
        this.blr.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.blt.get(i3).b(this);
        }
        com.kwad.lottie.a.b.a<?, Float> aVar3 = this.blu;
        if (aVar3 != null) {
            aVar3.b(this);
        }
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        this.bjz.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    @Override // com.kwad.lottie.a.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.util.List<com.kwad.lottie.a.a.b> r8, java.util.List<com.kwad.lottie.a.a.b> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.kwad.lottie.a.a.b r3 = (com.kwad.lottie.a.a.b) r3
            boolean r4 = r3 instanceof com.kwad.lottie.a.a.r
            if (r4 == 0) goto L1f
            com.kwad.lottie.a.a.r r3 = (com.kwad.lottie.a.a.r) r3
            com.kwad.lottie.model.content.ShapeTrimPath$Type r4 = r3.QI()
            com.kwad.lottie.model.content.ShapeTrimPath$Type r5 = com.kwad.lottie.model.content.ShapeTrimPath.Type.Individually
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.a(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
        L2d:
            if (r8 < 0) goto L6d
            java.lang.Object r0 = r9.get(r8)
            com.kwad.lottie.a.a.b r0 = (com.kwad.lottie.a.a.b) r0
            boolean r3 = r0 instanceof com.kwad.lottie.a.a.r
            r4 = 0
            if (r3 == 0) goto L56
            r3 = r0
            com.kwad.lottie.a.a.r r3 = (com.kwad.lottie.a.a.r) r3
            com.kwad.lottie.model.content.ShapeTrimPath$Type r5 = r3.QI()
            com.kwad.lottie.model.content.ShapeTrimPath$Type r6 = com.kwad.lottie.model.content.ShapeTrimPath.Type.Individually
            if (r5 != r6) goto L56
            if (r1 == 0) goto L4c
            java.util.List<com.kwad.lottie.a.a.a$a> r0 = r7.blo
            r0.add(r1)
        L4c:
            com.kwad.lottie.a.a.a$a r0 = new com.kwad.lottie.a.a.a$a
            r0.<init>(r3, r4)
            r3.a(r7)
            r1 = r0
            goto L6a
        L56:
            boolean r3 = r0 instanceof com.kwad.lottie.a.a.l
            if (r3 == 0) goto L6a
            if (r1 != 0) goto L61
            com.kwad.lottie.a.a.a$a r1 = new com.kwad.lottie.a.a.a$a
            r1.<init>(r2, r4)
        L61:
            java.util.List r3 = com.kwad.lottie.a.a.a.C0567a.a(r1)
            com.kwad.lottie.a.a.l r0 = (com.kwad.lottie.a.a.l) r0
            r3.add(r0)
        L6a:
            int r8 = r8 + (-1)
            goto L2d
        L6d:
            if (r1 == 0) goto L74
            java.util.List<com.kwad.lottie.a.a.a$a> r8 = r7.blo
            r8.add(r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.lottie.a.a.a.b(java.util.List, java.util.List):void");
    }

    @Override // com.kwad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.kwad.lottie.c.beginSection("StrokeContent#draw");
        this.blq.setAlpha(com.kwad.lottie.d.e.clamp((int) ((((i / 255.0f) * this.bls.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        this.blq.setStrokeWidth(this.blr.getValue().floatValue() * com.kwad.lottie.d.f.b(matrix));
        if (this.blq.getStrokeWidth() <= 0.0f) {
            com.kwad.lottie.c.dg("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.blv;
        if (aVar != null) {
            this.blq.setColorFilter(aVar.getValue());
        }
        for (int i2 = 0; i2 < this.blo.size(); i2++) {
            C0567a c0567a = this.blo.get(i2);
            if (c0567a.blx != null) {
                a(canvas, c0567a, matrix);
            } else {
                com.kwad.lottie.c.beginSection("StrokeContent#buildPath");
                this.blk.reset();
                for (int size = c0567a.blw.size() - 1; size >= 0; size--) {
                    this.blk.addPath(((l) c0567a.blw.get(size)).getPath(), matrix);
                }
                com.kwad.lottie.c.dg("StrokeContent#buildPath");
                com.kwad.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.blk, this.blq);
                com.kwad.lottie.c.dg("StrokeContent#drawPath");
            }
        }
        com.kwad.lottie.c.dg("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.graphics.Canvas r13, com.kwad.lottie.a.a.a.C0567a r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.lottie.a.a.a.a(android.graphics.Canvas, com.kwad.lottie.a.a.a$a, android.graphics.Matrix):void");
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        com.kwad.lottie.c.beginSection("StrokeContent#getBounds");
        this.blk.reset();
        for (int i = 0; i < this.blo.size(); i++) {
            C0567a c0567a = this.blo.get(i);
            for (int i2 = 0; i2 < c0567a.blw.size(); i2++) {
                this.blk.addPath(((l) c0567a.blw.get(i2)).getPath(), matrix);
            }
        }
        this.blk.computeBounds(this.blm, false);
        float fFloatValue = this.blr.getValue().floatValue();
        RectF rectF2 = this.blm;
        float f = fFloatValue / 2.0f;
        rectF2.set(rectF2.left - f, this.blm.top - f, this.blm.right + f, this.blm.bottom + f);
        rectF.set(this.blm);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.kwad.lottie.c.dg("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.kwad.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.blt.isEmpty()) {
            com.kwad.lottie.c.dg("StrokeContent#applyDashPattern");
            return;
        }
        float fB = com.kwad.lottie.d.f.b(matrix);
        for (int i = 0; i < this.blt.size(); i++) {
            this.blp[i] = this.blt.get(i).getValue().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.blp;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.blp;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.blp;
            fArr3[i] = fArr3[i] * fB;
        }
        com.kwad.lottie.a.b.a<?, Float> aVar = this.blu;
        this.blq.setPathEffect(new DashPathEffect(this.blp, aVar == null ? 0.0f : aVar.getValue().floatValue()));
        com.kwad.lottie.c.dg("StrokeContent#applyDashPattern");
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.kwad.lottie.model.f
    public <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        if (t == com.kwad.lottie.i.bkA) {
            this.bls.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkH) {
            this.blr.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkU) {
            if (cVar == null) {
                this.blv = null;
                return;
            }
            com.kwad.lottie.a.b.p pVar = new com.kwad.lottie.a.b.p(cVar);
            this.blv = pVar;
            pVar.b(this);
            this.bln.a(this.blv);
        }
    }

    /* renamed from: com.kwad.lottie.a.a.a$a, reason: collision with other inner class name */
    static final class C0567a {
        private final List<l> blw;
        private final r blx;

        /* synthetic */ C0567a(r rVar, byte b) {
            this(rVar);
        }

        private C0567a(r rVar) {
            this.blw = new ArrayList();
            this.blx = rVar;
        }
    }
}
