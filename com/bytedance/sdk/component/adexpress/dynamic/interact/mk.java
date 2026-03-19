package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk implements h {
    private HandLongPressView d;

    public mk(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this.d = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 180.0f));
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        this.d.setGuideText(hVar.fu());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void d() {
        this.d.d();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void hc() {
        this.d.hc();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public ViewGroup b() {
        return this.d;
    }
}
