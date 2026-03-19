package com.bytedance.sdk.djx.core.util;

import com.bytedance.sdk.djx.absdk.EMABManager;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.SettingData;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ThumbHelper {
    public static boolean isThumbCanEnable() {
        return SettingData.getInstance().isSeekThumbShow() && ((Integer) EMABManager.getInstance().getConfig(ILogConst.CLICK_THUMB_SHOW, 0)).intValue() == 1;
    }
}
