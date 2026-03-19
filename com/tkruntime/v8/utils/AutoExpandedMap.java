package com.tkruntime.v8.utils;

import com.tkruntime.v8.V8Value;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class AutoExpandedMap<K, V> extends HashMap<K, V> {
    public AutoExpandedMap() {
    }

    public AutoExpandedMap(Map map) {
        super(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        V v = (V) super.get(obj);
        if (!(v instanceof V8Value)) {
            return v;
        }
        V v2 = (V) V8ObjectUtilsQuick.getValue((V8Value) v);
        if (v2 != v) {
            put(obj, v2);
        }
        return v2;
    }
}
