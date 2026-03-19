package com.baidu.mobads.container.nativecpu;

import android.view.View;
import com.baidu.mobads.container.util.ci;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements ci.b {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.mobads.container.util.ci.b
    public void a(View view, boolean z) {
        if (z) {
            this.a.f = System.currentTimeMillis();
        } else {
            this.a.j = System.currentTimeMillis();
            this.a.a(this.a.f, this.a.j);
        }
    }
}
