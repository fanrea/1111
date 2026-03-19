package com.kwad.sdk.glide.e.a;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static final d<Object> cat = new d<Object>() { // from class: com.kwad.sdk.glide.e.a.a.1
        @Override // com.kwad.sdk.glide.e.a.a.d
        public final void reset(Object obj) {
        }
    };

    /* renamed from: com.kwad.sdk.glide.e.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0602a<T> {
        T agF();
    }

    public interface c {
        com.kwad.sdk.glide.e.a.b agy();
    }

    public interface d<T> {
        void reset(T t);
    }

    public static <T extends c> Pools.Pool<T> a(int i, InterfaceC0602a<T> interfaceC0602a) {
        return a(new Pools.SynchronizedPool(i), interfaceC0602a);
    }

    public static <T> Pools.Pool<List<T>> ajF() {
        return gu(20);
    }

    private static <T> Pools.Pool<List<T>> gu(int i) {
        return a(new Pools.SynchronizedPool(20), new InterfaceC0602a<List<T>>() { // from class: com.kwad.sdk.glide.e.a.a.2
            @Override // com.kwad.sdk.glide.e.a.a.InterfaceC0602a
            public final /* synthetic */ Object agF() {
                return ajH();
            }

            private static List<T> ajH() {
                return new ArrayList();
            }
        }, new d<List<T>>() { // from class: com.kwad.sdk.glide.e.a.a.3
            @Override // com.kwad.sdk.glide.e.a.a.d
            public final /* synthetic */ void reset(Object obj) {
                ax((List) obj);
            }

            private static void ax(List<T> list) {
                list.clear();
            }
        });
    }

    private static <T extends c> Pools.Pool<T> a(Pools.Pool<T> pool, InterfaceC0602a<T> interfaceC0602a) {
        return a(pool, interfaceC0602a, ajG());
    }

    private static <T> Pools.Pool<T> a(Pools.Pool<T> pool, InterfaceC0602a<T> interfaceC0602a, d<T> dVar) {
        return new b(pool, interfaceC0602a, dVar);
    }

    private static <T> d<T> ajG() {
        return (d<T>) cat;
    }

    static final class b<T> implements Pools.Pool<T> {
        private final Pools.Pool<T> bSL;
        private final InterfaceC0602a<T> cau;
        private final d<T> cav;

        b(Pools.Pool<T> pool, InterfaceC0602a<T> interfaceC0602a, d<T> dVar) {
            this.bSL = pool;
            this.cau = interfaceC0602a;
            this.cav = dVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public final T acquire() {
            T tAcquire = this.bSL.acquire();
            if (tAcquire == null) {
                tAcquire = this.cau.agF();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof c) {
                tAcquire.agy().cW(false);
            }
            return (T) tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public final boolean release(T t) {
            if (t instanceof c) {
                ((c) t).agy().cW(true);
            }
            this.cav.reset(t);
            return this.bSL.release(t);
        }
    }
}
