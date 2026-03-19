package com.kwad.sdk.glide.c;

import com.kwad.sdk.glide.load.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f {
    private final List<a<?>> bYZ = new ArrayList();

    public final synchronized <Z> void c(Class<Z> cls, h<Z> hVar) {
        this.bYZ.add(new a<>(cls, hVar));
    }

    public final synchronized <Z> void d(Class<Z> cls, h<Z> hVar) {
        this.bYZ.add(0, new a<>(cls, hVar));
    }

    public final synchronized <Z> h<Z> u(Class<Z> cls) {
        int size = this.bYZ.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.bYZ.get(i);
            if (aVar.s(cls)) {
                return (h<Z>) aVar.bTg;
            }
        }
        return null;
    }

    static final class a<T> {
        private final Class<T> bSz;
        final h<T> bTg;

        a(Class<T> cls, h<T> hVar) {
            this.bSz = cls;
            this.bTg = hVar;
        }

        final boolean s(Class<?> cls) {
            return this.bSz.isAssignableFrom(cls);
        }
    }
}
