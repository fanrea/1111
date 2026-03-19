package com.component.a.g.c;

import com.component.a.g.c.e;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements com.baidu.mobads.container.components.command.b {
    final /* synthetic */ e.a a;

    f(e.a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.mobads.container.components.command.b
    public void a() {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((com.baidu.mobads.container.components.command.b) it.next()).a();
        }
    }
}
