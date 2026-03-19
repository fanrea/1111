package com.qq.e.comm.plugin;

import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x extends s5 {
    public void c(int i) {
        a((byte) (i & 255));
        a((byte) ((i >> 8) & 255));
        a((byte) ((i >> 16) & 255));
        a((byte) ((i >> 24) & 255));
    }

    public void d(int i) {
        a((byte) ((i >> 24) & 255));
        a((byte) ((i >> 16) & 255));
        a((byte) ((i >> 8) & 255));
        a((byte) (i & 255));
    }

    @Override // com.qq.e.comm.plugin.s5
    public void a(int i) {
        super.a(i);
        this.a.order(ByteOrder.BIG_ENDIAN);
    }
}
