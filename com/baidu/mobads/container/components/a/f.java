package com.baidu.mobads.container.components.a;

import android.app.Activity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements com.baidu.mobads.container.components.b.e {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void a(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void b(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void c(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void d(Activity activity) {
        this.a.d = System.currentTimeMillis() - this.a.d;
        if (this.a.d < 600) {
            this.a.a();
            return;
        }
        if (!this.a.e) {
            o.a().a(204, this.a.a.d());
            o.a().a(205, this.a.a);
        }
        this.a.a();
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void e(Activity activity) {
        this.a.d = System.currentTimeMillis();
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void f(Activity activity) {
        this.a.e = true;
    }
}
