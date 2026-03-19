package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qq.e.comm.plugin.a30;
import com.qq.e.comm.plugin.apkmanager.a;
import com.qq.e.comm.plugin.b10;
import com.qq.e.comm.plugin.b4;
import com.qq.e.comm.plugin.cb;
import com.qq.e.comm.plugin.dq;
import com.qq.e.comm.plugin.e3;
import com.qq.e.comm.plugin.ea;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.ga;
import com.qq.e.comm.plugin.gu;
import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.ha;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.ja;
import com.qq.e.comm.plugin.ll;
import com.qq.e.comm.plugin.mc;
import com.qq.e.comm.plugin.qc;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.ub;
import com.qq.e.comm.plugin.v10;
import com.qq.e.comm.plugin.wb;
import com.qq.e.comm.plugin.wj;
import com.qq.e.comm.plugin.wt;
import com.qq.e.comm.plugin.zi;
import com.qq.e.comm.plugin.zr;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class n implements com.qq.e.comm.plugin.apkmanager.a {
    private final Context a;
    private final h b;
    private final v10 c;
    private a.InterfaceC0696a d;
    private final ApkDownloadTask e;
    private final Intent f;
    private final Lock g;
    private Future<Bitmap> h;
    private zi i;
    private com.qq.e.comm.plugin.m j;
    private long m = 0;
    private zr n;

    /* compiled from: A */
    class b implements ll {
        final /* synthetic */ String a;
        final /* synthetic */ ApkDownloadTask b;

        b(String str, ApkDownloadTask apkDownloadTask) {
            this.a = str;
            this.b = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.ll
        public void a(long j, long j2) {
            n.this.a(j, j2);
            int i = j2 <= 0 ? 0 : (int) ((100 * j) / j2);
            if (com.qq.e.comm.plugin.n.a().a(n.this.a, this.a, false) == 128) {
                com.qq.e.comm.plugin.n.a().a(this.b.r(), 4);
            }
            com.qq.e.comm.plugin.n.a().a(this.b.r(), i, j2);
            this.b.a("progress", i);
            if (n.this.m == 0) {
                n.this.m = j2;
                this.b.a("totalSize", j2);
                n.this.c(this.b);
            }
            n.this.b(j, j2);
        }
    }

    public n(Context context, ApkDownloadTask apkDownloadTask, Intent intent, Lock lock) {
        this.a = context;
        zr zrVarP = r1.d().c().p();
        this.n = zrVarP;
        this.b = new h(zrVarP);
        this.c = new ha();
        this.e = apkDownloadTask;
        this.f = intent;
        a();
        this.g = lock;
    }

    private int b(int i) {
        if (i == 4) {
            return 4096;
        }
        if (i != 5) {
            return i != 6 ? 0 : 2048;
        }
        return 1024;
    }

    private int c() {
        return r1.d().f().a("airmsv", 0);
    }

    private int d(ApkDownloadTask apkDownloadTask) {
        if (!apkDownloadTask.x()) {
            return 0;
        }
        if (!this.c.a(apkDownloadTask)) {
            return !this.c.b(apkDownloadTask) ? 3 : 0;
        }
        e(apkDownloadTask);
        return 2;
    }

    private int e() {
        File fileA = gu.a();
        if (fileA == null) {
            return 5;
        }
        return (fileA.exists() || fileA.mkdirs()) ? 0 : 6;
    }

    private void f() {
        Future<Bitmap> future = this.h;
        if (future == null || !future.isDone()) {
            return;
        }
        try {
            this.e.a(this.h.get());
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkDownloadTask apkDownloadTask) {
        try {
            t tVarA = t.a(this.a);
            ApkDownloadTask apkDownloadTaskA = tVarA.a(apkDownloadTask.r());
            if (apkDownloadTaskA != null) {
                apkDownloadTask.d(apkDownloadTaskA.t());
                tVarA.c(apkDownloadTask);
            } else {
                tVarA.a(apkDownloadTask);
            }
        } catch (SQLException unused) {
        }
    }

    private void f(ApkDownloadTask apkDownloadTask) {
        apkDownloadTask.a("progress", 0);
        com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 0, 0L);
        com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 0);
    }

    private void e(ApkDownloadTask apkDownloadTask) {
        try {
            t.a(this.a).b(apkDownloadTask);
        } catch (SQLException unused) {
        }
    }

    private void d(int i) {
        a.InterfaceC0696a interfaceC0696a = this.d;
        if (interfaceC0696a != null) {
            interfaceC0696a.a(i);
        }
    }

    private void c(int i) {
        if (i == 0) {
            b().a();
            return;
        }
        if (mc.a(i)) {
            return;
        }
        if (!mc.e(i) && !mc.c(i)) {
            b().a(a(i));
        } else {
            b().b(a(i));
        }
    }

    private void d() {
        b().start();
    }

    private void a(wj wjVar, ApkDownloadTask apkDownloadTask) throws JSONException {
        if (wjVar.b() != 0 || wjVar.j() == 0 || wjVar.d() == 0) {
            return;
        }
        qc qcVar = new qc(10000001);
        int iJ = (int) ((wjVar.j() * 1000) / (wjVar.d() * 1024));
        qcVar.c(iJ);
        qcVar.a(f5.a(apkDownloadTask.v()));
        qcVar.d(wjVar.h());
        ub.c().a(qcVar, false);
        ub.c().e(wb.a());
        ja jaVar = new ja();
        jaVar.a("data2", Integer.valueOf(this.b.b));
        jaVar.a("data", Integer.valueOf(iJ));
        if (wjVar.e() != null) {
            jaVar.a("msg", wjVar.e().toString());
        }
        t3.a(apkDownloadTask, 1100935, wjVar.h(), this.n.b(), jaVar);
        wt wtVar = new wt(this.n.equals(zr.WIFI) ? 2130103 : 2130104);
        wtVar.b(iJ).b(wjVar.h());
        b10.a(wtVar);
    }

    private void a() {
        com.qq.e.comm.plugin.p pVar = new com.qq.e.comm.plugin.p(this.a, this.e);
        this.i = pVar;
        pVar.a(new ea(this.f, this.e, this.a));
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a
    public void a(a.InterfaceC0696a interfaceC0696a) {
        this.d = interfaceC0696a;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f5 A[LOOP:0: B:19:0x0047->B:79:0x01f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b3 A[EDGE_INSN: B:80:0x01b3->B:72:0x01b3 BREAK  A[LOOP:0: B:19:0x0047->B:79:0x01f5], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.qq.e.comm.plugin.apkmanager.ApkDownloadTask r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.apkmanager.n.a(com.qq.e.comm.plugin.apkmanager.ApkDownloadTask):void");
    }

    /* compiled from: A */
    class a implements com.qq.e.comm.plugin.m {
        final /* synthetic */ String a;
        final /* synthetic */ wj b;

        @Override // com.qq.e.comm.plugin.m
        public void a(String str, int i, int i2, long j) {
            if (TextUtils.isEmpty(this.a) || !this.a.equals(str)) {
                return;
            }
            if (i == 32) {
                this.b.pause();
            } else if (i == 64) {
                this.b.cancel();
            }
        }

        a(String str, wj wjVar) {
            this.a = str;
            this.b = wjVar;
        }
    }

    private wj a(ApkDownloadTask apkDownloadTask, File file) {
        dq dqVar = new dq(apkDownloadTask.s(), file, this.b.a(), new cb.b().a(qg.b).a(), false, e3.e());
        dqVar.c(true);
        return new b4(dqVar, new ga(apkDownloadTask.d()));
    }

    private int a(File file, ApkDownloadTask apkDownloadTask) throws JSONException {
        int iD = com.qq.e.comm.plugin.n.a().d(this.a, apkDownloadTask.r());
        if (file.exists()) {
            if (com.qq.e.comm.plugin.q.a(file, apkDownloadTask.r(), this.a)) {
                ApkDownloadTask apkDownloadTaskA = t.a(this.a).a(apkDownloadTask.r());
                long jC = apkDownloadTaskA == null ? 0L : apkDownloadTaskA.c("totalSize");
                long length = file.length();
                if (jC > 0 && jC != length) {
                    t3.a(apkDownloadTaskA, jC, length);
                }
                com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 8);
            } else {
                file.delete();
                f(apkDownloadTask);
            }
        } else if (h10.d(iD)) {
            f(apkDownloadTask);
        }
        int iD2 = com.qq.e.comm.plugin.n.a().d(this.a, apkDownloadTask.r());
        apkDownloadTask.o();
        if (h10.f(iD2)) {
            return 7;
        }
        if (h10.e(iD2)) {
            return 8;
        }
        if (h10.d(iD2)) {
            return 9;
        }
        t tVarA = t.a(this.a);
        ApkDownloadTask apkDownloadTaskA2 = tVarA.a(apkDownloadTask.r());
        a(apkDownloadTaskA2, apkDownloadTask, file);
        if (iD2 == 0) {
            d(3);
            apkDownloadTask.a("progress", 0);
            com.qq.e.comm.plugin.n.a().b(apkDownloadTask.r());
            if (apkDownloadTaskA2 != null && com.qq.e.comm.plugin.q.c(apkDownloadTask)) {
                j3.b(4001005, apkDownloadTask, 1, 103);
            } else {
                j3.a(4001001, apkDownloadTask);
            }
        }
        com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), 4);
        apkDownloadTask.c(4);
        if (apkDownloadTaskA2 != null) {
            apkDownloadTask.d(apkDownloadTaskA2.t());
            tVarA.c(apkDownloadTask);
        } else {
            tVarA.a(apkDownloadTask);
        }
        return 0;
    }

    private void a(ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2, File file) {
        if (apkDownloadTask == null || TextUtils.equals(a30.c(apkDownloadTask.s()), a30.c(apkDownloadTask2.s()))) {
            return;
        }
        com.qq.e.comm.plugin.q.a(apkDownloadTask2);
    }

    private void a(int i, String str, File file) throws JSONException {
        t3.a(i, str, this.e, file);
        j3.b(i, this.e);
        a.InterfaceC0696a interfaceC0696a = this.d;
        if (interfaceC0696a != null) {
            interfaceC0696a.a(i, str, file);
        }
    }

    private void a(int i, String str) throws JSONException {
        a(i, str, (File) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        b().a(j, j2);
    }

    private String a(int i) {
        return mc.c(i) ? "连接到运营商网络，暂停下载，点击这里继续！" : mc.e(i) ? "已暂停" : mc.d(i) ? "看起来网络出问题了，快去检查网络正常后点这里重试吧！" : mc.b(i) ? "存储卡不可用或者存储空间不足，快去检查存储卡状态后点这里重试吧！" : "真遗憾，下载失败了，稍后点这里重试吧";
    }

    private void a(ApkDownloadTask apkDownloadTask, int i) {
        int i2;
        if (i == 0) {
            i2 = 8;
        } else if (mc.a(i)) {
            i2 = 64;
        } else {
            i2 = (mc.c(i) || mc.e(i)) ? 32 : 16;
        }
        com.qq.e.comm.plugin.n.a().a(apkDownloadTask.r(), i2);
        apkDownloadTask.c(i2);
        if (i == 8) {
            t.a(this.a).b(apkDownloadTask);
        } else {
            t.a(this.a).c(apkDownloadTask);
        }
    }

    private zi b() {
        if (this.h == null && !TextUtils.isEmpty(this.e.k())) {
            Future<Bitmap> futureSubmit = qg.b.submit(new g(this.e.k()));
            this.h = futureSubmit;
            this.i.a(futureSubmit);
        }
        return this.i;
    }

    private wj b(ApkDownloadTask apkDownloadTask, File file) {
        String strR = apkDownloadTask.r();
        wj wjVarA = a(apkDownloadTask, file);
        if (this.j != null) {
            com.qq.e.comm.plugin.n.a().b(strR, this.j);
        }
        this.j = new a(strR, wjVarA);
        com.qq.e.comm.plugin.n.a().a(strR, this.j);
        wjVarA.a(new b(strR, apkDownloadTask));
        return wjVarA;
    }

    private void b(ApkDownloadTask apkDownloadTask) {
        try {
            this.g.lockInterruptibly();
            t3.a(1100902, this.e);
            a(apkDownloadTask);
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2) {
        a.InterfaceC0696a interfaceC0696a = this.d;
        if (interfaceC0696a != null) {
            interfaceC0696a.a(j, j2);
        }
    }
}
