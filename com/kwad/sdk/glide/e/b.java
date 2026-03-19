package com.kwad.sdk.glide.e;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<K, V> extends ArrayMap<K, V> {
    private int bUb;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        this.bUb = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap
    public final V setValueAt(int i, V v) {
        this.bUb = 0;
        return (V) super.setValueAt(i, v);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final V put(K k, V v) {
        this.bUb = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.bUb = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final V removeAt(int i) {
        this.bUb = 0;
        return (V) super.removeAt(i);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final int hashCode() {
        if (this.bUb == 0) {
            this.bUb = super.hashCode();
        }
        return this.bUb;
    }
}
