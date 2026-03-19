package com.baidu.mobads.container.nativecpu;

import android.view.View;
import com.baidu.mobads.container.util.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements bh.a {
    final /* synthetic */ bh a;
    final /* synthetic */ View b;
    final /* synthetic */ a c;

    d(a aVar, bh bhVar, View view) {
        this.c = aVar;
        this.a = bhVar;
        this.b = view;
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a() {
        this.a.b();
        this.c.q.set(false);
        if (this.c.r) {
            this.c.a(1045);
        }
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a(int i) {
        this.c.g = com.baidu.mobads.container.util.r.d(this.b);
        StringBuilder sb = new StringBuilder();
        a aVar = this.c;
        aVar.f = sb.append(aVar.f).append(this.c.g).toString();
        this.c.t = i;
        if (this.c.f.endsWith("00")) {
            this.a.b();
            this.c.q.set(false);
            this.c.a(this.b.getContext());
            if (this.c.p.get() && this.c.r) {
                this.c.a(1045);
                this.c.r = false;
            }
        }
    }
}
