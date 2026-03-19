package com.bytedance.sdk.component.tc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb<V> extends FutureTask<V> implements Comparable<gb<V>> {
    private int d;
    private int hc;

    public gb(Callable<V> callable, int i, int i2) {
        super(callable);
        this.d = i == -1 ? 5 : i;
        this.hc = i2;
    }

    public gb(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.d = i == -1 ? 5 : i;
        this.hc = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(gb gbVar) {
        if (d() < gbVar.d()) {
            return 1;
        }
        return d() > gbVar.d() ? -1 : 0;
    }

    public int d() {
        return this.d;
    }
}
