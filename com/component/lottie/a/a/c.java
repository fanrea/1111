package com.component.lottie.a.a;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private final List<y> a = new ArrayList();

    void a(y yVar) {
        this.a.add(yVar);
    }

    public void a(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            com.component.lottie.g.g.a(path, this.a.get(size));
        }
    }
}
