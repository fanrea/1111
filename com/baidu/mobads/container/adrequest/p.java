package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.container.components.g.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements f.a {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, String str2) {
        if (this.a.J) {
            return;
        }
        this.a.x = System.currentTimeMillis() - this.a.w;
        this.a.b(str, "");
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, int i) {
        int i2;
        if (this.a.J) {
            return;
        }
        this.a.p.a(this.a.f720K, com.baidu.mobads.container.components.h.b.e.j, String.valueOf(i));
        this.a.p.a(this.a.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_FAILED, str);
        this.a.u = System.currentTimeMillis();
        if (i != 1) {
            i2 = 502;
        } else {
            i2 = 408;
        }
        this.a.q.a(this.a.F, i2, this.a.u - this.a.w);
        this.a.a(com.baidu.mobads.container.c.a.AD_REQUEST_ERROR.b(), com.baidu.mobads.container.c.a.AD_REQUEST_ERROR.c());
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(long j) {
        this.a.s = System.currentTimeMillis();
        com.baidu.mobads.container.components.h.c.f.a(this.a.b).a(this.a.f720K, com.baidu.mobads.container.components.h.b.e.k, String.valueOf(j));
        com.baidu.mobads.container.components.h.c.f.a(this.a.b).a(this.a.f720K, com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_SUCCESS);
    }
}
