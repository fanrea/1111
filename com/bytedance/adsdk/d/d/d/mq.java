package com.bytedance.adsdk.d.d.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class mq extends u {
    static final int d = u.d("IHDR");
    int b;
    byte[] gb = new byte[5];
    int hc;

    mq() {
    }

    @Override // com.bytedance.adsdk.d.d.d.u
    void d(com.bytedance.adsdk.d.d.hc.d dVar) throws IOException {
        this.hc = dVar.hc();
        this.b = dVar.hc();
        byte[] bArr = this.gb;
        dVar.d(bArr, 0, bArr.length);
    }
}
