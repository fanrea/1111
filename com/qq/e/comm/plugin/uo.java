package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class uo {
    private static volatile uo e;
    private final Looper a;
    private final Handler b;
    private vo c;
    private final Set<d> d = new CopyOnWriteArraySet();

    /* compiled from: A */
    public interface d {
        void a();

        void b();
    }

    private uo(Looper looper) throws NoSuchFieldException, SecurityException {
        this.a = looper;
        this.b = new Handler(looper);
        c();
    }

    private void c() throws NoSuchFieldException, SecurityException {
        vo voVar;
        Field fieldA = mv.a((Class) this.a.getClass(), "mLogging", false);
        Printer printer = null;
        if (fieldA != null) {
            try {
                fieldA.setAccessible(true);
                Printer printer2 = (Printer) fieldA.get(this.a);
                try {
                    voVar = this.c;
                } catch (ClassCastException | IllegalAccessException unused) {
                }
                if (printer2 == voVar && voVar != null) {
                    return;
                }
                if (printer2 != null && voVar != null) {
                    if (printer2.getClass().getName().equals(this.c.getClass().getName())) {
                        return;
                    }
                }
                printer = printer2;
            } catch (ClassCastException | IllegalAccessException unused2) {
            }
        }
        vo voVar2 = new vo(this, printer);
        this.c = voVar2;
        this.a.setMessageLogging(voVar2);
    }

    public Set<d> b() {
        return this.d;
    }

    public void b(d dVar) {
        if (Thread.currentThread() != this.a.getThread()) {
            this.b.post(new b(dVar));
        } else {
            this.d.remove(dVar);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            uo.this.d.add(this.a);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            uo.this.d.remove(this.a);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uo.this.d.clear();
        }
    }

    public void a() {
        vo voVar = this.c;
        if (voVar != null) {
            this.a.setMessageLogging(voVar.c());
        }
        if (Thread.currentThread() != this.a.getThread()) {
            this.b.post(new c());
        } else {
            this.d.clear();
        }
        e = null;
    }

    public static uo a(Looper looper) {
        if (e == null) {
            synchronized (uo.class) {
                if (e == null) {
                    e = new uo(looper);
                }
            }
        }
        return e;
    }

    public void a(d dVar) {
        if (Thread.currentThread() != this.a.getThread()) {
            this.b.post(new a(dVar));
        } else {
            this.d.add(dVar);
        }
    }
}
