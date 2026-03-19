package com.bytedance.framwork.core.de.gh;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: AsyncEventManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a {
    private static long d = 30000;
    CopyOnWriteArraySet<b> a;
    private d b;
    private volatile boolean c;
    private final Runnable e;

    /* compiled from: AsyncEventManager.java */
    /* renamed from: com.bytedance.framwork.core.de.gh.a$a, reason: collision with other inner class name */
    private static final class C0209a {
        static final a a = new a();
    }

    private a() {
        this.c = true;
        this.e = new Runnable() { // from class: com.bytedance.framwork.core.de.gh.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator<b> it = a.this.a.iterator();
                    while (it.hasNext()) {
                        it.next().onTimeEvent(System.currentTimeMillis());
                    }
                    if (a.this.c) {
                        a.this.b.a(this, a.d);
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
        };
        this.a = new CopyOnWriteArraySet<>();
        d dVar = new d("AsyncEventManager-Thread");
        this.b = dVar;
        dVar.a();
    }

    public static a a() {
        return C0209a.a;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.b.a(runnable);
    }

    public void a(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.b.a(runnable, j);
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
