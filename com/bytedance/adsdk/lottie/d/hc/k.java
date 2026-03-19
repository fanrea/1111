package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k extends d<PointF, PointF> {
    private final PointF an;
    protected com.bytedance.adsdk.lottie.an.b<Float> c;
    private final d<Float, Float> gb;
    private final PointF h;
    private final d<Float, Float> tt;
    protected com.bytedance.adsdk.lottie.an.b<Float> u;

    public k(d<Float, Float> dVar, d<Float, Float> dVar2) {
        super(Collections.emptyList());
        this.an = new PointF();
        this.h = new PointF();
        this.gb = dVar;
        this.tt = dVar2;
        d(gb());
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d
    public void d(float f) {
        this.gb.d(f);
        this.tt.d(f);
        this.an.set(this.gb.h().floatValue(), this.tt.h().floatValue());
        for (int i = 0; i < this.d.size(); i++) {
            this.d.get(i).d();
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: tt, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return d(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public PointF d(com.bytedance.adsdk.lottie.an.d<PointF> dVar, float f) {
        Float fD;
        com.bytedance.adsdk.lottie.an.d<Float> dVarB;
        com.bytedance.adsdk.lottie.an.d<Float> dVarB2;
        Float fD2 = null;
        if (this.c == null || (dVarB2 = this.gb.b()) == null) {
            fD = null;
        } else {
            float fU = this.gb.u();
            Float f2 = dVarB2.h;
            fD = this.c.d(dVarB2.an, f2 == null ? dVarB2.an : f2.floatValue(), dVarB2.d, dVarB2.hc, f, f, fU);
        }
        if (this.u != null && (dVarB = this.tt.b()) != null) {
            float fU2 = this.tt.u();
            Float f3 = dVarB.h;
            fD2 = this.u.d(dVarB.an, f3 == null ? dVarB.an : f3.floatValue(), dVarB.d, dVarB.hc, f, f, fU2);
        }
        if (fD == null) {
            this.h.set(this.an.x, 0.0f);
        } else {
            this.h.set(fD.floatValue(), 0.0f);
        }
        if (fD2 == null) {
            PointF pointF = this.h;
            pointF.set(pointF.x, this.an.y);
        } else {
            PointF pointF2 = this.h;
            pointF2.set(pointF2.x, fD2.floatValue());
        }
        return this.h;
    }
}
