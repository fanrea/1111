package com.component.a.i;

import android.view.View;
import com.component.a.i.f;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ View b;
    final /* synthetic */ com.baidu.mobads.container.util.d.c c;
    final /* synthetic */ f d;

    j(f fVar, String str, View view, com.baidu.mobads.container.util.d.c cVar) {
        this.d = fVar;
        this.a = str;
        this.b = view;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.d.c.iterator();
        while (it.hasNext()) {
            ((f.a) it.next()).a(this.a, this.b, this.c);
        }
    }
}
