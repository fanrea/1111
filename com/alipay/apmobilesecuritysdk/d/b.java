package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import com.dhylive.app.utils.JumpParam;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        map2 = new HashMap();
        String strA = com.alipay.sdk.m.z.a.a(map, "tid", "");
        String strA2 = com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, "");
        String strA3 = com.alipay.sdk.m.z.a.a(map, JumpParam.USER_ID, "");
        String strA4 = com.alipay.sdk.m.z.a.a(map, "appName", "");
        String strA5 = com.alipay.sdk.m.z.a.a(map, "appKeyClient", "");
        String strA6 = com.alipay.sdk.m.z.a.a(map, "tmxSessionId", "");
        String strF = h.f(context);
        String strA7 = com.alipay.sdk.m.z.a.a(map, "sessionId", "");
        map2.put("AC1", strA);
        map2.put("AC2", strA2);
        map2.put("AC3", "");
        map2.put("AC4", strF);
        map2.put("AC5", strA3);
        map2.put("AC6", strA6);
        map2.put("AC7", "");
        map2.put("AC8", strA4);
        map2.put("AC9", strA5);
        if (com.alipay.sdk.m.z.a.b(strA7)) {
            map2.put("AC10", strA7);
        }
        return map2;
    }
}
