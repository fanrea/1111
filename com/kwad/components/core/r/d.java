package com.kwad.components.core.r;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static volatile d ZH;
    private volatile List<WeakReference<Object>> ZI = new CopyOnWriteArrayList();

    public static d sT() {
        if (ZH == null) {
            synchronized (d.class) {
                if (ZH == null) {
                    ZH = sU();
                }
            }
        }
        return ZH;
    }

    private static d sU() {
        return new d();
    }

    public final void f(Object obj) {
        if (a(this.ZI, obj)) {
            return;
        }
        b(this.ZI, obj);
        sW();
    }

    public final void g(Object obj) {
        c(this.ZI, obj);
        sW();
    }

    private int sV() {
        Iterator<WeakReference<Object>> it = this.ZI.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            } else {
                i++;
            }
        }
        return i;
    }

    private void sW() {
        boolean z = sV() > 0;
        b.sM();
        b.aO(z);
    }

    private static boolean a(Collection<WeakReference<Object>> collection, Object obj) {
        if (obj == null) {
            return false;
        }
        for (WeakReference<Object> weakReference : collection) {
            if (weakReference != null && weakReference.get() != null && weakReference.get().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    private static void b(Collection<WeakReference<Object>> collection, Object obj) {
        if (obj == null) {
            return;
        }
        collection.add(new WeakReference<>(obj));
    }

    private static boolean c(Collection<WeakReference<Object>> collection, Object obj) {
        if (obj == null) {
            return false;
        }
        for (WeakReference<Object> weakReference : collection) {
            if (weakReference != null && weakReference.get() != null && weakReference.get().equals(obj)) {
                return collection.remove(weakReference);
            }
        }
        return false;
    }
}
