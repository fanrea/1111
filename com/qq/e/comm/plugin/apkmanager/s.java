package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.kuaishou.socket.nano.SocketMessages;
import com.qq.e.comm.plugin.b10;
import com.qq.e.comm.plugin.c1;
import com.qq.e.comm.plugin.e3;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.s3;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.vx;
import com.qq.e.comm.plugin.ym;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s {
    private final Context a;
    private volatile ScheduledFuture b;
    private long c;
    private final long d;
    private AtomicBoolean e;
    private final long f;
    private final int g;
    private int h;
    private final int i;

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - s.this.c >= s.this.f) {
                if (s.this.a(this.a, true)) {
                    s.this.a(2);
                    long j = s.this.f / 1000;
                    return;
                }
                return;
            }
            if (ym.b() && s.this.a(this.a, true)) {
                s.this.a(3);
            }
        }
    }

    /* compiled from: A */
    class b implements s3.g {
        final /* synthetic */ d a;

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                if (s.this.a(bVar.a, true)) {
                    if (ym.b()) {
                        s.this.a(3);
                    } else {
                        s.this.a(4);
                    }
                }
            }
        }

        b(d dVar) {
            this.a = dVar;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() {
            qg.f.submit(new a());
            return true;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            return false;
        }
    }

    /* compiled from: A */
    public static class c {
        private static final s a = new s(null);
    }

    /* compiled from: A */
    interface d {
        void a(boolean z);
    }

    /* synthetic */ s(a aVar) {
        this();
    }

    public void c(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.h >= this.g || !this.e.get() || System.currentTimeMillis() - this.c < this.d || !s3.b().c() || ym.c() || ((this.i == 1 && !t3.d()) || (this.i == 2 && !t3.e()))) {
            dVar.a(false);
            return;
        }
        this.e.set(false);
        try {
            a(0);
            b();
            this.h++;
            b(dVar);
            a(dVar);
        } catch (Exception unused) {
            this.h = this.g;
            a(dVar, false);
            a(1);
        }
    }

    private s() {
        this.e = new AtomicBoolean(true);
        this.h = 0;
        this.a = r1.d().a();
        this.g = e3.b();
        vx vxVarF = r1.d().f();
        this.d = vxVarF.a("jusmi", SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC) * 1000;
        this.f = vxVarF.a("jusqt", 20) * 1000;
        this.i = vxVarF.a("jusres", 0);
    }

    private void b(d dVar) {
        this.c = System.currentTimeMillis();
        this.b = qg.f.scheduleAtFixedRate(new a(dVar), 1000L, 1000L, TimeUnit.MILLISECONDS);
    }

    public static s a() {
        return c.a;
    }

    private void b() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.a.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        this.a.startActivity(intent);
    }

    private void a(d dVar) {
        s3.b().a(new b(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        b10.a(9120018, null, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(d dVar, boolean z) {
        if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
        }
        if (!s3.b().c()) {
            c1.a();
        }
        if (!this.e.compareAndSet(false, true)) {
            return false;
        }
        dVar.a(z);
        return true;
    }
}
