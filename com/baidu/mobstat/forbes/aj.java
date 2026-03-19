package com.baidu.mobstat.forbes;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class aj {
    private static final Proxy a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
    private static final Proxy b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

    public static void a(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            fileOutputStreamOpenFileOutput = context.openFileOutput(str, z ? 32768 : 0);
            ao.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStreamOpenFileOutput);
        } catch (Exception e) {
        } catch (Throwable th) {
            ao.a(fileOutputStreamOpenFileOutput);
            throw th;
        }
        ao.a(fileOutputStreamOpenFileOutput);
    }

    public static String a(Context context, String str) {
        FileInputStream fileInputStreamOpenFileInput = null;
        try {
            fileInputStreamOpenFileInput = context.openFileInput(str);
            byte[] bArrA = a(fileInputStreamOpenFileInput);
            if (bArrA != null) {
                String str2 = new String(bArrA, "utf-8");
                ao.a(fileInputStreamOpenFileInput);
                return str2;
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            ao.a(fileInputStreamOpenFileInput);
            throw th;
        }
        ao.a(fileInputStreamOpenFileInput);
        return "";
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (ao.a(inputStream, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public static boolean b(Context context, String str) {
        return context.deleteFile(str);
    }

    public static boolean c(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    public static HttpURLConnection d(Context context, String str) {
        return a(context, str, 50000, 50000);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.HttpURLConnection a(android.content.Context r2, java.lang.String r3, int r4, int r5) {
        /*
            java.net.URL r0 = new java.net.URL
            r0.<init>(r3)
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            r3 = 0
            android.net.NetworkInfo r3 = r2.getNetworkInfo(r3)
            r1 = 1
            android.net.NetworkInfo r2 = r2.getNetworkInfo(r1)
            if (r2 == 0) goto L27
            boolean r2 = r2.isAvailable()
            if (r2 == 0) goto L27
            java.net.URLConnection r2 = r0.openConnection()
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            goto L70
        L27:
            if (r3 == 0) goto L6f
            boolean r2 = r3.isAvailable()
            if (r2 == 0) goto L6f
            java.lang.String r2 = r3.getExtraInfo()
            if (r2 == 0) goto L3a
            java.lang.String r2 = r2.toLowerCase()
            goto L3c
        L3a:
            java.lang.String r2 = ""
        L3c:
            java.lang.String r3 = "cmwap"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L66
            java.lang.String r3 = "uniwap"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L66
            java.lang.String r3 = "3gwap"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L55
            goto L66
        L55:
            java.lang.String r3 = "ctwap"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L6f
            java.net.Proxy r2 = com.baidu.mobstat.forbes.aj.b
            java.net.URLConnection r2 = r0.openConnection(r2)
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            goto L70
        L66:
            java.net.Proxy r2 = com.baidu.mobstat.forbes.aj.a
            java.net.URLConnection r2 = r0.openConnection(r2)
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            goto L70
        L6f:
            r2 = 0
        L70:
            if (r2 != 0) goto L78
            java.net.URLConnection r2 = r0.openConnection()
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
        L78:
            r2.setConnectTimeout(r4)
            r2.setReadTimeout(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.aj.a(android.content.Context, java.lang.String, int, int):java.net.HttpURLConnection");
    }

    public static boolean e(Context context, String str) {
        boolean z = false;
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
        } catch (Exception e) {
        }
        if (!z) {
            v.c().b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
        }
        if ((!TextUtils.isEmpty(str) && str.equals("android.permission.ACCESS_FINE_LOCATION")) || str.equals(com.kuaishou.weapon.p0.g.h) || str.equals(ap.a().d()) || str.equals("android.permission.READ_PHONE_STATE")) {
            return ap.a().d(str);
        }
        return z;
    }
}
