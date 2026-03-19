package com.kwad.sdk.glide.c;

import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.e.i;
import com.kwad.sdk.glide.load.engine.g;
import com.kwad.sdk.glide.load.engine.q;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static final q<?, ?, ?> bZa = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.kwad.sdk.glide.load.resource.e.g(), null)), null);
    private final ArrayMap<i, q<?, ?, ?>> bZb = new ArrayMap<>();
    private final AtomicReference<i> bZc = new AtomicReference<>();

    public static boolean a(q<?, ?, ?> qVar) {
        return bZa.equals(qVar);
    }

    public final <Data, TResource, Transcode> q<Data, TResource, Transcode> d(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        i iVarE = e(cls, cls2, cls3);
        synchronized (this.bZb) {
            qVar = (q) this.bZb.get(iVarE);
        }
        this.bZc.set(iVarE);
        return qVar;
    }

    public final void a(Class<?> cls, Class<?> cls2, Class<?> cls3, q<?, ?, ?> qVar) {
        synchronized (this.bZb) {
            ArrayMap<i, q<?, ?, ?>> arrayMap = this.bZb;
            i iVar = new i(cls, cls2, cls3);
            if (qVar == null) {
                qVar = bZa;
            }
            arrayMap.put(iVar, qVar);
        }
    }

    private i e(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.bZc.getAndSet(null);
        if (andSet == null) {
            andSet = new i();
        }
        andSet.g(cls, cls2, cls3);
        return andSet;
    }
}
