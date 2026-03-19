package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class aa {
    List<z9<?>> a = new ArrayList();
    Object b;

    aa() {
    }

    void a() {
        this.b = null;
        Iterator<z9<?>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
