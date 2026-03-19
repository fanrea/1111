package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.h;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.b {
    int d;
    private boolean de;
    boolean hc;
    private int jh;
    private int sy;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.sy = 0;
        setTag(Integer.valueOf(getClickArea()));
        tt();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().zw()) {
            return;
        }
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void u() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.hc) {
            layoutParams.leftMargin = this.tt;
        } else {
            layoutParams.leftMargin = this.tt + this.sy;
        }
        if (this.de && this.mq != null) {
            layoutParams.leftMargin = ((this.tt + this.sy) - ((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.b()))) - ((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.c()));
        }
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            layoutParams.topMargin = this.tc - ((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.hc()));
        } else {
            layoutParams.topMargin = this.tc;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        if (h.hc(this.k.getRenderRequest().an())) {
            return true;
        }
        super.gb();
        setPadding((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.b()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.hc()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.c()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.d()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.de && this.mq != null) {
            setMeasuredDimension(this.jh + ((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.b())) + ((int) com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), this.mq.c())), this.gb);
        } else if (this.hc) {
            setMeasuredDimension(this.h, this.gb);
        } else {
            setMeasuredDimension(this.d, this.gb);
        }
    }

    private void tt() {
        List<gb> listMk = this.uo.mk();
        if (listMk == null || listMk.size() <= 0) {
            return;
        }
        Iterator<gb> it = listMk.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            gb next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.tc().getType())) {
                this.jh = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, next.gb() + (com.bytedance.sdk.component.adexpress.c.d() ? next.uo() : 0));
                this.d = this.h - this.jh;
            }
        }
        this.sy = this.h - this.d;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.b
    public void d(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.de != z2) {
            this.de = z2;
            u();
            return;
        }
        if (z && this.hc != z) {
            this.hc = z;
            u();
        }
        this.hc = z;
    }
}
