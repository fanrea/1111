package com.kwad.sdk.glide.c;

import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.e.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private final AtomicReference<i> bZd = new AtomicReference<>();
    private final ArrayMap<i, List<Class<?>>> bZe = new ArrayMap<>();

    public final List<Class<?>> f(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.bZd.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.g(cls, cls2, cls3);
        }
        synchronized (this.bZe) {
            list = this.bZe.get(andSet);
        }
        this.bZd.set(andSet);
        return list;
    }

    public final void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.bZe) {
            this.bZe.put(new i(cls, cls2, cls3), list);
        }
    }
}
