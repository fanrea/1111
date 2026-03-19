package com.fc.tjcpl.sdk.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.baidu.mobstat.forbes.Config;
import com.fc.tjcpl.sdk.TJListener;
import com.fc.tjcpl.sdk.c.e;
import com.fc.tjcpl.sdk.c.g;
import com.fc.tjcpl.sdk.c.h;
import com.fc.tjcpl.sdk.c.j;
import com.fc.tjcpl.sdk.l.f;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    public static Application a;
    public static TreeMap<String, String> b;
    public static String c;
    public static String d;
    public static String e;
    public static TJListener f;

    public static int a(float f2) {
        return (int) ((f2 * b().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
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

    public static Bitmap a(Uri uri, int i) throws IOException {
        BitmapFactory.Options options;
        ContentResolver contentResolver;
        InputStream inputStreamOpenInputStream;
        Bitmap bitmapDecodeStream;
        Bitmap bitmap = null;
        try {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            contentResolver = b().getContentResolver();
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
        } catch (IOException e2) {
            e = e2;
        }
        try {
            int i2 = options.outWidth;
            if (i2 > i && i > 0) {
                options.inSampleSize = i2 / i;
            }
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            inputStreamOpenInputStream.close();
            return BitmapFactory.decodeStream(contentResolver.openInputStream(uri), null, options);
        } catch (IOException e3) {
            e = e3;
            bitmap = bitmapDecodeStream;
            e.printStackTrace();
            return bitmap;
        }
    }

    public static String a(long j) {
        StringBuilder sbAppend;
        String str;
        if (j < 1024) {
            sbAppend = new StringBuilder().append(j);
            str = "B";
        } else if (j < 1048576) {
            sbAppend = new StringBuilder().append(j / 1024);
            str = "KB";
        } else if (j < 1073741824) {
            sbAppend = new StringBuilder().append(String.format("%.1f", Float.valueOf(j / 1048576.0f)));
            str = "MB";
        } else {
            sbAppend = new StringBuilder().append(String.format("%.2f", Float.valueOf(j / 1.0737418E9f)));
            str = "GB";
        }
        return sbAppend.append(str).toString();
    }

    public static String a(Context context, int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(boolean z, String str) {
        StringBuilder sb;
        String str2;
        if (TextUtils.isEmpty(str) || !str.startsWith("//")) {
            return str;
        }
        if (z) {
            sb = new StringBuilder();
            str2 = "https:";
        } else {
            sb = new StringBuilder();
            str2 = "http:";
        }
        return sb.append(str2).append(str).toString();
    }

    public static HashMap<String, String> a(Context context) {
        String str;
        HashMap<String, String> map = new HashMap<>();
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if (packageManager.getLaunchIntentForPackage(packageInfo.applicationInfo.packageName) != null || (packageInfo.applicationInfo.flags & 1) == 0) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) == 0) {
                    String strTrim = ((String) applicationInfo.loadLabel(packageManager)).trim();
                    if (TextUtils.isEmpty(strTrim)) {
                        str = "";
                        map.put(packageInfo.applicationInfo.packageName, str);
                    } else {
                        try {
                            str = new String(Base64.encode(strTrim.getBytes(), 2), "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        map.put(packageInfo.applicationInfo.packageName, str);
                    }
                }
            }
        }
        return map;
    }

    public static void a(Application application) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (application == null) {
            application = c();
        }
        a = application;
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(com.fc.tjcpl.sdk.f.a aVar) {
        if (a()) {
            h hVar = j.a().b;
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
                com.fc.tjcpl.sdk.i.c.c("DownloadTaskManager", "appID:" + aVar.a + " DownloadTask is exit");
            } else {
                com.fc.tjcpl.sdk.i.c.c("DownloadTaskManager", "appID:" + aVar.a + " create new DownloadTask");
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
        return TextUtils.isEmpty(str) || !new File(str).exists() || b().getPackageManager().getPackageArchiveInfo(str, 1) == null;
    }

    public static Application b() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Application application = a;
        if (application != null) {
            return application;
        }
        Application applicationC = c();
        a(applicationC);
        return applicationC;
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

    public static void b(Context context, String str) {
        com.fc.tjcpl.sdk.i.c.a("packageName:" + str);
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DELETE");
            intent.addFlags(268435456);
            intent.setData(Uri.parse("package:" + str));
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            Intent intent2 = new Intent();
            intent2.addFlags(268435456);
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.parse("package:" + str));
            context.startActivity(intent2);
        }
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (b().getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static Application c() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
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

    public static void c(String str) {
        if (a()) {
            h hVar = j.a().b;
            String strA = hVar.a(str, "");
            synchronized (hVar.h) {
                g gVarA = hVar.a(strA, hVar.f);
                if (gVarA != null) {
                    gVarA.e();
                }
            }
        }
    }

    public static com.fc.tjcpl.sdk.a.a d(String str) throws JSONException {
        com.fc.tjcpl.sdk.a.a aVar = new com.fc.tjcpl.sdk.a.a();
        if (TextUtils.isEmpty(str)) {
            aVar.a = 2;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                boolean zOptBoolean = jSONObject.optBoolean("IMEIStatus", false);
                aVar.a = zOptBoolean ? 1 : 0;
                if (zOptBoolean) {
                    aVar.b = jSONObject.optString("Token", "");
                    aVar.e = jSONObject.optString("IDTask", "");
                    aVar.f = jSONObject.optString("AppName", "");
                    aVar.g = jSONObject.optString("CredentialID", "");
                    aVar.h = jSONObject.optString("UrlDownload", "");
                    aVar.c = jSONObject.optInt("DownloadType", 2);
                    aVar.d = jSONObject.optInt("PlatformType", 1);
                    aVar.r = jSONObject.optInt("IngState", 0);
                    aVar.o = jSONObject.optBoolean("isAuth", false);
                    aVar.p = jSONObject.optBoolean("FileUniqueOpen", false);
                    aVar.q = new ArrayList();
                    aVar.s = jSONObject.optString("unselectedColor", "#0098FF");
                    aVar.t = jSONObject.optString("selectedColor", "#0086E1");
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("FileUniqueVal");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            aVar.q.add(jSONArrayOptJSONArray.get(i).toString().toLowerCase());
                        }
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SdkCfg");
                    if (jSONObjectOptJSONObject != null) {
                        JSONObject jSONObject2 = jSONObjectOptJSONObject.getJSONObject("AutoDownload");
                        if (jSONObject2 != null) {
                            aVar.i = jSONObject2.optInt(com.baidu.mobads.container.util.e.a.a, 0);
                            aVar.j = jSONObject2.optInt("nowifi", 0);
                        }
                        JSONObject jSONObject3 = jSONObjectOptJSONObject.getJSONObject("PauseDownload");
                        if (jSONObject3 != null) {
                            aVar.k = jSONObject3.optInt(com.baidu.mobads.container.util.e.a.a, 0);
                            aVar.l = jSONObject3.optInt("nowifi", 0);
                        }
                        JSONObject jSONObject4 = jSONObjectOptJSONObject.getJSONObject("AutoOpen");
                        if (jSONObject4 != null) {
                            aVar.m = jSONObject4.optInt(com.baidu.mobads.container.util.e.a.a, 0);
                            aVar.n = jSONObject4.optInt("nowifi", 0);
                        }
                    }
                }
                if (aVar.a == 1 && (TextUtils.isEmpty(aVar.e) || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.g) || TextUtils.isEmpty(aVar.h))) {
                    aVar.a = 2;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (aVar.a == 2) {
            f.a().a("数据错误无法体验", 0);
        }
        return aVar;
    }

    public static String d() {
        return ((TelephonyManager) b().getSystemService("phone")).getDeviceId();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r0.equalsIgnoreCase("CDMA2000") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fc.tjcpl.sdk.g.c e() {
        /*
            com.fc.tjcpl.sdk.g.c r0 = com.fc.tjcpl.sdk.g.c.NETWORK_NO
            android.app.Application r1 = b()
            java.lang.String r2 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L59
            boolean r2 = r1.isAvailable()
            if (r2 == 0) goto L59
            int r0 = r1.getType()
            r2 = 1
            if (r0 != r2) goto L24
            com.fc.tjcpl.sdk.g.c r0 = com.fc.tjcpl.sdk.g.c.NETWORK_WIFI
            goto L59
        L24:
            int r0 = r1.getType()
            if (r0 != 0) goto L57
            int r0 = r1.getSubtype()
            switch(r0) {
                case 1: goto L51;
                case 2: goto L51;
                case 3: goto L54;
                case 4: goto L51;
                case 5: goto L54;
                case 6: goto L54;
                case 7: goto L51;
                case 8: goto L54;
                case 9: goto L54;
                case 10: goto L54;
                case 11: goto L51;
                case 12: goto L54;
                case 13: goto L4e;
                case 14: goto L54;
                case 15: goto L54;
                case 16: goto L51;
                case 17: goto L54;
                case 18: goto L4e;
                case 19: goto L4e;
                default: goto L31;
            }
        L31:
            java.lang.String r0 = r1.getSubtypeName()
            java.lang.String r1 = "TD-SCDMA"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L54
            java.lang.String r1 = "WCDMA"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L54
            java.lang.String r1 = "CDMA2000"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L57
            goto L54
        L4e:
            com.fc.tjcpl.sdk.g.c r0 = com.fc.tjcpl.sdk.g.c.NETWORK_4G
            goto L59
        L51:
            com.fc.tjcpl.sdk.g.c r0 = com.fc.tjcpl.sdk.g.c.NETWORK_2G
            goto L59
        L54:
            com.fc.tjcpl.sdk.g.c r0 = com.fc.tjcpl.sdk.g.c.NETWORK_3G
            goto L59
        L57:
            com.fc.tjcpl.sdk.g.c r0 = com.fc.tjcpl.sdk.g.c.NETWORK_UNKNOWN
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.b.a.e():com.fc.tjcpl.sdk.g.c");
    }

    public static String e(String str) {
        return "state_" + c + Config.replace + e + Config.replace + str;
    }

    public static Bitmap f(String str) {
        Bitmap bitmapDecodeFile;
        int attributeInt;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        int i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            bitmapDecodeFile = BitmapFactory.decodeFile(str);
        } catch (Exception e3) {
            e3.printStackTrace();
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null || i <= 0) {
            return bitmapDecodeFile;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
    }

    public static boolean f() {
        return (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) ? false : true;
    }

    public static String g(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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

    public static boolean g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) b().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static int h(String str) {
        int i = -1;
        if (a()) {
            h hVar = j.a().b;
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
                        com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + gVarA.a.a + ",TaskStatus:" + i2);
                        i = i2;
                    }
                }
            }
        }
        return i;
    }

    public static boolean h() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0;
    }

    public static void i(String str) {
        if (a()) {
            h hVar = j.a().b;
            String strA = hVar.a(str, "");
            synchronized (hVar.h) {
                g gVarA = hVar.a(strA, hVar.f);
                if (gVarA != null) {
                    gVarA.i();
                }
            }
        }
    }

    public static void j(String str) {
        Uri uriFromFile;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(1);
                uriFromFile = FileProvider.getUriForFile(b(), b().getPackageName() + ".tjfileprovider", file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
            intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
            intent.addFlags(335544320);
            b().startActivity(intent);
        }
    }

    public static void k(String str) {
        if (a()) {
            h hVar = j.a().b;
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
                        com.fc.tjcpl.sdk.i.c.b("DownloadTaskManager", "doingMap not has the task url:" + str);
                    }
                }
            }
        }
    }

    public static void l(String str) {
        if (a()) {
            h hVar = j.a().b;
            hVar.getClass();
            com.fc.tjcpl.sdk.i.c.b("DownloadTaskManager", "start url:" + str);
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(hVar.a.d.a, "下载地址不能为空", 1).show();
                return;
            }
            if (!str.startsWith(com.alipay.sdk.m.l.a.r) && !str.startsWith("//")) {
                hVar.i.a(new com.fc.tjcpl.sdk.f.a(str), new com.fc.tjcpl.sdk.e.a(1, 12));
                return;
            }
            String strA = hVar.a(str, "");
            synchronized (hVar.h) {
                g gVar = hVar.d.get(strA);
                if (gVar != null) {
                    com.fc.tjcpl.sdk.i.c.b("DownloadTaskManager", "appID:" + gVar.b.i.a + ",正在下载中");
                } else {
                    g gVarA = hVar.a(strA, hVar.c);
                    if (gVarA != null) {
                        hVar.i.b(gVarA.b.i);
                        com.fc.tjcpl.sdk.i.c.c("DownloadTaskManager", "appID:" + gVarA.b.i.a + ",待下载中");
                    } else {
                        g gVarA2 = hVar.a(strA, hVar.f);
                        if (gVarA2 == null) {
                            Toast.makeText(hVar.a.d.a, "请先添加下载任务", 1).show();
                        } else {
                            com.fc.tjcpl.sdk.i.c.c("DownloadTaskManager", "appID:" + gVarA2.b.i.a + ",cacheMemory exit the downTask");
                            int size = hVar.d.entrySet().size();
                            if (size < hVar.b.c) {
                                hVar.d.put(strA, gVarA2);
                                com.fc.tjcpl.sdk.i.c.c("DownloadTaskManager", "appID:" + gVarA2.b.i.a + ",to submit,maxDownloadTaskSize:" + hVar.b.c + ",runTaskSize:" + size);
                                gVarA2.a(false);
                                hVar.a.d.i.execute(gVarA2);
                            } else {
                                hVar.c.add(gVarA2);
                                gVarA2.b.h = 1;
                                com.fc.tjcpl.sdk.i.c.c("DownloadTaskManager", "appID:" + gVarA2.b.i.a + ",to wait,maxDownloadTaskSize:" + hVar.b.c + ",runTaskSize:" + size);
                                hVar.i.b(gVarA2.b.i);
                            }
                        }
                    }
                }
            }
        }
    }

    public static g b(com.fc.tjcpl.sdk.f.a aVar) {
        if (!a()) {
            return null;
        }
        h hVar = j.a().b;
        hVar.getClass();
        if (aVar == null || TextUtils.isEmpty(aVar.b)) {
            return null;
        }
        return hVar.a(hVar.a(aVar.b, aVar.c), hVar.f);
    }

    public static void b(Context context) {
        Intent intent;
        String str = com.fc.tjcpl.sdk.k.c.a;
        if (str.contains("huawei")) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
                if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                    intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                }
            }
        } else if (str.contains("xiaomi")) {
            intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.putExtra("extra_pkgname", context.getPackageName());
            if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                intent.setPackage("com.miui.securitycenter");
                if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                    intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                    if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                    }
                }
            }
        } else if (str.contains("oppo")) {
            intent = new Intent();
            intent.putExtra("packageName", context.getPackageName());
            intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
            if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
                if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                    intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
                }
            }
        } else if (str.contains("vivo")) {
            intent = new Intent();
            intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
            intent.putExtra("packagename", context.getPackageName());
            if (!com.fc.tjcpl.sdk.k.c.a(context, intent)) {
                intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
            }
        } else if (str.contains("meizu")) {
            intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        } else {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        }
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", context.getPackageName(), null));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public static boolean a() {
        if (j.a().a != null) {
            return true;
        }
        com.fc.tjcpl.sdk.i.c.a("AppLoader please init AppLoader first");
        return false;
    }

    public static HttpURLConnection a(com.fc.tjcpl.sdk.j.c cVar) throws ProtocolException, NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(cVar.a);
        if (cVar.a.toLowerCase().startsWith("https")) {
            httpURLConnection = (HttpsURLConnection) url.openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new com.fc.tjcpl.sdk.j.a()}, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier(new com.fc.tjcpl.sdk.j.b());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(cVar.b);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setReadTimeout(5000);
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

    public static void b(com.fc.tjcpl.sdk.e.b bVar) {
        if (a()) {
            e eVar = j.a().b.i;
            eVar.getClass();
            if (bVar == null || !eVar.a.contains(bVar)) {
                return;
            }
            eVar.a.remove(bVar);
        }
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

    public static void a(boolean z) {
        if (a()) {
            h hVar = j.a().b;
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
            com.fc.tjcpl.sdk.c.b bVar = hVar.a;
            bVar.a.set(false);
            bVar.b.set(z);
            synchronized (bVar.c) {
                bVar.c.notifyAll();
            }
        }
    }

    public static void a(com.fc.tjcpl.sdk.e.b bVar) {
        if (a()) {
            e eVar = j.a().b.i;
            eVar.getClass();
            if (bVar == null || eVar.a.contains(bVar)) {
                return;
            }
            eVar.a.add(bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x013b A[PHI: r4
  0x013b: PHI (r4v8 java.lang.String) = (r4v7 java.lang.String), (r4v10 java.lang.String), (r4v10 java.lang.String) binds: [B:32:0x00ff, B:34:0x010d, B:41:0x0130] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.net.Uri.Builder r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.b.a.a(android.net.Uri$Builder, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
