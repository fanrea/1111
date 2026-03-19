package com.baidu.mobads.container.o;

import com.baidu.mobads.container.util.au;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h extends com.baidu.mobads.container.d.a {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    h(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.b.l.get(this.a);
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        au.a(this.b.b(this.a, e.g), new File(this.b.k + this.a + "0"), false);
        au.a(this.b.b(this.a, e.f), new File(this.b.k + this.a + "1"), false);
        return null;
    }
}
