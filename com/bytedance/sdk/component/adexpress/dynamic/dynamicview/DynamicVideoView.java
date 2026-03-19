package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.u {
    TextView d;
    FrameLayout hc;
    boolean jh;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean c() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.jh = false;
        this.e = new View(context);
        this.e.setTag(Integer.valueOf(getClickArea()));
        this.d = new TextView(context);
        this.hc = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.c.gb.d(context, 15.0f));
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.d.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.d.setBackground(gradientDrawable);
        this.d.setTextSize(10.0f);
        this.d.setGravity(17);
        this.d.setTextColor(-1);
        this.d.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            addView(this.hc, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.d);
        addView(this.e, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.c.d()) {
            addView(this.hc, getWidgetLayoutParams());
        }
        dynamicRootView.b = this.hc;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        double dH = 0.0d;
        double dAn = 0.0d;
        for (gb gbVarMq = this.uo; gbVarMq != null; gbVarMq = gbVarMq.mq()) {
            dAn = (dAn + gbVarMq.an()) - gbVarMq.c();
            dH = (dH + gbVarMq.h()) - gbVarMq.u();
        }
        try {
            float f = (float) dAn;
            int iD = (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), f);
            int iD2 = (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), f + this.u);
            if (com.bytedance.sdk.component.adexpress.c.b.d(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.k.getChildAt(0);
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - iD2;
                iD2 = dynamicWidth - iD;
                iD = i;
            }
            if (!"open_ad".equals(this.k.getRenderRequest().an())) {
                DynamicRoot dynamicRoot2 = (DynamicRoot) this.k.getChildAt(0);
                float f2 = (float) dH;
                dynamicRoot2.d.update(iD, (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), f2), iD2, (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), f2 + this.an));
            } else {
                this.k.b = this.hc;
            }
        } catch (Exception unused) {
        }
        this.k.d(dAn, dH, this.u, this.an, this.mq.e());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void setTimeUpdate(int i) {
        String str;
        String str2;
        if (this.uo.tc().u().jm() && i > 0 && !this.jh) {
            if (i >= 60) {
                str = "0" + (i / 60);
            } else {
                str = "00";
            }
            String str3 = str + ":";
            int i2 = i % 60;
            if (i2 > 9) {
                str2 = str3 + i2;
            } else {
                str2 = str3 + "0" + i2;
            }
            this.d.setText(str2);
            this.d.setVisibility(0);
            return;
        }
        this.jh = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            b(getChildAt(i3));
        }
        this.d.setVisibility(8);
    }

    private void b(View view) {
        if (view == this.d || view == this.rf) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.d.an)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            b(viewGroup.getChildAt(i));
            i++;
        }
    }
}
