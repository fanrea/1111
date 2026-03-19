package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ca {
    public static final String a = "ApkLoader";
    protected static Thread.UncaughtExceptionHandler b = null;
    public static final String c = "__badApkVersion__9.40";
    public static final String d = "previousProxyVersion";
    protected static final String e = "__xadsdk__remote__final__";
    protected static final String f = "bdxadsdk.jar";
    protected static final String g = "__xadsdk__remote__final__builtin__.jar";
    protected static final String h = "__xadsdk__remote__final__builtinversion__.jar";
    protected static final String i = "__xadsdk__remote__final__downloaded__.jar";
    protected static final String j = "__xadsdk__remote__final__running__.jar";
    public static final String k = "OK";
    public static final String l = "ERROR";
    public static final String m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    protected static volatile bp p = null;
    protected static volatile bp q = null;
    protected static volatile Class r = null;
    protected static String s = null;
    protected static final Handler t = new cb(Looper.getMainLooper());
    private static final String x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;
    protected Handler u;
    protected final Handler v;
    private by w;
    private final Context y;
    private bu z;

    public interface c {
        void a(boolean z);
    }

    public final String a() {
        return "9.40";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] fileArrListFiles = this.y.getFilesDir().listFiles();
            int i2 = 0;
            while (fileArrListFiles != null) {
                if (i2 >= fileArrListFiles.length) {
                    return;
                }
                if (fileArrListFiles[i2].getAbsolutePath().contains(e) && fileArrListFiles[i2].getAbsolutePath().endsWith("dex")) {
                    fileArrListFiles[i2].delete();
                }
                i2++;
            }
        } catch (Exception e2) {
            bu.a().c(e2);
        }
    }

    public ca(Activity activity) {
        this(activity.getApplicationContext());
    }

    public ca(Context context) {
        this.z = bu.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new cc(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = co.a(context);
            co.a(context).a(new cd(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof co) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.y.getSharedPreferences(z.aL, 0);
    }

    protected void b() {
        new File(f()).delete();
    }

    protected void a(String str) {
        if (p != null) {
            SharedPreferences.Editor editorEdit = m().edit();
            editorEdit.putFloat(c, (float) p.b);
            editorEdit.apply();
        }
    }

    private boolean n() {
        String string = m().getString(d, null);
        return string == null || !string.equals(a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message messageObtainMessage = this.u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.what = 0;
        this.u.sendMessage(messageObtainMessage);
    }

    protected static String c() {
        return TextUtils.isEmpty(s) ? "" : s + g;
    }

    protected static String d() {
        return TextUtils.isEmpty(s) ? "" : s + h;
    }

    protected void e() throws b {
        this.z.a(a, "start load assets file");
        d(this.y);
        String strC = c();
        bt btVar = new bt(strC, this.y);
        if (bs.a(btVar)) {
            this.z.a(a, "assets file can read ,will use it ");
            if (c(btVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + strC);
    }

    private static synchronized void d(Context context) {
        try {
            String strC = c();
            double dB = b(strC);
            bu.a().a(a, "copy assets,compare version=" + Double.valueOf("9.40") + "remote=" + dB);
            if (Double.valueOf("9.40").doubleValue() != dB) {
                bt btVar = new bt(strC, context);
                if (btVar.exists()) {
                    btVar.delete();
                }
                bs.a(context, f, strC);
            }
        } catch (Exception e2) {
            throw new b("loadBuiltInApk failed: " + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bt btVar) {
        Class<?> clsB = btVar.b();
        synchronized (this) {
            q = new bp(clsB, this.y);
        }
    }

    private void b(bt btVar) throws Throwable {
        this.z.a(a, "len=" + btVar.length() + ", path=" + btVar.getAbsolutePath());
        if (p == null) {
            String strA = a(this.y);
            bt btVar2 = new bt(strA, this.y);
            if (btVar2.exists()) {
                btVar2.delete();
            }
            try {
                bs.a(new FileInputStream(btVar), strA);
            } catch (Exception e2) {
                this.z.c(e2);
            }
            p = new bp(btVar2.b(), this.y);
            try {
                this.z.a(a, "preloaded apk.version=" + p.a().getRemoteVersion());
                return;
            } catch (a e3) {
                this.z.a(a, "preload local apk " + btVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.z.a(a, "mApkBuilder already initialized, version: " + p.b);
    }

    private boolean c(bt btVar) {
        synchronized (this) {
            b(btVar);
            this.z.a(a, "loaded: " + btVar.getPath());
        }
        return true;
    }

    private boolean o() {
        try {
            if (!bs.a(c())) {
                if (!bs.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!z && !o()) {
            this.A = true;
        } else {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            be.a().a((j) new ce(this, z));
        } else {
            be.a().a(new cf(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d2 = 0.0d;
        }
        ao.a(d2, new cg(this, d2), new ch(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str) {
        try {
            co.a(this.y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
        return TextUtils.isEmpty(s) ? "" : s + j;
    }

    protected static String f() {
        return TextUtils.isEmpty(s) ? "" : s + i;
    }

    protected void g() throws a {
        if (h() != 2 ? p() : false) {
            this.z.a(a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.z.a(a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    public int h() {
        return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() throws a {
        bt btVar = new bt(f(), this.y);
        if (!bs.a(btVar)) {
            return false;
        }
        try {
            if (n()) {
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            }
            synchronized (this) {
                this.z.a(a, "loadDownloadedOrBuiltInApk len=" + btVar.length() + ", path=" + btVar.getAbsolutePath());
                b(btVar);
                double d2 = m().getFloat(c, -1.0f);
                this.z.a(a, "downloadedApkFile.getApkVersion(): " + btVar.c() + ", badApkVersion: " + d2);
                if (btVar.c() == d2) {
                    throw new a("downloaded file marked bad, drop it and use built-in");
                }
                this.z.a(a, "loaded: " + btVar.getPath());
            }
            return true;
        } catch (a e2) {
            this.z.a(a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
            if (btVar.exists()) {
                btVar.delete();
            }
            k();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(by byVar) {
        if (byVar.a().booleanValue()) {
            bw bwVarA = bw.a(this.y, byVar, s, this.v);
            if (!bwVarA.isAlive()) {
                this.z.a(a, "XApkDownloadThread starting ...");
                bwVarA.start();
            } else {
                this.z.a(a, "XApkDownloadThread already started");
                bwVarA.a(byVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) throws a {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    public void a(c cVar, Handler handler) {
        be.a().a((j) new ci(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, t);
    }

    public IXAdContainerFactory i() {
        return a(p);
    }

    public IXAdContainerFactory j() {
        return a(q);
    }

    private IXAdContainerFactory a(bp bpVar) {
        if (bpVar == null) {
            return null;
        }
        try {
            return bpVar.a();
        } catch (Exception unused) {
            return null;
        }
    }

    protected void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }

    public static final class a extends Exception {
        private static final long a = 2978543166232984104L;

        public a(String str) {
            bu.a().c(str);
        }
    }

    protected static final class b extends Exception {
        private static final long a = -7838296421993681751L;

        public b(String str) {
            bu.a().c(str);
        }
    }

    public static double b(Context context) throws Throwable {
        try {
            c(context);
            double dB = b(f());
            String strD = d();
            if (Double.valueOf("9.40").doubleValue() > b(strD)) {
                bt btVar = new bt(strD, context);
                if (btVar.exists()) {
                    btVar.delete();
                }
                bs.a(context, f, strD);
            }
            return Math.max(dB, b(d()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static double b(String str) throws Throwable {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!cn.d.booleanValue()) {
            return Double.valueOf("9.40").doubleValue();
        }
        File file = new File(str);
        if (bs.a(file)) {
            JarFile jarFile2 = new JarFile(file);
            try {
                double d2 = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                if (d2 > 0.0d) {
                    try {
                        jarFile2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return d2;
                }
                jarFile = jarFile2;
            } catch (Exception unused2) {
                jarFile = jarFile2;
                if (jarFile != null) {
                    jarFile.close();
                }
                return 0.0d;
            } catch (Throwable th2) {
                th = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        if (jarFile != null) {
            jarFile.close();
        }
        return 0.0d;
    }
}
