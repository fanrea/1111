package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.hc.cb;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends b {
    private final c gb;
    private final com.bytedance.adsdk.lottie.d.d.c h;

    tc(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, c cVar, com.bytedance.adsdk.lottie.an anVar) {
        super(gbVar, gbVar2);
        this.gb = cVar;
        com.bytedance.adsdk.lottie.d.d.c cVar2 = new com.bytedance.adsdk.lottie.d.d.c(gbVar, this, new cb("__container", gbVar2.k(), false), anVar);
        this.h = cVar2;
        cVar2.d(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        super.hc(canvas, matrix, i);
        this.h.d(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b, com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.h.d(rectF, this.d, z);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public com.bytedance.adsdk.lottie.model.hc.d mq() {
        com.bytedance.adsdk.lottie.model.hc.d dVarMq = super.mq();
        return dVarMq != null ? dVarMq : this.gb.mq();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public com.bytedance.adsdk.lottie.c.tc uo() {
        com.bytedance.adsdk.lottie.c.tc tcVarUo = super.uo();
        return tcVarUo != null ? tcVarUo : this.gb.uo();
    }
}
