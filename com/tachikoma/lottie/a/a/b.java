package com.tachikoma.lottie.a.a;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private List<s> IN = new ArrayList();

    final void a(s sVar) {
        this.IN.add(sVar);
    }

    public final void a(Path path) {
        for (int size = this.IN.size() - 1; size >= 0; size--) {
            com.tachikoma.lottie.d.f.a(path, this.IN.get(size));
        }
    }
}
