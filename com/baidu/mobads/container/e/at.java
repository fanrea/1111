package com.baidu.mobads.container.e;

import com.component.a.g.c.bo;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class at implements bo.c {
    final /* synthetic */ l a;

    at(l lVar) {
        this.a = lVar;
    }

    @Override // com.component.a.g.c.bo.c
    public void a(int i) {
        if (this.a.A != null) {
            this.a.A.setText(String.format(Locale.getDefault(), this.a.B, Integer.valueOf(i / 1000)));
        }
    }
}
