package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w<E extends SlideUpView> implements h<E> {
    protected DynamicBaseWidget b;
    protected com.bytedance.sdk.component.adexpress.dynamic.b.h c;
    protected SlideUpView d;
    protected Context hc;
    protected int u;

    public w(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, int i) {
        this.u = i;
        this.hc = context;
        this.b = dynamicBaseWidget;
        this.c = hVar;
        c();
    }

    public w(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        this(context, dynamicBaseWidget, hVar, 0);
    }

    protected void c() {
        this.d = new SlideUpView(this.hc, this.c.tr());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.hc, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.hc, 100 - this.u);
        this.d.setLayoutParams(layoutParams);
        try {
            this.d.setGuideText(this.c.fu());
        } catch (Throwable unused) {
        }
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
    /* renamed from: an, reason: merged with bridge method [inline-methods] */
    public E b() {
        return (E) this.d;
    }
}
