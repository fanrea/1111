package com.bytedance.d.hc.gb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.mobads.container.util.e.a;
import com.bytedance.d.hc.h.hc;
import com.kwai.middleware.azeroth.utils.NetworkUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tt {
    public static String d(Context context) {
        return d(b(context));
    }

    /* renamed from: com.bytedance.d.hc.gb.tt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[hc.EnumC0189hc.values().length];
            d = iArr;
            try {
                iArr[hc.EnumC0189hc.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[hc.EnumC0189hc.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[hc.EnumC0189hc.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[hc.EnumC0189hc.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[hc.EnumC0189hc.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String d(hc.EnumC0189hc enumC0189hc) {
        try {
            int i = AnonymousClass1.d[enumC0189hc.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "mobile" : NetworkUtils.MOBILE_NETWORK_4G : NetworkUtils.MOBILE_NETWORK_3G : NetworkUtils.MOBILE_NETWORK_2G : a.a;
        } catch (Exception unused) {
            return "";
        }
    }

    private static hc.EnumC0189hc b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return hc.EnumC0189hc.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return hc.EnumC0189hc.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return hc.EnumC0189hc.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return hc.EnumC0189hc.MOBILE;
                        case 13:
                            return hc.EnumC0189hc.MOBILE_4G;
                    }
                }
                return hc.EnumC0189hc.MOBILE;
            }
            return hc.EnumC0189hc.NONE;
        } catch (Throwable unused) {
            return hc.EnumC0189hc.MOBILE;
        }
    }

    public static boolean hc(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
