package com.kwad.sdk.glide.load.c;

import androidx.core.util.Pools;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class r {
    private static final c bWL = new c();
    private static final n<Object, Object> bWM = new a();
    private final Pools.Pool<List<Throwable>> bQe;
    private final List<b<?, ?>> bWN;
    private final c bWO;
    private final Set<b<?, ?>> bWP;

    public r(Pools.Pool<List<Throwable>> pool) {
        this(pool, bWL);
    }

    private r(Pools.Pool<List<Throwable>> pool, c cVar) {
        this.bWN = new ArrayList();
        this.bWP = new HashSet();
        this.bQe = pool;
        this.bWO = cVar;
    }

    final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.bWN;
        list.add(list.size(), bVar);
    }

    final synchronized <Model> List<n<Model, ?>> r(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.bWN) {
                if (!this.bWP.contains(bVar) && bVar.s(cls)) {
                    this.bWP.add(bVar);
                    arrayList.add(a(bVar));
                    this.bWP.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.bWP.clear();
            throw th;
        }
        return arrayList;
    }

    final synchronized List<Class<?>> o(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.bWN) {
            if (!arrayList.contains(bVar.dataClass) && bVar.s(cls)) {
                arrayList.add(bVar.dataClass);
            }
        }
        return arrayList;
    }

    public final synchronized <Model, Data> n<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.bWN) {
                if (this.bWP.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.bWP.add(bVar);
                    arrayList.add(a(bVar));
                    this.bWP.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return c.a(arrayList, this.bQe);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (z) {
                return ahG();
            }
            throw new Registry.NoModelLoaderAvailableException(cls, cls2);
        } catch (Throwable th) {
            this.bWP.clear();
            throw th;
        }
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        return (n) ax.checkNotNull(bVar.bWR.a(this));
    }

    private static <Model, Data> n<Model, Data> ahG() {
        return (n<Model, Data>) bWM;
    }

    static class b<Model, Data> {
        private final Class<Model> bWQ;
        final o<? extends Model, ? extends Data> bWR;
        final Class<Data> dataClass;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.bWQ = cls;
            this.dataClass = cls2;
            this.bWR = oVar;
        }

        public final boolean b(Class<?> cls, Class<?> cls2) {
            return s(cls) && this.dataClass.isAssignableFrom(cls2);
        }

        public final boolean s(Class<?> cls) {
            return this.bWQ.isAssignableFrom(cls);
        }
    }

    static class c {
        c() {
        }

        public static <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    static class a implements n<Object, Object> {
        @Override // com.kwad.sdk.glide.load.c.n
        public final boolean E(Object obj) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c.n
        public final n.a<Object> b(Object obj, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
            return null;
        }

        a() {
        }
    }
}
