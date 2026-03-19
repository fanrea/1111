package com.bytedance.sdk.djx.core.util;

import android.util.Log;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LRUCache<K, V> {
    LinkedHashMap<K, V> cache;
    int capacity;
    Removed<V> mRemoved;

    public interface Removed<V> {
        void onRemove(V v);
    }

    public LRUCache(int i) {
        this.cache = new LinkedHashMap<>(i);
        this.capacity = i;
    }

    public LRUCache(int i, Removed<V> removed) {
        this.capacity = i;
        this.mRemoved = removed;
    }

    public V get(K k) {
        if (!this.cache.containsKey(k)) {
            return null;
        }
        V v = this.cache.get(k);
        this.cache.remove(k);
        this.cache.put(k, v);
        return v;
    }

    public void put(K k, V v) {
        this.cache.remove(k);
        if (this.capacity == this.cache.size()) {
            V vRemove = this.cache.remove(this.cache.keySet().iterator().next());
            Removed<V> removed = this.mRemoved;
            if (removed != null) {
                removed.onRemove(vRemove);
                Log.d("LiveCardAdItemModel", "put: remove");
            }
        }
        this.cache.put(k, v);
    }

    public boolean containsKey(K k) {
        return this.cache.containsKey(k);
    }
}
