package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.b {
    private boolean d;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.d = dynamicRootView.getRenderRequest().cb();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (!TextUtils.equals(this.uo.tc().getType(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.e).setText("");
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.e).getText())) {
            setMeasuredDimension(0, this.gb);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void u() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.uo.tc().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.h, this.gb);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 17) {
                this.e.setTextAlignment(1);
            }
            ((TextView) this.e).setGravity(17);
        } else {
            super.u();
        }
        if (!"skip-with-time-skip-btn".equals(this.uo.tc().getType()) && Build.VERSION.SDK_INT >= 17) {
            this.e.setTextAlignment(1);
            ((TextView) this.e).setGravity(17);
        }
        setVisibility(8);
    }

    private String d(boolean z) {
        String strD = jh.d(com.bytedance.sdk.component.adexpress.c.getContext(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.uo.tc().getType())) {
            return strD;
        }
        if (com.bytedance.sdk.component.adexpress.c.d() && this.d) {
            strD = "X";
        }
        return z ? strD : "| ".concat(String.valueOf(strD));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void d(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.e).setText(d(z2));
        } else {
            if (z2) {
                ((TextView) this.e).setText(d(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
