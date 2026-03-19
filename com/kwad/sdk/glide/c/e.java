package com.kwad.sdk.glide.c;

import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private final List<String> bZf = new ArrayList();
    private final Map<String, List<a<?, ?>>> bZg = new HashMap();

    public final synchronized void aw(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.bZf);
        this.bZf.clear();
        this.bZf.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.bZf.add(str);
            }
        }
    }

    public final synchronized <T, R> List<g<T, R>> e(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.bZf.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.bZg.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.b(cls, cls2)) {
                        arrayList.add(aVar.bQJ);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> List<Class<R>> f(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.bZf.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.bZg.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.b(cls, cls2) && !arrayList.contains(aVar.bSz)) {
                        arrayList.add(aVar.bSz);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> void a(String str, g<T, R> gVar, Class<T> cls, Class<R> cls2) {
        hq(str).add(new a<>(cls, cls2, gVar));
    }

    public final synchronized <T, R> void b(String str, g<T, R> gVar, Class<T> cls, Class<R> cls2) {
        hq(str).add(0, new a<>(cls, cls2, gVar));
    }

    private synchronized List<a<?, ?>> hq(String str) {
        List<a<?, ?>> arrayList;
        if (!this.bZf.contains(str)) {
            this.bZf.add(str);
        }
        arrayList = this.bZg.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.bZg.put(str, arrayList);
        }
        return arrayList;
    }

    static class a<T, R> {
        final g<T, R> bQJ;
        final Class<R> bSz;
        private final Class<T> dataClass;

        public a(Class<T> cls, Class<R> cls2, g<T, R> gVar) {
            this.dataClass = cls;
            this.bSz = cls2;
            this.bQJ = gVar;
        }

        public final boolean b(Class<?> cls, Class<?> cls2) {
            return this.dataClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.bSz);
        }
    }
}
