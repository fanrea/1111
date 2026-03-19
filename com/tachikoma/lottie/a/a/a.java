package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class a implements e, k, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    protected final com.tachikoma.lottie.model.layer.a IC;
    private final float[] IE;
    private final com.tachikoma.lottie.a.b.a<?, Float> IG;
    private final com.tachikoma.lottie.a.b.a<?, Integer> IH;
    private final List<com.tachikoma.lottie.a.b.a<?, Float>> II;
    private final com.tachikoma.lottie.a.b.a<?, Float> IJ;
    private com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> IK;
    private final PathMeasure Iy = new PathMeasure();
    private final Path Iz = new Path();
    private final Path IA = new Path();
    private final RectF IB = new RectF();
    private final List<C0798a> ID = new ArrayList();
    final Paint IF = new com.tachikoma.lottie.a.a(1);

    a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tachikoma.lottie.model.a.d dVar, com.tachikoma.lottie.model.a.b bVar, List<com.tachikoma.lottie.model.a.b> list, com.tachikoma.lottie.model.a.b bVar2) {
        this.Gt = gVar;
        this.IC = aVar;
        this.IF.setStyle(Paint.Style.STROKE);
        this.IF.setStrokeCap(cap);
        this.IF.setStrokeJoin(join);
        this.IF.setStrokeMiter(f);
        this.IH = dVar.kB();
        this.IG = bVar.kB();
        if (bVar2 == null) {
            this.IJ = null;
        } else {
            this.IJ = bVar2.kB();
        }
        this.II = new ArrayList(list.size());
        this.IE = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.II.add(list.get(i).kB());
        }
        aVar.a(this.IH);
        aVar.a(this.IG);
        for (int i2 = 0; i2 < this.II.size(); i2++) {
            aVar.a(this.II.get(i2));
        }
        com.tachikoma.lottie.a.b.a<?, Float> aVar2 = this.IJ;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.IH.b(this);
        this.IG.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.II.get(i3).b(this);
        }
        com.tachikoma.lottie.a.b.a<?, Float> aVar3 = this.IJ;
        if (aVar3 != null) {
            aVar3.b(this);
        }
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        this.Gt.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    @Override // com.tachikoma.lottie.a.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.util.List<com.tachikoma.lottie.a.a.c> r8, java.util.List<com.tachikoma.lottie.a.a.c> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.tachikoma.lottie.a.a.c r3 = (com.tachikoma.lottie.a.a.c) r3
            boolean r4 = r3 instanceof com.tachikoma.lottie.a.a.s
            if (r4 == 0) goto L1f
            com.tachikoma.lottie.a.a.s r3 = (com.tachikoma.lottie.a.a.s) r3
            com.tachikoma.lottie.model.content.ShapeTrimPath$Type r4 = r3.jX()
            com.tachikoma.lottie.model.content.ShapeTrimPath$Type r5 = com.tachikoma.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY
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
            com.tachikoma.lottie.a.a.c r0 = (com.tachikoma.lottie.a.a.c) r0
            boolean r3 = r0 instanceof com.tachikoma.lottie.a.a.s
            r4 = 0
            if (r3 == 0) goto L56
            r3 = r0
            com.tachikoma.lottie.a.a.s r3 = (com.tachikoma.lottie.a.a.s) r3
            com.tachikoma.lottie.model.content.ShapeTrimPath$Type r5 = r3.jX()
            com.tachikoma.lottie.model.content.ShapeTrimPath$Type r6 = com.tachikoma.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY
            if (r5 != r6) goto L56
            if (r1 == 0) goto L4c
            java.util.List<com.tachikoma.lottie.a.a.a$a> r0 = r7.ID
            r0.add(r1)
        L4c:
            com.tachikoma.lottie.a.a.a$a r0 = new com.tachikoma.lottie.a.a.a$a
            r0.<init>(r3, r4)
            r3.a(r7)
            r1 = r0
            goto L6a
        L56:
            boolean r3 = r0 instanceof com.tachikoma.lottie.a.a.m
            if (r3 == 0) goto L6a
            if (r1 != 0) goto L61
            com.tachikoma.lottie.a.a.a$a r1 = new com.tachikoma.lottie.a.a.a$a
            r1.<init>(r2, r4)
        L61:
            java.util.List r3 = com.tachikoma.lottie.a.a.a.C0798a.a(r1)
            com.tachikoma.lottie.a.a.m r0 = (com.tachikoma.lottie.a.a.m) r0
            r3.add(r0)
        L6a:
            int r8 = r8 + (-1)
            goto L2d
        L6d:
            if (r1 == 0) goto L74
            java.util.List<com.tachikoma.lottie.a.a.a$a> r8 = r7.ID
            r8.add(r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.lottie.a.a.a.b(java.util.List, java.util.List):void");
    }

    @Override // com.tachikoma.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tachikoma.lottie.c.beginSection("StrokeContent#draw");
        if (com.tachikoma.lottie.d.f.c(matrix)) {
            com.tachikoma.lottie.c.S("StrokeContent#draw");
            return;
        }
        this.IF.setAlpha(com.tachikoma.lottie.d.e.c((int) ((((i / 255.0f) * ((com.tachikoma.lottie.a.b.e) this.IH).getIntValue()) / 100.0f) * 255.0f), 0, 255));
        this.IF.setStrokeWidth(((com.tachikoma.lottie.a.b.c) this.IG).kh() * com.tachikoma.lottie.d.f.b(matrix));
        if (this.IF.getStrokeWidth() <= 0.0f) {
            com.tachikoma.lottie.c.S("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.IK;
        if (aVar != null) {
            this.IF.setColorFilter(aVar.getValue());
        }
        for (int i2 = 0; i2 < this.ID.size(); i2++) {
            C0798a c0798a = this.ID.get(i2);
            if (c0798a.IM != null) {
                a(canvas, c0798a, matrix);
            } else {
                com.tachikoma.lottie.c.beginSection("StrokeContent#buildPath");
                this.Iz.reset();
                for (int size = c0798a.IL.size() - 1; size >= 0; size--) {
                    this.Iz.addPath(((m) c0798a.IL.get(size)).getPath(), matrix);
                }
                com.tachikoma.lottie.c.S("StrokeContent#buildPath");
                com.tachikoma.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.Iz, this.IF);
                com.tachikoma.lottie.c.S("StrokeContent#drawPath");
            }
        }
        com.tachikoma.lottie.c.S("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.graphics.Canvas r13, com.tachikoma.lottie.a.a.a.C0798a r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.lottie.a.a.a.a(android.graphics.Canvas, com.tachikoma.lottie.a.a.a$a, android.graphics.Matrix):void");
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        com.tachikoma.lottie.c.beginSection("StrokeContent#getBounds");
        this.Iz.reset();
        for (int i = 0; i < this.ID.size(); i++) {
            C0798a c0798a = this.ID.get(i);
            for (int i2 = 0; i2 < c0798a.IL.size(); i2++) {
                this.Iz.addPath(((m) c0798a.IL.get(i2)).getPath(), matrix);
            }
        }
        this.Iz.computeBounds(this.IB, false);
        float fKh = ((com.tachikoma.lottie.a.b.c) this.IG).kh();
        RectF rectF2 = this.IB;
        float f = fKh / 2.0f;
        rectF2.set(rectF2.left - f, this.IB.top - f, this.IB.right + f, this.IB.bottom + f);
        rectF.set(this.IB);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tachikoma.lottie.c.S("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tachikoma.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.II.isEmpty()) {
            com.tachikoma.lottie.c.S("StrokeContent#applyDashPattern");
            return;
        }
        float fB = com.tachikoma.lottie.d.f.b(matrix);
        for (int i = 0; i < this.II.size(); i++) {
            this.IE[i] = this.II.get(i).getValue().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.IE;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.IE;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.IE;
            fArr3[i] = fArr3[i] * fB;
        }
        com.tachikoma.lottie.a.b.a<?, Float> aVar = this.IJ;
        this.IF.setPathEffect(new DashPathEffect(this.IE, aVar == null ? 0.0f : aVar.getValue().floatValue()));
        com.tachikoma.lottie.c.S("StrokeContent#applyDashPattern");
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        com.tachikoma.lottie.d.e.a(dVar, i, list, dVar2, this);
    }

    @Override // com.tachikoma.lottie.model.e
    public <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        if (t == com.tachikoma.lottie.k.HM) {
            this.IH.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.HX) {
            this.IG.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.Ik) {
            if (cVar == null) {
                this.IK = null;
                return;
            }
            this.IK = new com.tachikoma.lottie.a.b.p(cVar);
            this.IK.b(this);
            this.IC.a(this.IK);
        }
    }

    /* renamed from: com.tachikoma.lottie.a.a.a$a, reason: collision with other inner class name */
    static final class C0798a {
        private final List<m> IL;
        private final s IM;

        /* synthetic */ C0798a(s sVar, byte b) {
            this(sVar);
        }

        private C0798a(s sVar) {
            this.IL = new ArrayList();
            this.IM = sVar;
        }
    }
}
