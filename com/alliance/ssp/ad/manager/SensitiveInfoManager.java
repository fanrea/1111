package com.alliance.ssp.ad.manager;

import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.alliance.ssp.ad.f0.b;
import com.alliance.ssp.ad.o0.l;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.mta.PointCategory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SensitiveInfoManager {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static double[] e = null;
    public static String f = "02:00:00:00:00:00";
    public static String g = "";
    public static String h = "";
    public static int i = 0;
    public static boolean j = true;
    public static boolean k = true;
    public static boolean l = true;
    public static boolean m = true;
    public static boolean n = true;
    public static boolean o = true;
    public static boolean p = true;
    public static boolean q = true;
    public static TelephonyManager r = null;
    public static boolean s = false;
    public static SAAllianceAdInitParams t;

    public enum CONNECT_TYPE {
        NET_Unknown(0),
        NET_Ethernet(1),
        NET_Wifi(2),
        NET_Mobile_Unknown(3),
        NET_2G(4),
        NET_3G(5),
        NET_4G(6),
        NET_5G(7);

        private final int value;

        CONNECT_TYPE(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public class a implements b {
        @Override // com.alliance.ssp.ad.f0.b
        public void a(Exception exc) {
        }

        @Override // com.alliance.ssp.ad.f0.b
        public void a(String str) {
            SensitiveInfoManager.c = str;
        }
    }

    public static String a() {
        if (a(a) || !l) {
            String str = a;
            int i2 = l.a;
            return str;
        }
        l = false;
        int i3 = l.a;
        try {
            a = Settings.Secure.getString(com.alliance.ssp.ad.d0.b.b().a().getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = l.a;
        }
        return a;
    }

    public static String b() {
        if (a(d)) {
            String str = d;
            int i2 = l.a;
            return str;
        }
        if (!o) {
            return "0";
        }
        d = "0";
        int i3 = l.a;
        try {
            TelephonyManager telephonyManagerH = h();
            if (telephonyManagerH != null) {
                String simOperator = telephonyManagerH.getSimOperator();
                if (!TextUtils.isEmpty(simOperator)) {
                    d = simOperator;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = l.a;
        }
        return d;
    }

    public static String c() {
        TelephonyManager telephonyManagerH;
        if (a(b)) {
            String str = b;
            int i2 = l.a;
            return str;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int i3 = l.a;
            return b;
        }
        int i4 = l.a;
        try {
            if (ActivityCompat.checkSelfPermission(com.alliance.ssp.ad.d0.b.b().a(), "android.permission.READ_PHONE_STATE") == 0 && (telephonyManagerH = h()) != null) {
                b = telephonyManagerH.getDeviceId();
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i5 = l.a;
        }
        return b;
    }

    public static void d() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        g = inetAddressNextElement.getHostAddress();
                    }
                    if (inetAddressNextElement instanceof Inet6Address) {
                        if (!(inetAddressNextElement.isAnyLocalAddress() || inetAddressNextElement.isLinkLocalAddress() || inetAddressNextElement.isLoopbackAddress())) {
                            String hostAddress = inetAddressNextElement.getHostAddress();
                            int iIndexOf = hostAddress.indexOf(37);
                            if (iIndexOf > 0) {
                                hostAddress = hostAddress.substring(0, iIndexOf);
                            }
                            h = hostAddress;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i2 = l.a;
        }
    }

    public static double[] e() {
        double[] dArr = e;
        if (dArr != null && dArr.length >= 2 && dArr[0] != 0.0d && dArr[1] != 0.0d) {
            int i2 = l.a;
            return dArr;
        }
        if (dArr == null) {
            e = new double[]{0.0d, 0.0d};
        }
        if (!m) {
            return e;
        }
        m = false;
        int i3 = l.a;
        try {
            if (ActivityCompat.checkSelfPermission(com.alliance.ssp.ad.d0.b.b().a(), g.h) == 0) {
                Location lastKnownLocation = ((LocationManager) com.alliance.ssp.ad.d0.b.b().a().getSystemService("location")).getLastKnownLocation(PointCategory.NETWORK);
                e[0] = lastKnownLocation.getLatitude();
                e[1] = lastKnownLocation.getLongitude();
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = l.a;
        }
        return e;
    }

    public static void f() throws SocketException {
        if (n && q) {
            n = false;
            if (Build.VERSION.SDK_INT >= 29) {
                return;
            }
            try {
                String string = "";
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : hardwareAddress) {
                            sb.append(String.format("%02x:", Byte.valueOf(b2)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        string = sb.toString();
                    }
                }
                if (a(string)) {
                    f = string.replace(":", "").toUpperCase();
                }
            } catch (Exception e2) {
                e2.getMessage();
                int i2 = l.a;
            }
        }
    }

    public static String g() {
        if (a(c) || !k) {
            String str = c;
            int i2 = l.a;
            return str;
        }
        k = false;
        int i3 = l.a;
        try {
            com.alliance.ssp.ad.f0.a.a(com.alliance.ssp.ad.d0.b.b().a(), new a());
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = l.a;
        }
        return c;
    }

    public static TelephonyManager h() {
        TelephonyManager telephonyManager = r;
        if (telephonyManager != null || !j || !o) {
            return telephonyManager;
        }
        int i2 = l.a;
        j = false;
        try {
            if (ActivityCompat.checkSelfPermission(com.alliance.ssp.ad.d0.b.b().a(), "android.permission.READ_PHONE_STATE") == 0) {
                r = (TelephonyManager) com.alliance.ssp.ad.d0.b.b().a().getSystemService("phone");
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i3 = l.a;
        }
        return r;
    }

    public static void i() {
        CONNECT_TYPE connect_type;
        WifiManager wifiManager;
        if (!q || s) {
            return;
        }
        s = true;
        q = false;
        int i2 = l.a;
        CONNECT_TYPE connect_type2 = CONNECT_TYPE.NET_Unknown;
        try {
            if (ActivityCompat.checkSelfPermission(com.alliance.ssp.ad.d0.b.b().a(), g.b) != 0) {
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.alliance.ssp.ad.d0.b.b().a().getSystemService("connectivity")).getActiveNetworkInfo();
            f();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype != 20) {
                        switch (subtype) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                connect_type = CONNECT_TYPE.NET_2G;
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
                                connect_type = CONNECT_TYPE.NET_3G;
                                break;
                            case 13:
                                connect_type = CONNECT_TYPE.NET_4G;
                                break;
                            default:
                                connect_type = CONNECT_TYPE.NET_Mobile_Unknown;
                                break;
                        }
                    } else {
                        connect_type = CONNECT_TYPE.NET_5G;
                    }
                    connect_type2 = connect_type;
                    d();
                } else if (type == 1) {
                    connect_type2 = CONNECT_TYPE.NET_Wifi;
                    if (ActivityCompat.checkSelfPermission(com.alliance.ssp.ad.d0.b.b().a(), g.d) == 0 && (wifiManager = (WifiManager) com.alliance.ssp.ad.d0.b.b().a().getApplicationContext().getSystemService(com.baidu.mobads.container.util.e.a.a)) != null) {
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        g = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                    }
                } else if (type == 9) {
                    connect_type2 = CONNECT_TYPE.NET_Ethernet;
                    d();
                }
            }
            i = connect_type2.getValue();
        } catch (Exception e2) {
            e2.getMessage();
            int i3 = l.a;
        }
    }

    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
