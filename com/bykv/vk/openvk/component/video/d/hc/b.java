package com.bykv.vk.openvk.component.video.d.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private final long b;
    private final long d;
    private final long hc;

    public long d(int i) {
        if (i <= 0) {
            return this.d;
        }
        return Math.min(this.d + (this.hc * i), this.b);
    }
}
