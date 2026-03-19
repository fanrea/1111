package com.bytedance.adsdk.lottie.d.d;

import com.bytedance.adsdk.lottie.d.hc.d;
import com.bytedance.adsdk.lottie.model.hc.rf;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class sy implements b, d.InterfaceC0167d {
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> an;
    private final List<d.InterfaceC0167d> b = new ArrayList();
    private final rf.d c;
    private final String d;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> h;
    private final boolean hc;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> u;

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
    }

    public sy(com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.rf rfVar) {
        this.d = rfVar.d();
        this.hc = rfVar.u();
        this.c = rfVar.getType();
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = rfVar.b().d();
        this.u = dVarD;
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD2 = rfVar.hc().d();
        this.an = dVarD2;
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD3 = rfVar.c().d();
        this.h = dVarD3;
        bVar.d(dVarD);
        bVar.d(dVarD2);
        bVar.d(dVarD3);
        dVarD.d(this);
        dVarD2.d(this);
        dVarD3.d(this);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        for (int i = 0; i < this.b.size(); i++) {
            this.b.get(i).d();
        }
    }

    void d(d.InterfaceC0167d interfaceC0167d) {
        this.b.add(interfaceC0167d);
    }

    rf.d getType() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.d.hc.d<?, Float> hc() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.d.hc.d<?, Float> b() {
        return this.an;
    }

    public com.bytedance.adsdk.lottie.d.hc.d<?, Float> c() {
        return this.h;
    }

    public boolean u() {
        return this.hc;
    }
}
