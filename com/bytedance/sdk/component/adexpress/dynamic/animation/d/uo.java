package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo extends c {
    public uo(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        if ((this.b instanceof ImageView) && (this.b.getParent() instanceof DynamicImageView)) {
            this.b = (View) this.b.getParent();
            ((ViewGroup) this.b).setClipChildren(true);
            ((ViewGroup) this.b.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        return arrayList;
    }
}
