package com.bytedance.sdk.djx.core.business.budrama;

import android.view.ViewGroup;
import com.bytedance.sdk.djx.utils.UIUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class GridRenderHelper {
    public static int getRatioHeight(int i, float f) {
        return (int) (i / f);
    }

    public static int getRatioWidth(int i, float f) {
        return (int) (i * f);
    }

    public static ViewGroup.LayoutParams handleVerticalLayoutParams(ViewGroup.LayoutParams layoutParams, int i, int i2, int i3, float f) {
        if (layoutParams != null && i > 0) {
            if (i3 != 0) {
                i = getRealSpace(i, i2, i3);
            }
            layoutParams.width = i;
            layoutParams.height = f == 0.0f ? -2 : getRatioHeight(layoutParams.width, f);
        }
        return layoutParams;
    }

    public static ViewGroup.LayoutParams handleHorizontalLayoutParams(ViewGroup.LayoutParams layoutParams, int i, int i2, int i3, float f) {
        if (layoutParams != null && i > 0) {
            if (i3 != 0) {
                i = getRealSpace(i, i2, i3);
            }
            layoutParams.height = i;
            layoutParams.width = f == 0.0f ? -2 : getRatioWidth(layoutParams.height, f);
        }
        return layoutParams;
    }

    public static int getRealSpace(int i, int i2, int i3) {
        return (i - (UIUtil.dp2px(i2) * (i3 - 1))) / i3;
    }
}
