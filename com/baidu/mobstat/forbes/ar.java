package com.baidu.mobstat.forbes;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobstat.forbes.ah;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ar {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static final Pattern d = Pattern.compile("\\s*|\t|\r|\n");

    public static String a(int i, Context context) {
        return "";
    }

    public static String b(int i, Context context) {
        String strT = al.a().t(context);
        if (TextUtils.isEmpty(strT)) {
            strT = "";
        }
        return ah.b.c(i, strT.getBytes());
    }

    public static String c(int i, Context context) {
        return "";
    }

    public static String d(int i, Context context) {
        return "";
    }

    public static String e(int i, Context context) {
        return "";
    }

    public static String f(int i, Context context) {
        return "";
    }

    public static String a(Context context) {
        return "";
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = d(context);
        } catch (Exception e) {
        }
        return displayMetrics.widthPixels;
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = d(context);
        } catch (Exception e) {
        }
        return displayMetrics.heightPixels;
    }

    public static DisplayMetrics d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public static String g(int i, Context context) {
        return "";
    }

    private static String a(byte b2) {
        return ("00" + Integer.toHexString(b2) + ":").substring(r2.length() - 3);
    }

    public static String h(int i, Context context) throws Throwable {
        String strC;
        if (!ap.a().e()) {
            return "";
        }
        String strI = i(i, context);
        if (TextUtils.isEmpty(strI)) {
            strC = null;
        } else {
            strC = ah.b.c(i, strI.getBytes());
        }
        return TextUtils.isEmpty(strC) ? "" : strC;
    }

    public static String i(int i, Context context) throws Throwable {
        if (!ap.a().e()) {
            return "";
        }
        String strA = a();
        if (TextUtils.isEmpty(strA)) {
            strA = j(i, context);
        }
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static String j(int i, Context context) throws SocketException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] hardwareAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isAnyLocalAddress() && (inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                            if (inetAddressNextElement.isSiteLocalAddress()) {
                                hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                            } else if (!inetAddressNextElement.isLinkLocalAddress()) {
                                hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        if (hardwareAddress != null) {
            for (byte b2 : hardwareAddress) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        String strG = g(i, context);
        if (strG != null) {
            return strG.replaceAll(":", "");
        }
        return strG;
    }

    public static String a() throws Throwable {
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader2 = null;
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int i = inputStreamReader.read(cArr);
                    if (i == -1) {
                        break;
                    }
                    if (i != 20 || cArr[19] == '\r') {
                        for (int i2 = 0; i2 < i; i2++) {
                            if (cArr[i2] != '\r') {
                                stringBuffer.append(cArr[i2]);
                            }
                        }
                    } else {
                        System.out.print(cArr);
                    }
                } catch (Exception e) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
            String strReplaceAll = stringBuffer.toString().trim().replaceAll(":", "");
            try {
                inputStreamReader.close();
            } catch (Exception e4) {
            }
            return strReplaceAll;
        } catch (Exception e5) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(Context context, int i) {
        String strG = g(context);
        return TextUtils.isEmpty(strG) ? "" : ah.b.c(i, strG.getBytes());
    }

    public static String g(Context context) {
        return "";
    }

    public static String k(int i, Context context) {
        return "";
    }

    public static String l(int i, Context context) {
        ap.a().e();
        return "";
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return false;
            }
            if (!networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String i(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            if (!typeName.equals("WIFI") && activeNetworkInfo.getSubtypeName() != null) {
                return activeNetworkInfo.getSubtypeName();
            }
            return typeName;
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean j(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (aj.e(context, com.kuaishou.weapon.p0.g.b) && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    return activeNetworkInfo.isAvailable();
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static String k(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    public static String m(int i, Context context) {
        String strK = k(context);
        if (!TextUtils.isEmpty(strK)) {
            try {
                return ah.b.c(i, strK.getBytes());
            } catch (Exception e) {
                return "";
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        r0 = r2.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String o(android.content.Context r5) {
        /*
            java.lang.String r0 = com.baidu.mobstat.forbes.ar.a
            if (r0 != 0) goto L39
            java.lang.String r1 = "activity"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch: java.lang.Exception -> L31
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch: java.lang.Exception -> L31
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch: java.lang.Exception -> L31
            r1 = 0
        L11:
            if (r5 == 0) goto L30
            int r2 = r5.size()     // Catch: java.lang.Exception -> L31
            if (r1 >= r2) goto L30
            java.lang.Object r2 = r5.get(r1)     // Catch: java.lang.Exception -> L31
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch: java.lang.Exception -> L31
            if (r2 == 0) goto L2d
            int r3 = r2.pid     // Catch: java.lang.Exception -> L31
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L31
            if (r3 != r4) goto L2d
            java.lang.String r5 = r2.processName     // Catch: java.lang.Exception -> L31
            r0 = r5
            goto L30
        L2d:
            int r1 = r1 + 1
            goto L11
        L30:
            goto L32
        L31:
            r5 = move-exception
        L32:
            if (r0 != 0) goto L37
            java.lang.String r5 = ""
            r0 = r5
        L37:
            com.baidu.mobstat.forbes.ar.a = r0
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.ar.o(android.content.Context):java.lang.String");
    }

    private static String a(Context context, String str) {
        int iLastIndexOf;
        int i;
        if (str != null && (iLastIndexOf = str.lastIndexOf(58)) > 0 && (i = iLastIndexOf + 1) < str.length()) {
            return str.substring(i);
        }
        return null;
    }

    private static String b(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            return null;
        }
        return str;
    }

    public static String l(Context context) {
        String str = b;
        if (str == null) {
            String strO = o(context);
            String strA = a(context, strO);
            if (TextUtils.isEmpty(strA)) {
                strA = b(context, strO);
            }
            if (strA != null) {
                str = strA;
            } else {
                str = "";
            }
            b = str;
        }
        return str;
    }

    public static String m(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        ServiceInfo[] serviceInfoArr;
        String str;
        String strO = o(context);
        if (strO == null) {
            return "";
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (Exception e) {
            packageInfo = null;
        }
        if (packageInfo == null || (serviceInfoArr = packageInfo.services) == null) {
            return "";
        }
        int length = serviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i];
            if (!strO.equals(serviceInfo.processName)) {
                i++;
            } else {
                str = serviceInfo.name;
                break;
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean n(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static String b() {
        return "";
    }

    public static String a(String str) {
        return ah.b.c(2, str.getBytes());
    }
}
