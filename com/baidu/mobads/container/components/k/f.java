package com.baidu.mobads.container.components.k;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.container.activity.v;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.k;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements v {
    final /* synthetic */ k a;
    final /* synthetic */ j b;
    final /* synthetic */ Context c;
    final /* synthetic */ HashMap m;
    final /* synthetic */ String n;
    final /* synthetic */ String o;
    final /* synthetic */ String p;
    final /* synthetic */ c q;

    f(c cVar, k kVar, j jVar, Context context, HashMap map, String str, String str2, String str3) {
        this.q = cVar;
        this.a = kVar;
        this.b = jVar;
        this.c = context;
        this.m = map;
        this.n = str;
        this.o = str2;
        this.p = str3;
    }

    @Override // com.baidu.mobads.container.activity.v
    public void d() {
        this.a.handlePause(this.b);
        this.q.E = false;
        this.q.a(this.b, 200, false);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void e() {
        com.baidu.mobads.container.activity.e.a().b(this.q.D);
        this.a.handleResume(this.b);
        if (!this.q.E) {
            this.q.a(this.b, 202, true);
        }
    }

    @Override // com.baidu.mobads.container.activity.v
    public void f() {
        this.a.onPermissionShow(this.b);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void g() {
        this.a.onPermissionClose(this.b);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void h() {
        this.a.onPrivacyClick(this.b);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void i() {
        this.a.onPrivacyLpClose(this.b);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void j() {
        this.a.onFunctionClick(this.b);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void k() {
        this.a.onFunctionLpClose(this.b);
    }

    @Override // com.baidu.mobads.container.activity.v
    public void l() {
        this.q.E = true;
        this.q.a(this.b, 201, true);
        this.q.a(this.c, this.m, this.b, this.n, this.o, this.p, this.a);
        this.a.onAdClick(this.b, (View) this.m.get("adView"));
    }
}
