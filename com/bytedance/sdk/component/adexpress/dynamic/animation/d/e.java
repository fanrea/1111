package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e extends c {
    public e(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        float f;
        float fD = com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.hc.an());
        float fD2 = com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.hc.h());
        float f2 = 0.0f;
        if ("reverse".equals(this.hc.cb())) {
            f = fD2;
            fD2 = 0.0f;
            f2 = fD;
            fD = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.c.b.d(this.b.getContext())) {
            fD = -fD;
            f2 = -f2;
        }
        this.b.setTranslationX(fD);
        this.b.setTranslationY(fD2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "translationX", fD, f2).setDuration((int) (this.hc.tc() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.b, "translationY", fD2, f).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        arrayList.add(d(duration2));
        return arrayList;
    }
}
