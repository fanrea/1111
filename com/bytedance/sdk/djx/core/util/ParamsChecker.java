package com.bytedance.sdk.djx.core.util;

import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ParamsChecker {
    private static final String TAG = "ParamsChecker";

    public static boolean checkDraw(DJXWidgetDrawParams dJXWidgetDrawParams) {
        if (dJXWidgetDrawParams == null) {
            return false;
        }
        if ((dJXWidgetDrawParams.mDrawContentType & 1) <= 0 || dJXWidgetDrawParams.mDetailConfig != null || dJXWidgetDrawParams.mEnterDelegate != null) {
            return true;
        }
        LG.e(TAG, "mDramaDetailConfig and mEnterDelegate is null, must set one of them to use drama content");
        return false;
    }
}
