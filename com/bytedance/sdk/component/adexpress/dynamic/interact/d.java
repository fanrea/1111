package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.BluePressInteractView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements h {
    private BluePressInteractView d;

    public d(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        double dNr = hVar.nr();
        dNr = dNr == 0.0d ? 1.0d : dNr;
        double dI = hVar.i();
        int dynamicWidth = (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * dNr);
        int dynamicWidth2 = (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * (dI != 0.0d ? dI : 1.0d));
        this.d = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, hVar.nw() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, hVar.dz() - 3);
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
    public ViewGroup b() {
        return this.d;
    }
}
