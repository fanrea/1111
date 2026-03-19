package com.bytedance.adsdk.d.d.hc;

import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends c {
    public void d(int i) {
        d((byte) (i & 255));
        d((byte) ((i >> 8) & 255));
        d((byte) ((i >> 16) & 255));
        d((byte) ((i >> 24) & 255));
    }

    public void hc(int i) {
        d((byte) ((i >> 24) & 255));
        d((byte) ((i >> 16) & 255));
        d((byte) ((i >> 8) & 255));
        d((byte) (i & 255));
    }

    @Override // com.bytedance.adsdk.d.d.hc.c
    public void b(int i) {
        super.b(i);
        this.d.order(ByteOrder.BIG_ENDIAN);
    }
}
