package com.bytedance.msdk.gb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.container.util.e.a;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.kwai.middleware.azeroth.utils.NetworkUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class np {
    private static final AtomicInteger d = new AtomicInteger(0);

    private static int d(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i == 4) {
                    return 1;
                }
                if (i == 5) {
                    return 4;
                }
                if (i != 6) {
                    return i;
                }
                return 5;
            }
        }
        return i2;
    }

    private static String hc(int i) {
        return i != 0 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "mobile" : NetworkUtils.MOBILE_NETWORK_5G : NetworkUtils.MOBILE_NETWORK_4G : a.a : NetworkUtils.MOBILE_NETWORK_3G : NetworkUtils.MOBILE_NETWORK_2G : "unknown";
    }

    public static String d() {
        com.bytedance.sdk.component.c.hc hcVar = (com.bytedance.sdk.component.c.hc) AutoService.d(com.bytedance.sdk.component.c.hc.class);
        return hcVar != null ? hcVar.d() : "";
    }

    public static String hc() {
        com.bytedance.sdk.component.c.hc hcVar = (com.bytedance.sdk.component.c.hc) AutoService.d(com.bytedance.sdk.component.c.hc.class);
        return hcVar != null ? hcVar.hc() : "";
    }

    public static String b() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.np() : "";
    }

    public static String c() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.d() : "";
    }

    public static int u() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        int iB = 0;
        if (com.bytedance.msdk.core.d.mk().j().b() && dVar != null) {
            iB = dVar.b();
        }
        return d(iB);
    }

    public static String an() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        int iB = 0;
        if (com.bytedance.msdk.core.d.mk().j().b() && dVar != null) {
            iB = dVar.b();
        }
        return hc(iB);
    }

    public static String h() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.c() : "";
    }

    public static String gb() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.u() : "";
    }

    public static boolean d(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean hc(Context context) {
        return com.bytedance.sdk.component.utils.k.b(context) == 3;
    }

    public static boolean b(Context context) {
        return com.bytedance.sdk.component.utils.k.b(context) == 2;
    }

    public static String tt() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.an() : "";
    }

    public static String tc() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.h() : "";
    }

    public static String mk() {
        com.bytedance.sdk.component.c.d dVar;
        return (ba() && (dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class)) != null) ? dVar.gb() : "";
    }

    public static String mq() {
        com.bytedance.sdk.component.c.d dVar;
        return (ba() && (dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class)) != null) ? dVar.tt() : "";
    }

    public static int uo() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        if (dVar != null) {
            return dVar.tc();
        }
        return 0;
    }

    public static String k() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.mk() : "";
    }

    public static String e() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.uo() : "";
    }

    public static String cb() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.k() : "";
    }

    public static String w() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.e() : "";
    }

    private static boolean ba() {
        return com.bytedance.msdk.core.d.mk().j().b() && c(com.bytedance.msdk.core.hc.getContext());
    }

    public static String yo() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.mq() : "";
    }

    public static String rf() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.cb() : "";
    }

    public static String jh() {
        com.bytedance.sdk.component.c.d dVar;
        return (ba() && (dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class)) != null) ? dVar.w() : "";
    }

    public static String sy() {
        AtomicInteger atomicInteger = d;
        if (atomicInteger.intValue() > 5) {
            return null;
        }
        atomicInteger.incrementAndGet();
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        if (dVar != null) {
            return dVar.yo();
        }
        return null;
    }

    public static String de() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.rf() : "";
    }

    public static String v() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.jh() : "";
    }

    public static String np() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.sy() : "";
    }

    public static String yi() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.v() : "";
    }

    public static String he() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.de() : "";
    }

    public static String vv() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.yi() : "";
    }

    public static String zw() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.he() : "";
    }

    public static int j() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        if (dVar != null) {
            return dVar.vv();
        }
        return 1;
    }

    public static String s() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.zw() : "";
    }

    public static String us() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.j() : "";
    }

    public static int z() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        if (dVar != null) {
            return dVar.s();
        }
        return 0;
    }

    public static String fs() {
        com.bytedance.sdk.component.c.d dVar = (com.bytedance.sdk.component.c.d) AutoService.d(com.bytedance.sdk.component.c.d.class);
        return dVar != null ? dVar.us() : "";
    }

    private static boolean c(Context context) {
        return com.bytedance.msdk.core.mq.b.d(context, "android.permission.READ_PHONE_STATE") == 0;
    }
}
