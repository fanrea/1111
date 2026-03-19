package lkxssdk.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.lingku.xuanshang.core.data.model.XSListener;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import lkxssdk.a0.d;
import lkxssdk.e0.f;
import lkxssdk.e0.k;
import lkxssdk.h0.c;
import lkxssdk.l.c;
import lkxssdk.w.e;
import lkxssdk.w.g;
import lkxssdk.w.h;
import lkxssdk.w.j;
import lkxssdk.y.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static XSListener f;
    public static List<Field> g;
    public static Application h;

    public static int a(float f2) {
        return (int) (((f2 * d().getResources().getDisplayMetrics().xdpi) / 72.0f) + 0.5d);
    }

    public static long a(Map<String, List<String>> map) throws NumberFormatException {
        List<String> list;
        long j;
        if (map == null || map.isEmpty() || (list = map.get("Content-Length")) == null || list.size() == 0) {
            return -1L;
        }
        String str = list.get(0);
        if (TextUtils.isEmpty(str)) {
            j = -1;
        } else {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        if (j > 0) {
            return j;
        }
        List<String> list2 = map.get("Accept-Length");
        if (list2 == null || list2.size() == 0) {
            return -1L;
        }
        String str2 = list2.get(0);
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            return j;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4, android.graphics.Bitmap r5, android.graphics.Bitmap.CompressFormat r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L27
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3b
            r2.<init>()     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3b
            r3 = 100
            r5.compress(r6, r3, r2)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3b
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3b
            r1.write(r5)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L3b
            r1.flush()     // Catch: java.lang.Exception -> L1e
            r1.close()     // Catch: java.lang.Exception -> L1e
            goto L3a
        L1e:
            r5 = move-exception
            r5.printStackTrace()
            goto L3a
        L23:
            r4 = move-exception
            goto L29
        L25:
            r4 = move-exception
            goto L3d
        L27:
            r4 = move-exception
            r1 = r0
        L29:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L39
            r1.flush()     // Catch: java.lang.Exception -> L35
            r1.close()     // Catch: java.lang.Exception -> L35
            goto L39
        L35:
            r4 = move-exception
            r4.printStackTrace()
        L39:
            r4 = r0
        L3a:
            return r4
        L3b:
            r4 = move-exception
            r0 = r1
        L3d:
            if (r0 == 0) goto L4a
            r0.flush()     // Catch: java.lang.Exception -> L46
            r0.close()     // Catch: java.lang.Exception -> L46
            goto L4a
        L46:
            r5 = move-exception
            r5.printStackTrace()
        L4a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.a.a.a(java.lang.String, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat):java.lang.String");
    }

    public static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static void a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(i);
            boolean z = (i & 255) >= 187 && ((65280 & i) >> 8) >= 187 && ((i & 16711680) >> 16) >= 187;
            View decorView = window.getDecorView();
            if (z) {
                decorView.setSystemUiVisibility(8192);
            } else {
                decorView.setSystemUiVisibility(0);
            }
        }
    }

    public static void a(Activity activity, String str) {
        if (TextUtils.isEmpty(str) || activity == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DELETE");
            intent.setData(Uri.parse("package:" + str));
            activity.startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent();
            intent2.addFlags(268435456);
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.parse("package:" + str));
            activity.startActivity(intent2);
        }
    }

    public static void a(Application application) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (application == null) {
            application = e();
        }
        h = application;
    }

    public static void a(lkxssdk.z.a aVar) {
        if (a()) {
            h hVar = j.a().c;
            hVar.getClass();
            if (TextUtils.isEmpty(aVar.b)) {
                Toast.makeText(hVar.a.d.a, "下载地址不能为空", 1).show();
                return;
            }
            String strA = hVar.a(aVar.b, aVar.c);
            g gVarA = hVar.a(strA, hVar.f);
            if (gVarA != null) {
                gVarA.a = aVar;
                gVarA.b.i = aVar;
                c.c("DownloadTaskManager", "appID:" + aVar.a + " DownloadTask is exit");
            } else {
                c.c("DownloadTaskManager", "appID:" + aVar.a + " create new DownloadTask");
                g gVar = new g(strA, aVar, hVar.a, hVar.i, hVar.g, hVar);
                synchronized (hVar.h) {
                    hVar.f.add(gVar);
                }
            }
        }
    }

    public static void a(Closeable... closeableArr) throws IOException {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || !new File(str).exists() || d().getPackageManager().getPackageArchiveInfo(str, 1) == null;
    }

    public static boolean b() {
        if (lkxssdk.e0.c.a().b != null) {
            return true;
        }
        c.b("tag", "ImageLoader please init AppLoader first");
        return false;
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (d().getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static void c(String str) {
        if (a()) {
            h hVar = j.a().c;
            String strA = hVar.a(str, "");
            synchronized (hVar.h) {
                g gVarA = hVar.a(strA, hVar.f);
                if (gVarA != null) {
                    gVarA.e();
                }
            }
        }
    }

    public static Application d() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Application application = h;
        if (application != null) {
            return application;
        }
        Application applicationE = e();
        a(applicationE);
        return applicationE;
    }

    public static String d(String str) throws UnsupportedEncodingException {
        String strA = lkxssdk.a0.c.a("xsw-8ks!2s0x3");
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            str2 = str2 + (((cCharAt & 128) >> 7) | ((cCharAt & 1) << 7) | ((cCharAt & 2) << 5) | ((cCharAt & 4) << 3) | ((cCharAt & '\b') << 1) | ((cCharAt & 16) >> 1) | ((cCharAt & ' ') >> 3) | ((cCharAt & '@') >> 5)) + ",";
            if (i < 32) {
                char cCharAt2 = strA.charAt(i);
                str2 = str2 + (((cCharAt2 & 128) >> 7) | ((cCharAt2 & 1) << 7) | ((cCharAt2 & 2) << 5) | ((cCharAt2 & 4) << 3) | ((cCharAt2 & '\b') << 1) | ((cCharAt2 & 16) >> 1) | ((cCharAt2 & ' ') >> 3) | ((cCharAt2 & '@') >> 5)) + ",";
            }
        }
        return str2;
    }

    public static Application e() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (objInvoke != null) {
                return (Application) objInvoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    public static lkxssdk.a0.a e(String str) throws PackageManager.NameNotFoundException {
        lkxssdk.a0.a aVar = new lkxssdk.a0.a();
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = d().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo == null) {
                    return aVar;
                }
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                lkxssdk.a0.a aVar2 = new lkxssdk.a0.a();
                aVar2.a = applicationInfo.loadIcon(packageManager);
                applicationInfo.loadLabel(packageManager).toString();
                aVar2.b = applicationInfo.sourceDir;
                aVar2.d = packageInfo.versionCode;
                aVar2.c = packageInfo.versionName;
                return aVar2;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("tag", "getAppInfo" + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return aVar;
    }

    public static d f() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) d().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return d.NETWORK_NO;
        }
        if (activeNetworkInfo.getType() == 1) {
            return d.NETWORK_WIFI;
        }
        if (activeNetworkInfo.getType() != 0) {
            return d.NETWORK_UNKNOWN;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return d.NETWORK_2G;
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
                return d.NETWORK_3G;
            case 13:
            case 18:
                return d.NETWORK_4G;
            case 19:
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? d.NETWORK_3G : d.NETWORK_UNKNOWN;
            case 20:
                return d.NETWORK_5G;
        }
    }

    public static int g(String str) {
        int i = -1;
        if (a()) {
            h hVar = j.a().c;
            hVar.getClass();
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(hVar.a.d.a, "下载地址不能为空", 1).show();
            } else {
                String strA = hVar.a(str, "");
                synchronized (hVar.h) {
                    g gVarA = hVar.a(strA, hVar.f);
                    if (gVarA != null) {
                        int i2 = gVarA.b.h;
                        if (i2 == 21 || i2 == 22 || i2 == 23) {
                            i2 = 2;
                        }
                        c.c("DownloadTask", "appID:" + gVarA.a.a + ",TaskStatus:" + i2);
                        i = i2;
                    }
                }
            }
        }
        return i;
    }

    public static boolean g() {
        return (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) ? false : true;
    }

    public static void h(String str) {
        Uri uriFromFile;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            int i = 0;
            try {
                i = d().getPackageManager().getPackageInfo(d().getPackageName(), 0).applicationInfo.targetSdkVersion;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT < 24 || i < 24) {
                uriFromFile = Uri.fromFile(file);
            } else {
                intent.setFlags(1);
                uriFromFile = FileProvider.getUriForFile(d(), d().getPackageName() + ".lkxs.fileprovider", file);
            }
            intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
            intent.addFlags(335544320);
            d().startActivity(intent);
        }
    }

    public static boolean h() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) d().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static void i(String str) {
        if (a()) {
            h hVar = j.a().c;
            String strA = hVar.a(str, "");
            synchronized (hVar.h) {
                g gVarA = hVar.a(strA, hVar.c);
                if (gVarA != null) {
                    gVarA.l();
                    hVar.c.remove(gVarA);
                } else {
                    CountDownTimer countDownTimer = hVar.e.get(strA);
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        hVar.e.remove(strA);
                    }
                    g gVar = hVar.d.get(strA);
                    if (gVar != null) {
                        gVar.l();
                    } else {
                        c.b("DownloadTaskManager", "doingMap not has the task url:" + str);
                    }
                }
            }
        }
    }

    public static void j(String str) {
        if (a()) {
            h hVar = j.a().c;
            hVar.getClass();
            c.b("DownloadTaskManager", "start url:" + str);
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(hVar.a.d.a, "下载地址不能为空", 1).show();
                return;
            }
            if (!str.startsWith(com.alipay.sdk.m.l.a.r) && !str.startsWith("//")) {
                hVar.i.a(new lkxssdk.z.a(str), new lkxssdk.y.a(1, 12));
                return;
            }
            String strA = hVar.a(str, "");
            synchronized (hVar.h) {
                g gVar = hVar.d.get(strA);
                if (gVar != null) {
                    c.b("DownloadTaskManager", "appID:" + gVar.b.i.a + ",正在下载中");
                } else {
                    g gVarA = hVar.a(strA, hVar.c);
                    if (gVarA != null) {
                        hVar.i.c(gVarA.b.i);
                        c.c("DownloadTaskManager", "appID:" + gVarA.b.i.a + ",待下载中");
                    } else {
                        g gVarA2 = hVar.a(strA, hVar.f);
                        if (gVarA2 == null) {
                            Toast.makeText(hVar.a.d.a, "请先添加下载任务", 1).show();
                        } else {
                            c.c("DownloadTaskManager", "appID:" + gVarA2.b.i.a + ",cacheMemory exit the downTask");
                            int size = hVar.d.entrySet().size();
                            if (size < hVar.b.c) {
                                hVar.d.put(strA, gVarA2);
                                c.c("DownloadTaskManager", "appID:" + gVarA2.b.i.a + ",to submit,maxDownloadTaskSize:" + hVar.b.c + ",runTaskSize:" + size);
                                gVarA2.a(false);
                                hVar.a.d.i.execute(gVarA2);
                            } else {
                                hVar.c.add(gVarA2);
                                gVarA2.b.h = 1;
                                c.c("DownloadTaskManager", "appID:" + gVarA2.b.i.a + ",to wait,maxDownloadTaskSize:" + hVar.b.c + ",runTaskSize:" + size);
                                hVar.i.c(gVarA2.b.i);
                            }
                        }
                    }
                }
            }
        }
    }

    public static String b(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        byte[] bArrDoFinal = cipher.doFinal(bytes2);
        if (bArrDoFinal == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArrDoFinal.length * 2);
        for (byte b2 : bArrDoFinal) {
            stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15)).append("0123456789ABCDEF".charAt(b2 & 15));
        }
        return stringBuffer.toString();
    }

    public static String f(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str2 = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (objInvoke != null) {
                str2 = (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(str2) ? "" : str2.toLowerCase();
    }

    public static Executor c() {
        return Executors.newCachedThreadPool(new lkxssdk.e0.a(5, "fc-pool-d-"));
    }

    public static void b(b bVar) {
        if (a()) {
            e eVar = j.a().c.i;
            eVar.getClass();
            if (bVar == null || !eVar.a.contains(bVar)) {
                return;
            }
            eVar.a.remove(bVar);
        }
    }

    public static boolean a() {
        if (j.a().b != null) {
            return true;
        }
        c.b("AppLoader please init AppLoader first");
        return false;
    }

    public static Executor a(int i, int i2, lkxssdk.e0.j jVar) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (jVar == lkxssdk.e0.j.LIFO ? new lkxssdk.f0.a() : new LinkedBlockingQueue()), new lkxssdk.e0.a(i2, "fc-pool-"));
    }

    public static HttpURLConnection a(lkxssdk.c0.c cVar) throws ProtocolException, NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(cVar.a);
        if (cVar.a.toLowerCase().startsWith("https")) {
            httpURLConnection = (HttpsURLConnection) url.openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new lkxssdk.c0.a()}, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier(new lkxssdk.c0.b());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(cVar.b);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setInstanceFollowRedirects(false);
        if (!TextUtils.isEmpty("UTF-8")) {
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
        }
        long j = cVar.c;
        if (j >= 0) {
            if (j >= 0 && cVar.d > j) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + cVar.c + "-" + cVar.d);
            } else {
                httpURLConnection.setRequestProperty("Range", "bytes=" + cVar.c + "-");
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, k kVar) {
        Rect rect;
        Rect rect2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (kVar == k.CROP) {
            float f2 = width;
            float f3 = height;
            float f4 = i / i2;
            if (f2 / f3 > f4) {
                int i3 = (int) (f3 * f4);
                int i4 = (width - i3) / 2;
                rect = new Rect(i4, 0, i3 + i4, height);
            } else {
                int i5 = (int) (f2 / f4);
                int i6 = (height - i5) / 2;
                rect = new Rect(0, i6, width, i5 + i6);
            }
        } else {
            rect = new Rect(0, 0, width, height);
        }
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        if (kVar == k.FIT) {
            float f5 = width2 / height2;
            float f6 = i;
            float f7 = i2;
            rect2 = f5 > f6 / f7 ? new Rect(0, 0, i, (int) (f6 / f5)) : new Rect(0, 0, (int) (f7 * f5), i2);
        } else {
            rect2 = new Rect(0, 0, i, i2);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_4444);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, rect, rect2, new Paint(2));
        return bitmapCreateBitmap;
    }

    public static String a(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = str2.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(bArr));
    }

    public static int a(int i, boolean z) {
        if (i == 1) {
            if (z) {
                lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
                return eVarA.b.getResources().getIdentifier("lkxs_aty_ani_right_in", "anim", eVarA.c);
            }
            lkxssdk.l0.e eVarA2 = lkxssdk.l0.e.a();
            return eVarA2.b.getResources().getIdentifier("lkxs_aty_ani_right_out", "anim", eVarA2.c);
        }
        if (i != 2) {
            if (z) {
                lkxssdk.l0.e eVarA3 = lkxssdk.l0.e.a();
                return eVarA3.b.getResources().getIdentifier("lkxs_aty_ani_zoom_in", "anim", eVarA3.c);
            }
            lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
            return eVarA4.b.getResources().getIdentifier("lkxs_aty_ani_zoom_out", "anim", eVarA4.c);
        }
        if (z) {
            lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
            return eVarA5.b.getResources().getIdentifier("lkxs_aty_ani_bom_to_top", "anim", eVarA5.c);
        }
        lkxssdk.l0.e eVarA6 = lkxssdk.l0.e.a();
        return eVarA6.b.getResources().getIdentifier("lkxs_aty_ani_top_to_bom", "anim", eVarA6.c);
    }

    public static String a(Context context) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        String strF = f("ro.hardware");
        String strF2 = f("ro.build.flavor");
        String lowerCase = Build.FINGERPRINT.toLowerCase();
        String strF3 = f("ro.product.model");
        String strF4 = f("ro.product.manufacturer");
        String strF5 = f("ro.product.board");
        String strF6 = f("ro.board.platform");
        String strF7 = f("gsm.version.baseband");
        int size = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).size();
        lkxssdk.l.c cVar = c.a.a;
        String strA = cVar.a("pm list package -3");
        int length = TextUtils.isEmpty(strA) ? 0 : strA.split("package:").length;
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera");
        boolean zHasSystemFeature2 = context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        int i = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) != null ? 1 : 0;
        boolean zHasSystemFeature3 = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
        int i2 = !TextUtils.isEmpty(cVar.a("cat /proc/self/cgroup")) ? 1 : 0;
        boolean z = ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
        Intent intent = new Intent();
        boolean z2 = z;
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        int i3 = intent.resolveActivity(context.getPackageManager()) != null ? 1 : 0;
        try {
            jSONObject.put("hardware", strF);
            jSONObject.put("buildFlavor", strF2);
            jSONObject.put("fingerprint", lowerCase);
            jSONObject.put("model", strF3);
            jSONObject.put("manufacturer", strF4);
            jSONObject.put("productBoard", strF5);
            jSONObject.put("boardPlatform", strF6);
            jSONObject.put("baseband", strF7);
            jSONObject.put("sensorNumber", size);
            jSONObject.put("userAppNum", length);
            jSONObject.put("supportCamera", zHasSystemFeature ? 1 : 0);
            jSONObject.put("supportCameraFlash", zHasSystemFeature2 ? 1 : 0);
            jSONObject.put("hasLightSensor", i);
            jSONObject.put("supportBluetooth", zHasSystemFeature3 ? 1 : 0);
            jSONObject.put("featuresByCgroup", i2);
            jSONObject.put("simState", z2 ? 1 : 2);
            jSONObject.put("supportCallPhone", i3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        lkxssdk.h0.c.b("check emulator:" + string);
        if (!TextUtils.isEmpty(string)) {
            try {
                return new String(Base64.encode(string.getBytes(), 2), "UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        return "";
    }

    public static void a(String str, View view, int i, int i2, lkxssdk.g0.a aVar) {
        if (b()) {
            lkxssdk.e0.c cVarA = lkxssdk.e0.c.a();
            cVarA.getClass();
            lkxssdk.d0.a bVar = view == null ? new lkxssdk.d0.b(str) : new lkxssdk.d0.c(view);
            if (TextUtils.isEmpty(str)) {
                lkxssdk.h0.c.a("FileLoader", "the load image uri is null");
                aVar.a(str, bVar.b(), "the load image uri is null");
                return;
            }
            cVarA.c.a(bVar, str + i);
            Bitmap bitmapA = cVarA.b.f.a(str + i);
            if (bitmapA != null && !bitmapA.isRecycled()) {
                lkxssdk.h0.c.a("FileLoader", "get image from memory cache [" + str + "]");
                cVarA.c.a(bVar);
                aVar.a(str, bVar.b(), bitmapA);
            } else {
                lkxssdk.e0.h hVar = new lkxssdk.e0.h(cVarA.c, cVarA.d, str, bVar, str + i, aVar, cVarA.c.a(str));
                hVar.i = i;
                hVar.j = i2;
                f fVar = cVarA.c;
                fVar.d.execute(new lkxssdk.e0.e(fVar, hVar));
            }
        }
    }

    public static void a(String str, View view, lkxssdk.g0.a aVar) {
        if (b()) {
            lkxssdk.e0.c cVarA = lkxssdk.e0.c.a();
            cVarA.getClass();
            lkxssdk.d0.b bVar = new lkxssdk.d0.b(str);
            if (TextUtils.isEmpty(str)) {
                aVar.a(str, bVar.b(), "the load image uri is null");
                return;
            }
            cVarA.c.e.put(bVar.getId() + "", str);
            Bitmap bitmapA = cVarA.b.f.a(str);
            if (bitmapA != null && !bitmapA.isRecycled()) {
                lkxssdk.h0.c.a("FileLoader", "get image from memory cache [" + str + "]");
                cVarA.c.a(bVar);
                aVar.a(str, bVar.b(), bitmapA);
            } else {
                f fVar = cVarA.c;
                lkxssdk.e0.h hVar = new lkxssdk.e0.h(fVar, cVarA.d, str, bVar, str, aVar, fVar.a(str));
                f fVar2 = cVarA.c;
                fVar2.d.execute(new lkxssdk.e0.e(fVar2, hVar));
            }
        }
    }

    public static void a(String str, View view, int i, lkxssdk.g0.a aVar) {
        if (b()) {
            lkxssdk.e0.c cVarA = lkxssdk.e0.c.a();
            cVarA.getClass();
            lkxssdk.d0.a bVar = view == null ? new lkxssdk.d0.b(str) : new lkxssdk.d0.c(view);
            if (TextUtils.isEmpty(str)) {
                lkxssdk.h0.c.a("FileLoader", "the load video image uri is null");
                aVar.a(str, bVar.b(), "the load video image uri is null");
                return;
            }
            cVarA.c.a(bVar, str + i);
            Bitmap bitmapA = cVarA.b.f.a(str + i);
            if (bitmapA != null && !bitmapA.isRecycled()) {
                lkxssdk.h0.c.a("FileLoader", "get video image from memory cache [" + str + "]");
                cVarA.c.a(bVar);
                aVar.a(str, bVar.b(), bitmapA);
            } else {
                lkxssdk.e0.h hVar = new lkxssdk.e0.h(cVarA.c, cVarA.d, str, bVar, str + i, aVar, cVarA.c.a(str));
                hVar.i = i;
                hVar.j = 0;
                hVar.k = true;
                f fVar = cVarA.c;
                fVar.d.execute(new lkxssdk.e0.e(fVar, hVar));
            }
        }
    }

    public static void a(boolean z) {
        if (a()) {
            h hVar = j.a().c;
            if (!z) {
                synchronized (hVar.h) {
                    hVar.c.clear();
                    hVar.d.clear();
                    Iterator<Map.Entry<String, CountDownTimer>> it = hVar.e.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next().getValue().cancel();
                    }
                    hVar.e.clear();
                    Iterator<g> it2 = hVar.f.iterator();
                    while (it2.hasNext()) {
                        it2.next().l();
                    }
                }
            }
            lkxssdk.w.b bVar = hVar.a;
            bVar.a.set(false);
            bVar.b.set(z);
            synchronized (bVar.c) {
                bVar.c.notifyAll();
            }
        }
    }

    public static void a(b bVar) {
        if (a()) {
            e eVar = j.a().c.i;
            eVar.getClass();
            if (bVar == null || eVar.a.contains(bVar)) {
                return;
            }
            eVar.a.add(bVar);
        }
    }

    public static void a(Activity activity, Class<?> cls, int i, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        intent.putExtra("animType", i);
        activity.startActivity(intent);
        int iA = a(i, true);
        lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
        activity.overridePendingTransition(iA, eVarA.b.getResources().getIdentifier("lkxs_aty_ani_stay", "anim", eVarA.c));
    }

    public static void a(Activity activity, Class<?> cls, int i, int i2, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("animType", i2);
        activity.startActivityForResult(intent, i);
        int iA = a(i2, true);
        lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
        activity.overridePendingTransition(iA, eVarA.b.getResources().getIdentifier("lkxs_aty_ani_stay", "anim", eVarA.c));
    }
}
