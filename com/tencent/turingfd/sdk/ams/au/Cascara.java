package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import com.tencent.turingfd.sdk.ams.au.Olive;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Cascara {
    public static volatile Olive a;

    public static Olive a(String str) {
        Olive olive;
        try {
            olive = new Olive(str);
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 14 && i < 20) {
                    synchronized (olive) {
                        synchronized (olive) {
                            olive.a(new Olive.Cfor("export LD_LIBRARY_PATH=/vendor/lib:/system/lib", "export LD_LIBRARY_PATH=/vendor/lib:/system/lib", 5000L));
                        }
                    }
                }
            } catch (Exception unused) {
                if (olive != null) {
                    try {
                        olive.a();
                        return null;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                return olive;
            }
        } catch (Exception unused3) {
            olive = null;
        }
        return olive;
    }

    public static Olive.Cif b(String str) {
        Olive.Cif cifA;
        Olive.Cfor cfor = new Olive.Cfor(str, str, 5000L);
        try {
            if (a == null) {
                synchronized (Cascara.class) {
                    if (a == null) {
                        a = a("sh");
                    }
                }
            }
            cifA = a.a(cfor);
        } catch (Exception e) {
            if (((e instanceof IOException) || (e instanceof InterruptedException)) && a != null) {
                synchronized (Cascara.class) {
                    if (a != null) {
                        Olive olive = a;
                        olive.getClass();
                        try {
                            olive.a();
                        } catch (Throwable unused) {
                        }
                        a = null;
                    }
                }
            }
            cifA = null;
        }
        return cifA == null ? new Olive.Cif(cfor.a, 2, "", "e") : cifA;
    }
}
