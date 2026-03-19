package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private final List<sy> d = new ArrayList();

    void d(sy syVar) {
        this.d.add(syVar);
    }

    public void d(Path path) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.u.tt.d(path, this.d.get(size));
        }
    }
}
