package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends c {
    public mq(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        int i;
        int i2;
        this.b.setTag(2097610711, Integer.valueOf(this.hc.c()));
        if (this.b == null || !com.bytedance.sdk.component.adexpress.c.b.d(this.b.getContext())) {
            i = 1;
            i2 = 0;
        } else {
            i2 = 1;
            i = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "shineValue", i2, i).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        return arrayList;
    }
}
