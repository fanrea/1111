package com.baidu.mobads.container.w.b;

import android.app.Application;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h extends com.baidu.mobads.container.w.c.f {
    private com.baidu.mobads.container.w.h.h f;
    private com.baidu.mobads.container.w.a.a g;

    @Override // com.baidu.mobads.container.w.c.f, com.baidu.mobads.container.w.c.d
    public void a(Application application, g gVar) {
        super.a(application, gVar);
        this.f = new com.baidu.mobads.container.w.h.h();
        this.g = new com.baidu.mobads.container.w.a.a();
    }

    @Override // com.baidu.mobads.container.w.c.f, com.baidu.mobads.container.w.c.d
    public void a() {
        super.a();
        if (!i()) {
            return;
        }
        if (this.f != null) {
            this.f.d();
        }
        if (this.g != null) {
            this.g.d();
        }
    }

    @Override // com.baidu.mobads.container.w.c.f, com.baidu.mobads.container.w.c.d
    public void c() {
        super.c();
        if (!i()) {
            return;
        }
        if (this.f != null) {
            this.f.e();
        }
        if (this.g != null) {
            this.g.e();
        }
    }
}
