package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.d.hc.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb implements mk, tc, u, uo, d.InterfaceC0167d {
    private final boolean an;
    private final com.bytedance.adsdk.lottie.gb b;
    private final com.bytedance.adsdk.lottie.model.layer.b c;
    private final com.bytedance.adsdk.lottie.d.hc.d<Float, Float> gb;
    private final com.bytedance.adsdk.lottie.d.hc.d<Float, Float> h;
    private c tc;
    private final com.bytedance.adsdk.lottie.d.hc.cb tt;
    private final String u;
    private final Matrix d = new Matrix();
    private final Path hc = new Path();

    public cb(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.mq mqVar) {
        this.b = gbVar;
        this.c = bVar;
        this.u = mqVar.d();
        this.an = mqVar.u();
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = mqVar.hc().d();
        this.h = dVarD;
        bVar.d(dVarD);
        dVarD.d(this);
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD2 = mqVar.b().d();
        this.gb = dVarD2;
        bVar.d(dVarD2);
        dVarD2.d(this);
        com.bytedance.adsdk.lottie.d.hc.cb cbVarTc = mqVar.c().tc();
        this.tt = cbVarTc;
        cbVarTc.d(bVar);
        cbVarTc.d(this);
    }

    @Override // com.bytedance.adsdk.lottie.d.d.tc
    public void d(ListIterator<b> listIterator) {
        if (this.tc != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.tc = new c(this.b, this.c, "Repeater", this.an, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        this.tc.d(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        Path pathC = this.tc.c();
        this.hc.reset();
        float fFloatValue = this.h.h().floatValue();
        float fFloatValue2 = this.gb.h().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.d.set(this.tt.hc(i + fFloatValue2));
            this.hc.addPath(pathC, this.d);
        }
        return this.hc;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.h.h().floatValue();
        float fFloatValue2 = this.gb.h().floatValue();
        float fFloatValue3 = this.tt.hc().h().floatValue() / 100.0f;
        float fFloatValue4 = this.tt.b().h().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.d.set(matrix);
            float f = i2;
            this.d.preConcat(this.tt.hc(f + fFloatValue2));
            this.tc.d(canvas, this.d, (int) (i * com.bytedance.adsdk.lottie.u.gb.d(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.tc.d(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.b.invalidateSelf();
    }
}
