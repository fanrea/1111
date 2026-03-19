package com.kwai.middleware.azeroth.utils;

import aegon.chrome.net.NetError;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.baidu.mobads.container.util.e.a;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class NetworkUtils {
    public static final String MOBILE_NETWORK_2G = "2g";
    public static final String MOBILE_NETWORK_3G = "3g";
    public static final String MOBILE_NETWORK_4G = "4g";
    public static final String MOBILE_NETWORK_5G = "5g";
    public static final String MOBILE_NETWORK_NOT_FOUND = "";
    private static final int NETWORK_TYPE_LTE_CA = 19;
    private static final int NETWORK_TYPE_NR = 20;
    public static final String NONE_NETWORK_NAME = "unknown";
    private static volatile Pattern sHostPattern;

    public interface NetworkRssiFetchListener {
        void onFetchFinish(int i, boolean z);
    }

    private NetworkUtils() {
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getActiveNetworkTypeName(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type != 1 ? "unknown" : activeNetworkInfo.getTypeName();
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        return android.text.TextUtils.isEmpty(subtypeName) ? activeNetworkInfo.getTypeName() : subtypeName;
    }

    public static String getSimpleActiveNetworkTypeName(Context context) {
        String str;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type != 1 ? "unknown" : "WIFI";
        }
        String networkType = getNetworkType(context);
        if (android.text.TextUtils.isEmpty(networkType)) {
            str = "MOBILE";
        } else {
            str = "MOBILE_" + networkType;
        }
        return str.toUpperCase();
    }

    public static boolean isMobileNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getCurrentWifiName(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        if (wifiInfo != null) {
            return wifiInfo.getSSID();
        }
        return null;
    }

    private static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(a.a);
        if (wifiManager == null) {
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentWifiBSSID(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        return (wifiInfo == null || android.text.TextUtils.isEmpty(wifiInfo.getBSSID())) ? "" : wifiInfo.getBSSID();
    }

    @Deprecated
    public static String getIsp(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String simOperator = telephonyManager.getSimOperator();
            String simOperatorName = telephonyManager.getSimOperatorName();
            if (!android.text.TextUtils.isEmpty(simOperatorName)) {
                return simOperatorName;
            }
            if (simOperator == null) {
                return "";
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                if (!simOperator.equals("46001") && !simOperator.equals("46009")) {
                    return simOperator.equals("46003") ? "中国电信" : simOperator;
                }
                return "中国联通";
            }
            return "中国移动";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIspV2(Context context) {
        String simOperator;
        String simOperatorName = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                return "";
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                if (!simOperator.equals("46001") && !simOperator.equals("46009")) {
                    if (!simOperator.equals("46003") && !simOperator.equals("46005") && !simOperator.equals("46011")) {
                        simOperatorName = telephonyManager.getSimOperatorName();
                        return simOperatorName;
                    }
                    return "中国电信";
                }
                return "中国联通";
            }
            return "中国移动";
        } catch (Exception unused) {
            return simOperatorName;
        }
    }

    public static String getNetworkType(Context context) {
        TelephonyManager telephonyManager;
        if ((Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return "";
        }
        int networkType = 0;
        if (Build.VERSION.SDK_INT >= 26 && RomUtils.isEmui()) {
            try {
                try {
                    networkType = ((Integer) JavaCalls.callMethodOrThrow(telephonyManager.getServiceState(), "getHwNetworkType", new Object[0])).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception unused) {
                networkType = telephonyManager.getNetworkType();
            }
        } else {
            try {
                networkType = telephonyManager.getNetworkType();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        switch (networkType) {
        }
        return "";
    }

    public static String getHost(String str) {
        try {
            return Uri.parse(str).getHost().toLowerCase(Locale.US);
        } catch (Exception e) {
            throw new RuntimeException("Illegal url:" + str, e);
        }
    }

    public static String getIp(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return InetAddress.getByName(getHost(str)).getHostAddress();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static void getRssi(final Context context, final NetworkRssiFetchListener networkRssiFetchListener) {
        if (isWifiConnected(context)) {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                networkRssiFetchListener.onFetchFinish(wifiInfo.getRssi(), false);
                return;
            } else {
                networkRssiFetchListener.onFetchFinish(Integer.MAX_VALUE, false);
                return;
            }
        }
        if (isMobileNetworkConnected(context)) {
            CommonUtils.UI_HANDLER.post(new Runnable() { // from class: com.kwai.middleware.azeroth.utils.NetworkUtils.1
                @Override // java.lang.Runnable
                public final void run() {
                    final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        networkRssiFetchListener.onFetchFinish(Integer.MAX_VALUE, false);
                        return;
                    }
                    try {
                        telephonyManager.listen(new PhoneStateListener() { // from class: com.kwai.middleware.azeroth.utils.NetworkUtils.1.1
                            int mCallbackTimes;

                            @Override // android.telephony.PhoneStateListener
                            public void onSignalStrengthsChanged(SignalStrength signalStrength) throws NumberFormatException {
                                telephonyManager.listen(this, 0);
                                int i = this.mCallbackTimes;
                                if (i > 0) {
                                    return;
                                }
                                this.mCallbackTimes = i + 1;
                                int i2 = Integer.MAX_VALUE;
                                if (telephonyManager.getNetworkType() == 13) {
                                    try {
                                        i2 = Integer.parseInt(signalStrength.toString().split(" ")[9]);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                    networkRssiFetchListener.onFetchFinish(i2, true);
                                } else if (signalStrength.isGsm()) {
                                    int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                                    if (gsmSignalStrength == 99) {
                                        networkRssiFetchListener.onFetchFinish(Integer.MAX_VALUE, true);
                                    } else {
                                        networkRssiFetchListener.onFetchFinish((gsmSignalStrength * 2) + NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH, true);
                                    }
                                } else if (telephonyManager.getNetworkType() == 5 || telephonyManager.getNetworkType() == 6 || telephonyManager.getNetworkType() == 12) {
                                    networkRssiFetchListener.onFetchFinish(signalStrength.getEvdoDbm(), true);
                                } else {
                                    networkRssiFetchListener.onFetchFinish(signalStrength.getCdmaDbm(), true);
                                }
                                super.onSignalStrengthsChanged(signalStrength);
                            }
                        }, 256);
                    } catch (Exception e) {
                        networkRssiFetchListener.onFetchFinish(Integer.MAX_VALUE, true);
                        e.printStackTrace();
                    }
                }
            });
        } else {
            networkRssiFetchListener.onFetchFinish(Integer.MAX_VALUE, false);
        }
    }

    public static int getMCC(Context context) {
        TelephonyManager telephonyManager;
        if (!isMobileNetworkConnected(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return -1;
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (android.text.TextUtils.isEmpty(networkOperator)) {
            return -1;
        }
        try {
            return Integer.parseInt(networkOperator.substring(0, 3));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getMNC(Context context) {
        TelephonyManager telephonyManager;
        if (!isMobileNetworkConnected(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return -1;
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (android.text.TextUtils.isEmpty(networkOperator)) {
            return -1;
        }
        try {
            return Integer.parseInt(networkOperator.substring(3));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String privateIpAddress() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String hostAddress = inetAddressNextElement.getHostAddress();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return hostAddress;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
