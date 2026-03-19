package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.d.hc.d;
import com.bytedance.adsdk.lottie.model.hc.rf;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements mk, uo, d.InterfaceC0167d {
    private final com.bytedance.adsdk.lottie.model.hc.hc an;
    private final com.bytedance.adsdk.lottie.gb b;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, PointF> c;
    private boolean gb;
    private final String hc;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, PointF> u;
    private final Path d = new Path();
    private final hc h = new hc();

    public an(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.hc hcVar) {
        this.hc = hcVar.d();
        this.b = gbVar;
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD = hcVar.b().d();
        this.c = dVarD;
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD2 = hcVar.hc().d();
        this.u = dVarD2;
        this.an = hcVar;
        bVar.d(dVarD);
        bVar.d(dVarD2);
        dVarD.d(this);
        dVarD2.d(this);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        hc();
    }

    private void hc() {
        this.gb = false;
        this.b.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof sy) {
                sy syVar = (sy) bVar;
                if (syVar.getType() == rf.d.SIMULTANEOUSLY) {
                    this.h.d(syVar);
                    syVar.d(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        if (this.gb) {
            return this.d;
        }
        this.d.reset();
        if (this.an.u()) {
            this.gb = true;
            return this.d;
        }
        PointF pointFH = this.c.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.d.reset();
        if (this.an.c()) {
            float f5 = -f2;
            this.d.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.d.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.d.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.d.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.d.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.d.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.d.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.d.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.d.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.d.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFH2 = this.u.h();
        this.d.offset(pointFH2.x, pointFH2.y);
        this.d.close();
        this.h.d(this.d);
        this.gb = true;
        return this.d;
    }
}
