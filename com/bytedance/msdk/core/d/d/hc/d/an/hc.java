package com.bytedance.msdk.core.d.d.hc.d.an;

import android.util.SparseArray;
import com.kuaishou.android.live.network.ApiStatus;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private Function<SparseArray<Object>, Object> d;

    public hc(Function<SparseArray<Object>, Object> function) {
        this.d = function;
    }

    public int d() {
        if (this.d == null) {
            return ApiStatus.SC_INTERCEPT_BY_KEY_CONFIG;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40005);
        sparseArray.put(-99999985, Integer.class);
        return ((Integer) this.d.apply(sparseArray)).intValue();
    }

    public String hc() {
        if (this.d == null) {
            return "adn no msg";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40006);
        sparseArray.put(-99999985, String.class);
        return (String) this.d.apply(sparseArray);
    }
}
