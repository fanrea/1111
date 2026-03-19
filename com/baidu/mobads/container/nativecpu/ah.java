package com.baidu.mobads.container.nativecpu;

import android.view.View;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ah implements Runnable {
    final /* synthetic */ t a;

    ah(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View viewFindViewById;
        if (this.a.b == null) {
            return;
        }
        if (this.a.c != null && (this.a.c.getTag() instanceof a)) {
            ((a) this.a.c.getTag()).onImpression(this.a.c);
        }
        if (this.a.c != null && (viewFindViewById = this.a.c.findViewById(337)) != null && (viewFindViewById.getTag() instanceof a)) {
            ((a) viewFindViewById.getTag()).onImpression(viewFindViewById);
        }
        View viewFindViewById2 = this.a.b.findViewById(this.a.j);
        if (viewFindViewById2 instanceof TextView) {
            viewFindViewById2.setVisibility(4);
        }
    }
}
