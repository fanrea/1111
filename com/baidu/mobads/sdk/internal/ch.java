package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class ch implements ao.a {
    final /* synthetic */ ca a;

    ch(ca caVar) {
        this.a = caVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        if (this.a.A) {
            this.a.A = false;
            this.a.a(false, "remote update Network access failed");
        }
    }
}
