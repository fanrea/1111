package com.qq.e.comm.plugin;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l50<K, V> {
    private Map<K, List<WeakReference<V>>> a = new HashMap();

    public synchronized void a(K k, V v) {
        List<WeakReference<V>> arrayList = this.a.get(k);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.a.put(k, arrayList);
        }
        arrayList.add(new WeakReference<>(v));
    }

    public synchronized Collection<V> a(K k) {
        List<WeakReference<V>> list = this.a.get(k);
        if (list != null && !list.isEmpty()) {
            Iterator<WeakReference<V>> it = list.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                V v = it.next().get();
                if (v == null) {
                    it.remove();
                } else {
                    arrayList.add(v);
                }
            }
            if (arrayList.isEmpty()) {
                this.a.remove(k);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public synchronized void a(String str, V v) {
        List<WeakReference<V>> list = this.a.get(str);
        if (list != null) {
            Iterator<WeakReference<V>> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().get() == v) {
                    it.remove();
                }
            }
        }
    }
}
