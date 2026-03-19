package com.bytedance.d.hc.c;

import android.os.SystemClock;
import com.bytedance.d.hc.an;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.k;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.d.hc.u.d.u;
import com.bytedance.sdk.component.utils.mq;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static d d;
    private hc c;
    private Thread.UncaughtExceptionHandler hc;
    private HashSet<Thread.UncaughtExceptionHandler> b = new HashSet<>();
    private long u = -1;

    private d() {
        hc();
    }

    public static d d() {
        if (d == null) {
            d = new d();
        }
        return d;
    }

    public void d(hc hcVar) {
        this.c = hcVar;
    }

    private void hc() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.hc == null) {
                this.hc = defaultUncaughtExceptionHandler;
            } else {
                this.b.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        hc hcVar;
        if (SystemClock.uptimeMillis() - this.u < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.u = SystemClock.uptimeMillis();
            boolean zD = d(thread, th);
            if (zD) {
                com.bytedance.d.hc.b bVar = com.bytedance.d.hc.b.JAVA;
                hc(thread, th);
                if (zD && (hcVar = this.c) != null && hcVar.d(th)) {
                    this.c.d(jCurrentTimeMillis, thread, th);
                    mq.d("crash_dispatcher", "end dispose ".concat(String.valueOf(th)));
                }
            }
        } catch (Throwable th2) {
            try {
                tc.d(th2);
            } finally {
                b(thread, th);
            }
        }
    }

    private boolean d(Thread thread, Throwable th) {
        an anVarC = gb.hc().c();
        if (anVarC != null) {
            try {
                if (!anVarC.d(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void hc(Thread thread, Throwable th) {
        List<Object> listHc = gb.hc().hc();
        com.bytedance.d.hc.b bVar = com.bytedance.d.hc.b.JAVA;
        Iterator<Object> it = listHc.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                k.d(th);
            } catch (Throwable th2) {
                tc.hc(th2);
            }
        }
    }

    private void b(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.hc.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public static void d(final String str) {
        if (str == null) {
            return;
        }
        com.bytedance.d.b.d.hc.d.d().d(new com.bytedance.d.b.d.hc.b() { // from class: com.bytedance.d.hc.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.d.hc.b.d dVar = new com.bytedance.d.hc.b.d();
                    dVar.d("data", str);
                    dVar.d("userdefine", (Object) 1);
                    com.bytedance.d.hc.b.d dVarD = u.d().d(com.bytedance.d.hc.b.CUSTOM_JAVA, dVar);
                    if (dVarD != null) {
                        com.bytedance.d.hc.h.d.d().b(dVarD.d());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
