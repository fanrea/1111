package com.tachikoma.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class m extends a<PointF, PointF> {
    private final PointF JS;
    private final a<Float, Float> JZ;
    private final a<Float, Float> Ka;

    @Override // com.tachikoma.lottie.a.b.a
    final /* synthetic */ PointF a(com.tachikoma.lottie.e.a<PointF> aVar, float f) {
        return kn();
    }

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.JS = new PointF();
        this.JZ = aVar;
        this.Ka = aVar2;
        setProgress(getProgress());
    }

    @Override // com.tachikoma.lottie.a.b.a
    public final void setProgress(float f) {
        this.JZ.setProgress(f);
        this.Ka.setProgress(f);
        this.JS.set(this.JZ.getValue().floatValue(), this.Ka.getValue().floatValue());
        for (int i = 0; i < this.Jz.size(); i++) {
            this.Jz.get(i).jO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: km, reason: merged with bridge method [inline-methods] */
    public PointF getValue() {
        return kn();
    }

    private PointF kn() {
        return this.JS;
    }
}
