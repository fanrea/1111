package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.kwad.sdk.utils.ax;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements com.kwad.sdk.glide.load.engine.bitmap_recycle.b {
    private int OJ;
    private final b bUI;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> bUJ;
    private final Map<Class<?>, com.kwad.sdk.glide.load.engine.bitmap_recycle.a<?>> bUK;
    private final h<a, Object> bUy;
    private final int maxSize;

    public j() {
        this.bUy = new h<>();
        this.bUI = new b();
        this.bUJ = new HashMap();
        this.bUK = new HashMap();
        this.maxSize = 4194304;
    }

    public j(int i) {
        this.bUy = new h<>();
        this.bUI = new b();
        this.bUJ = new HashMap();
        this.bUK = new HashMap();
        this.maxSize = i;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public final <T> void B(T t) {
        put(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public final synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> aVarN = n(cls);
        int iA = aVarN.A(t);
        int iAgR = aVarN.agR() * iA;
        if (gh(iAgR)) {
            a aVarE = this.bUI.e(iA, cls);
            this.bUy.a(aVarE, t);
            NavigableMap<Integer, Integer> navigableMapM = m(cls);
            Integer num = (Integer) navigableMapM.get(Integer.valueOf(aVarE.size));
            Integer numValueOf = Integer.valueOf(aVarE.size);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM.put(numValueOf, Integer.valueOf(iIntValue));
            this.OJ += iAgR;
            agY();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public final synchronized <T> T b(int i, Class<T> cls) {
        return (T) a(this.bUI.e(8, cls), cls);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public final synchronized <T> T a(int i, Class<T> cls) {
        a aVarE;
        Integer numCeilingKey = m(cls).ceilingKey(Integer.valueOf(i));
        if (a(i, numCeilingKey)) {
            aVarE = this.bUI.e(numCeilingKey.intValue(), cls);
        } else {
            aVarE = this.bUI.e(i, cls);
        }
        return (T) a(aVarE, cls);
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> aVarN = n(cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.OJ -= aVarN.A(t) * aVarN.agR();
            c(aVarN.A(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(aVarN.getTag(), 2)) {
            Log.v(aVarN.getTag(), "Allocated " + aVar.size + " bytes");
        }
        return aVarN.ge(aVar.size);
    }

    private <T> T a(a aVar) {
        return (T) this.bUy.b((h<a, Object>) aVar);
    }

    private boolean gh(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean a(int i, Integer num) {
        if (num != null) {
            return agX() || num.intValue() <= i * 8;
        }
        return false;
    }

    private boolean agX() {
        int i = this.OJ;
        return i == 0 || this.maxSize / i >= 2;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public final synchronized void clearMemory() {
        gi(0);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public final synchronized void fV(int i) {
        if (i >= 40) {
            clearMemory();
            return;
        }
        if (i >= 20 || i == 15) {
            gi(this.maxSize / 2);
        }
    }

    private void agY() {
        gi(this.maxSize);
    }

    private void gi(int i) {
        while (this.OJ > i) {
            Object objRemoveLast = this.bUy.removeLast();
            ax.checkNotNull(objRemoveLast);
            com.kwad.sdk.glide.load.engine.bitmap_recycle.a aVarC = C(objRemoveLast);
            this.OJ -= aVarC.A(objRemoveLast) * aVarC.agR();
            c(aVarC.A(objRemoveLast), objRemoveLast.getClass());
            if (Log.isLoggable(aVarC.getTag(), 2)) {
                Log.v(aVarC.getTag(), "evicted: " + aVarC.A(objRemoveLast));
            }
        }
    }

    private void c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapM = m(cls);
        Integer num = (Integer) navigableMapM.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        if (num.intValue() == 1) {
            navigableMapM.remove(Integer.valueOf(i));
        } else {
            navigableMapM.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.bUJ.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.bUJ.put(cls, treeMap);
        return treeMap;
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> C(T t) {
        return n(t.getClass());
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> n(Class<T> cls) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> gVar = (com.kwad.sdk.glide.load.engine.bitmap_recycle.a) this.bUK.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.bUK.put(cls, gVar);
        }
        return gVar;
    }

    static final class b extends d<a> {
        b() {
        }

        final a e(int i, Class<?> cls) {
            a aVarAgW = agW();
            aVarAgW.d(i, cls);
            return aVarAgW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: agZ, reason: merged with bridge method [inline-methods] */
        public a agV() {
            return new a(this);
        }
    }

    static final class a implements m {
        private final b bUL;
        private Class<?> bUM;
        int size;

        a(b bVar) {
            this.bUL = bVar;
        }

        final void d(int i, Class<?> cls) {
            this.size = i;
            this.bUM = cls;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.size == aVar.size && this.bUM == aVar.bUM) {
                    return true;
                }
            }
            return false;
        }

        public final String toString() {
            return "Key{size=" + this.size + "array=" + this.bUM + '}';
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public final void agT() {
            this.bUL.a(this);
        }

        public final int hashCode() {
            int i = this.size * 31;
            Class<?> cls = this.bUM;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
