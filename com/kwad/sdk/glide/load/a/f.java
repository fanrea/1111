package com.kwad.sdk.glide.load.a;

import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.utils.ax;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f {
    private static final e.a<?> bRH = new e.a<Object>() { // from class: com.kwad.sdk.glide.load.a.f.1
        @Override // com.kwad.sdk.glide.load.a.e.a
        public final e<Object> y(Object obj) {
            return new a(obj);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        public final Class<Object> afT() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };
    private final Map<Class<?>, e.a<?>> bRG = new HashMap();

    public final synchronized void b(e.a<?> aVar) {
        this.bRG.put(aVar.afT(), aVar);
    }

    public final synchronized <T> e<T> y(T t) {
        e.a<?> aVar;
        ax.checkNotNull(t);
        aVar = this.bRG.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.bRG.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.afT().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = bRH;
        }
        return (e<T>) aVar.y(t);
    }

    static final class a implements e<Object> {
        private final Object data;

        @Override // com.kwad.sdk.glide.load.a.e
        public final void afU() {
        }

        a(Object obj) {
            this.data = obj;
        }

        @Override // com.kwad.sdk.glide.load.a.e
        public final Object afX() {
            return this.data;
        }
    }
}
