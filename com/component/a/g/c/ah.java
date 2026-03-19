package com.component.a.g.c;

import com.baidu.mobads.container.util.cf;
import com.component.a.g.c.aa;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ah extends cf.a {
    final /* synthetic */ aa.b a;

    ah(aa.b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        double d = this.a.g;
        Double.isNaN(d);
        this.a.b.setText(this.a.f.replace("XX", String.valueOf((int) Math.round(d / 1000.0d))));
        aa.b.a(this.a, 200);
        if (this.a.g >= 0) {
            this.a.a(this, 200L);
        }
    }
}
