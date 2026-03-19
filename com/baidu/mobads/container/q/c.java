package com.baidu.mobads.container.q;

import android.content.Context;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.f.z;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    c(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            if (this.a != null) {
                com.baidu.enan.a.a(this.a, 24);
                this.b.b(this.a);
                com.baidu.enan.a.a(this.b.b, IDManager.getInstance().a(this.a));
                com.baidu.enan.a.a(this.b.c, z.a(this.a));
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
