package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.on;
import com.qq.e.comm.plugin.ra;
import com.qq.e.comm.plugin.s3;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ct {
    private static final String[] a = {"tbopen://m.taobao.com", "taobao://m.taobao.com"};
    private static long b;

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ ApkDownloadTask b;
        final /* synthetic */ Context c;

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - ct.b < this.a / 3) {
                long unused = ct.b;
                return;
            }
            long unused2 = ct.b = System.currentTimeMillis();
            j3.a(this.b.r()).i = 6;
            ct.b(this.c, this.b, 4);
        }

        d(long j, ApkDownloadTask apkDownloadTask, Context context) {
            this.a = j;
            this.b = apkDownloadTask;
            this.c = context;
        }
    }

    private static void d(Context context, ApkDownloadTask apkDownloadTask) {
        s3.b().a(new c(apkDownloadTask, context));
    }

    public static Intent c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private static void c(ApkDownloadTask apkDownloadTask) {
        Context contextA = r1.d().a();
        if (s3.b().c()) {
            b(contextA, apkDownloadTask, 1);
            return;
        }
        c1.a();
        b(contextA, apkDownloadTask, 2);
        if (s3.b().c()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            c(contextA, apkDownloadTask);
        } else {
            d(contextA, apkDownloadTask);
        }
    }

    public static Intent b(Context context, String str) {
        if (TextUtils.isEmpty(str) || r1.d().f().a("ecglifp", 1) != 1) {
            return null;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
        }
        return launchIntentForPackage;
    }

    private static void c(Context context, ApkDownloadTask apkDownloadTask) {
        long jA = r1.d().f().a("oappdt", 0) * 1000;
        if (jA <= 0) {
            return;
        }
        xo.a(new d(jA, apkDownloadTask, context), jA);
    }

    /* compiled from: A */
    class a extends on.c {
        final /* synthetic */ boolean d;
        final /* synthetic */ ApkDownloadTask e;
        final /* synthetic */ AtomicLong f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, f5 f5Var, boolean z, ApkDownloadTask apkDownloadTask, AtomicLong atomicLong) {
            super(i, f5Var);
            this.d = z;
            this.e = apkDownloadTask;
            this.f = atomicLong;
        }

        @Override // com.qq.e.comm.plugin.on.c, com.qq.e.comm.plugin.s3.g
        public boolean h() throws JSONException {
            super.h();
            if (this.d) {
                j3.a(4002016, this.e, this.f.get());
            }
            b10.a(1100921, null, 1);
            return true;
        }
    }

    /* compiled from: A */
    class b implements ra.b {
        final /* synthetic */ int a;
        final /* synthetic */ Context b;
        final /* synthetic */ ApkDownloadTask c;

        b(int i, Context context, ApkDownloadTask apkDownloadTask) {
            this.a = i;
            this.b = context;
            this.c = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.ra.b
        public void a() throws JSONException {
            b10.a(1100916, null, Integer.valueOf(this.a));
            ct.b(this.b, this.c);
        }

        @Override // com.qq.e.comm.plugin.ra.b
        public void b() {
            b10.a(1100917, null, Integer.valueOf(this.a));
        }
    }

    public static void a(Intent intent, String str, String str2, boolean z) {
        if (intent != null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            int iA = xc.a("oaoiafc", "", 0, com.qq.e.comm.plugin.b.c().d());
            if (iA == 0) {
                return;
            }
            int i = iA % 10;
            int i2 = iA / 10;
            boolean z2 = TextUtils.equals("com.taobao.taobao", str) || m10.b(str2, a);
            if (!z || (i != 2 && (i != 1 || !z2))) {
                if (z) {
                    return;
                }
                if (i2 != 2 && (i2 != 1 || !z2)) {
                    return;
                }
            }
            intent.addFlags(805339136);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, ApkDownloadTask apkDownloadTask) throws JSONException {
        String strF = apkDownloadTask.f();
        boolean zD = a30.d(strF);
        f5 f5VarA = f5.a(apkDownloadTask.v());
        if (zD) {
            j3.a(4002014, apkDownloadTask, 0L);
        } else {
            b10.a(1100515, f5VarA);
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        on.a(new a(zD ? 11 : 10, f5VarA, zD, apkDownloadTask, atomicLong));
        atomicLong.set(SystemClock.elapsedRealtime());
        if (!b(context, a(context, apkDownloadTask.r(), strF)) && !b(context, b(context, apkDownloadTask.r()))) {
            t3.a(apkDownloadTask, false);
            if (zD) {
                j3.a(4002024, apkDownloadTask, 0L);
            } else {
                b10.a(1100517, f5VarA);
            }
            return false;
        }
        t3.a(apkDownloadTask, true);
        if (zD) {
            j3.a(4002015, apkDownloadTask, 0L);
        } else {
            b10.a(1100516, f5VarA);
        }
        if (zD && !a(apkDownloadTask, 4)) {
            h.a(apkDownloadTask.c());
        }
        return true;
    }

    /* compiled from: A */
    class c implements s3.g {
        final /* synthetic */ ApkDownloadTask a;
        final /* synthetic */ Context b;

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            return true;
        }

        c(ApkDownloadTask apkDownloadTask, Context context) {
            this.a = apkDownloadTask;
            this.b = context;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() throws PackageManager.NameNotFoundException {
            boolean zA = ct.a(this.a.r());
            this.a.r();
            if (zA) {
                return true;
            }
            j3.a(this.a.r()).i = 3;
            ct.b(this.b, this.a, 3);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, ApkDownloadTask apkDownloadTask, int i) {
        b10.a(1100925, null, Integer.valueOf(i));
        b10.a(1100915, null, Integer.valueOf(i));
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(apkDownloadTask.p()) ? "应用" : apkDownloadTask.p();
        ra.a(String.format("%s已安装完成，是否立即打开？", objArr), new b(i, context, apkDownloadTask));
    }

    public static String a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return "";
    }

    public static boolean b(Context context, Intent intent) throws JSONException {
        if (context != null && intent != null) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                qc qcVar = new qc(9120011);
                ja jaVar = new ja();
                jaVar.a("ot", e.toString());
                qcVar.a(jaVar);
                b10.a(qcVar);
            }
        }
        return false;
    }

    private static boolean b() {
        return !yh.a("soate") && xc.a("alaai", "APP", "", 1) == 1;
    }

    public static void b(ApkDownloadTask apkDownloadTask) throws JSONException {
        b(r1.d().a(), apkDownloadTask);
    }

    public static Intent a(Context context, String str, String str2) {
        Intent intentC = a30.d(str2) ? c(context, str2) : null;
        Intent intent = a(context, intentC) != null ? intentC : null;
        return intent == null ? b(context, str) : intent;
    }

    public static ResolveInfo a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return null;
        }
        return context.getPackageManager().resolveActivity(intent, 65536);
    }

    public static boolean a(String str) throws PackageManager.NameNotFoundException {
        File file;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Context contextA = r1.d().a();
        int i = contextA.getApplicationInfo().targetSdkVersion;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            return true;
        }
        try {
            if (i2 >= 29 && i >= 29) {
                File parentFile = contextA.getExternalFilesDir(null).getParentFile();
                file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/" + str);
            }
            if (!file.exists()) {
                return false;
            }
            long jLastModified = file.lastModified();
            if (!n3.b()) {
                return true;
            }
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < jLastModified) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void a(ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask != null && b()) {
            c(apkDownloadTask);
        }
    }

    public static boolean a(ApkDownloadTask apkDownloadTask, int i) {
        Object objRemove;
        if (apkDownloadTask == null) {
            return false;
        }
        String strD = apkDownloadTask.d("launchParam");
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(strD).optJSONObject("reportUrl");
            if (jSONObjectOptJSONObject != null && (objRemove = jSONObjectOptJSONObject.remove(String.valueOf(i))) != null) {
                zt.a(objRemove.toString());
                return true;
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return false;
    }
}
