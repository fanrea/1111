package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.d.hc.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements mk, u, d.InterfaceC0167d {
    private final boolean an;
    private final Paint b;
    private final com.bytedance.adsdk.lottie.model.layer.b c;
    float d;
    private final com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> gb;
    private final List<uo> h;
    private final Path hc;
    private final com.bytedance.adsdk.lottie.gb mk;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> mq;
    private com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> tc;
    private final com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> tt;
    private final String u;
    private com.bytedance.adsdk.lottie.d.hc.b uo;

    public h(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.e eVar) {
        Path path = new Path();
        this.hc = path;
        this.b = new com.bytedance.adsdk.lottie.d.d(1);
        this.h = new ArrayList();
        this.c = bVar;
        this.u = eVar.d();
        this.an = eVar.u();
        this.mk = gbVar;
        if (bVar.mq() != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = bVar.mq().d().d();
            this.mq = dVarD;
            dVarD.d(this);
            bVar.d(this.mq);
        }
        if (bVar.uo() != null) {
            this.uo = new com.bytedance.adsdk.lottie.d.hc.b(this, bVar, bVar.uo());
        }
        if (eVar.hc() == null || eVar.b() == null) {
            this.gb = null;
            this.tt = null;
            return;
        }
        path.setFillType(eVar.c());
        com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVarD2 = eVar.hc().d();
        this.gb = dVarD2;
        dVarD2.d(this);
        bVar.d(dVarD2);
        com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVarD3 = eVar.b().d();
        this.tt = dVarD3;
        dVarD3.d(this);
        bVar.d(dVarD3);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.mk.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof uo) {
                this.h.add((uo) bVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.an) {
            return;
        }
        com.bytedance.adsdk.lottie.u.d("FillContent#draw");
        this.b.setColor((com.bytedance.adsdk.lottie.u.gb.d((int) ((((i / 255.0f) * this.tt.h().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.d.hc.hc) this.gb).tt() & 16777215));
        com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> dVar = this.tc;
        if (dVar != null) {
            this.b.setColorFilter(dVar.h());
        }
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVar2 = this.mq;
        if (dVar2 != null) {
            float fFloatValue = dVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.b.setMaskFilter(null);
            } else if (fFloatValue != this.d) {
                this.b.setMaskFilter(this.c.hc(fFloatValue));
            }
            this.d = fFloatValue;
        }
        com.bytedance.adsdk.lottie.d.hc.b bVar = this.uo;
        if (bVar != null) {
            bVar.d(this.b);
        }
        this.hc.reset();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.hc.addPath(this.h.get(i2).c(), matrix);
        }
        canvas.drawPath(this.hc, this.b);
        com.bytedance.adsdk.lottie.u.hc("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.hc.reset();
        for (int i = 0; i < this.h.size(); i++) {
            this.hc.addPath(this.h.get(i).c(), matrix);
        }
        this.hc.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
