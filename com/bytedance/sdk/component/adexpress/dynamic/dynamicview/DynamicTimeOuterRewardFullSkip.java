package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.b {
    private boolean d;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.d = dynamicRootView.getRenderRequest().cb();
        }
        this.h = this.gb;
        this.e = new ImageView(context);
        this.e.setTag(Integer.valueOf(getClickArea()));
        addView(this.e, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().zw()) {
            return;
        }
        this.e.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        Drawable drawableB;
        super.gb();
        ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableD = com.bytedance.sdk.component.adexpress.c.c.d(getContext(), this.mq);
        if (drawableD != null) {
            ((ImageView) this.e).setBackground(drawableD);
        }
        if (this.d) {
            drawableB = jh.b(getContext(), "tt_close_btn");
        } else {
            drawableB = jh.b(getContext(), "tt_skip_btn");
            if (drawableB != null && Build.VERSION.SDK_INT >= 19) {
                drawableB.setAutoMirrored(true);
            }
        }
        if (drawableB != null) {
            ((ImageView) this.e).setImageDrawable(drawableB);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void d(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
