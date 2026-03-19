package com.baidu.mobads.container.components.command;

import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements Runnable {
    final /* synthetic */ IOAdEventListener a;
    final /* synthetic */ c b;

    f(c cVar, IOAdEventListener iOAdEventListener) {
        this.b = cVar;
        this.a = iOAdEventListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        cm cmVar = new cm(com.baidu.mobads.container.components.k.b.u, this.b.e.Z);
        if (cmVar.getData() != null) {
            cmVar.getData().put("adid", this.b.e.ag);
        }
        this.a.run(cmVar);
    }
}
