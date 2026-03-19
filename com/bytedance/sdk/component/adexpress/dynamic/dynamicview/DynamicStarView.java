package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {
    private int d;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.d = 0;
        this.e = new TTRatingBar2(context, null);
        this.e.setTag(Integer.valueOf(getClickArea()));
        addView(this.e, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iD = (int) ((com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.u()) * 5.0f) + com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.b() + com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.c())));
        if (this.h > iD && 4 == this.mq.gb()) {
            this.d = (this.h - iD) / 2;
        }
        this.h = iD;
        return new FrameLayout.LayoutParams(this.h, this.gb);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void u() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.h, this.gb);
        layoutParams.topMargin = this.tc;
        layoutParams.leftMargin = this.tt + this.d;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() throws NumberFormatException {
        super.gb();
        double dUo = this.mq.uo();
        if (com.bytedance.sdk.component.adexpress.c.d() && (dUo < 0.0d || dUo > 5.0d || (this.k != null && this.k.getRenderRequest() != null && this.k.getRenderRequest().uo() != 4))) {
            this.e.setVisibility(8);
            return true;
        }
        double d = (dUo < 0.0d || dUo > 5.0d) ? 5.0d : dUo;
        this.e.setVisibility(0);
        ((TTRatingBar2) this.e).d(d, this.mq.h(), (int) this.mq.u(), ((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.hc())) + ((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.d())) + ((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.u())));
        return true;
    }
}
