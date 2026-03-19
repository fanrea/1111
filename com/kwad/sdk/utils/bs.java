package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityManager;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.middleware.azeroth.utils.DeviceIDUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bs {
    private static String cnD = null;
    private static String cnE = "";
    private static boolean cnF = false;
    private static String cnG = "";
    private static String cnH = "";
    private static int cnI = 0;
    private static boolean cnJ = false;
    private static int cnK = 0;
    private static boolean cnL = false;
    private static String cnQ;
    private static String cnR;
    private static int cnZ;
    private static long coa;
    private static final String[] cnM = {"", ""};
    private static String cnN = "";
    private static String cnO = "";
    private static String cnP = "";
    private static int cnS = -1;
    private static boolean cnT = false;
    private static boolean cnU = false;
    private static boolean cnV = false;
    private static boolean cnW = false;
    private static boolean cnX = false;
    private static boolean cnY = false;
    private static String cob = "";
    private static String coc = "";
    public static String cod = "";
    private static final List<String> coe = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static int eJ(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(512L)) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static long apU() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static long apV() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    private static long apS() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(com.baidu.mobads.container.w.f.a.f), 8192);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!line.contains(com.baidu.mobads.container.w.f.a.g));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return jLongValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long eK(Context context) throws Throwable {
        long j = coa;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long jApS = memoryInfo.totalMem;
            if (jApS <= 0) {
                jApS = apS();
            }
            coa = jApS;
            return jApS;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long eG(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long apW() {
        long jFreeMemory;
        try {
            jFreeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (jFreeMemory > 0) {
            return jFreeMemory;
        }
        return 0L;
    }

    public static int apX() {
        int i = cnZ;
        if (i > 0) {
            return i;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        cnZ = iAvailableProcessors;
        return iAvailableProcessors;
    }

    public static String w(Context context, boolean z) {
        if (bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevImei())) {
            return bd.getDevImei();
        }
        String strEL = eL(context);
        return (TextUtils.isEmpty(strEL) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.getAppOAID(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Uf() : strEL;
    }

    private static synchronized String eL(Context context) {
        if (bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevImei())) {
            return bd.getDevImei();
        }
        if (cnT) {
            return cnG;
        }
        if (TextUtils.isEmpty(cnG) && context != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return cnG;
            }
            if (bd.usePhoneStateDisable()) {
                return cnG;
            }
            if (!s.aod()) {
                return cnG;
            }
            boolean zEF = false;
            try {
                zEF = SystemUtil.eF(context);
                if (zEF) {
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    cnG = deviceId;
                    if (TextUtils.isEmpty(deviceId)) {
                        cnT = true;
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                if (zEF) {
                    cnT = true;
                }
            }
            return cnG;
        }
        return cnG;
    }

    public static synchronized String eM(Context context) {
        TelephonyManager telephonyManager;
        if (cnY) {
            return cnH;
        }
        if (TextUtils.isEmpty(cnH) && context != null) {
            if (bd.usePhoneStateDisable()) {
                return cnH;
            }
            if (!s.aoc()) {
                return cnP;
            }
            boolean zEF = false;
            try {
                zEF = SystemUtil.eF(context);
                if (zEF && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        String meid = telephonyManager.getMeid();
                        cnH = meid;
                        if (TextUtils.isEmpty(meid)) {
                            cnY = true;
                        }
                    } else if (telephonyManager.getPhoneType() == 2) {
                        String deviceId = telephonyManager.getDeviceId();
                        cnH = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            cnY = true;
                        }
                    } else {
                        cnH = null;
                        cnY = true;
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                if (zEF) {
                    cnY = true;
                }
            }
            return cnH;
        }
        return cnH;
    }

    public static synchronized String[] eN(Context context) {
        if (bd.usePhoneStateDisable() && bd.getDevImeis() != null) {
            return bd.getDevImeis();
        }
        if (cnX) {
            return cnM;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return cnM;
        }
        String[] strArr = cnM;
        boolean z = false;
        if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
            if (bd.usePhoneStateDisable()) {
                return strArr;
            }
            if (!s.aod()) {
                return strArr;
            }
            try {
                boolean zEF = SystemUtil.eF(context);
                if (zEF) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                int iMin = Math.min(eO(context), 2);
                                for (int i = 0; i < iMin; i++) {
                                    cnM[i] = telephonyManager.getImei(i);
                                }
                                String[] strArr2 = cnM;
                                if (TextUtils.isEmpty(strArr2[0]) && TextUtils.isEmpty(strArr2[1])) {
                                    cnX = true;
                                }
                            } else if (telephonyManager.getPhoneType() == 1) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    int iMin2 = Math.min(eO(context), 2);
                                    for (int i2 = 0; i2 < iMin2; i2++) {
                                        cnM[i2] = telephonyManager.getDeviceId(i2);
                                    }
                                } else {
                                    strArr[0] = telephonyManager.getDeviceId();
                                    strArr[1] = null;
                                }
                                String[] strArr3 = cnM;
                                if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                    cnX = true;
                                }
                            } else {
                                strArr[0] = null;
                                strArr[1] = null;
                                cnX = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        z = zEF;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        if (z) {
                            cnX = true;
                        }
                        return cnM;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return cnM;
        }
        return strArr;
    }

    public static synchronized int eO(Context context) {
        if (cnJ || cnI > 0 || Build.VERSION.SDK_INT < 23 || context == null || bd.usePhoneStateDisable()) {
            return cnI;
        }
        try {
            cnI = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
        } catch (Exception unused) {
        }
        int i = cnI;
        cnJ = i == 0;
        return i;
    }

    public static int eP(Context context) {
        if (context == null || cnK > 0 || cnL || Build.VERSION.SDK_INT < 22 || !SystemUtil.eF(context) || bd.usePhoneStateDisable()) {
            return cnK;
        }
        try {
            cnK = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        int i = cnK;
        cnL = i != 0;
        return i;
    }

    public static synchronized String el(Context context) {
        if (context != null) {
            if (!cnU && TextUtils.isEmpty(cnN) && SystemUtil.eF(context) && !bd.usePhoneStateDisable() && s.aoe()) {
                try {
                    cnN = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                } catch (Exception unused) {
                }
                cnU = TextUtils.isEmpty(cnN);
                return cnN;
            }
        }
        return cnN;
    }

    public static int checkSelfPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static String eQ(Context context) {
        if (!TextUtils.isEmpty(cnO) || context == null) {
            return cnO;
        }
        if (cnV) {
            return cnO;
        }
        if (bd.usePhoneStateDisable()) {
            return cnO;
        }
        if (!s.aof()) {
            return cnO;
        }
        try {
            if (SystemUtil.eF(context)) {
                cnO = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cnO = null;
        }
        if (TextUtils.isEmpty(cnO)) {
            cnV = true;
        }
        String str = TextUtils.isEmpty(cnO) ? "" : cnO;
        cnO = str;
        return str;
    }

    public static String getLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String apY() {
        return Build.MODEL;
    }

    public static synchronized long apZ() {
        long j;
        j = 0;
        if (bd.usePhoneStateDisable() && (!TextUtils.isEmpty(bd.getDevImei()) || bd.getDevImeis() != null)) {
            j = 1;
        }
        if (bd.readLocationDisable() && bd.apt() != null) {
            j |= 64;
        }
        if (bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevAndroidId())) {
            j |= 2;
        }
        if (bd.useMacAddressDisable() && !TextUtils.isEmpty(bd.getDevMacAddress())) {
            j |= 4;
        }
        if (bd.useOaidDisable() && !TextUtils.isEmpty(bd.getDevOaid())) {
            j |= 2048;
        }
        if (bd.readInstalledPackagesDisable()) {
            if (bd.getDevInstalledPackages() != null) {
                j |= 16;
            }
        }
        return j;
    }

    public static String aqa() {
        return Build.BRAND;
    }

    public static String aqb() {
        return Build.CPU_ABI;
    }

    public static synchronized int eR(Context context) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return ((AudioManager) context.getSystemService("audio")).getRingerMode();
    }

    public static synchronized long aqc() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static synchronized long aqd() {
        return Build.TIME;
    }

    public static synchronized String aqe() {
        return Build.FINGERPRINT;
    }

    public static synchronized String aqf() {
        if (!TextUtils.isEmpty(cnD)) {
            return cnD;
        }
        String radioVersion = Build.getRadioVersion();
        cnD = radioVersion;
        return radioVersion;
    }

    public static synchronized String aqg() {
        return bc.getName();
    }

    public static synchronized String aqh() {
        return bc.getVersion();
    }

    public static String aqi() {
        return Build.MANUFACTURER;
    }

    public static int aqj() {
        if (cnS == -1) {
            cnS = eS(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return cnS;
    }

    public static String aqk() {
        if (TextUtils.isEmpty(cnR)) {
            try {
                cnR = System.getProperty("os.arch");
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return cnR;
    }

    private static boolean eS(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int aql() {
        return Build.VERSION.SDK_INT;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 35) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Rect bounds = currentWindowMetrics.getBounds();
                Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (bounds.width() - insets.left) - insets.right;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 35) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Rect bounds = currentWindowMetrics.getBounds();
                Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (bounds.height() - insets.top) - insets.bottom;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String aqm() {
        if (bd.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(cod)) {
            return cod;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        cod = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String eh(Context context) {
        if (!TextUtils.isEmpty(cnP) || context == null || cnW) {
            return cnP;
        }
        if (bd.usePhoneStateDisable()) {
            return bd.getDevAndroidId();
        }
        if (!s.anX()) {
            return cnP;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            cnP = string;
            if (!iS(string)) {
                cnP = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(cnP)) {
            cnW = true;
        }
        return cnP;
    }

    public static synchronized String eT(Context context) {
        if (TextUtils.isEmpty(cnE) && context != null && !cnF) {
            if (bd.useMacAddressDisable()) {
                String devMacAddress = bd.getDevMacAddress();
                cnE = devMacAddress;
                return devMacAddress;
            }
            if (!s.anY()) {
                return cnE;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(com.baidu.mobads.container.util.e.a.a)).getConnectionInfo();
                if (connectionInfo != null) {
                    cnE = connectionInfo.getMacAddress();
                }
                if (iQ(cnE)) {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress != null && hardwareAddress.length != 0) {
                                StringBuilder sb = new StringBuilder();
                                for (byte b : hardwareAddress) {
                                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                cnE = sb.toString();
                            }
                        }
                    }
                }
                if (iQ(cnE)) {
                    cnE = com.kwad.sdk.crash.utils.h.d(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                }
                if (!iQ(cnE)) {
                    cnE = cnE.toUpperCase(Locale.US);
                }
            } catch (Exception unused) {
                cnF = true;
            }
            cnF = iQ(cnE);
            return cnE;
        }
        return cnE;
    }

    private static boolean iQ(String str) {
        return TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID);
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(cnQ)) {
            return cnQ;
        }
        String strAqo = aqo();
        if (!TextUtils.isEmpty(strAqo)) {
            String str = DeviceIDUtil.DEVICE_ID_PREFIX + strAqo;
            cnQ = str;
            return str;
        }
        String strEh = eh(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(strEh) && !iR(strEh) && iS(strEh)) {
            String str2 = DeviceIDUtil.DEVICE_ID_PREFIX + strEh;
            cnQ = str2;
            return str2;
        }
        String strAqn = aqn();
        if (!TextUtils.isEmpty(strAqn)) {
            cnQ = DeviceIDUtil.DEVICE_ID_PREFIX + strAqn;
            iT(strAqn);
            return cnQ;
        }
        return DeviceIDUtil.DEVICE_ID_PREFIX;
    }

    private static String aqn() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    private static boolean iR(String str) {
        return coe.contains(str.toLowerCase(Locale.US));
    }

    private static boolean iS(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void iT(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ag.a("ksadsdk_pref", "android_id", str, true);
    }

    private static String aqo() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String strH = ag.h("ksadsdk_pref", "android_id", (String) null);
        ag.i(strH, "ksadsdk_pref", "android_id");
        return strH;
    }

    public static String dK(boolean z) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String appOAID = com.kwad.sdk.core.e.a.getAppOAID(context);
        return (TextUtils.isEmpty(appOAID) && !z && TextUtils.isEmpty(eL(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ug() : appOAID;
    }

    public static List<String> eU(Context context) {
        String[] list;
        if (d.cP(context)) {
            return new ArrayList();
        }
        if (!eV(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean eV(Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 30 || Build.VERSION.SDK_INT < 30) {
            return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return false;
    }

    public static String iU(String str) throws ErrnoException {
        String strValueOf;
        if (!TextUtils.isEmpty(coc) || TextUtils.isEmpty(str)) {
            return coc;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                StructStat structStatStat = Os.stat(str);
                if (structStatStat == null) {
                    return coc;
                }
                String strValueOf2 = "";
                if (Build.VERSION.SDK_INT >= 27) {
                    if (structStatStat.st_atim == null) {
                        strValueOf = "";
                    } else {
                        strValueOf2 = String.valueOf(structStatStat.st_atim.tv_sec);
                        strValueOf = String.valueOf(structStatStat.st_atim.tv_nsec);
                    }
                    coc = strValueOf2 + "." + strValueOf;
                } else {
                    if (structStatStat.st_atime != 0) {
                        strValueOf2 = String.valueOf(structStatStat.st_atime);
                    }
                    coc = strValueOf2;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return coc;
    }

    public static Pair<Boolean, Boolean> eW(Context context) {
        boolean z;
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            accessibilityManager.getEnabledAccessibilityServiceList(16);
            boolean zIsEnabled = accessibilityManager.isEnabled();
            try {
                z = accessibilityManager.getEnabledAccessibilityServiceList(16).isEmpty() ? false : true;
                return new Pair<>(Boolean.valueOf(zIsEnabled), Boolean.valueOf(z));
            } catch (Throwable th) {
                th = th;
                z = z;
                z = zIsEnabled;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z), Boolean.valueOf(z));
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }
}
