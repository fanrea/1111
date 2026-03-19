package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk extends c {
    public mk(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        float f;
        float fMk = (float) this.hc.mk();
        float fMq = (float) this.hc.mq();
        String strCb = this.hc.cb();
        float f2 = 1.0f;
        if ("reverse".equals(strCb) || "alternate-reverse".equals(strCb)) {
            f = 1.0f;
        } else {
            f = fMq;
            fMq = 1.0f;
            f2 = fMk;
            fMk = 1.0f;
        }
        this.b.setTag(2097610710, this.hc.hc());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "scaleX", fMk, f2).setDuration((int) (this.hc.tc() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.b, "scaleY", fMq, f).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        arrayList.add(d(duration2));
        return arrayList;
    }
}
