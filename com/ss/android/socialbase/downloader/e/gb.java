package com.ss.android.socialbase.downloader.e;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb<K, T> extends LinkedHashMap<K, T> {
    private int d;

    public gb() {
        this(4, 4);
    }

    public gb(int i, int i2) {
        this(i, i2, true);
    }

    public gb(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        d(i2);
    }

    public void d(int i) {
        this.d = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.d;
    }
}
