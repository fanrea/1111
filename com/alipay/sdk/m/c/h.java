package com.alipay.sdk.m.c;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements com.alipay.sdk.m.b.b {
    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zC = com.alipay.sdk.m.p0.e.c(context);
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(zC));
        if (zC) {
            return com.alipay.sdk.m.p0.e.a(context);
        }
        return null;
    }
}
