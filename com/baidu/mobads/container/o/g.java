package com.baidu.mobads.container.o;

import com.baidu.mobads.container.util.au;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g extends com.baidu.mobads.container.d.a {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    g(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        au.a(this.b.b(this.a, e.g), new File(this.b.k + this.a + "0"), false);
        au.a(this.b.b(this.a, e.f), new File(this.b.k + this.a + "1"), false);
        return null;
    }
}
