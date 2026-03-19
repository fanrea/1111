package com.baidu.mobads.container;

import android.content.Context;
import com.baidu.mobads.container.util.bw;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;
    final /* synthetic */ c b;

    d(c cVar, Context context) {
        this.b = cVar;
        this.a = context;
    }

    @Override // com.baidu.mobads.container.d.a
    public Object a() {
        this.b.b = String.format("%s/%s", bw.i(this.a), "pdata");
        this.b.c = this.b.b(this.b.b, this.b.d);
        return null;
    }
}
