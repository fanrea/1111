package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.q;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    private static long b;
    private final b a;
    private boolean c = false;
    private final Runnable d;

    c(b bVar) {
        Runnable runnable = new Runnable() { // from class: com.apm.insight.b.c.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (c.this.c) {
                    return;
                }
                c.this.a.d();
                long unused = c.b = SystemClock.uptimeMillis();
                f.a();
                q.b().a(c.this.d, 500L);
                com.apm.insight.runtime.b.a(c.b);
            }
        };
        this.d = runnable;
        this.a = bVar;
        q.b().a(runnable, 5000L);
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - b <= 15000;
    }

    public void a() {
        if (this.c) {
            return;
        }
        q.b().a(this.d, 5000L);
    }

    public void b() {
        this.c = true;
    }
}
