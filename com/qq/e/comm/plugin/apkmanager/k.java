package com.qq.e.comm.plugin.apkmanager;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.plugin.fs;
import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.t3;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class k {
    private final Context a;
    private final t b;

    k(Context context) {
        this.a = context;
        this.b = t.a(context);
    }

    public boolean a(ApkDownloadTask apkDownloadTask, int i) {
        if (apkDownloadTask == null) {
            return false;
        }
        try {
            com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 32, i);
            a(apkDownloadTask, 32, i);
            t3.a(1100908, apkDownloadTask);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    int b(String str, int i) {
        return this.b.a(str, i);
    }

    List<ApkDownloadTask> c() {
        return this.b.c();
    }

    List<ApkDownloadTask> d() {
        return this.b.d();
    }

    boolean b(int i) {
        return b(this.b.b(i));
    }

    int c(ApkDownloadTask apkDownloadTask) {
        return this.b.c(apkDownloadTask);
    }

    boolean b(String str) {
        return b(this.b.a(str));
    }

    boolean a(int i, int i2) {
        return a(this.b.a(i), i2);
    }

    boolean b(ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask != null && apkDownloadTask.o() != 8) {
            try {
                if (h10.d(com.qq.e.comm.plugin.n.a().d(this.a, apkDownloadTask.r()))) {
                    b(apkDownloadTask, 8);
                    return true;
                }
                com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 128);
                apkDownloadTask.c(128);
                Intent intentA = i.a(this.a, apkDownloadTask);
                if (intentA != null) {
                    this.a.startService(intentA);
                }
                t3.a(1100909, apkDownloadTask);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    boolean a(String str, int i) {
        return a(this.b.a(str), i);
    }

    boolean a(int i, int i2, long j) {
        try {
            ApkDownloadTask apkDownloadTaskC = this.b.c(i);
            if (apkDownloadTaskC != null) {
                a(apkDownloadTaskC, this.b, i2, j);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    boolean a(ApkDownloadTask apkDownloadTask, boolean z) {
        if (apkDownloadTask != null) {
            try {
                com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 64);
                b(apkDownloadTask, 64);
                String strD = apkDownloadTask.d("notifyTag");
                int iB = apkDownloadTask.b("notifyId");
                NotificationManager notificationManagerA = fs.a(this.a);
                if (notificationManagerA != null) {
                    notificationManagerA.cancel(strD, iB);
                }
                if (!z) {
                    return true;
                }
                com.qq.e.comm.plugin.q.a(apkDownloadTask);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void a(ApkDownloadTask apkDownloadTask, t tVar, int i, long j) {
        apkDownloadTask.a("totalSize", j);
        apkDownloadTask.a("progress", i);
        tVar.c(apkDownloadTask);
    }

    private void b(ApkDownloadTask apkDownloadTask, int i) {
        apkDownloadTask.c(i);
        this.b.c(apkDownloadTask);
    }

    List<ApkDownloadTask> b() {
        List<ApkDownloadTask> listB = this.b.b();
        if (listB != null && listB.size() > 0) {
            Iterator<ApkDownloadTask> it = listB.iterator();
            while (it.hasNext()) {
                if (!com.qq.e.comm.plugin.q.d(it.next())) {
                    it.remove();
                }
            }
        }
        return listB;
    }

    private void a(ApkDownloadTask apkDownloadTask, int i, int i2) {
        apkDownloadTask.a("manualPause", i2);
        b(apkDownloadTask, i);
    }

    int a(ApkDownloadTask apkDownloadTask) {
        return this.b.a(apkDownloadTask);
    }

    public List<ApkDownloadTask> a() {
        return this.b.a();
    }

    public ApkDownloadTask a(String str) {
        return this.b.a(str);
    }

    public ApkDownloadTask a(int i) {
        return this.b.c(i);
    }
}
