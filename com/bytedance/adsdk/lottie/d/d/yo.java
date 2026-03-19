package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.d.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo implements uo, d.InterfaceC0167d {
    private boolean an;
    private final boolean b;
    private final com.bytedance.adsdk.lottie.gb c;
    private final Path d = new Path();
    private final hc h = new hc();
    private final String hc;
    private final com.bytedance.adsdk.lottie.d.hc.uo u;

    public yo(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.w wVar) {
        this.hc = wVar.d();
        this.b = wVar.b();
        this.c = gbVar;
        com.bytedance.adsdk.lottie.d.hc.uo uoVarD = wVar.hc().d();
        this.u = uoVarD;
        bVar.d(uoVarD);
        uoVarD.d(this);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        hc();
    }

    private void hc() {
        this.an = false;
        this.c.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.bytedance.adsdk.lottie.d.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.util.List<com.bytedance.adsdk.lottie.d.d.b> r6, java.util.List<com.bytedance.adsdk.lottie.d.d.b> r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L39
            java.lang.Object r1 = r6.get(r0)
            com.bytedance.adsdk.lottie.d.d.b r1 = (com.bytedance.adsdk.lottie.d.d.b) r1
            boolean r2 = r1 instanceof com.bytedance.adsdk.lottie.d.d.sy
            if (r2 == 0) goto L26
            r2 = r1
            com.bytedance.adsdk.lottie.d.d.sy r2 = (com.bytedance.adsdk.lottie.d.d.sy) r2
            com.bytedance.adsdk.lottie.model.hc.rf$d r3 = r2.getType()
            com.bytedance.adsdk.lottie.model.hc.rf$d r4 = com.bytedance.adsdk.lottie.model.hc.rf.d.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            com.bytedance.adsdk.lottie.d.d.hc r1 = r5.h
            r1.d(r2)
            r2.d(r5)
            goto L36
        L26:
            boolean r2 = r1 instanceof com.bytedance.adsdk.lottie.d.d.rf
            if (r2 == 0) goto L36
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            com.bytedance.adsdk.lottie.d.d.rf r1 = (com.bytedance.adsdk.lottie.d.d.rf) r1
            r7.add(r1)
        L36:
            int r0 = r0 + 1
            goto L2
        L39:
            com.bytedance.adsdk.lottie.d.hc.uo r6 = r5.u
            r6.d(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.d.d.yo.d(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        if (this.an) {
            return this.d;
        }
        this.d.reset();
        if (this.b) {
            this.an = true;
            return this.d;
        }
        Path pathH = this.u.h();
        if (pathH == null) {
            return this.d;
        }
        this.d.set(pathH);
        this.d.setFillType(Path.FillType.EVEN_ODD);
        this.h.d(this.d);
        this.an = true;
        return this.d;
    }
}
