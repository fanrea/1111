package com.qq.e.comm.plugin;

import com.kwai.middleware.azeroth.utils.NetworkUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum zr {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, com.baidu.mobads.container.util.e.a.a),
    NET_2G(2, 4, NetworkUtils.MOBILE_NETWORK_2G),
    NET_3G(3, 8, NetworkUtils.MOBILE_NETWORK_3G),
    NET_4G(4, 16, NetworkUtils.MOBILE_NETWORK_4G);

    private int a;
    private int b;
    private String c;

    zr(int i2, int i3, String str) {
        this.a = i2;
        this.b = i3;
        this.c = str;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
