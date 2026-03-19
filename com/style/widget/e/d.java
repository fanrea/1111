package com.style.widget.e;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private static d a;
    private CopyOnWriteArrayList<SoftReference<a>> b;

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                    a.b = new CopyOnWriteArrayList<>();
                }
            }
        }
        return a;
    }

    public void a(a aVar) {
        this.b.add(new SoftReference<>(aVar));
    }

    public void b(a aVar) {
        if (this.b == null || this.b.size() == 0) {
            return;
        }
        Iterator<SoftReference<a>> it = this.b.iterator();
        while (it.hasNext()) {
            a aVar2 = it.next().get();
            if (aVar2 != aVar && aVar2 != null) {
                aVar2.f(-3);
                aVar2.I();
            }
        }
    }

    public void c(a aVar) {
        if (this.b == null || this.b.size() == 0) {
            return;
        }
        Iterator<SoftReference<a>> it = this.b.iterator();
        while (it.hasNext()) {
            SoftReference<a> next = it.next();
            a aVar2 = next.get();
            if (aVar2 == aVar || aVar2 == null) {
                this.b.remove(next);
            }
        }
    }
}
