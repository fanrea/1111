package com.pandora.common.applog;

import android.text.TextUtils;
import com.pandora.common.Constants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppLogParams {
    public static int getUriConfig(String appRegion) {
        return TextUtils.equals(appRegion, Constants.AppRegion.MYA) ? 1 : 0;
    }
}
