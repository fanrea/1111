package com.alipay.sdk.m.b0;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    public static String a(String str) {
        String strA;
        try {
            strA = f.a(str);
        } catch (Throwable unused) {
            strA = "";
        }
        return com.alipay.sdk.m.z.a.a(strA) ? c.a(".SystemConfig" + File.separator + str) : strA;
    }
}
