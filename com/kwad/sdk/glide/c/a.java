package com.kwad.sdk.glide.c;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private final List<C0600a<?>> bYZ = new ArrayList();

    public final synchronized <T> com.kwad.sdk.glide.load.a<T> t(Class<T> cls) {
        for (C0600a<?> c0600a : this.bYZ) {
            if (c0600a.s(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0600a.bSw;
            }
        }
        return null;
    }

    public final synchronized <T> void b(Class<T> cls, com.kwad.sdk.glide.load.a<T> aVar) {
        this.bYZ.add(new C0600a<>(cls, aVar));
    }

    /* renamed from: com.kwad.sdk.glide.c.a$a, reason: collision with other inner class name */
    static final class C0600a<T> {
        final com.kwad.sdk.glide.load.a<T> bSw;
        private final Class<T> dataClass;

        C0600a(Class<T> cls, com.kwad.sdk.glide.load.a<T> aVar) {
            this.dataClass = cls;
            this.bSw = aVar;
        }

        final boolean s(Class<?> cls) {
            return this.dataClass.isAssignableFrom(cls);
        }
    }
}
