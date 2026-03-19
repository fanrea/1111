package com.baidu.mobads.container.util.b;

import com.baidu.mobads.container.util.bq;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j extends com.baidu.mobads.container.d.a {
    final /* synthetic */ f a;
    final /* synthetic */ g b;

    j(g gVar, f fVar) {
        this.b = gVar;
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            if (this.a != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String name = ((File) this.a.b()).getName();
                g.c(this.b);
                this.a.d();
                this.b.e("File deleted using " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms: " + name);
                return null;
            }
            return null;
        } catch (Throwable th) {
            bq.a().a("Failed to delete file. " + th);
            return null;
        }
    }
}
