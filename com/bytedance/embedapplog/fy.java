package com.bytedance.embedapplog;

import android.os.SystemProperties;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class fy {
    private static volatile Object d;

    private Object d() {
        if (d == null) {
            synchronized (fy.class) {
                if (d == null) {
                    try {
                        d = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                }
            }
        }
        return d;
    }

    public String d(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            um.d(th);
            try {
                Object objD = d();
                return (String) objD.getClass().getMethod("get", String.class).invoke(objD, str);
            } catch (Throwable th2) {
                um.d(th2);
                return "";
            }
        }
    }
}
