package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g implements e, k, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final com.tachikoma.lottie.model.layer.a IC;
    private final com.tachikoma.lottie.a.b.a<Integer, Integer> IH;
    private com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> IK;
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<Integer, Integer> IX;
    private final String name;
    private final Path Iz = new Path();
    private final Paint IF = new com.tachikoma.lottie.a.a(1);
    private final List<m> IL = new ArrayList();

    public g(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.i iVar) {
        this.IC = aVar;
        this.name = iVar.getName();
        this.IO = iVar.isHidden();
        this.Gt = gVar;
        if (iVar.ls() == null || iVar.kJ() == null) {
            this.IX = null;
            this.IH = null;
            return;
        }
        this.Iz.setFillType(iVar.getFillType());
        this.IX = iVar.ls().kB();
        this.IX.b(this);
        aVar.a(this.IX);
        this.IH = iVar.kJ().kB();
        this.IH.b(this);
        aVar.a(this.IH);
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.IL.add((m) cVar);
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        if (this.IO) {
            return;
        }
        com.tachikoma.lottie.c.beginSection("FillContent#draw");
        this.IF.setColor(((com.tachikoma.lottie.a.b.b) this.IX).getIntValue());
        this.IF.setAlpha(com.tachikoma.lottie.d.e.c((int) ((((i / 255.0f) * this.IH.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.IK;
        if (aVar != null) {
            this.IF.setColorFilter(aVar.getValue());
        }
        this.Iz.reset();
        for (int i2 = 0; i2 < this.IL.size(); i2++) {
            this.Iz.addPath(this.IL.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.Iz, this.IF);
        com.tachikoma.lottie.c.S("FillContent#draw");
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.Iz.reset();
        for (int i = 0; i < this.IL.size(); i++) {
            this.Iz.addPath(this.IL.get(i).getPath(), matrix);
        }
        this.Iz.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        com.tachikoma.lottie.d.e.a(dVar, i, list, dVar2, this);
    }

    @Override // com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        if (t == com.tachikoma.lottie.k.HJ) {
            this.IX.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.HM) {
            this.IH.a(cVar);
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
}
