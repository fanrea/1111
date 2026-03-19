package com.bytedance.framwork.core.de.ha;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: ListUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f {

    /* compiled from: ListUtils.java */
    public interface a<A, B> {
        boolean a(A a, B b);
    }

    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static <L, O> boolean a(Collection<L> collection, O o, a<? super L, O> aVar) {
        Iterator<L> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (aVar.a(it.next(), o)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
