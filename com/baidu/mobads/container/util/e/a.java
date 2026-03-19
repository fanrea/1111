package com.baidu.mobads.container.util.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.x;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kuaishou.weapon.p0.g;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "wifi";
    public static final String b = "none";
    public static final String c = "unknown";
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 100;
    public static final int i = 19;
    public static final int j = 10000;
    public static final int k = 1000;
    private static final String p = "wlan0";
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 101;
    private static final int t = 999;
    public static long l = 0;
    public static long m = 0;
    public static boolean n = false;
    public static int o = 0;
    private static final Map<String, Integer> u = new b();

    public static String a(Context context) {
        try {
            String strF = x.a(context).f();
            return strF == null ? "" : strF;
        } catch (Throwable th) {
            return "";
        }
    }

    public static Integer b(Context context) {
        String strA;
        try {
            strA = a(context);
        } catch (Throwable th) {
            bq.a().a("Get carrier encounter exception: " + th.getMessage());
        }
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        for (Map.Entry<String, Integer> entry : u.entrySet()) {
            if (strA.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return 99;
    }

    public static NetworkInfo c(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(g.b) == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static NetworkCapabilities l(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(g.b) == 0) {
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String a(int i2) {
        switch (i2) {
            case 0:
                return "NO";
            case 1:
            default:
                return "UNKNOWN";
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "5G";
            case 100:
                return "WIFI";
            case 101:
                return "ETHERNET";
        }
    }

    public static int d(Context context) {
        NetworkInfo networkInfoC = c(context);
        if (networkInfoC != null && networkInfoC.isAvailable()) {
            int i2 = 1;
            if (networkInfoC.getType() == 1) {
                return 100;
            }
            if (networkInfoC.getType() == 0) {
                switch (networkInfoC.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        i2 = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        i2 = 3;
                        break;
                    case 13:
                    case 18:
                    case 19:
                        i2 = 4;
                        break;
                    case 20:
                        i2 = 5;
                        break;
                    default:
                        String subtypeName = networkInfoC.getSubtypeName();
                        if (!TextUtils.isEmpty(subtypeName) && (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) {
                            i2 = 3;
                            break;
                        } else if (!TextUtils.isEmpty(subtypeName) && subtypeName.equalsIgnoreCase("LTE_CA")) {
                            i2 = 4;
                            break;
                        }
                        break;
                }
                return i2;
            }
            if (networkInfoC.getType() == 9) {
                return 101;
            }
            return 999;
        }
        return 0;
    }

    public static Pair<Integer, Integer> e(Context context) {
        try {
            DisplayMetrics displayMetricsG = bv.g(context);
            return new Pair<>(Integer.valueOf(displayMetricsG.widthPixels), Integer.valueOf(displayMetricsG.heightPixels));
        } catch (Exception e2) {
            bq.a().a("Get screen size error: " + e2.getMessage());
            return null;
        }
    }

    public static String f(Context context) {
        try {
            NetworkInfo networkInfoC = c(context);
            if (networkInfoC == null || !networkInfoC.isConnectedOrConnecting()) {
                return "none";
            }
            if (networkInfoC.getType() == 1) {
                return a;
            }
            if (networkInfoC.getSubtypeName() == null) {
                return "unknown";
            }
            return networkInfoC.getSubtypeName().toLowerCase();
        } catch (Exception e2) {
            bq.a().d(e2);
            return "none";
        }
    }

    public static String g(Context context) {
        return "";
    }

    public static int h(Context context) {
        try {
            if (x.a(context).a() >= 29 && i(context).booleanValue()) {
                o = 100;
                return o;
            }
            if (System.currentTimeMillis() - m > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                m = System.currentTimeMillis();
                NetworkInfo networkInfoC = c(context);
                if (networkInfoC != null && networkInfoC.isConnected()) {
                    if (networkInfoC.getType() == 1) {
                        o = 100;
                    } else if (networkInfoC.getType() == 0) {
                        String subtypeName = networkInfoC.getSubtypeName();
                        switch (networkInfoC.getSubtype()) {
                            case 0:
                                o = 1;
                                break;
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                            case 16:
                                o = 2;
                                break;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                o = 3;
                                break;
                            case 13:
                            case 18:
                            case 19:
                                o = 4;
                                break;
                            case 20:
                                o = 5;
                                break;
                            default:
                                if (!TextUtils.isEmpty(subtypeName) && (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) {
                                    o = 3;
                                    break;
                                } else if (!TextUtils.isEmpty(subtypeName) && subtypeName.equalsIgnoreCase("LTE_CA")) {
                                    o = 4;
                                    break;
                                } else {
                                    o = 1;
                                    break;
                                }
                                break;
                        }
                    }
                }
            }
            return o;
        } catch (Exception e2) {
            return o;
        }
    }

    public static Boolean i(Context context) {
        try {
            if (System.currentTimeMillis() - l > 1000) {
                l = System.currentTimeMillis();
                boolean z = true;
                if (x.a(context).a() < 29) {
                    NetworkInfo networkInfoC = c(context);
                    if (networkInfoC == null || !networkInfoC.isConnected() || networkInfoC.getType() != 1) {
                        z = false;
                    }
                    n = z;
                } else {
                    NetworkCapabilities networkCapabilitiesL = l(context);
                    if (networkCapabilitiesL == null || !networkCapabilitiesL.hasCapability(12) || !networkCapabilitiesL.hasCapability(16) || !networkCapabilitiesL.hasTransport(1)) {
                        z = false;
                    }
                    n = z;
                }
            }
            return Boolean.valueOf(n);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean j(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasCapability(12);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean k(Context context) {
        try {
            if (x.a(context).a() < 29) {
                NetworkInfo networkInfoC = c(context);
                return networkInfoC != null && networkInfoC.isConnected() && networkInfoC.isAvailable();
            }
            NetworkCapabilities networkCapabilitiesL = l(context);
            return networkCapabilitiesL != null && networkCapabilitiesL.hasCapability(12) && networkCapabilitiesL.hasCapability(16);
        } catch (Exception e2) {
            bq.a().a("isCurrentNetworkAvailable", e2);
            return false;
        }
    }
}
