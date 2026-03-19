package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.pandora.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        String strA = com.alipay.sdk.m.z.a.a(map, Constants.APPLog.APP_CHANNEL, "");
        map2 = new HashMap();
        map2.put("AA1", context.getPackageName());
        com.alipay.sdk.m.a0.a.a();
        map2.put("AA2", com.alipay.sdk.m.a0.a.a(context));
        map2.put("AA3", "APPSecuritySDK-ALIPAYSDK");
        map2.put("AA4", "3.4.0.202311031119");
        map2.put("AA6", strA);
        return map2;
    }
}
