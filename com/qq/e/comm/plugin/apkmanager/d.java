package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import com.qq.e.comm.plugin.e3;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.s3;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d {
    private final Context a;
    private long b;
    private final long c;

    /* compiled from: A */
    class a implements s3.g {
        final /* synthetic */ File a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC0699d c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.apkmanager.d$a$a, reason: collision with other inner class name */
        class RunnableC0698a implements Runnable {
            RunnableC0698a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - d.this.b >= 2000 && a.this.a.exists() && !com.qq.e.comm.plugin.q.b(d.this.a, a.this.b)) {
                    d.this.b = System.currentTimeMillis();
                    j3.a(a.this.b).d = 7;
                    a.this.c.a();
                }
            }
        }

        a(File file, String str, InterfaceC0699d interfaceC0699d) {
            this.a = file;
            this.b = str;
            this.c = interfaceC0699d;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() {
            qg.f.submit(new RunnableC0698a());
            return true;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            return false;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ File a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC0699d c;

        b(File file, String str, InterfaceC0699d interfaceC0699d) {
            this.a = file;
            this.b = str;
            this.c = interfaceC0699d;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - d.this.b < d.this.c / 5) {
                long j = d.this.c / 5000;
                return;
            }
            if (this.a.exists() && s3.b().c() && !com.qq.e.comm.plugin.q.b(d.this.a, this.b)) {
                d.this.b = System.currentTimeMillis();
                j3.a(this.b).d = 6;
                this.c.a();
            }
        }
    }

    /* compiled from: A */
    private static class c {
        private static final d a = new d(null);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.d$d, reason: collision with other inner class name */
    interface InterfaceC0699d {
        void a();
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    private d() {
        this.a = r1.d().a();
        this.c = r1.d().f().a("rtiad", 60) * 1000;
    }

    private void b(File file, String str, InterfaceC0699d interfaceC0699d) {
        if (e3.g()) {
            s3.b().a(new a(file, str, interfaceC0699d));
        }
    }

    static d a() {
        return c.a;
    }

    void a(File file, String str, boolean z, InterfaceC0699d interfaceC0699d) {
        if (interfaceC0699d == null) {
            return;
        }
        if (z) {
            a(file, str, interfaceC0699d);
        }
        if (s3.b().c()) {
            return;
        }
        b(file, str, interfaceC0699d);
    }

    private void a(File file, String str, InterfaceC0699d interfaceC0699d) {
        if (e3.f()) {
            qg.f.schedule(new b(file, str, interfaceC0699d), this.c, TimeUnit.MILLISECONDS);
        }
    }
}
