package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb implements h {
    private DynamicBaseWidget b;
    private com.bytedance.sdk.component.adexpress.dynamic.b.h c;
    private SlideRightView d;
    private Context hc;

    public cb(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this.hc = context;
        this.b = dynamicBaseWidget;
        this.c = hVar;
        c();
    }

    private void c() {
        this.d = new SlideRightView(this.hc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.hc, 120.0f));
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        this.d.setClipChildren(false);
        this.d.setGuideText(this.c.fu());
        DynamicBaseWidget dynamicBaseWidget = this.b;
        if (dynamicBaseWidget != null) {
            this.d.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void d() {
        SlideRightView slideRightView = this.d;
        if (slideRightView != null) {
            slideRightView.d();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public void hc() {
        SlideRightView slideRightView = this.d;
        if (slideRightView != null) {
            slideRightView.hc();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    public ViewGroup b() {
        return this.d;
    }
}
