package com.baidu.mobads.container.s;

import android.view.View;
import com.component.a.g.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ad extends d.c {
    final /* synthetic */ ab a;

    ad(ab abVar) {
        this.a = abVar;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        if ("lottie_shake_view".equals(str2) && (view instanceof com.component.a.a.f)) {
            this.a.o = (com.component.a.a.f) view;
        }
    }
}
