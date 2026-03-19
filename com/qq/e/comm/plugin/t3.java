package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import java.io.File;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t3 extends j3 {
    private static final long b = r1.d().f().a("appito", "", 15) * 86400000;

    public static boolean d() {
        long jA = yy.a("app_installed_time", 0L);
        return jA != 0 && System.currentTimeMillis() - jA < b;
    }

    public static boolean e() {
        return yy.a("haingogd", false);
    }

    public static void f() {
        yy.b("ainsc", yy.a("ainsc", 0) + 1);
        yy.b("ainst", System.currentTimeMillis());
    }

    public static void g() {
        yy.b("haingogd", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        yy.b("app_installed_time", System.currentTimeMillis());
    }

    public static void i() {
        int i = ((((d() ? 1 : 2) * 10) + (c() ? 1 : 2)) * 10) + (e() ? 1 : 2);
        int iB = b();
        if (iB >= 100) {
            iB = 100;
        }
        b10.a(9200003, null, Integer.valueOf(i), Integer.valueOf(iB), null);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask == null) {
            apkDownloadTask = new ApkDownloadTask("");
        }
        a(i, Integer.valueOf(apkDownloadTask.x() ? 1 : 0), apkDownloadTask);
    }

    public static void a(int i, Integer num, ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask == null) {
            apkDownloadTask = new ApkDownloadTask("");
        }
        b10.a(i, c(apkDownloadTask), num, Integer.valueOf(b(apkDownloadTask.r())), null);
    }

    private static int c(String str) {
        int iA = ym.a();
        if (TextUtils.isEmpty(str)) {
            return iA;
        }
        v20 v20VarA = j3.a(str);
        return iA + (v20VarA.f * 10) + (v20VarA.d * 100);
    }

    protected static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        v20 v20VarA = j3.a(str);
        return v20VarA.i + (v20VarA.h * 10) + (v20VarA.g * 100) + (v20VarA.e * 1000) + ((v20VarA.a ? 2 : 1) * 10000);
    }

    public static void a(ApkDownloadTask apkDownloadTask, int i, String str) throws JSONException {
        f5 f5VarC = c(apkDownloadTask);
        ja jaVar = new ja();
        jaVar.a("msg", str);
        jaVar.a("url", apkDownloadTask.s());
        jaVar.a("pkgName", apkDownloadTask.r());
        b10.a(1100938, f5VarC, 0, Integer.valueOf(i), jaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f5 c(ApkDownloadTask apkDownloadTask) {
        return f5.a(apkDownloadTask.v());
    }

    /* compiled from: A */
    public static class a implements c.a {
        private final c.a a;
        private final ApkDownloadTask b;
        private final long c = System.currentTimeMillis();
        private final String d;

        public a(ApkDownloadTask apkDownloadTask, c.a aVar) {
            this.a = aVar;
            this.b = apkDownloadTask;
            this.d = apkDownloadTask.r();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            c.a aVar = this.a;
            return aVar != null && aVar.a();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i, String str, boolean z) throws JSONException {
            c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(i, str, z);
            }
            if (i == 0) {
                if (this.b.b("appStore") == 0) {
                    t3.h();
                    t3.b(this.b, this.d);
                }
                t3.c(1100906, this.b);
                wt wtVar = new wt(2030016);
                wtVar.b((System.currentTimeMillis() - this.c) / 1000);
                wtVar.a(t3.c(this.b));
                b10.a(wtVar);
            }
        }
    }

    public static void a(String str, int i, f5 f5Var) {
        b10.a(i, f5Var, Integer.valueOf(j3.a(str).g), Integer.valueOf(b(str)), null);
    }

    public static void b(ApkDownloadTask apkDownloadTask, int i, int i2, String str, long j) throws JSONException {
        f5 f5VarC = c(apkDownloadTask);
        ja jaVar = new ja();
        jaVar.a("msg", str);
        jaVar.a("url", apkDownloadTask.s());
        jaVar.a("pkgName", apkDownloadTask.r());
        jaVar.a("data", Long.valueOf(j));
        b10.a(9120021, f5VarC, Integer.valueOf(i), Integer.valueOf(i2), jaVar);
    }

    public static void c(int i, ApkDownloadTask apkDownloadTask) {
        b(i, apkDownloadTask, b(apkDownloadTask.r()));
    }

    private static boolean c() {
        long jA = yy.a("ainst", 0L);
        if (jA == 0) {
            return false;
        }
        if (System.currentTimeMillis() - jA < b) {
            return true;
        }
        if (yy.a("ainsc", 0) > 0) {
            yy.b("ainsc", 0);
        }
        return false;
    }

    public static void b(int i, ApkDownloadTask apkDownloadTask, int i2) {
        a(i, apkDownloadTask, i2, (ja) null);
    }

    public static void a(ApkDownloadTask apkDownloadTask, int i, int i2, String str, long j) throws JSONException {
        f5 f5VarC = c(apkDownloadTask);
        ja jaVar = new ja();
        jaVar.a("msg", str);
        jaVar.a("url", apkDownloadTask.s());
        jaVar.a("pkgName", apkDownloadTask.r());
        jaVar.a("data", Long.valueOf(j));
        b10.a(9120019, f5VarC, Integer.valueOf(i2), Integer.valueOf(i), jaVar);
    }

    public static void a(int i, String str, ApkDownloadTask apkDownloadTask, File file) throws JSONException {
        int length;
        ja jaVar = new ja();
        jaVar.a("download_scene", Integer.valueOf(j3.a(apkDownloadTask.r()).b));
        if ((i == 0 || i == 9) && file != null && file.exists() && (length = (int) (file.length() >> 10)) > 0) {
            jaVar.a("as", Integer.valueOf(length));
        }
        if (!TextUtils.isEmpty(str)) {
            jaVar.a("msg", str);
        } else if (i != 0) {
            jaVar.a("msg", "code=" + i);
        }
        b10.a(i == 0 ? 1100903 : i == 7 ? 1100931 : i == 8 ? 1100932 : i == 9 ? 1100933 : 1100904, c(apkDownloadTask), Integer.valueOf(apkDownloadTask.x() ? 1 : 0), Integer.valueOf(b(apkDownloadTask.r())), jaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void b(ApkDownloadTask apkDownloadTask, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = r1.d().f().b("apksiw", "");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        String strA = q.a(r1.d().a(), str);
        int i = 1;
        if (TextUtils.isEmpty(strA)) {
            b10.a(9200015, null, 0, 1, new ja().a("pkgName", apkDownloadTask.r()));
            return;
        }
        if (TextUtils.equals(strA, r1.d().b().b())) {
            return;
        }
        f5 f5VarC = c(apkDownloadTask);
        ja jaVar = new ja();
        jaVar.a("msg", strA);
        jaVar.a("url", apkDownloadTask.s());
        jaVar.a("pkgName", apkDownloadTask.r());
        String[] strArrC = ap.c();
        if (strArrC != null && strArrC.length > 0) {
            for (String str2 : strArrC) {
                if (TextUtils.equals(str2, strA)) {
                    b10.a(9200015, f5VarC, 2, 2, jaVar);
                    return;
                }
            }
            i = 3;
        }
        String[] strArrSplit = strB.split(":");
        if (strArrSplit == 0 || strArrSplit.length <= 0) {
            return;
        }
        if (TextUtils.isEmpty(strArrSplit[0]) || !strA.contains(strArrSplit[0])) {
            if (strArrSplit.length < 2 || !strArrSplit[2].contains(strA)) {
                if (TextUtils.equals(strA, apkDownloadTask.r())) {
                    i = 4;
                }
                b10.a(9200015, f5VarC, Integer.valueOf(i), 2, jaVar);
            }
        }
    }

    public static int b() {
        return yy.a("ainsc", 0);
    }

    public static void a(ApkDownloadTask apkDownloadTask, int i, int i2, int i3, ja jaVar) {
        b10.a(i, c(apkDownloadTask), Integer.valueOf(i2), Integer.valueOf(i3), jaVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask, long j, long j2) throws JSONException {
        f5 f5VarC = c(apkDownloadTask);
        ja jaVar = new ja();
        jaVar.a("msg", Long.valueOf(j));
        jaVar.a("url", apkDownloadTask.s());
        jaVar.a("pkgName", apkDownloadTask.r());
        jaVar.a("data", Long.valueOf(j2));
        b10.a(9120022, f5VarC, 0, 0, jaVar);
    }

    public static void a(int i, ApkDownloadTask apkDownloadTask, int i2, ja jaVar) {
        b10.a(i, c(apkDownloadTask), Integer.valueOf(c(apkDownloadTask.r())), Integer.valueOf(i2), jaVar);
    }

    public static void a(int i, String str) {
        ja jaVar = new ja();
        jaVar.a("msg", str);
        b10.a(9130009, null, Integer.valueOf(i), jaVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask, boolean z) {
        String strR = apkDownloadTask.r();
        if (TextUtils.isEmpty(strR)) {
            return;
        }
        a(strR, c(apkDownloadTask), z);
    }

    public static void a(String str, f5 f5Var, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b10.a(z ? 1100907 : 1100924, f5Var, Integer.valueOf(c(str)), Integer.valueOf(b(str)), null);
    }
}
