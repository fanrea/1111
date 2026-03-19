package com.baidu.mobads.container.components.command;

import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements Runnable {
    final /* synthetic */ com.baidu.mobads.container.components.e.b a;
    final /* synthetic */ c b;

    d(c cVar, com.baidu.mobads.container.components.e.b bVar) {
        this.b = cVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.b.e.X == b.a.CANCELLED) {
                c.c.cancel(this.b.e.W);
                this.b.d("已取消下载");
            } else {
                c.c.notify(this.b.e.W, this.b.b(this.a));
                if (this.b.e.X != b.a.ERROR) {
                    if (this.b.e.X == b.a.COMPLETED) {
                        bq.a().a(c.a, "status >> complete");
                        this.b.n.postDelayed(new e(this), 1000L);
                    }
                } else {
                    bq.a().a(c.a, "status >> error");
                }
            }
        } catch (Exception e) {
            bq.a().a(c.a, e);
        }
    }
}
