package com.baidu.mobads.container.components.f;

import com.baidu.mobads.container.util.bq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final int a = 500;
    private static c d;
    private a b = new a();
    private volatile AtomicBoolean c = new AtomicBoolean(false);
    private List<com.baidu.mobads.container.components.f.a> e = Collections.synchronizedList(new ArrayList());

    private c() {
    }

    public static synchronized c a() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    public synchronized void b() {
        if (!this.c.get()) {
            com.baidu.mobads.container.d.b.a().a(this.b, 0L, 500L, TimeUnit.MILLISECONDS);
        }
        this.c.set(true);
    }

    public synchronized void c() {
        this.c.set(false);
        this.e.clear();
    }

    public void a(com.baidu.mobads.container.components.f.a aVar) {
        this.e.add(aVar);
    }

    public void b(com.baidu.mobads.container.components.f.a aVar) {
        this.e.remove(aVar);
    }

    class a extends com.baidu.mobads.container.d.a {
        a() {
        }

        @Override // com.baidu.mobads.container.d.a
        public Object a() {
            try {
                if (c.this.c.get()) {
                    for (com.baidu.mobads.container.components.f.a aVar : c.this.e) {
                        if (aVar.a()) {
                            c.this.e.remove(aVar);
                        }
                    }
                    if (c.this.e.isEmpty()) {
                        c();
                        return null;
                    }
                    return null;
                }
                c();
                return null;
            } catch (Throwable th) {
                bq.a().d(th);
                c();
                return null;
            }
        }

        protected void c() {
            c.this.c.set(false);
            c.this.e.clear();
            a_();
        }
    }
}
