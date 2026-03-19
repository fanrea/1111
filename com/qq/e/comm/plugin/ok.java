package com.qq.e.comm.plugin;

import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ok extends e6 {
    static final int h = e6.a("IHDR");
    int e;
    int f;
    byte[] g = new byte[5];

    ok() {
    }

    @Override // com.qq.e.comm.plugin.e6
    void a(w wVar) throws IOException {
        this.e = wVar.f();
        this.f = wVar.f();
        byte[] bArr = this.g;
        wVar.read(bArr, 0, bArr.length);
    }
}
