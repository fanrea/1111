package com.bytedance.sdk.component.adexpress.dynamic.b;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    public float d;
    public float hc;

    public tt(float f, float f2) {
        this.d = f;
        this.hc = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            tt ttVar = (tt) obj;
            if (Float.compare(ttVar.d, this.d) == 0 && Float.compare(ttVar.hc, this.hc) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.d), Float.valueOf(this.hc)});
    }
}
