package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class Coconut<T> {
    public volatile T a;

    public abstract T a();

    public final T b() {
        T tA = this.a;
        if (tA == null) {
            synchronized (this) {
                tA = this.a;
                if (tA == null) {
                    tA = a();
                    this.a = tA;
                }
            }
        }
        return tA;
    }
}
