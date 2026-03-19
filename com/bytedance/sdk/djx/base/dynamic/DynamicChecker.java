package com.bytedance.sdk.djx.base.dynamic;

import com.bytedance.sdk.djx.params.DJXWidgetDrawParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicChecker {
    public static void checkDraw(DJXWidgetDrawParams dJXWidgetDrawParams) {
        DynamicModel dynamicModel = DynamicManager.getInstance().getDynamicModel();
        if (dynamicModel != null) {
            if (dJXWidgetDrawParams.mDrawContentType == 1) {
                dJXWidgetDrawParams.adCodeId(dynamicModel.mDramaDrawAdCodeId);
                dJXWidgetDrawParams.nativeAdCodeId(dynamicModel.mDramaDrawAdCodeId);
            } else {
                dJXWidgetDrawParams.adCodeId(dynamicModel.mSmallDrawCodeId);
                dJXWidgetDrawParams.nativeAdCodeId(dynamicModel.mSmallDrawNativeCodeId);
            }
        }
    }
}
