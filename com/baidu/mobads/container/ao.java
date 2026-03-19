package com.baidu.mobads.container;

import com.style.widget.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ao implements v.c {
    final /* synthetic */ k a;

    ao(k kVar) {
        this.a = kVar;
    }

    @Override // com.style.widget.v.c
    public void a(boolean z) {
        this.a.handlePause(null);
        this.a.reasonValue = 4;
    }

    @Override // com.style.widget.v.c
    public void b(boolean z) {
        this.a.handleResume(null);
    }
}
