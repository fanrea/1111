package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.co;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class cd implements co.a {
    final /* synthetic */ ca a;

    cd(ca caVar) {
        this.a = caVar;
    }

    @Override // com.baidu.mobads.sdk.internal.co.a
    public void a(String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }
}
