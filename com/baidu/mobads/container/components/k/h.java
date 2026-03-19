package com.baidu.mobads.container.components.k;

import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.container.components.c.a;
import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements a.InterfaceC0121a {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    h(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    @Override // com.baidu.mobads.container.components.c.a.InterfaceC0121a
    public boolean a(Context context, Intent intent) {
        if (this.b.B != null) {
            this.b.B.run(new cm(b.u, this.a));
            return false;
        }
        return false;
    }
}
