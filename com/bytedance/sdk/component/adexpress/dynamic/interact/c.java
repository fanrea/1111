package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends w<ClickSlideUpView> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.w
    protected void c() {
    }

    public c(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        super(context, dynamicBaseWidget, hVar);
        d(hVar);
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this.d = new ClickSlideUpView(this.hc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.hc, hVar.q());
        this.d.setLayoutParams(layoutParams);
        this.d.setSlideText(this.c.fu());
        if (this.d instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.d).setButtonText(this.c.tc());
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
