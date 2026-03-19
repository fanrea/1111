package com.bytedance.adsdk.lottie.model;

import android.util.Pair;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h<T> {
    T d;
    T hc;

    public void d(T t, T t2) {
        this.d = t;
        this.hc = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return hc(pair.first, this.d) && hc(pair.second, this.hc);
    }

    private static boolean hc(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.d;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.hc;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.d + " " + this.hc + i.d;
    }
}
