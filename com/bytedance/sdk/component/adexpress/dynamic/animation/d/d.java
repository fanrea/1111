package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends c {
    public d(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        float fYo = this.hc.yo() / 100.0f;
        float fRf = this.hc.rf() / 100.0f;
        if ("reverse".equals(this.hc.cb()) && this.hc.k() <= 0.0d) {
            fRf = fYo;
            fYo = fRf;
        }
        this.b.setAlpha(fYo);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "alpha", fYo, fRf).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        return arrayList;
    }
}
