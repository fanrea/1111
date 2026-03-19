package com.bytedance.framwork.core.de.gh;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: LogEventManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static long d = 30000;
    CopyOnWriteArraySet<b> a;
    private d b;
    private volatile boolean c;
    private final Runnable e;

    /* compiled from: LogEventManager.java */
    private static final class a {
        static final c a = new c();
    }

    private c() {
        this.c = true;
        this.e = new Runnable() { // from class: com.bytedance.framwork.core.de.gh.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator<b> it = c.this.a.iterator();
                    while (it.hasNext()) {
                        it.next().onTimeEvent(System.currentTimeMillis());
                    }
                    if (c.this.c) {
                        c.this.b.a(this, c.d);
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
        };
        this.a = new CopyOnWriteArraySet<>();
        d dVar = new d("LogSendManager-Thread");
        this.b = dVar;
        dVar.a();
    }

    public static c a() {
        return a.a;
    }

    public void a(b bVar) {
        if (bVar != null) {
            try {
                this.a.add(bVar);
                if (this.c) {
                    this.b.b(this.e);
                    this.b.a(this.e, d);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
