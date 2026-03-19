package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cj;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class bx implements cj.a {
    final /* synthetic */ bw a;

    bx(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cj.a
    public void a(by byVar) {
        this.a.a(ca.k, byVar, "download apk successfully, downloader exit");
        bw unused = bw.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.cj.a
    public void b(by byVar) {
        this.a.a(ca.l, byVar, "downloadApk failed");
    }
}
