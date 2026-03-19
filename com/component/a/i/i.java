package com.component.a.i;

import android.view.View;
import com.component.a.i.f;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ f d;

    i(f fVar, String str, View view, int i) {
        this.d = fVar;
        this.a = str;
        this.b = view;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.d.c.iterator();
        while (it.hasNext()) {
            ((f.a) it.next()).a(this.a, this.b, this.c);
        }
    }
}
