package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.InetAddress;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ao {
    private static int cmy;
    private static boolean cmz;

    public static NetworkInfo dW(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfoDW = dW(context);
            if (networkInfoDW != null) {
                if (networkInfoDW.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfoDW = dW(context);
            if (networkInfoDW != null && networkInfoDW.isConnected()) {
                return 1 == networkInfoDW.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo networkInfoDW = dW(context);
            if (networkInfoDW != null && networkInfoDW.isConnected()) {
                if (networkInfoDW.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo networkInfoDW = dW(context);
            if (networkInfoDW == null) {
                return -1;
            }
            return networkInfoDW.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int dX(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) && SystemUtil.b(context, "android.permission.READ_PHONE_STATE")) {
            try {
                NetworkInfo networkInfoDW = dW(context);
                if (!(networkInfoDW != null && networkInfoDW.isConnected())) {
                    return 0;
                }
                if (1 == networkInfoDW.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int iQ = q(context, telephonyManager.getNetworkType());
                    if (iQ == 20) {
                        return 5;
                    }
                    switch (iQ) {
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int d(Context context, String str, boolean z) {
        if (context == null || cmy > 0 || cmz) {
            return cmy;
        }
        try {
            if (!z) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (Build.VERSION.SDK_INT >= 22) {
                    String simOperator = telephonyManager.getSimOperator();
                    char c = 65535;
                    int iHashCode = simOperator.hashCode();
                    if (iHashCode != 49679502) {
                        switch (iHashCode) {
                            case 49679470:
                                if (simOperator.equals("46000")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 49679471:
                                if (simOperator.equals("46001")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 49679472:
                                if (simOperator.equals("46002")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 49679473:
                                if (simOperator.equals("46003")) {
                                    c = 7;
                                    break;
                                }
                                break;
                            default:
                                switch (iHashCode) {
                                    case 49679475:
                                        if (simOperator.equals("46005")) {
                                            c = '\b';
                                            break;
                                        }
                                        break;
                                    case 49679476:
                                        if (simOperator.equals("46006")) {
                                            c = 5;
                                            break;
                                        }
                                        break;
                                    case 49679477:
                                        if (simOperator.equals("46007")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case 49679478:
                                        if (simOperator.equals("46008")) {
                                            c = 3;
                                            break;
                                        }
                                        break;
                                    case 49679479:
                                        if (simOperator.equals("46009")) {
                                            c = 6;
                                            break;
                                        }
                                        break;
                                }
                        }
                    } else if (simOperator.equals("46011")) {
                        c = '\t';
                    }
                    switch (c) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            cmy = 1;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            cmy = 3;
                            break;
                        case 7:
                        case '\b':
                        case '\t':
                            cmy = 2;
                            break;
                        default:
                            cmy = 0;
                            break;
                    }
                }
            } else {
                cmy = 0;
            }
            if (cmy == 0 && !TextUtils.isEmpty(str)) {
                if (str.startsWith("46000") || str.startsWith("46002")) {
                    cmy = 1;
                } else if (str.startsWith("46001")) {
                    cmy = 3;
                } else if (str.startsWith("46003")) {
                    cmy = 2;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        int i = cmy;
        cmz = i == 0;
        return i;
    }

    private static int q(Context context, int i) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT < 26 || !SystemUtil.b(context, com.kuaishou.weapon.p0.g.b)) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    serviceState = (ServiceState) z.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null) {
                return i;
            }
            if (bc.app()) {
                Integer num = (Integer) z.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i;
            }
            if (iv(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    private static boolean iv(String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    public static boolean iw(String str) {
        return y(str, 3000);
    }

    private static boolean y(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
