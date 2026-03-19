package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.b {
    private int[] d;
    private int hc;
    private int jh;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        ((TextView) this.e).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void u() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.h, this.gb);
        layoutParams.gravity = 8388629;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.e).getText())) {
            setMeasuredDimension(0, this.gb);
        } else {
            setMeasuredDimension(this.h, this.gb);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void d(CharSequence charSequence, boolean z, int i, boolean z2) {
        String strD = jh.d(com.bytedance.sdk.component.adexpress.c.getContext(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.e.setVisibility(0);
            ((TextView) this.e).setText("| ".concat(String.valueOf(strD)));
            this.e.measure(-2, -2);
            this.d = new int[]{this.e.getMeasuredWidth() + 1, this.e.getMeasuredHeight()};
            View view = this.e;
            int[] iArr = this.d;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.e).setGravity(17);
            ((TextView) this.e).setIncludeFontPadding(false);
            tt();
            this.e.setPadding(this.mq.b(), this.hc, this.mq.c(), this.jh);
        }
        requestLayout();
    }

    private void tt() {
        int iD = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.u());
        this.hc = ((this.gb - iD) / 2) - this.mq.d();
        this.jh = 0;
    }
}
