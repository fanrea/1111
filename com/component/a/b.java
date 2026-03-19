package com.component.a;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.cf;
import com.component.a.i.p;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b extends cf.a {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    b(a aVar, ViewGroup viewGroup, int i) {
        this.c = aVar;
        this.a = viewGroup;
        this.b = i;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        p.a(this.a, this.c.b, this.c.a, this.b, (RelativeLayout.LayoutParams) null);
    }
}
