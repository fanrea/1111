package com.bytedance.common.utility.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WeakContainer<E> implements Iterable<E> {
    private final WeakHashMap<E, Object> mMap = new WeakHashMap<>();
    private final Object mValue = new Object();

    public void add(E e) {
        if (e == null) {
            this.mMap.size();
        } else {
            this.mMap.put(e, this.mValue);
        }
    }

    public void clear() {
        this.mMap.clear();
    }

    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    public int size() {
        return this.mMap.size();
    }

    public void remove(E e) {
        if (e == null) {
            this.mMap.size();
        } else {
            this.mMap.remove(e);
        }
    }

    public E peek() {
        E e = null;
        if (this.mMap.size() == 0) {
            return null;
        }
        Iterator<E> it = this.mMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            E next = it.next();
            if (next != null) {
                e = next;
                break;
            }
        }
        this.mMap.remove(e);
        return e;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        ArrayList arrayList = new ArrayList(this.mMap.size());
        for (E e : this.mMap.keySet()) {
            if (e != null) {
                arrayList.add(e);
            }
        }
        return arrayList.iterator();
    }

    public boolean contains(E e) {
        return this.mMap.containsKey(e);
    }
}
