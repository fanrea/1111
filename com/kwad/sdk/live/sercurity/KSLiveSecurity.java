package com.kwad.sdk.live.sercurity;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KSLiveSecurity {
    public static String atlasSign(String str) {
        Context appContext = KSLiveInitModule.getInstance().getAppContext();
        if (appContext != null && !TextUtils.isEmpty(str)) {
            try {
                String strDoSign = KWEGIDDFP.instance().doSign(appContext, str);
                return strDoSign == null ? "" : strDoSign;
            } catch (Throwable unused) {
            }
        }
        return "";
    }
}
