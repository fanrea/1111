package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lf {
    private static final d20 a = new d20(Math.max(r1.d().f().a("downloaded_not_installed_limit_num", 2048), 5));

    public static boolean c(ApkDownloadTask apkDownloadTask) {
        return System.currentTimeMillis() - apkDownloadTask.e() >= ((long) r1.d().f().a("apk_downloaded_time", 172800000));
    }

    public static boolean d() {
        return a.b();
    }

    public static c3 d(ApkDownloadTask apkDownloadTask) {
        return new c3(apkDownloadTask.r(), apkDownloadTask.u(), apkDownloadTask.g(), apkDownloadTask.p(), apkDownloadTask.k(), apkDownloadTask);
    }

    private static void c() throws JSONException {
        List<ApkDownloadTask> listC;
        if (r1.d().f().a("aiirc", 1) == 0 || (listC = com.qq.e.comm.plugin.apkmanager.l.e().c()) == null || listC.isEmpty()) {
            return;
        }
        for (ApkDownloadTask apkDownloadTask : listC) {
            if (!c(apkDownloadTask)) {
                String strR = apkDownloadTask.r();
                if (q.b(r1.d().a(), strR)) {
                    com.qq.e.comm.plugin.apkmanager.l.e().a(strR, 1);
                    o.c(apkDownloadTask);
                    j3.a(strR).d = 11;
                    j3.a(4001011, apkDownloadTask, 1, 0);
                    t3.c(1100906, apkDownloadTask);
                }
            }
        }
    }

    public static boolean a(List<ApkDownloadTask> list) {
        return list == null || list.size() == 0;
    }

    public static void b(ApkDownloadTask apkDownloadTask) {
        com.qq.e.comm.plugin.apkmanager.o oVar = new com.qq.e.comm.plugin.apkmanager.o(r1.d().a(), apkDownloadTask);
        oVar.a(new a(apkDownloadTask, apkDownloadTask));
        File fileA = a(apkDownloadTask);
        if (fileA != null) {
            oVar.a(fileA);
        }
    }

    /* compiled from: A */
    class a implements c.a {
        final /* synthetic */ ApkDownloadTask a;
        final /* synthetic */ ApkDownloadTask b;

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return true;
        }

        a(ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2) {
            this.a = apkDownloadTask;
            this.b = apkDownloadTask2;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i, String str, boolean z) {
            ApkDownloadTask apkDownloadTask;
            if (i != 0 || (apkDownloadTask = this.a) == null) {
                return;
            }
            JSONObject jSONObjectL = apkDownloadTask.l();
            if (jSONObjectL != null) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONObjectL.optJSONObject("reportUrl");
                    String strOptString = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optString(String.valueOf(2));
                    if (TextUtils.isEmpty(strOptString)) {
                        o.a(this.a, true);
                    } else {
                        zt.a(strOptString + "&tips_install=1", true, null);
                    }
                } catch (Exception unused) {
                    o.a(this.a, true);
                }
            } else {
                o.a(this.a, true);
            }
            j3.a(this.b.r()).i = 5;
            ct.a(this.b);
        }
    }

    public static File a(ApkDownloadTask apkDownloadTask) {
        return q.b(apkDownloadTask);
    }

    public static boolean a(long j, long j2, ApkDownloadTask apkDownloadTask) throws JSONException {
        wt wtVar = new wt(2020035);
        long j3 = j2 - j;
        wtVar.b(j3);
        f5 f5Var = new f5();
        f5Var.a(apkDownloadTask.a());
        wtVar.a(f5Var);
        b10.a(wtVar);
        return j3 >= ((long) r1.d().f().a("apk_downloaded_inter_time", 43200000));
    }

    public static void a() {
        c();
        b();
    }

    public static void b(List<ApkDownloadTask> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).y()) {
                return;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ApkDownloadTask apkDownloadTask = list.get(i2);
            apkDownloadTask.a(false);
            com.qq.e.comm.plugin.apkmanager.l.e().d(apkDownloadTask);
        }
    }

    private static void b() {
        List<ApkDownloadTask> listD = com.qq.e.comm.plugin.apkmanager.l.e().d();
        if (listD == null || listD.isEmpty()) {
            return;
        }
        for (ApkDownloadTask apkDownloadTask : listD) {
            if (!c(apkDownloadTask)) {
                String strR = apkDownloadTask.r();
                if (h10.d(n.a().d(r1.d().a(), strR))) {
                    com.qq.e.comm.plugin.apkmanager.l.e().a(strR, 8);
                    o.a(apkDownloadTask);
                    b10.a(1100934, (f5) null);
                }
            }
        }
    }
}
