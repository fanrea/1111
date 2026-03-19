package com.qq.e.comm.plugin;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.gdt.qone.sdk.IQoneSDK;
import com.android.gdt.qone.sdk.Qone;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.j0;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bv {
    private static volatile bv h;
    private volatile IQoneSDK b;
    private volatile String c;
    private volatile AtomicBoolean d;
    private volatile AtomicBoolean e;
    private volatile String g;
    private int f = 0;
    private final av a = new av();

    public static bv c() {
        if (h == null) {
            synchronized (av.class) {
                if (h == null) {
                    h = new bv();
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        pro.getVresult(288, 0, this);
    }

    private boolean f() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (!GlobalSetting.isAgreePrivacyStrategy()) {
            this.f = 2;
            return false;
        }
        if (r1.d().f().a("qoele", 0) != 0) {
            this.f = 1;
            return true;
        }
        this.f = 3;
        this.e = new AtomicBoolean(true);
        return false;
    }

    private bv() {
    }

    public void g() {
        if (this.d == null || !this.d.compareAndSet(true, false)) {
            return;
        }
        a(false);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bv.this.a(true);
        }
    }

    /* compiled from: A */
    class b implements j0.c {
        final /* synthetic */ long a;

        b(long j) {
            this.a = j;
        }

        @Override // com.qq.e.comm.plugin.j0.c
        public void b() {
            bv.this.a(1, SystemClock.elapsedRealtime() - this.a);
            if (iu.e()) {
                bv.this.e();
            } else {
                qg.b.submit(new a());
            }
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                bv.this.e();
            }
        }

        @Override // com.qq.e.comm.plugin.j0.c
        public void a(boolean z) {
            if (bv.this.d == null && z) {
                bv.this.d = new AtomicBoolean(true);
            }
        }
    }

    public void b() {
        if (f()) {
            this.g = yy.a("lcod", (String) null);
            if (iu.e()) {
                qg.b.submit(new a());
            } else {
                a(true);
            }
        }
    }

    public String d() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        if (this.b == null) {
            return this.g;
        }
        Qone qone = this.b.getQone();
        if (qone == null) {
            return this.g;
        }
        this.c = qone.getQ36();
        if (!TextUtils.isEmpty(this.c)) {
            yy.b("lcod", this.c);
        }
        return this.c;
    }

    public void h() {
        a(9120042, (f5) null);
    }

    public void a() {
        if (this.e != null && this.e.compareAndSet(true, false) && f()) {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.a.a(new b(SystemClock.elapsedRealtime()), z);
    }

    private void a(int i, f5 f5Var) {
        b10.a(i, f5Var, Integer.valueOf(this.f), Integer.valueOf(this.b != null ? -1 : this.a.h()), new ja().a("du", Long.valueOf(SystemClock.elapsedRealtime() - iu.b())));
    }

    public void a(e2 e2Var, String str) {
        a(9120041, new f5().a(e2Var).c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j) {
        b10.a(new wt(2130201).b(j).b(i));
    }
}
