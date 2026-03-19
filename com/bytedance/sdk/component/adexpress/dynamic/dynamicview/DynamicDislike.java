package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            this.e = new ImageView(context);
        } else {
            this.e = new DislikeView(context);
        }
        this.e.setTag(3);
        addView(this.e, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.e);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            Drawable drawableD = com.bytedance.sdk.component.adexpress.c.c.d(getContext(), this.mq);
            if (drawableD != null) {
                this.e.setBackground(drawableD);
            }
            int iU = jh.u(getContext(), "tt_close_btn");
            if (iU > 0) {
                ((ImageView) this.e).setImageResource(iU);
            }
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iD = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.w());
        if (this.e instanceof DislikeView) {
            ((DislikeView) this.e).setRadius((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.e()));
            ((DislikeView) this.e).setStrokeWidth(iD);
            ((DislikeView) this.e).setStrokeColor(this.mq.cb());
            ((DislikeView) this.e).setBgColor(this.mq.zw());
            ((DislikeView) this.e).setDislikeColor(this.mq.h());
            ((DislikeView) this.e).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, 1.0f));
        }
        return true;
    }
}
