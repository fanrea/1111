package com.alliance.ssp.ad.r;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.alliance.ssp.ad.o0.l;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: DownLoadTask.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public static int a;
    public static com.alliance.ssp.ad.m0.b f;
    public static com.alliance.ssp.ad.m0.a g;
    public static ArrayList<String> b = new ArrayList<>();
    public static Map<String, String> c = new HashMap();
    public static Map<String, f> d = new HashMap();
    public static Map<String, g> e = new HashMap();
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;

    /* compiled from: DownLoadTask.java */
    public interface a {
        void a();

        void a(Exception exc);

        void a(String str);

        void b();

        void c();
    }

    /* compiled from: DownLoadTask.java */
    public interface b {
        void a(int i);
    }

    public static HttpURLConnection c(String str) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if (url.getProtocol().toLowerCase().equals("https")) {
                com.alliance.ssp.ad.p.b.a();
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            return httpURLConnection;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        int i2 = l.a;
        try {
            String str2 = (String) ((HashMap) c).get(str);
            if (b.contains(str2)) {
                b.remove(str2);
            }
            ((HashMap) c).remove(str);
            ((HashMap) d).remove(str);
            ((HashMap) e).remove(str);
        } catch (Exception e2) {
            e2.getMessage();
            int i3 = l.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream, java.lang.Object] */
    public static Bitmap b(String e2) {
        Bitmap bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        InputStream inputStream = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                inputStream = e2;
            }
        } catch (Exception e3) {
            e2 = e3;
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnectionC = c(e2);
            httpURLConnectionC.setConnectTimeout(3000);
            e2 = httpURLConnectionC.getInputStream();
        } catch (Exception e4) {
            e = e4;
            e2 = 0;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        try {
            Context contextA = com.alliance.ssp.ad.d0.b.b().a();
            Bitmap.Config config = com.alliance.ssp.ad.o0.c.a;
            contextA.getClass();
            e2.getClass();
            bitmapDecodeStream = BitmapFactory.decodeStream(e2, null, com.alliance.ssp.ad.o0.c.a(contextA));
            e2.close();
            e2 = e2;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            if (e2 != 0) {
                e2.close();
                e2 = e2;
            }
            return bitmapDecodeStream;
        }
        return bitmapDecodeStream;
    }

    public static void a(String str, boolean z) {
        f fVar = (f) ((HashMap) d).get(str);
        g gVar = (g) ((HashMap) e).get(str);
        if (fVar == null || gVar == null) {
            return;
        }
        if (z) {
            fVar.a(gVar.b);
        } else {
            fVar.a(gVar.b, f.h);
        }
    }
}
