package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap map;
        map = new HashMap();
        try {
            new com.alipay.apmobilesecuritysdk.c.b();
            map.put("AE16", "");
        } catch (Throwable unused) {
        }
        return map;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap map;
        com.alipay.sdk.m.a0.e.a();
        com.alipay.sdk.m.a0.b.a(APSecuritySdk.getInstance(context));
        map = new HashMap();
        map.put("AE1", com.alipay.sdk.m.a0.e.b());
        map.put("AE2", (com.alipay.sdk.m.a0.e.c() ? "1" : "0"));
        map.put("AE3", (com.alipay.sdk.m.a0.e.d() ? "1" : "0"));
        map.put("AE4", com.alipay.sdk.m.a0.e.e());
        map.put("AE5", com.alipay.sdk.m.a0.e.f());
        map.put("AE6", com.alipay.sdk.m.a0.e.g());
        map.put("AE7", com.alipay.sdk.m.a0.e.h());
        map.put("AE8", com.alipay.sdk.m.a0.e.i());
        map.put("AE9", com.alipay.sdk.m.a0.e.j());
        map.put("AE10", com.alipay.sdk.m.a0.e.k());
        map.put("AE11", com.alipay.sdk.m.a0.e.l());
        map.put("AE12", com.alipay.sdk.m.a0.e.m());
        map.put("AE13", com.alipay.sdk.m.a0.e.n());
        map.put("AE14", com.alipay.sdk.m.a0.e.o());
        map.put("AE15", com.alipay.sdk.m.a0.e.p());
        map.put("AE21", com.alipay.sdk.m.a0.b.f());
        return map;
    }
}
