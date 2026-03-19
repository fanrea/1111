package com.kwad.sdk.glide.e;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g<T, Y> {
    private final long bUQ;
    private long bUS;
    private final Map<T, Y> cam = new LinkedHashMap(100, 0.75f, true);
    private long maxSize;

    protected int D(Y y) {
        return 1;
    }

    protected void b(T t, Y y) {
    }

    public g(long j) {
        this.bUQ = j;
        this.maxSize = j;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized Y get(T t) {
        return this.cam.get(t);
    }

    public final synchronized Y put(T t, Y y) {
        long jD = D(y);
        if (jD >= this.maxSize) {
            b(t, y);
            return null;
        }
        if (y != null) {
            this.bUS += jD;
        }
        Y yPut = this.cam.put(t, y);
        if (yPut != null) {
            this.bUS -= D(yPut);
            if (!yPut.equals(y)) {
                b(t, yPut);
            }
        }
        agY();
        return yPut;
    }

    public final synchronized Y remove(T t) {
        Y yRemove;
        yRemove = this.cam.remove(t);
        if (yRemove != null) {
            this.bUS -= D(yRemove);
        }
        return yRemove;
    }

    public final void clearMemory() {
        bp(0L);
    }

    protected final synchronized void bp(long j) {
        while (this.bUS > j) {
            Iterator<Map.Entry<T, Y>> it = this.cam.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.bUS -= D(value);
            T key = next.getKey();
            it.remove();
            b(key, value);
        }
    }

    private void agY() {
        bp(this.maxSize);
    }
}
