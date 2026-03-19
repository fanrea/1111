package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class mq<V> {
    private final V d;
    private final Throwable hc;

    public mq(V v) {
        this.d = v;
        this.hc = null;
    }

    public mq(Throwable th) {
        this.hc = th;
        this.d = null;
    }

    public V d() {
        return this.d;
    }

    public Throwable hc() {
        return this.hc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mq)) {
            return false;
        }
        mq mqVar = (mq) obj;
        if (d() != null && d().equals(mqVar.d())) {
            return true;
        }
        if (hc() == null || mqVar.hc() == null) {
            return false;
        }
        return hc().toString().equals(hc().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{d(), hc()});
    }
}
