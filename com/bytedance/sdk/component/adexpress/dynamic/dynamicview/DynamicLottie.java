package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.b.an;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {
    String d;
    gb hc;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, gb gbVar, String str) {
        super(context, dynamicRootView, gbVar);
        this.d = str;
        this.hc = gbVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        if (this.uo == null || this.uo.tc() == null || this.mk == null || TextUtils.isEmpty(this.d)) {
            return null;
        }
        an anVarU = this.uo.tc().u();
        String strEy = anVarU != null ? anVarU.ey() : "";
        if (TextUtils.isEmpty(strEy)) {
            return null;
        }
        String str = this.d + "static/lotties/" + strEy + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.mk);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.tt();
        return dynamicLottieView;
    }
}
