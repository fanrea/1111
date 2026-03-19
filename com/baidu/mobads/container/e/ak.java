package com.baidu.mobads.container.e;

import android.graphics.Rect;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ak extends cf.a {
    final /* synthetic */ l a;

    ak(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        if (this.a.D == null) {
            return;
        }
        Rect rect = new Rect();
        this.a.D.getGlobalVisibleRect(rect);
        this.a.al = rect.top;
        this.a.am = rect.bottom;
        this.a.ar = rect.bottom + 10;
        if (this.a.an != 0) {
            if ((this.a.al < this.a.an && this.a.an < this.a.am) || (this.a.al < this.a.ao && this.a.ao < this.a.am)) {
                l lVar = this.a;
                double d = this.a.am - this.a.an;
                double d2 = this.a.ao - this.a.an;
                Double.isNaN(d);
                Double.isNaN(d2);
                lVar.a(true, d / d2);
                return;
            }
            this.a.a(false, 0.0d);
        }
    }
}
