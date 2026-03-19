package com.tachikoma.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class o implements k, m, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<?, PointF> IS;
    private final com.tachikoma.lottie.a.b.a<?, PointF> IT;
    private boolean IW;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jt;
    private final String name;
    private final Path Iz = new Path();
    private final RectF IB = new RectF();
    private b IV = new b();

    public o(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.f fVar) {
        this.name = fVar.getName();
        this.IO = fVar.isHidden();
        this.Gt = gVar;
        this.IT = fVar.kG().kB();
        this.IS = fVar.kP().kB();
        this.Jt = fVar.lm().kB();
        aVar.a(this.IT);
        aVar.a(this.IS);
        aVar.a(this.Jt);
        this.IT.b(this);
        this.IS.b(this);
        this.Jt.b(this);
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        invalidate();
    }

    private void invalidate() {
        this.IW = false;
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.jX() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.IV.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        if (this.IW) {
            return this.Iz;
        }
        this.Iz.reset();
        if (this.IO) {
            this.IW = true;
            return this.Iz;
        }
        PointF value = this.IS.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        com.tachikoma.lottie.a.b.a<?, Float> aVar = this.Jt;
        float fKh = aVar == null ? 0.0f : ((com.tachikoma.lottie.a.b.c) aVar).kh();
        float fMin = Math.min(f, f2);
        if (fKh > fMin) {
            fKh = fMin;
        }
        PointF value2 = this.IT.getValue();
        this.Iz.moveTo(value2.x + f, (value2.y - f2) + fKh);
        this.Iz.lineTo(value2.x + f, (value2.y + f2) - fKh);
        if (fKh > 0.0f) {
            float f3 = fKh * 2.0f;
            this.IB.set((value2.x + f) - f3, (value2.y + f2) - f3, value2.x + f, value2.y + f2);
            this.Iz.arcTo(this.IB, 0.0f, 90.0f, false);
        }
        this.Iz.lineTo((value2.x - f) + fKh, value2.y + f2);
        if (fKh > 0.0f) {
            float f4 = fKh * 2.0f;
            this.IB.set(value2.x - f, (value2.y + f2) - f4, (value2.x - f) + f4, value2.y + f2);
            this.Iz.arcTo(this.IB, 90.0f, 90.0f, false);
        }
        this.Iz.lineTo(value2.x - f, (value2.y - f2) + fKh);
        if (fKh > 0.0f) {
            float f5 = fKh * 2.0f;
            this.IB.set(value2.x - f, value2.y - f2, (value2.x - f) + f5, (value2.y - f2) + f5);
            this.Iz.arcTo(this.IB, 180.0f, 90.0f, false);
        }
        this.Iz.lineTo((value2.x + f) - fKh, value2.y - f2);
        if (fKh > 0.0f) {
            float f6 = fKh * 2.0f;
            this.IB.set((value2.x + f) - f6, value2.y - f2, value2.x + f, (value2.y - f2) + f6);
            this.Iz.arcTo(this.IB, 270.0f, 90.0f, false);
        }
        this.Iz.close();
        this.IV.a(this.Iz);
        this.IW = true;
        return this.Iz;
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        com.tachikoma.lottie.d.e.a(dVar, i, list, dVar2, this);
    }

    @Override // com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        if (t == com.tachikoma.lottie.k.HQ) {
            this.IS.a(cVar);
        } else if (t == com.tachikoma.lottie.k.HS) {
            this.IT.a(cVar);
        } else if (t == com.tachikoma.lottie.k.HR) {
            this.Jt.a(cVar);
        }
    }
}
