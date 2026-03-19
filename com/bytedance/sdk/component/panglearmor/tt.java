package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    private static AtomicInteger b = new AtomicInteger(0);
    private static volatile tt d = null;
    private static volatile boolean hc = false;

    private tt() {
    }

    public static tt d() {
        if (d == null) {
            synchronized (tt.class) {
                if (d == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.bytedance.sdk.openadsdk.zw.an.d("panglearmor");
                        hc = true;
                        b.set(1);
                    } catch (Throwable unused) {
                        hc = false;
                        b.set(2);
                    }
                    d = new tt();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    gb gbVarH = an.h();
                    if (gbVarH != null) {
                        gbVarH.d(jCurrentTimeMillis2 - jCurrentTimeMillis, hc);
                    }
                }
            }
        }
        return d;
    }

    public static boolean hc() {
        return hc;
    }

    public static int b() {
        return b.get();
    }

    public byte[] d(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && hc) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] hc(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && hc) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String d(String str) {
        if (str == null || str.length() == 0 || !hc) {
            return null;
        }
        try {
            byte[] bArrHc = hc(Base64.decode(str, 0));
            if (bArrHc != null) {
                return new String(bArrHc);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
