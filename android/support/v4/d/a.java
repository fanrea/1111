package android.support.v4.d;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class a<K, V> extends k<K, V> implements Map<K, V> {
    g<K, V> bA;

    private g<K, V> L() {
        if (this.bA == null) {
            this.bA = new g<K, V>() { // from class: android.support.v4.d.a.1
                @Override // android.support.v4.d.g
                protected final int M() {
                    return a.this.mSize;
                }

                @Override // android.support.v4.d.g
                protected final Object d(int i, int i2) {
                    return a.this.bJ[(i << 1) + i2];
                }

                @Override // android.support.v4.d.g
                protected final int i(Object obj) {
                    return a.this.indexOfKey(obj);
                }

                @Override // android.support.v4.d.g
                protected final int j(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                @Override // android.support.v4.d.g
                protected final Map<K, V> N() {
                    return a.this;
                }

                @Override // android.support.v4.d.g
                protected final void a(K k, V v) {
                    a.this.put(k, v);
                }

                @Override // android.support.v4.d.g
                protected final V a(int i, V v) {
                    return a.this.setValueAt(i, v);
                }

                @Override // android.support.v4.d.g
                protected final void h(int i) {
                    a.this.removeAt(i);
                }

                @Override // android.support.v4.d.g
                protected final void O() {
                    a.this.clear();
                }
            };
        }
        return this.bA;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return L().R();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return L().S();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return L().T();
    }
}
