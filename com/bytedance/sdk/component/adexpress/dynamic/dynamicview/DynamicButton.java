package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.e = new AnimationButton(context);
        this.e.setTag(Integer.valueOf(getClickArea()));
        addView(this.e, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.c.d() && "fillButton".equals(this.uo.tc().getType())) {
            ((TextView) this.e).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.e).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.mq.yo() * 2;
            widgetLayoutParams.height -= this.mq.yo() * 2;
            widgetLayoutParams.topMargin += this.mq.yo();
            widgetLayoutParams.leftMargin += this.mq.yo();
            if (Build.VERSION.SDK_INT >= 17) {
                widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
                widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            }
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (TextUtils.equals("download-progress-button", this.uo.tc().getType()) && TextUtils.isEmpty(this.mq.tc())) {
            this.e.setVisibility(4);
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.e.setTextAlignment(this.mq.gb());
        }
        ((TextView) this.e).setText(this.mq.tc());
        ((TextView) this.e).setTextColor(this.mq.h());
        ((TextView) this.e).setTextSize(this.mq.u());
        ((TextView) this.e).setGravity(17);
        ((TextView) this.e).setIncludeFontPadding(false);
        if ("fillButton".equals(this.uo.tc().getType())) {
            this.e.setPadding(0, 0, 0, 0);
        } else {
            this.e.setPadding(this.mq.b(), this.mq.hc(), this.mq.c(), this.mq.d());
        }
        return true;
    }
}
