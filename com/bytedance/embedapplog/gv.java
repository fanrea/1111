package com.bytedance.embedapplog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class gv<T> {
    private volatile T d;

    protected abstract T d(Object... objArr);

    gv() {
    }

    public final T hc(Object... objArr) {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = d(objArr);
                }
            }
        }
        return this.d;
    }
}
