package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.tachikoma.lottie.model.content.ShapeStroke;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class r extends a {
    private final com.tachikoma.lottie.model.layer.a IC;
    private com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> IK;
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<Integer, Integer> IX;
    private final String name;

    public r(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.kX().toPaintCap(), shapeStroke.kY().toPaintJoin(), shapeStroke.lb(), shapeStroke.kJ(), shapeStroke.kW(), shapeStroke.kZ(), shapeStroke.la());
        this.IC = aVar;
        this.name = shapeStroke.getName();
        this.IO = shapeStroke.isHidden();
        this.IX = shapeStroke.ls().kB();
        this.IX.b(this);
        aVar.a(this.IX);
    }

    @Override // com.tachikoma.lottie.a.a.a, com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        if (this.IO) {
            return;
        }
        this.IF.setColor(((com.tachikoma.lottie.a.b.b) this.IX).getIntValue());
        if (this.IK != null) {
            this.IF.setColorFilter(this.IK.getValue());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    @Override // com.tachikoma.lottie.a.a.a, com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        super.a(t, cVar);
        if (t == com.tachikoma.lottie.k.HK) {
            this.IX.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.Ik) {
            if (cVar == null) {
                this.IK = null;
                return;
            }
            this.IK = new com.tachikoma.lottie.a.b.p(cVar);
            this.IK.b(this);
            this.IC.a(this.IX);
        }
    }
}
