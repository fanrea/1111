package com.baidu.mobads.container.components.e;

import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements Runnable {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.a.m.size(); i++) {
            try {
                if (!this.a.m.get(i).c()) {
                    this.a.m.get(i).f();
                }
            } catch (Throwable th) {
                bq.a().a("Downloader", th);
            }
        }
        this.a.a(this.a.d + this.a.g + ".tmp");
    }
}
