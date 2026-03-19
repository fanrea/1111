package com.baidu.mobads.container.x;

import android.view.View;
import com.baidu.mobads.container.x.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements View.OnClickListener {
    final /* synthetic */ a.C0142a a;

    f(a.C0142a c0142a) {
        this.a = c0142a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iG;
        if (a.this.g != null) {
            if (a.this.e != null) {
                iG = a.this.e.g();
            } else {
                iG = 0;
            }
            a.this.g.a(iG);
        }
    }
}
