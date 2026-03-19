package com.bytedance.sdk.djx.core.business.view.scroll;

import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class LayoutParamsUtils {
    LayoutParamsUtils() {
    }

    public static void invalidTopAndBottomMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
        }
    }
}
