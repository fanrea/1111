package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends c {
    public gb(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.hc.tc() * 1000.0d));
        ((ViewGroup) this.b.getParent()).setClipChildren(false);
        ((ViewGroup) this.b.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.b.getParent().getParent().getParent()).setClipChildren(false);
        this.b.setTag(2097610712, this.hc.gb());
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        return arrayList;
    }
}
