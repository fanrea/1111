package com.baidu.mobads.container.w.b;

import android.app.Application;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private static final String a = d.class.getSimpleName();
    private static volatile d c;
    private final Application b;
    private final HashSet<com.baidu.mobads.container.w.c.f> d;

    private d(Application application, g gVar, HashSet<com.baidu.mobads.container.w.c.f> hashSet) {
        this.b = application;
        this.d = hashSet;
        Iterator<com.baidu.mobads.container.w.c.f> it = hashSet.iterator();
        while (it.hasNext()) {
            it.next().a(application, gVar);
        }
    }

    public static boolean a() {
        return c != null;
    }

    public static d b() {
        return c;
    }

    public Application c() {
        return this.b;
    }

    public void d() {
        Iterator<com.baidu.mobads.container.w.c.f> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void e() {
        Iterator<com.baidu.mobads.container.w.c.f> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void f() {
        Iterator<com.baidu.mobads.container.w.c.f> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public <T extends com.baidu.mobads.container.w.c.f> T a(Class<T> cls) {
        String name = cls.getName();
        Iterator<com.baidu.mobads.container.w.c.f> it = this.d.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass().getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public static d a(d dVar) {
        if (dVar == null) {
            throw new RuntimeException("GodEye init, GodEye should not be null.");
        }
        synchronized (d.class) {
            if (c == null) {
                c = dVar;
            }
        }
        return c;
    }

    public static class a {
        private final Application a;
        private g b;
        private final HashSet<com.baidu.mobads.container.w.c.f> c = new HashSet<>();

        public a(Application application) {
            if (application == null) {
                throw new RuntimeException("GodEye init, application is null");
            }
            this.a = application;
        }

        public a a(com.baidu.mobads.container.w.c.f fVar) {
            String strE = fVar.e();
            Iterator<com.baidu.mobads.container.w.c.f> it = this.c.iterator();
            while (it.hasNext()) {
                if (strE.equals(it.next().e())) {
                    throw new RuntimeException(String.format("plugin with tag %s is already exist", strE));
                }
            }
            this.c.add(fVar);
            return this;
        }

        public a a(g gVar) {
            this.b = gVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.b, this.c);
        }
    }
}
