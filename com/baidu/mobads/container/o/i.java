package com.baidu.mobads.container.o;

import com.baidu.mobads.container.util.au;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i extends com.baidu.mobads.container.d.a {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    i(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() throws IOException {
        au.h(new File(this.b.k + this.a + "0"));
        au.h(new File(this.b.k + this.a + "1"));
        return null;
    }
}
