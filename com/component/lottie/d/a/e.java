package com.component.lottie.d.a;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e implements m<PointF, PointF> {
    private final List<com.component.lottie.h.a<PointF>> a;

    public e(List<com.component.lottie.h.a<PointF>> list) {
        this.a = list;
    }

    @Override // com.component.lottie.d.a.m
    public List<com.component.lottie.h.a<PointF>> c() {
        return this.a;
    }

    @Override // com.component.lottie.d.a.m
    public boolean b() {
        return this.a.size() == 1 && this.a.get(0).e();
    }

    @Override // com.component.lottie.d.a.m
    public com.component.lottie.a.b.a<PointF, PointF> a() {
        if (this.a.get(0).e()) {
            return new com.component.lottie.a.b.m(this.a);
        }
        return new com.component.lottie.a.b.l(this.a);
    }
}
