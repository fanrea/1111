package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickInteractView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements h {
    ClickInteractView d;

    public b(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this.d = new ClickInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
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
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ClickInteractView b() {
        return this.d;
    }
}
