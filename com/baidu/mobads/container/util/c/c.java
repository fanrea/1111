package com.baidu.mobads.container.util.c;

import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.components.b.e;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c extends com.baidu.mobads.container.d.a {
    final /* synthetic */ t a;
    final /* synthetic */ String b;
    final /* synthetic */ j c;
    final /* synthetic */ HashMap d;
    final /* synthetic */ e e;
    final /* synthetic */ a f;

    c(a aVar, t tVar, String str, j jVar, HashMap map, e eVar) {
        this.f = aVar;
        this.a = tVar;
        this.b = str;
        this.c = jVar;
        this.d = map;
        this.e = eVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        a.a += 100;
        if (this.f.f) {
            a_();
            if (this.f.i > 15000) {
                this.f.i = System.currentTimeMillis() - this.f.i;
            }
            this.f.a(this.a, this.b, this.c);
            return null;
        }
        if (a.a <= 15000) {
            return null;
        }
        a_();
        this.f.i = 15000L;
        this.f.a(this.a, this.c, (HashMap<String, String>) this.d, this.e);
        this.f.a(this.a, this.b, this.c);
        return null;
    }
}
