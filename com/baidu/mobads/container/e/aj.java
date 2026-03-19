package com.baidu.mobads.container.e;

import android.graphics.Rect;
import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aj extends cf.a {
    final /* synthetic */ l a;

    aj(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        if (this.a.C == null) {
            return;
        }
        Rect rect = new Rect();
        this.a.C.getGlobalVisibleRect(rect);
        this.a.an = rect.top;
        this.a.ao = rect.bottom;
        if (this.a.am != 0) {
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
