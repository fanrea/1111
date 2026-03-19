package com.bytedance.apm.common.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.baidu.mobads.container.util.e.a;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class NetworkUtils {
    static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final long PHONE_INTERNAL = 60000;
    private static volatile boolean enableTelephony = true;
    private static final long sInterval = 2000;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor = null;
    private static volatile boolean useCheckNetworkFast = false;
    private static NetworkType sNetworkType = NetworkType.UNKNOWN;
    private static volatile long lastAdjustTime = 0;
    private static volatile long lastPhoneTime = 0;
    private static volatile long telephonyAccessInterval = 60000;

    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    private NetworkUtils() {
    }

    public enum NetworkType {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);

        final int nativeInt;

        NetworkType(int i) {
            this.nativeInt = i;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public boolean isAvailable() {
            return (this == UNKNOWN || this == NONE) ? false : true;
        }
    }

    static void setNetworkType(NetworkType networkType) {
        sNetworkType = networkType;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor networkTypeInterceptor) {
        sNetworkTypeInterceptor = networkTypeInterceptor;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static NetworkType getNetworkTypeFast(Context context) {
        checkNetworkTypeInit(context);
        adjustNetwork(context);
        return sNetworkType;
    }

    public static boolean isNetworkAvailableFast(Context context) {
        checkNetworkTypeInit(context);
        adjustNetwork(context);
        return sNetworkType.isAvailable();
    }

    private static void checkNetworkTypeInit(Context context) {
        NetworkTypeInterceptor networkTypeInterceptor = sNetworkTypeInterceptor;
        if (networkTypeInterceptor != null && networkTypeInterceptor.getNetworkType() != NetworkType.NONE) {
            sNetworkType = sNetworkTypeInterceptor.getNetworkType();
        } else if (sNetworkType == NetworkType.UNKNOWN) {
            sNetworkType = getNetworkTypeIntern(context);
        }
    }

    private static void adjustNetwork(Context context) {
        if (System.currentTimeMillis() - lastAdjustTime > sInterval) {
            sNetworkType = getNetworkTypeIntern(context);
            lastAdjustTime = System.currentTimeMillis();
        }
    }

    private static NetworkType getNetworkTypeIntern(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return NetworkType.WIFI;
                }
                if (type == 0) {
                    if (!enableTelephony) {
                        return NetworkType.MOBILE;
                    }
                    if (System.currentTimeMillis() - lastPhoneTime < telephonyAccessInterval && sNetworkType != NetworkType.NONE && sNetworkType != NetworkType.UNKNOWN && sNetworkType != NetworkType.WIFI) {
                        return sNetworkType;
                    }
                    lastPhoneTime = System.currentTimeMillis();
                    int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    if (networkType != 3) {
                        if (networkType == 20) {
                            sNetworkType = NetworkType.MOBILE_5G;
                            return NetworkType.MOBILE_5G;
                        }
                        if (networkType != 5 && networkType != 6) {
                            switch (networkType) {
                                case 8:
                                case 9:
                                case 10:
                                    break;
                                default:
                                    switch (networkType) {
                                        case 12:
                                        case 14:
                                        case 15:
                                            break;
                                        case 13:
                                            sNetworkType = NetworkType.MOBILE_4G;
                                            return NetworkType.MOBILE_4G;
                                        default:
                                            sNetworkType = NetworkType.MOBILE;
                                            return NetworkType.MOBILE;
                                    }
                            }
                        }
                    }
                    sNetworkType = NetworkType.MOBILE_3G;
                    return NetworkType.MOBILE_3G;
                }
                sNetworkType = NetworkType.MOBILE;
                return NetworkType.MOBILE;
            }
            return NetworkType.NONE;
        } catch (Throwable unused) {
            sNetworkType = NetworkType.MOBILE;
            return NetworkType.MOBILE;
        }
    }

    public static NetworkType getNetworkType(Context context) {
        if (useCheckNetworkFast) {
            return getNetworkTypeFast(context);
        }
        return getNetworkTypeIntern(context);
    }

    public static String getNetworkAccessType(Context context) {
        return getNetworkAccessType(getNetworkType(context));
    }

    public static String getNetworkAccessType(NetworkType networkType) {
        return networkType == NetworkType.WIFI ? a.a : networkType == NetworkType.WIFI_24GHZ ? "wifi24ghz" : networkType == NetworkType.WIFI_5GHZ ? "wifi5ghz" : networkType == NetworkType.MOBILE_2G ? com.kwai.middleware.azeroth.utils.NetworkUtils.MOBILE_NETWORK_2G : networkType == NetworkType.MOBILE_3G ? com.kwai.middleware.azeroth.utils.NetworkUtils.MOBILE_NETWORK_3G : networkType == NetworkType.MOBILE_3G_H ? "3gh" : networkType == NetworkType.MOBILE_3G_HP ? "3ghp" : networkType == NetworkType.MOBILE_4G ? com.kwai.middleware.azeroth.utils.NetworkUtils.MOBILE_NETWORK_4G : networkType == NetworkType.MOBILE_5G ? com.kwai.middleware.azeroth.utils.NetworkUtils.MOBILE_NETWORK_5G : networkType == NetworkType.MOBILE ? "mobile" : "";
    }

    public static String format(List<Pair<String, String>> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, String> pair : list) {
            String strEncode = encode((String) pair.first, str);
            String str2 = (String) pair.second;
            String strEncode2 = str2 != null ? encode(str2, str) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strEncode);
            sb.append(NAME_VALUE_SEPARATOR);
            sb.append(strEncode2);
        }
        return sb.toString();
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void setupSSLFactory(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new TLSSocketFactory(sSLContext.getSocketFactory()));
            } catch (Throwable unused) {
            }
        }
    }

    public static void setTelephonyAccessInternal(long j) {
        telephonyAccessInterval = j;
    }

    public static void enableTelephony(boolean z) {
        enableTelephony = z;
    }

    public static boolean isTelephonyEnable() {
        return enableTelephony;
    }
}
