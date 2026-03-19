package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends c {
    public an(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        float f = this.b.getLayoutParams().width;
        this.b.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "translationX", f, 0.0f).setDuration((int) (this.hc.tc() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.b, "alpha", 0.0f, 1.0f).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        arrayList.add(d(duration2));
        return arrayList;
    }
}
