package com.tachikoma.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f implements k, m, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final com.tachikoma.lottie.a.b.a<?, PointF> IS;
    private final com.tachikoma.lottie.a.b.a<?, PointF> IT;
    private final com.tachikoma.lottie.model.content.a IU;
    private boolean IW;
    private final String name;
    private final Path Iz = new Path();
    private b IV = new b();

    public f(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.Gt = gVar;
        this.IS = aVar2.kP().kB();
        this.IT = aVar2.kG().kB();
        this.IU = aVar2;
        aVar.a(this.IS);
        aVar.a(this.IT);
        this.IS.b(this);
        this.IT.b(this);
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

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        if (this.IW) {
            return this.Iz;
        }
        this.Iz.reset();
        if (this.IU.isHidden()) {
            this.IW = true;
            return this.Iz;
        }
        PointF value = this.IS.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.Iz.reset();
        if (this.IU.kQ()) {
            float f5 = -f2;
            this.Iz.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.Iz.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.Iz.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.Iz.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.Iz.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.Iz.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.Iz.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.Iz.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.Iz.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.Iz.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF value2 = this.IT.getValue();
        this.Iz.offset(value2.x, value2.y);
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
        if (t == com.tachikoma.lottie.k.HP) {
            this.IS.a(cVar);
        } else if (t == com.tachikoma.lottie.k.HS) {
            this.IT.a(cVar);
        }
    }
}
