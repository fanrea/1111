package com.baidu.mobads.container.components.c;

import android.content.Context;
import com.baidu.mobads.container.components.a.o;
import com.baidu.mobads.container.util.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    b(a aVar, Context context, String str) {
        this.c = aVar;
        this.a = context;
        this.b = str;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        a.a(this.c, 1000);
        if (this.c.g > this.c.c.aA) {
            this.c.c(404, true);
            if (!this.c.h && o.a().b()) {
                o.a().a(204, this.c.c.d());
                o.a().a(205, this.c.c);
            }
            a_();
            return null;
        }
        if (t.f(this.a, this.b)) {
            a_();
        }
        if (t.f(this.a, this.a.getPackageName())) {
            a_();
            this.c.f.b(this.a, this.c.c, this.c.h);
            if (!this.c.h && this.c.d()) {
                new com.baidu.mobads.container.components.a.e().a(this.a, this.c.c);
            }
            this.c.a(this.a);
            return null;
        }
        return null;
    }
}
