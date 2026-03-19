package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.e = new ImageView(context);
        this.e.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            this.gb = Math.max(dynamicRootView.getLogoUnionHeight(), this.gb);
        }
        addView(this.e, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.e).setImageResource(jh.u(getContext(), "tt_ad_logo"));
        ((ImageView) this.e).setColorFilter(this.mq.h(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
