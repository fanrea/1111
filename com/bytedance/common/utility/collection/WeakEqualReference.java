package com.bytedance.common.utility.collection;

import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WeakEqualReference<T> extends WeakReference<T> {
    int hash;

    public WeakEqualReference(T t) {
        super(t);
        this.hash = t == null ? 0 : t.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WeakEqualReference)) {
            return false;
        }
        Object obj2 = super.get();
        Object obj3 = ((WeakEqualReference) obj).get();
        if (obj2 == null) {
            return obj2 == obj3;
        }
        return obj2.equals(obj3);
    }

    public int hashCode() {
        return this.hash;
    }
}
