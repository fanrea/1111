package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.components.core.u.f;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    public static String G(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.YK().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", f.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String VH() {
        String strYL = com.kwad.sdk.core.config.e.YL();
        return TextUtils.isEmpty(strYL) ? "安装" : strYL;
    }

    public static String VI() {
        String strYM = com.kwad.sdk.core.config.e.YM();
        return TextUtils.isEmpty(strYM) ? "取消" : strYM;
    }
}
