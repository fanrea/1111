package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView d;
    private TextView de;
    private TextView hc;
    private TextView jh;
    private TextView sy;
    private LinearLayout v;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.d = new TextView(this.mk);
        this.hc = new TextView(this.mk);
        this.jh = new TextView(this.mk);
        this.v = new LinearLayout(this.mk);
        this.sy = new TextView(this.mk);
        this.de = new TextView(this.mk);
        this.d.setTag(9);
        this.hc.setTag(10);
        this.jh.setTag(12);
        this.v.addView(this.jh);
        this.v.addView(this.de);
        this.v.addView(this.hc);
        this.v.addView(this.sy);
        this.v.addView(this.d);
        addView(this.v, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected boolean b() {
        this.d.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.d.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.hc.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.hc.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.jh.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.jh.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.h, this.gb);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        this.jh.setText("功能");
        this.hc.setText("权限");
        this.sy.setText(" | ");
        this.de.setText(" | ");
        this.d.setText("隐私");
        if (this.mq != null) {
            this.jh.setTextColor(this.mq.h());
            this.jh.setTextSize(this.mq.u());
            this.hc.setTextColor(this.mq.h());
            this.hc.setTextSize(this.mq.u());
            this.sy.setTextColor(this.mq.h());
            this.de.setTextColor(this.mq.h());
            this.d.setTextColor(this.mq.h());
            this.d.setTextSize(this.mq.u());
            return false;
        }
        this.jh.setTextColor(-1);
        this.jh.setTextSize(12.0f);
        this.hc.setTextColor(-1);
        this.hc.setTextSize(12.0f);
        this.sy.setTextColor(-1);
        this.de.setTextColor(-1);
        this.d.setTextColor(-1);
        this.d.setTextSize(12.0f);
        return false;
    }
}
