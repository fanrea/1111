package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView d;

    public ClickSlideUpShakeView(Context context, tc tcVar, boolean z, int i) {
        super(context);
        d(context, tcVar, z, i);
    }

    private void d(Context context, tc tcVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.b.d.b(context), tcVar, z, i);
        this.d = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.d.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.d;
    }

    public void setShakeText(String str) {
        if (this.d == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.d.setShakeText("");
        } else {
            this.d.setShakeText(str);
        }
    }
}
