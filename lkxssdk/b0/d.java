package lkxssdk.b0;

import android.util.SparseIntArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class d<T> {
    public SparseIntArray a;

    public d a(int i, int i2) {
        if (this.a == null) {
            this.a = new SparseIntArray();
        }
        this.a.put(i, i2);
        return this;
    }
}
