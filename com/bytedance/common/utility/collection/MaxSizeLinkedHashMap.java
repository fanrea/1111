package com.bytedance.common.utility.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float FACTOR = 0.75f;
    private static final long serialVersionUID = 3805937866184666407L;
    final int mMaxSize;

    public MaxSizeLinkedHashMap(int i, int i2) {
        this(i, i2, false);
    }

    public MaxSizeLinkedHashMap(int i, int i2, boolean z) {
        super(i2, 0.75f, true);
        this.mMaxSize = i;
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.mMaxSize;
    }
}
