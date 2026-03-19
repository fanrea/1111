package com.bytedance.sdk.djx.core.util;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.settings.SettingData;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXToolUtil {
    public static boolean isNativeAd(String str, String str2) {
        return (!SettingData.getInstance().isAdRenderNative() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    public static boolean isMixAdLogic() {
        return SettingData.getInstance().isMixAdLogic();
    }
}
