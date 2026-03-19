package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.h;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.c.mk;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.b {
    private boolean d;
    private boolean hc;
    private boolean jh;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(gbVar.tc().getType())) {
            dynamicRootView.setTimedown(this.gb);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (h.hc(this.k.getRenderRequest().an())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.uo.tc().getType())) {
            ((TextView) this.e).setText(String.valueOf((int) Double.parseDouble(this.mq.tc())));
            return true;
        }
        ((TextView) this.e).setText(((int) Double.parseDouble(this.mq.tc())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void u() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.uo.tc().getType()) || TextUtils.equals("skip-with-time-countdown", this.uo.tc().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.h, this.gb);
            layoutParams.gravity = 8388627;
            if (com.bytedance.sdk.component.adexpress.c.d()) {
                layoutParams.leftMargin = this.tt;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            setLayoutParams(layoutParams);
            return;
        }
        super.u();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.e).getText())) {
            setMeasuredDimension(0, this.gb);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void d(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.jh) {
            ((TextView) this.e).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.k.getRenderRequest().b() && h.hc(this.k.getRenderRequest().an())) {
            if (com.bytedance.sdk.component.adexpress.c.d()) {
                ((TextView) this.e).setText(i + "s");
            } else {
                ((TextView) this.e).setText(String.format(jh.d(com.bytedance.sdk.component.adexpress.c.getContext(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.d = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.c.d() && !"open_ad".equals(this.k.getRenderRequest().an()) && this.k.getRenderRequest().b()) {
            this.jh = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.uo.tc().getType())) {
            ((TextView) this.e).setText(charSequence);
            return;
        }
        ((TextView) this.e).setText(((Object) charSequence) + "s");
        this.hc = true;
        if (this.d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (mk.hc(((TextView) this.e).getText() != null ? r5.toString() : "", this.mq.u(), true)[0] + com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.b() + this.mq.c())), this.gb);
            layoutParams.gravity = 8388629;
            this.e.setLayoutParams(layoutParams);
            this.d = false;
            requestLayout();
        }
    }
}
