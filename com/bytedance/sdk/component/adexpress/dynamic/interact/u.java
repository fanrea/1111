package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends w<ClickSlideUpView> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.w
    protected void c() {
    }

    public u(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        super(context, dynamicBaseWidget, hVar);
        d(hVar);
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this.d = new ClickSlideUpView2(this.hc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.d.setLayoutParams(layoutParams);
        if (this.d instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.d).setButtonText(this.c.fu());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.w, com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void d() {
        this.d.d();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.w, com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void hc() {
        this.d.hc();
    }
}
