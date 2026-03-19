package com.lingku.xuanshang.xutils.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DoubleKeyValueMap<K1, K2, V> {
    public final ConcurrentHashMap<K1, ConcurrentHashMap<K2, V>> a = new ConcurrentHashMap<>();

    public void clear() {
        if (this.a.size() > 0) {
            Iterator<ConcurrentHashMap<K2, V>> it = this.a.values().iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.a.clear();
        }
    }

    public boolean containsKey(K1 k1) {
        return this.a.containsKey(k1);
    }

    public boolean containsKey(K1 k1, K2 k2) {
        ConcurrentHashMap<K2, V> concurrentHashMap;
        if (!this.a.containsKey(k1) || (concurrentHashMap = this.a.get(k1)) == null) {
            return false;
        }
        return concurrentHashMap.containsKey(k2);
    }

    public V get(K1 k1, K2 k2) {
        ConcurrentHashMap<K2, V> concurrentHashMap = this.a.get(k1);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(k2);
    }

    public ConcurrentHashMap<K2, V> get(K1 k1) {
        return this.a.get(k1);
    }

    public Collection<V> getAllValues() {
        Collection<V> collectionValues;
        Set<K1> setKeySet = this.a.keySet();
        if (setKeySet == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<K1> it = setKeySet.iterator();
        while (it.hasNext()) {
            ConcurrentHashMap<K2, V> concurrentHashMap = this.a.get(it.next());
            if (concurrentHashMap != null && (collectionValues = concurrentHashMap.values()) != null) {
                arrayList.addAll(collectionValues);
            }
        }
        return arrayList;
    }

    public Collection<V> getAllValues(K1 k1) {
        ConcurrentHashMap<K2, V> concurrentHashMap = this.a.get(k1);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.values();
    }

    public Set<K1> getFirstKeys() {
        return this.a.keySet();
    }

    public void put(K1 k1, K2 k2, V v) {
        ConcurrentHashMap<K2, V> concurrentHashMap;
        if (k1 == null || k2 == null || v == null) {
            return;
        }
        if (this.a.containsKey(k1) && (concurrentHashMap = this.a.get(k1)) != null) {
            concurrentHashMap.put(k2, v);
            return;
        }
        ConcurrentHashMap<K2, V> concurrentHashMap2 = new ConcurrentHashMap<>();
        concurrentHashMap2.put(k2, v);
        this.a.put(k1, concurrentHashMap2);
    }

    public void remove(K1 k1) {
        this.a.remove(k1);
    }

    public void remove(K1 k1, K2 k2) {
        ConcurrentHashMap<K2, V> concurrentHashMap = this.a.get(k1);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(k2);
        }
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            this.a.remove(k1);
        }
    }

    public int size() {
        int size = 0;
        if (this.a.size() == 0) {
            return 0;
        }
        Iterator<ConcurrentHashMap<K2, V>> it = this.a.values().iterator();
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }
}
