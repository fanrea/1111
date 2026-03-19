package com.baidu.mobads.container.n;

import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a(null, "请求超时");
        } catch (Exception e) {
            bq.a().c(e.getMessage());
        }
    }
}
