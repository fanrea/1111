package com.qq.e.comm.plugin;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import java.util.concurrent.Future;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p implements zi {
    private final ApkDownloadTask a;
    private final fh b;
    private final NotificationManager c;
    private Future<Bitmap> d;
    private gs e;
    private long g;
    private String h;
    private int i;
    private int f = -1;
    private boolean j = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.zi
    public void start() {
        xo.a((Runnable) new a());
    }

    @Override // com.qq.e.comm.plugin.zi
    public void b(String str) {
        xo.a((Runnable) new c(str));
    }

    public void b() {
        xo.a((Runnable) new f());
    }

    public p(Context context, ApkDownloadTask apkDownloadTask) {
        this.a = apkDownloadTask;
        this.b = fh.a(context);
        this.c = fs.a(context);
        this.h = apkDownloadTask.d("notifyTag");
        this.i = apkDownloadTask.b("notifyId");
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                p.this.d();
                p.this.f = -1;
                p.this.g = 0L;
                p.this.b.a("玩儿命下载中").a(100, 100, true);
                if (p.this.e != null) {
                    p.this.b.a(p.this.e.e());
                }
                Notification notificationA = p.this.b.a();
                p.this.c();
                p.this.a(notificationA);
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;

        b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                long j = this.a;
                int i = j > 0 ? (int) ((this.b * 100) / j) : 0;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (i - p.this.f <= 1 || jCurrentTimeMillis - p.this.g <= 1000) {
                    return;
                }
                p.this.f = i;
                p.this.g = jCurrentTimeMillis;
                p.this.d();
                p.this.b.a(100, p.this.f, false);
                p.this.b.a("已完成：" + jz.a(this.b) + ",总大小：" + jz.a(this.a));
                if (p.this.e != null) {
                    p.this.b.a(p.this.e.e());
                }
                Notification notificationA = p.this.b.a();
                if (i % 10 == 0) {
                    p.this.c();
                }
                p.this.a(notificationA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        fh fhVar = this.b;
        if (fhVar != null) {
            fhVar.a(false).b("正在下载：" + this.a.p());
            e();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                p.this.b.a(false).b("暂停下载：" + p.this.a.p());
                p.this.e();
                p.this.b.a(100, p.this.f, false);
                p.this.b.a(this.a);
                if (p.this.e != null) {
                    p.this.b.a(p.this.e.d());
                }
                Notification notificationA = p.this.b.a();
                p.this.c();
                p.this.a(notificationA);
            }
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                p.this.d();
                p.this.b.a(100, 100, true);
                p.this.b.a(this.a);
                if (p.this.e != null) {
                    p.this.b.a(p.this.e.b());
                }
                Notification notificationA = p.this.b.a();
                p.this.c();
                p.this.a(notificationA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Notification notification) {
        NotificationManager notificationManager = this.c;
        if (notificationManager == null || notification == null) {
            return;
        }
        try {
            notificationManager.notify(this.h, this.i, notification);
        } catch (RuntimeException unused) {
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                p.this.d();
                p.this.b.a(100, 100, false);
                p.this.b.a("下载完成点击安装");
                if (p.this.e != null) {
                    p.this.b.a(p.this.e.a());
                }
                Notification notificationA = p.this.b.a();
                p.this.c();
                p.this.a(notificationA);
            }
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                if (p.this.e != null) {
                    p.this.b.a(p.this.e.c());
                }
                if (p.this.a.j() != null) {
                    p.this.b.a(p.this.a.j());
                }
                p.this.b.a("点击启动").b(p.this.a.p()).a(false);
                Notification notificationA = p.this.b.a();
                p.this.c();
                p.this.a(notificationA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Future<Bitmap> future;
        if (this.b == null || this.j || (future = this.d) == null || !future.isDone()) {
            return;
        }
        this.j = true;
        try {
            Bitmap bitmap = this.d.get();
            if (bitmap != null) {
                this.b.a(bitmap);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.zi
    public void a(Future<Bitmap> future) {
        this.d = future;
    }

    @Override // com.qq.e.comm.plugin.zi
    public void a(gs gsVar) {
        this.e = gsVar;
    }

    @Override // com.qq.e.comm.plugin.zi
    public void a(long j, long j2) {
        xo.a((Runnable) new b(j2, j));
    }

    @Override // com.qq.e.comm.plugin.zi
    public void a(String str) {
        xo.a((Runnable) new d(str));
    }

    @Override // com.qq.e.comm.plugin.zi
    public void a() {
        xo.a((Runnable) new e());
    }
}
