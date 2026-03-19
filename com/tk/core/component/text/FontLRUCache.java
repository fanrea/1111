package com.tk.core.component.text;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class FontLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    private final ReentrantReadWriteLock lock;

    public FontLRUCache(int i) {
        super(i, 0.75f, true);
        this.lock = new ReentrantReadWriteLock();
        this.capacity = i;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        this.lock.readLock().lock();
        try {
            return (V) super.get(obj);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        this.lock.writeLock().lock();
        try {
            return (V) super.put(k, v);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        this.lock.readLock().lock();
        try {
            return super.containsKey(obj);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.capacity;
    }
}
