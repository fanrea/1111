package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo implements h<DynamicUnlockView> {
    private final DynamicUnlockView d;

    public yo(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        int iQ;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.d = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (hVar.q() > 0) {
            iQ = hVar.q();
        } else {
            iQ = com.bytedance.sdk.component.adexpress.c.d() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, iQ);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(hVar.fu());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void d() {
        DynamicUnlockView dynamicUnlockView = this.d;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.d();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void hc() {
        DynamicUnlockView dynamicUnlockView = this.d;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.hc();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView b() {
        return this.d;
    }
}
