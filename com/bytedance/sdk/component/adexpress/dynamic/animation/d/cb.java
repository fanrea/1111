package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb extends c {
    public cb(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), 20.0f), 0.0f, -com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), 20.0f), 0.0f).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        return arrayList;
    }
}
