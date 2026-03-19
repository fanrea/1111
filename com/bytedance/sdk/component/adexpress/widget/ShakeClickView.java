package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.tc;
import com.bytedance.sdk.component.utils.jh;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView hc;

    public ShakeClickView(Context context, View view, tc tcVar, boolean z, int i) {
        super(context, view, tcVar, z, i);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    protected void d(Context context, View view) {
        addView(view);
        this.hc = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.hc == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.hc.setText(jh.hc(this.hc.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e) {
                mq.c("shakeClickView", e.getMessage());
                return;
            }
        }
        this.hc.setText(str);
    }
}
