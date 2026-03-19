package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends w<ClickSlideUpShakeView> implements e {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.w
    protected void c() {
    }

    public an(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar, boolean z, int i) {
        super(context, dynamicBaseWidget, hVar);
        this.hc = context;
        this.c = hVar;
        this.b = dynamicBaseWidget;
        d(tcVar, hVar, z, i);
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, boolean z, int i) {
        int iQ;
        this.d = new ClickSlideUpShakeView(this.hc, tcVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.hc, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.hc;
        if (hVar.q() > 0) {
            iQ = hVar.q();
        } else {
            iQ = com.bytedance.sdk.component.adexpress.c.d() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, iQ);
        this.d.setLayoutParams(layoutParams);
        this.d.setClipChildren(false);
        this.d.setSlideText(this.c.fu());
        if (this.d instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) this.d).setShakeText(this.c.to());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.d).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.d() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.an.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.d
                    public void d(boolean z2) {
                        if (an.this.b.getDynamicClickListener() != null) {
                            an.this.b.getDynamicClickListener().d(z2, an.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.b.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void u() {
        if (this.d.getParent() != null) {
            ((ViewGroup) this.d.getParent()).setVisibility(8);
        }
    }
}
