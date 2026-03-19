package com.bytedance.common.utility.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WeakValueMap<K, V> {
    private final HashMap<K, WeakValue<K, V>> mMap = new HashMap<>();
    private final ReferenceQueue<V> mRefrenceQueue = new ReferenceQueue<>();

    public static final class WeakValue<K, V> extends WeakReference<V> {
        final K mKey;

        public WeakValue(K k, V v, ReferenceQueue<V> referenceQueue) {
            super(v, referenceQueue);
            this.mKey = k;
        }
    }

    private void poll() {
        while (true) {
            WeakValue weakValue = (WeakValue) this.mRefrenceQueue.poll();
            if (weakValue == null) {
                return;
            }
            if (!this.mMap.isEmpty()) {
                this.mMap.remove(weakValue.mKey);
            }
        }
    }

    public V get(K k) {
        WeakValue<K, V> weakValue;
        poll();
        if (k == null || (weakValue = this.mMap.get(k)) == null) {
            return null;
        }
        return (V) weakValue.get();
    }

    public void put(K k, V v) {
        if (k == null || v == null) {
            return;
        }
        this.mMap.remove(k);
        poll();
        this.mMap.put(k, new WeakValue<>(k, v, this.mRefrenceQueue));
    }

    public void remove(K k) {
        poll();
        if (k != null) {
            this.mMap.remove(k);
        }
    }

    public void clear() {
        this.mMap.clear();
        poll();
    }

    public boolean isEmpty() {
        poll();
        return this.mMap.isEmpty();
    }

    public int size() {
        poll();
        return this.mMap.size();
    }
}
