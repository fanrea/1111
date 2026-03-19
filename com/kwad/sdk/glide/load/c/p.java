package com.kwad.sdk.glide.load.c;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p {
    private final r bWD;
    private final a bWE;

    public p(Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    private p(r rVar) {
        this.bWE = new a();
        this.bWD = rVar;
    }

    public final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.bWD.b(cls, cls2, oVar);
        this.bWE.clear();
    }

    public final <A> List<n<A, ?>> t(A a2) {
        List<n<A, ?>> listP = p(F(a2));
        int size = listP.size();
        List<n<A, ?>> listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            n<A, ?> nVar = listP.get(i);
            if (nVar.E(a2)) {
                if (z) {
                    listEmptyList = new ArrayList<>(size - i);
                    z = false;
                }
                listEmptyList.add(nVar);
            }
        }
        return listEmptyList;
    }

    public final synchronized List<Class<?>> o(Class<?> cls) {
        return this.bWD.o(cls);
    }

    private synchronized <A> List<n<A, ?>> p(Class<A> cls) {
        List<n<A, ?>> listQ;
        listQ = this.bWE.q(cls);
        if (listQ == null) {
            listQ = Collections.unmodifiableList(this.bWD.r(cls));
            this.bWE.a(cls, listQ);
        }
        return listQ;
    }

    private static <A> Class<A> F(A a2) {
        return (Class<A>) a2.getClass();
    }

    static class a {
        private final Map<Class<?>, C0607a<?>> bWF = new HashMap();

        a() {
        }

        public final void clear() {
            this.bWF.clear();
        }

        public final <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.bWF.put(cls, new C0607a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }

        public final <Model> List<n<Model, ?>> q(Class<Model> cls) {
            C0607a<?> c0607a = this.bWF.get(cls);
            if (c0607a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0607a.bWG;
        }

        /* renamed from: com.kwad.sdk.glide.load.c.p$a$a, reason: collision with other inner class name */
        static class C0607a<Model> {
            final List<n<Model, ?>> bWG;

            public C0607a(List<n<Model, ?>> list) {
                this.bWG = list;
            }
        }
    }
}
