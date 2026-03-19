package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo implements h<PressInteractView> {
    private PressInteractView d;

    public uo(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this.d = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 20.0f);
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
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public PressInteractView b() {
        return this.d;
    }
}
