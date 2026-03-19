package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class jh extends d {
    private final boolean an;
    private final com.bytedance.adsdk.lottie.model.layer.b c;
    private com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> gb;
    private final com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> h;
    private final String u;

    public jh(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.yo yoVar) {
        super(gbVar, bVar, yoVar.h().d(), yoVar.gb().d(), yoVar.tt(), yoVar.b(), yoVar.c(), yoVar.u(), yoVar.an());
        this.c = bVar;
        this.u = yoVar.d();
        this.an = yoVar.tc();
        com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVarD = yoVar.hc().d();
        this.h = dVarD;
        dVarD.d(this);
        bVar.d(dVarD);
    }

    @Override // com.bytedance.adsdk.lottie.d.d.d, com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        if (this.an) {
            return;
        }
        this.hc.setColor(((com.bytedance.adsdk.lottie.d.hc.hc) this.h).tt());
        if (this.gb != null) {
            this.hc.setColorFilter(this.gb.h());
        }
        super.d(canvas, matrix, i);
    }
}
