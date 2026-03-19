package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.components.g.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements f.a {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, String str2) {
        if (!this.a.c) {
            this.a.a(str);
        }
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, int i) {
        if (!this.a.c) {
            this.a.a(com.baidu.mobads.container.c.a.AD_REQUEST_ERROR.b(), com.baidu.mobads.container.c.a.AD_REQUEST_ERROR.c());
        }
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(long j) {
    }
}
