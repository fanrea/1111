package com.kwad.sdk.glide.load.resource.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f {
    private final List<a<?, ?>> bYz = new ArrayList();

    public final synchronized <Z, R> void b(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.bYz.add(new a<>(cls, cls2, eVar));
    }

    public final synchronized <Z, R> e<Z, R> c(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.aio();
        }
        for (a<?, ?> aVar : this.bYz) {
            if (aVar.b(cls, cls2)) {
                return (e<Z, R>) aVar.bTm;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public final synchronized <Z, R> List<Class<R>> d(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.bYz.iterator();
        while (it.hasNext()) {
            if (it.next().b(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    static final class a<Z, R> {
        final e<Z, R> bTm;
        private final Class<Z> bYA;
        private final Class<R> bYB;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.bYA = cls;
            this.bYB = cls2;
            this.bTm = eVar;
        }

        public final boolean b(Class<?> cls, Class<?> cls2) {
            return this.bYA.isAssignableFrom(cls) && cls2.isAssignableFrom(this.bYB);
        }
    }
}
