package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            this.e = new ImageView(context);
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h = this.gb;
        } else {
            this.e = new TextView(context);
        }
        this.e.setTag(3);
        addView(this.e, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.e);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().mk() && dynamicRootView.getRenderRequest().zw()) {
                return;
            }
            this.e.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            Drawable drawableD = com.bytedance.sdk.component.adexpress.c.c.d(getContext(), this.mq);
            if (drawableD != null) {
                ((ImageView) this.e).setBackground(drawableD);
            }
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iU = jh.u(getContext(), "tt_reward_full_feedback");
            if (iU > 0) {
                ((ImageView) this.e).setImageResource(iU);
            }
            return true;
        }
        ((TextView) this.e).setText(getText());
        if (Build.VERSION.SDK_INT >= 17) {
            this.e.setTextAlignment(this.mq.gb());
        }
        ((TextView) this.e).setTextColor(this.mq.h());
        ((TextView) this.e).setTextSize(this.mq.u());
        if (Build.VERSION.SDK_INT >= 16) {
            this.e.setBackground(getBackgroundDrawable());
        }
        if (!this.mq.de()) {
            ((TextView) this.e).setMaxLines(1);
            ((TextView) this.e).setGravity(17);
            ((TextView) this.e).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iV = this.mq.v();
            if (iV > 0) {
                ((TextView) this.e).setLines(iV);
                ((TextView) this.e).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.e.setPadding((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.b()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.hc()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.c()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.d()));
        ((TextView) this.e).setGravity(17);
        return true;
    }

    public String getText() {
        return jh.d(com.bytedance.sdk.component.adexpress.c.getContext(), "tt_reward_feedback");
    }
}
