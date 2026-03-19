package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.d.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e implements mk, uo, d.InterfaceC0167d {
    private final com.bytedance.adsdk.lottie.d.hc.d<?, PointF> an;
    private final String b;
    private final boolean c;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> gb;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, PointF> h;
    private boolean mk;
    private final com.bytedance.adsdk.lottie.gb u;
    private final Path d = new Path();
    private final RectF hc = new RectF();
    private final hc tt = new hc();
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> tc = null;

    public e(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.mk mkVar) {
        this.b = mkVar.d();
        this.c = mkVar.u();
        this.u = gbVar;
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD = mkVar.c().d();
        this.an = dVarD;
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD2 = mkVar.b().d();
        this.h = dVarD2;
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD3 = mkVar.hc().d();
        this.gb = dVarD3;
        bVar.d(dVarD);
        bVar.d(dVarD2);
        bVar.d(dVarD3);
        dVarD.d(this);
        dVarD2.d(this);
        dVarD3.d(this);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        hc();
    }

    private void hc() {
        this.mk = false;
        this.u.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // com.bytedance.adsdk.lottie.d.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.util.List<com.bytedance.adsdk.lottie.d.d.b> r5, java.util.List<com.bytedance.adsdk.lottie.d.d.b> r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L34
            java.lang.Object r0 = r5.get(r6)
            com.bytedance.adsdk.lottie.d.d.b r0 = (com.bytedance.adsdk.lottie.d.d.b) r0
            boolean r1 = r0 instanceof com.bytedance.adsdk.lottie.d.d.sy
            if (r1 == 0) goto L25
            r1 = r0
            com.bytedance.adsdk.lottie.d.d.sy r1 = (com.bytedance.adsdk.lottie.d.d.sy) r1
            com.bytedance.adsdk.lottie.model.hc.rf$d r2 = r1.getType()
            com.bytedance.adsdk.lottie.model.hc.rf$d r3 = com.bytedance.adsdk.lottie.model.hc.rf.d.SIMULTANEOUSLY
            if (r2 != r3) goto L25
            com.bytedance.adsdk.lottie.d.d.hc r0 = r4.tt
            r0.d(r1)
            r1.d(r4)
            goto L31
        L25:
            boolean r1 = r0 instanceof com.bytedance.adsdk.lottie.d.d.w
            if (r1 == 0) goto L31
            com.bytedance.adsdk.lottie.d.d.w r0 = (com.bytedance.adsdk.lottie.d.d.w) r0
            com.bytedance.adsdk.lottie.d.hc.d r0 = r0.hc()
            r4.tc = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.d.d.e.d(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVar;
        if (this.mk) {
            return this.d;
        }
        this.d.reset();
        if (this.c) {
            this.mk = true;
            return this.d;
        }
        PointF pointFH = this.h.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        com.bytedance.adsdk.lottie.d.hc.d<?, Float> dVar2 = this.gb;
        float fTt = dVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.d.hc.c) dVar2).tt();
        if (fTt == 0.0f && (dVar = this.tc) != null) {
            fTt = Math.min(dVar.h().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fTt > fMin) {
            fTt = fMin;
        }
        PointF pointFH2 = this.an.h();
        this.d.moveTo(pointFH2.x + f, (pointFH2.y - f2) + fTt);
        this.d.lineTo(pointFH2.x + f, (pointFH2.y + f2) - fTt);
        if (fTt > 0.0f) {
            float f3 = fTt * 2.0f;
            this.hc.set((pointFH2.x + f) - f3, (pointFH2.y + f2) - f3, pointFH2.x + f, pointFH2.y + f2);
            this.d.arcTo(this.hc, 0.0f, 90.0f, false);
        }
        this.d.lineTo((pointFH2.x - f) + fTt, pointFH2.y + f2);
        if (fTt > 0.0f) {
            float f4 = fTt * 2.0f;
            this.hc.set(pointFH2.x - f, (pointFH2.y + f2) - f4, (pointFH2.x - f) + f4, pointFH2.y + f2);
            this.d.arcTo(this.hc, 90.0f, 90.0f, false);
        }
        this.d.lineTo(pointFH2.x - f, (pointFH2.y - f2) + fTt);
        if (fTt > 0.0f) {
            float f5 = fTt * 2.0f;
            this.hc.set(pointFH2.x - f, pointFH2.y - f2, (pointFH2.x - f) + f5, (pointFH2.y - f2) + f5);
            this.d.arcTo(this.hc, 180.0f, 90.0f, false);
        }
        this.d.lineTo((pointFH2.x + f) - fTt, pointFH2.y - f2);
        if (fTt > 0.0f) {
            float f6 = fTt * 2.0f;
            this.hc.set((pointFH2.x + f) - f6, pointFH2.y - f2, pointFH2.x + f, (pointFH2.y - f2) + f6);
            this.d.arcTo(this.hc, 270.0f, 90.0f, false);
        }
        this.d.close();
        this.tt.d(this.d);
        this.mk = true;
        return this.d;
    }
}
