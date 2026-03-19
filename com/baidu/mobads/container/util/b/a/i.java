package com.baidu.mobads.container.util.b.a;

import com.baidu.mobads.container.util.b.a.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i implements k {
    private static final String a = "HttpClientInterceptor";

    @Override // com.baidu.mobads.container.util.b.a.k
    public com.baidu.mobads.container.util.b.f<?> a(k.b bVar, k.a aVar) {
        b bVarA = bVar.a();
        String str = bVarA.a;
        String str2 = bVarA.d;
        com.baidu.mobads.container.components.g.f fVar = new com.baidu.mobads.container.components.g.f(1, str);
        fVar.a(bVarA.h);
        fVar.b(bVarA.i);
        fVar.a(new j(this, bVarA, str, aVar, str2));
        fVar.a();
        return null;
    }
}
