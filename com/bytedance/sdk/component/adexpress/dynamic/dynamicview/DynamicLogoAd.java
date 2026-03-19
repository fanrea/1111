package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.c.mk;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.e = new TextView(context);
        this.e.setTag(Integer.valueOf(getClickArea()));
        addView(this.e, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (Build.VERSION.SDK_INT >= 17) {
            this.e.setTextAlignment(this.mq.gb());
        }
        ((TextView) this.e).setTextColor(this.mq.h());
        ((TextView) this.e).setTextSize(this.mq.u());
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            ((TextView) this.e).setIncludeFontPadding(false);
            ((TextView) this.e).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), this.gb) - this.mq.hc()) - this.mq.d()) - 0.5f, this.mq.u()));
            ((TextView) this.e).setText(jh.d(getContext(), "tt_logo_en"));
            return true;
        }
        if (tt()) {
            if (mk.hc()) {
                ((TextView) this.e).setText(mk.d());
                return true;
            }
            ((TextView) this.e).setText(mk.d(this.mq.hc));
            return true;
        }
        ((TextView) this.e).setText(jh.hc(getContext(), "tt_logo_cn"));
        return true;
    }

    private boolean tt() {
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.mq.hc) && this.mq.hc.contains("adx:")) || mk.hc();
    }
}
