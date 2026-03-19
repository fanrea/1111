package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class bk implements aa.a {
    final /* synthetic */ bj c;

    bk(bj bjVar) {
        this.c = bjVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.c.k.a(bj.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.c.h();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.c.k.a(bj.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.c.i();
    }
}
