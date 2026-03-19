package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.ss.android.d.d.hc.cb;
import com.ss.android.d.d.hc.de;
import com.ss.android.d.d.hc.jh;
import com.ss.android.d.d.hc.np;
import com.ss.android.d.d.hc.rf;
import com.ss.android.d.d.hc.yo;
import com.ss.android.d.d.u.d;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mq {
    private static com.ss.android.d.d.hc.tt an;
    private static com.ss.android.d.d.hc.h b;
    private static com.ss.android.d.d.hc.b c;
    private static np cb;
    public static final JSONObject d = new JSONObject();
    private static de de;
    private static com.ss.android.d.d.hc.uo e;
    private static com.ss.android.d.d.hc.mq gb;
    private static com.ss.android.d.d.hc.tc h;
    private static Context hc;
    private static com.ss.android.d.d.c.d jh;
    private static yo k;
    private static com.ss.android.socialbase.appdownloader.b.tt mk;
    private static com.ss.android.d.d.hc.c mq;
    private static rf rf;
    private static jh sy;
    private static com.ss.android.d.d.hc.hc tc;
    private static com.ss.android.d.d.u.d tt;
    private static com.ss.android.d.d.hc.k u;
    private static com.ss.android.d.d.hc.u uo;
    private static com.ss.android.d.d.hc.mk v;
    private static cb w;
    private static com.ss.android.d.d.hc.e yo;

    public static String k() {
        return "1.7.0";
    }

    public static void d(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        hc = context.getApplicationContext();
    }

    public static void hc(Context context) {
        if (hc != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        hc = context.getApplicationContext();
    }

    public static Context getContext() {
        Context context = hc;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void d(com.ss.android.d.d.hc.h hVar) {
        b = hVar;
    }

    public static void d(com.ss.android.d.d.hc.k kVar) {
        u = kVar;
    }

    public static void d(com.ss.android.d.d.hc.tt ttVar) {
        an = ttVar;
    }

    public static void d(com.ss.android.d.d.hc.tc tcVar) {
        h = tcVar;
    }

    public static void d(com.ss.android.d.d.hc.mq mqVar) {
        gb = mqVar;
    }

    public static void d(com.ss.android.d.d.u.d dVar) {
        tt = dVar;
    }

    public static void d(com.ss.android.d.d.hc.hc hcVar) {
        tc = hcVar;
    }

    public static com.ss.android.d.d.hc.h d() {
        return b;
    }

    public static com.ss.android.d.d.hc.b hc() {
        if (c == null) {
            c = new com.ss.android.d.d.hc.b() { // from class: com.ss.android.downloadlib.addownload.mq.1
            };
        }
        return c;
    }

    public static com.ss.android.d.d.hc.k b() {
        if (u == null) {
            u = new com.ss.android.d.d.d.d();
        }
        return u;
    }

    public static com.ss.android.d.d.hc.tt c() {
        return an;
    }

    public static com.ss.android.d.d.hc.tc u() {
        if (h == null) {
            h = new com.ss.android.d.d.d.hc();
        }
        return h;
    }

    public static com.ss.android.socialbase.appdownloader.b.tt an() {
        if (mk == null) {
            mk = new com.ss.android.socialbase.appdownloader.b.tt() { // from class: com.ss.android.downloadlib.addownload.mq.2
                @Override // com.ss.android.socialbase.appdownloader.b.tt
                public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i) {
                }
            };
        }
        return mk;
    }

    public static yo h() {
        return k;
    }

    public static rf gb() {
        if (rf == null) {
            rf = new rf() { // from class: com.ss.android.downloadlib.addownload.mq.3
            };
        }
        return rf;
    }

    public static JSONObject tt() {
        com.ss.android.d.d.hc.mq mqVar = gb;
        if (mqVar == null || mqVar.d() == null) {
            return d;
        }
        return gb.d();
    }

    public static com.ss.android.d.d.u.d tc() {
        if (tt == null) {
            tt = new d.C0749d().d();
        }
        return tt;
    }

    public static com.ss.android.d.d.hc.e mk() {
        return yo;
    }

    public static com.ss.android.d.d.hc.hc mq() {
        return tc;
    }

    public static cb uo() {
        return w;
    }

    public static void d(String str) {
        com.ss.android.socialbase.appdownloader.c.mk().d(str);
    }

    public static void d(com.ss.android.socialbase.appdownloader.b.b bVar) {
        com.ss.android.socialbase.appdownloader.c.mk().d(bVar);
    }

    public static com.ss.android.d.d.hc.c e() {
        return mq;
    }

    public static com.ss.android.d.d.hc.u cb() {
        return uo;
    }

    public static com.ss.android.d.d.hc.uo w() {
        return e;
    }

    public static void d(jh jhVar) {
        sy = jhVar;
    }

    public static jh yo() {
        return sy;
    }

    public static np rf() {
        return cb;
    }

    public static void d(com.ss.android.d.d.c.d dVar) {
        jh = dVar;
    }

    public static com.ss.android.d.d.c.d jh() {
        if (jh == null) {
            jh = new com.ss.android.d.d.c.d() { // from class: com.ss.android.downloadlib.addownload.mq.4
                @Override // com.ss.android.d.d.c.d
                public void d(Throwable th, String str) {
                }
            };
        }
        return jh;
    }

    public static de sy() {
        if (de == null) {
            de = new de() { // from class: com.ss.android.downloadlib.addownload.mq.5
            };
        }
        return de;
    }

    public static void d(com.ss.android.d.d.hc.mk mkVar) {
        v = mkVar;
    }

    public static com.ss.android.d.d.hc.mk de() {
        return v;
    }

    public static String v() {
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + tt().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean np() {
        return (b == null || an == null || gb == null || tc == null || sy == null) ? false : true;
    }
}
