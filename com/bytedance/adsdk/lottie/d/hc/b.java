package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.lottie.d.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements d.InterfaceC0167d {
    private final d<Float, Float> an;
    private final d<Float, Float> b;
    private final d<Float, Float> c;
    private final d.InterfaceC0167d d;
    private boolean h = true;
    private final d<Integer, Integer> hc;
    private final d<Float, Float> u;

    public b(d.InterfaceC0167d interfaceC0167d, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.c.tc tcVar) {
        this.d = interfaceC0167d;
        d<Integer, Integer> dVarD = tcVar.d().d();
        this.hc = dVarD;
        dVarD.d(this);
        bVar.d(dVarD);
        d<Float, Float> dVarD2 = tcVar.hc().d();
        this.b = dVarD2;
        dVarD2.d(this);
        bVar.d(dVarD2);
        d<Float, Float> dVarD3 = tcVar.b().d();
        this.c = dVarD3;
        dVarD3.d(this);
        bVar.d(dVarD3);
        d<Float, Float> dVarD4 = tcVar.c().d();
        this.u = dVarD4;
        dVarD4.d(this);
        bVar.d(dVarD4);
        d<Float, Float> dVarD5 = tcVar.u().d();
        this.an = dVarD5;
        dVarD5.d(this);
        bVar.d(dVarD5);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.h = true;
        this.d.d();
    }

    public void d(Paint paint) {
        if (this.h) {
            this.h = false;
            double dFloatValue = this.c.h().floatValue() * 0.017453292519943295d;
            float fFloatValue = this.u.h().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.hc.h().intValue();
            paint.setShadowLayer(this.an.h().floatValue(), fSin, fCos, Color.argb(Math.round(this.b.h().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
