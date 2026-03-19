package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.tt;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.hc {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean c() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.e = new ImageView(context);
        this.e.setTag(5);
        addView(this.e, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().zw()) {
            return;
        }
        this.e.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        super.gb();
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.k.hc);
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            Drawable drawableD = com.bytedance.sdk.component.adexpress.c.c.d(getContext(), this.mq);
            if (drawableD != null) {
                ((ImageView) this.e).setBackground(drawableD);
            }
        } else {
            ((ImageView) this.e).setBackgroundDrawable(tt.d(0, Integer.valueOf(this.mq.zw()), new int[]{this.gb / 2}, null, null, null));
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.hc
    public void setSoundMute(boolean z) {
        int iU;
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            if (z) {
                iU = jh.u(getContext(), "tt_reward_full_mute");
            } else {
                iU = jh.u(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            iU = jh.u(getContext(), "tt_mute");
        } else {
            iU = jh.u(getContext(), "tt_unmute");
        }
        ((ImageView) this.e).setImageResource(iU);
        if (((ImageView) this.e).getDrawable() == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ((ImageView) this.e).getDrawable().setAutoMirrored(true);
    }
}
